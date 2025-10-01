# Claude Code Review Guide for Explicit-Null Standard Library Migration

## Overview

This guide helps you systematically review the explicit-null migration changes to the Scala 3 standard library. The PR migrates **108 library files** to support explicit null checking.

## Review Context

The migration adds explicit null type annotations (`| Null`) to the Scala standard library to work with the `-Yexplicit-nulls` compiler flag. This is a **critical safety change** that requires deep, thorough review beyond just the diff.

## Review Principles

### 1. Preserve behavior and binary compatibility
- ✅ No logic changes allowed
- ✅ No new type parameters or changes to public definitions
- ✅ Public API must remain unchanged

### 2. Careful use of `.nn`
- `.nn` asserts that a value is non-null **immediately**
- Only add `.nn` when the value is **logically guaranteed** to be non-null at that point
- Common mistakes to watch for:
  - Using `.nn` on values that could actually be null → **runtime crash risk**
  - Redundant `.nn` on already non-null types → **should trigger warnings**
  - Passing `x.nn` to nullable parameters → **unnecessary**
- **Review each `.nn` with extreme scrutiny**

### 3. Use `| Null` when logic depends on null
- Add `| Null` to types when code **explicitly handles null**:
  - Pattern-matching on `null`
  - Comparing with `null` (e.g., `if (x == null)`)
  - Returning `null` as a valid value
- If code calls methods without null checks → keep type non-nullable
- **Exception**: Converters like `asScala`, `genericWrapArray` intentionally keep non-nullable signatures even when they check/return null (to reduce `.nn` proliferation and encourage safer code)

### 4. Mutable fields and initialization with `= _`
- If `null` signals "not initialized" → make field type explicitly nullable
- If field is initialized exactly once or set to `null` only for GC → keep non-nullable, use `null.asInstanceOf[T]` at specific sites
- Flow typing doesn't track mutable fields by default
- Use `@scala.annotation.stableNull` to force flow typing when prefix is a stable path

### 5. Removed `T >: Null` lower bounds
- `T >: Null` is now **discouraged**
- It forces nullable types everywhere and breaks flow typing
- Prefer using `T | Null` precisely at sites that need null

### 6. `Array[T]` nullability issues
- For primitive types: `Array[Int]` is fine
- For reference types: **uninitialized elements may be null**
- If `C` is a reference type and uninitialized elements can occur → use `Array[C | Null]`

### 7. No `language.unsafeNull`
- Should be **zero usages** of `unsafeNull`
- Only use in very limited scopes if absolutely necessary
- Prefer `| Null` instead

## Review Workflow

### Step 1: Choose a file to review
Open `REVIEW.md` and select a file marked as `[ ] TODO`. Update it to `[x] IN PROGRESS - @your_name`.

### Step 2: Read the annotated diff
Navigate to the file path in the `stdlib-explicit-null/` directory. The annotated format shows:
```scala
<<<<<<< OLD
  def foo: String = null
=======
  def foo: String = null.asInstanceOf[String]
>>>>>>> NEW
```

### Step 3: Review each change deeply

For **every change**, ask yourself:

#### For `.nn` additions:
- [ ] Can this value **ever** be null at this point in execution?
- [ ] What are all the code paths that reach here?
- [ ] Are there edge cases (empty collections, error states, concurrent modifications)?
- [ ] Is there upstream documentation guaranteeing non-null?

#### For `| Null` additions:
- [ ] Does the code actually check for or return null?
- [ ] Is the nullable type propagating to public API? (should avoid if possible)
- [ ] Could we refactor to avoid null instead?

#### For type parameter changes (e.g., `T >: Null` → `T | Null`):
- [ ] Does this preserve binary compatibility?
- [ ] Are all call sites still valid?
- [ ] Does flow typing still work correctly?

#### For `Array[T]` changes:
- [ ] Is T a reference type?
- [ ] Can array elements be uninitialized?
- [ ] Should this be `Array[T | Null]`?

#### For mutable fields:
- [ ] Is the field initialized exactly once, or multiple times?
- [ ] Is null used for GC cleanup only?
- [ ] Should we add `@stableNull`?
- [ ] Would nullable type cause too many `.nn` downstream?

### Step 4: Check surrounding code
**Critical**: Don't just review the diff. Look at:
- Methods that call the changed code
- Methods called by the changed code
- Overrides and implementations
- Public API contracts
- Edge cases and error paths

### Step 5: Document your findings

In `REVIEW.md`, under the file entry, write:

**If issues found:**
```markdown
- L42: `.nn` is unsafe - `getOrElse(null)` can return null on empty Option
- L78: Should use `| Null` here - code explicitly checks `if (x == null)`
- L120: `Array[String]` should be `Array[String | Null]` - array is pre-allocated
```

**If no issues:**
```markdown
Everything looks good to me.
```

### Step 6: Mark as complete
Change the status in `REVIEW.md` from `[x] IN PROGRESS` to `[x] REVIEWED`.

## Common Patterns to Watch For

### Safe patterns ✅
```scala
// Null used only for GC cleanup
private var cache: String = _
cache = null.asInstanceOf[String] // at end of lifecycle

// Explicit null handling with nullable type
def getOrNull: String | Null =
  if (hasValue) value else null

// Guaranteed non-null from API contract
val s = someList.headOption.nn // after checking nonEmpty
```

### Unsafe patterns ⚠️
```scala
// Dangerous .nn - could be null!
def get(key: String): Value = map.get(key).nn // get returns Option[Value]!

// Missing | Null
def find(x: Int): String = // returns null in implementation
  if (x > 0) "found" else null // should be String | Null

// Wrong Array type
val arr = new Array[String](10) // uninitialized = null!
arr(0).length // crash! Should be Array[String | Null]
```

## Tips for Efficient Review

1. **Start with smaller files** to build intuition
2. **Group related files** (e.g., all HashMap-related files together)
3. **Use IDE navigation** to trace method calls and implementations
4. **Search for patterns**: Use grep to find all `.nn` in a file at once
5. **Cross-reference**: Check if similar patterns in other files were handled consistently
6. **Take breaks**: Reviewing for `.nn` safety requires sustained focus

## Questions?

If you're unsure about a pattern:
1. Note it as "Questionable" in your review
2. Check similar patterns in other reviewed files
3. Consult the migration author or team

## Progress Tracking

Check `REVIEW.md` for:
- Overall progress (X/108 files reviewed)
- Which modules need attention
- Which reviewers are working on what

---

**Remember**: This migration affects the **entire Scala 3 ecosystem**. A single incorrect `.nn` could cause production crashes. Take your time and be thorough! 🔍

Workflow for reviewing a file:
- In the beginning, you will be assigned an ID. Use the ID to indicate your identity in the tracking document.
- Pick a file to review. Update REVIEW.md to change the TODO status and assignee immediately, since there are multiple concurrent reviewers working.
- Perform your review. This directory already contains the full source file with annotated changes. Make use of the context.
- When you finish your review, update REVIEW.md to leave your reviews and update the TODO status.
- If there is nothing suspicious, change the status to `DONE`. Otherwise, change it to `REVIEWED`.

