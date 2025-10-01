# Explicit-Null Standard Library Migration Review

## Progress Overview

**Total Files**: 108
**Reviewed**: 8
**In Progress**: 2
**Remaining**: 100

Last Updated: 2025-10-01

---

## Review Status by Module

- **Core Library** (8/9 files remaining - IArray.scala reviewed)
- **Collections** (53/53 files remaining)
- **Concurrent** (5/5 files remaining)
- **IO** (3/3 files remaining)
- **JDK Interop** (8/8 files remaining)
- **Math** (2/2 files remaining)
- **References & Reflection** (5/5 files remaining)
- **Runtime** (5/5 files remaining)
- **System** (8/8 files remaining)
- **Utilities** (6/6 files remaining)
- **Library-JS** (4/4 files remaining)

---

## Files to Review

### Core Library (scala.*)

#### [x] library/src/scala/Enumeration.scala
**Changes**: +8/-8 (16 total)
**Status**: REVIEWED
**Reviewer**: @CC2
**Notes**:

**Review**:
- **L5→7**: `vset: ValueSet = null` → `vset: ValueSet | Null = null` ✅
  - Mutable field used as lazy cache, null indicates "not initialized"
  - Follows Guideline #4 (nullable fields for uninitialized state)
  - Works with volatile flag `vsetDefined` for thread-safe lazy initialization

- **L16→18**: `vset` → `vset.nn` ✅
  - Safe usage: code initializes `vset` before this return statement
  - Protected by double-check pattern with volatile `vsetDefined` flag
  - Happens-before guarantees ensure visibility across threads

- **L27→29**: `nextNameOrNull =` → `nextNameOrNull: String | Null =` ✅
  - Returns null explicitly on L31: `else null`
  - Follows Guideline #3 (add `| Null` when returning null)
  - Method name clearly indicates nullable return

- **L38→40**: `Value(name: String)` → `Value(name: String | Null)` ✅
  - Widens parameter type from non-nullable to nullable
  - Binary compatible (callers can still pass non-null strings)
  - Necessary to accept output from `nextNameOrNull`

- **L49→51**: `Value(i: Int, name: String)` → `Value(i: Int, name: String | Null)` ✅
  - Same as L38→40, widens parameter type
  - Binary compatible

- **L56→58**: `getFields(clazz: Class[_], ...)` → `getFields(clazz: Class[_] | Null, ...)` ✅
  - Private recursive method using reflection
  - Explicitly checks `if (clazz == null)` on L60
  - Follows Guideline #3 (add `| Null` when code checks for null)

- **L67→69**: `Val(i: Int, name: String)` → `Val(i: Int, name: String | Null)` ✅
  - Primary constructor parameter widened to accept nullable
  - Required because L71 calls it with `nextNameOrNull` result
  - Binary compatible

- **L73→75**: `this(name: String)` → `this(name: String | Null)` ✅
  - Auxiliary constructor, consistent with primary constructor
  - Binary compatible type widening

**Summary**: All 8 changes are correct and follow migration guidelines. No safety issues. The `.nn` usage is properly protected by the volatile flag pattern. Parameter type widening maintains binary compatibility.

Everything looks good to me.


---

#### [x] library/src/scala/IArray.scala
**Changes**: +16/-7 (23 total)
**Status**: REVIEWED
**Reviewer**: Claude
**Notes**: Array handling, converter function with unsafeNulls import

**Review**:

- **L32: CRITICAL ISSUE** - `import scala.language.unsafeNulls // TODO!!! only for stdliib migration!`

  This violates **Guideline #7** which explicitly states to avoid `language.unsafeNull`. The comment acknowledges this is temporary ("TODO!!!"), but this should be resolved before merging. The import appears to be needed to make the cast operations type-check, but we should investigate alternatives:
  - Can we use explicit `| Null` annotations instead?
  - Is there a way to scope this import more narrowly?
  - **Recommendation**: Remove this import and fix the code properly.

- **L33: Type parameter change** - `T <: AnyRef` → `T <: AnyRef | Null`

  **Concern about binary compatibility**: This changes the signature of a public implicit conversion. According to **Guideline #1**, no changes to public definitions should be made. While this widens the type bound (making it more permissive), we need to verify this doesn't break binary compatibility:
  - Does this change the JVM signature?
  - Can existing compiled code that calls `wrapRefArray[String]` still link?
  - **Recommendation**: Verify binary compatibility with MiMa or similar tool.

- **L46-47: Complex cast chain** - `ArraySeq.ofRef[AnyRef](arr.asInstanceOf[Array[AnyRef]]).asInstanceOf[ArraySeq.ofRef[T]]`

  The cast logic changed from:
  - OLD: `ArraySeq.ofRef(arr.asInstanceOf[Array[T]])`
  - NEW: `ArraySeq.ofRef[AnyRef](arr.asInstanceOf[Array[AnyRef]]).asInstanceOf[ArraySeq.ofRef[T]]`

  **Analysis**: This appears to be working around type inference issues with the nullable type parameter. The cast to `Array[AnyRef]` (without `| Null`) then back to `ArraySeq.ofRef[T]` looks suspicious:
  - If `T` can be `Null`, why are we casting through non-nullable `Array[AnyRef]`?
  - This might be hiding a type safety issue
  - **Recommendation**: Clarify the reasoning or refactor to avoid double casting.

- **L46: Array type change** - `ArraySeq.empty[AnyRef]` → `ArraySeq.empty[AnyRef | Null]`

  This is consistent with the type parameter change and follows **Guideline #6** about Array[T] nullability for reference types. ✅

- **L10-20: mapNull function documentation**

  Good addition of explanatory comments. The function intentionally violates type safety for backward compatibility, which is well-documented. This aligns with **Guideline #3 exception** for converters/wrappers. ✅

**Summary**:
- **1 Critical Issue**: unsafeNulls import must be removed
- **1 Major Concern**: Binary compatibility needs verification
- **1 Code Smell**: Complex double-casting logic should be clarified
- **2 Good Changes**: Documentation and Array type consistency


---

#### [x] library/src/scala/MatchError.scala
**Changes**: +2/-2 (4 total)
**Status**: REVIEWED
**Reviewer**: Claude
**Notes**:

**Review**:
- L7: Added explicit `: String` type annotation to `objString` lazy val ✅
- L18: Added explicit `: String` return type to `getMessage()` override ✅
- Both changes are straightforward type annotations with no safety issues
- Code properly handles null on L10 by converting to string "null"
- No `.nn`, `| Null`, or API changes
Everything looks good to me.


---

#### [x] library/src/scala/Predef.scala
**Changes**: +26/-21 (47 total)
**Status**: IN PROGRESS
**Reviewer**: @CC3
**Notes**: High impact file - careful review needed

**Review**:


---

#### [x] library/src/scala/Specializable.scala
**Changes**: +11/-11 (22 total)
**Status**: REVIEWED
**Reviewer**: CC1
**Notes**:

**Review**:

- **L5→7: POTENTIAL BINARY COMPATIBILITY ISSUE** - Removed `T >: Null` lower bound from `Group[T]`

  - ✅ Follows **Guideline #5** (discourage `T >: Null`)
  - ⚠️ **Public API change**: This changes the signature of a public class. According to **Guideline #1**, we must verify binary compatibility:
    - Does removing the lower bound change the JVM signature?
    - Can existing compiled code that uses `Group` still link?
    - **Recommendation**: Verify with MiMa or similar tool before merging
  - The change itself is semantically correct - removes forced nullability

- **L11→19: Primitives field initialization** - Added explicit `asInstanceOf` cast
  - OLD: `final val Primitives: Group[...] = null`
  - NEW: `final val Primitives: Group[...] = null.asInstanceOf[Group[...]]`
  - ✅ Correct pattern - since `Group[T]` no longer has `>: Null`, direct assignment fails
  - ✅ Safe usage - these are sentinel/marker values for type-level specialization groups
  - ✅ Values are never dereferenced at runtime (type markers only)
  - Follows **Guideline #4** (null for sentinel values, use asInstanceOf)

- **L12→20, L13→21, L14→22, L15→23, L16→24, L17→25**: Same pattern for Everything, Bits32AndUp, Integral, AllNumeric, BestOfBreed, Unit ✅
  - All consistent with same safe pattern

- **L29→33, L30→34, L31→35**: Same pattern for Arg, Args, Return ✅
  - Consistent with above

- **No `.nn` usages**: ✅ Correct - values are sentinels, never dereferenced

- **No `| Null` additions needed**: ✅ Correct - the Group instances themselves are nullable (via asInstanceOf), not their type parameters

**Summary**:
- **1 Potential Issue**: Binary compatibility of removing `T >: Null` needs verification
- **11 Correct Changes**: All `null.asInstanceOf[Group[...]]` patterns are safe and appropriate for sentinel values
- Pattern follows guidelines correctly for removing `T >: Null` lower bounds

**Verdict**: Changes are semantically correct and follow migration guidelines. Only concern is binary compatibility verification needed before merge.


---

#### [x] library/src/scala/Symbol.scala
**Changes**: +2/-2 (4 total)
**Status**: REVIEWED
**Reviewer**: Claude
**Notes**:

**Review**:
- L5→7: Removed `V >: Null` lower bound from UniquenessCache ✅
  - Follows Guideline #5 (discourage `T >: Null`)
- L16→18: Added `| Null` to `cached()` return type ✅
  - Correctly reflects that `WeakHashMap.get()` can return null
  - Since V no longer has `>: Null`, must explicitly add `| Null`
  - Outer `apply()` returns non-null `V`, handles null internally
Everything looks good to me.


---

### Collections - Core (scala.collection.*)

#### [x] library/src/scala/collection/ArrayOps.scala
**Changes**: +1/-1 (2 total)
**Status**: REVIEWED
**Reviewer**: Claude
**Notes**:

**Review**:
- L5→7: Removed trailing whitespace after `AnyRef` in type parameter
- Whitespace-only change, no semantic or safety implications
Everything looks good to me.


---

#### [ ] library/src/scala/collection/Iterator.scala
**Changes**: +30/-27 (57 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**: Large file - complex iteration logic

**Review**:


---

#### [x] library/src/scala/collection/LazyZipOps.scala
**Changes**: +3/-3 (6 total)
**Status**: REVIEWED
**Reviewer**: Claude
**Notes**:

**Review**:
- L5→7: Added `| Null` to `_current` field for 2-tuple iterator ✅
- L16→18: Added `| Null` to `_current` field for 3-tuple iterator ✅
- L27→29: Added `| Null` to `_current` field for 4-tuple iterator ✅
- All three mutable fields are initialized with `= _` (null)
- Code explicitly checks `(_current eq null)` in the `current` method
- Follows Guideline #4 (nullable fields for "not initialized" state)
- Follows Guideline #3 (add `| Null` when code handles null)
Everything looks good to me.


---

#### [x] library/src/scala/collection/SeqView.scala
**Changes**: +2/-3 (5 total)
**Status**: REVIEWED
**Reviewer**: @CC2
**Notes**:

**Review**:
- **L5→7**: `underlying = null` → `underlying = nullForGC[SomeSeqOps[A]]` ✅
  - Uses `nullForGC[T]` helper which is `null.asInstanceOf[T]` (defined in Predef)
  - Comment confirms: "allow GC of unneeded reference"
  - Follows Guideline #4 (null for GC cleanup, use asInstanceOf at specific site)
  - Field type remains non-nullable (no `| Null` needed)
  - This is the recommended pattern for GC-only null assignments

- **L14→17**: Removed intermediate variable `orig` ✅
  - OLD: `val orig: SomeSeqOps[A]^{this} = underlying; if (evaluated) _sorted else orig`
  - NEW: `if (evaluated) _sorted else underlying`
  - Pure code simplification, no semantic change
  - No safety implications - both versions equivalent
  - No `.nn` needed because `underlying` is accessed before GC cleanup

**Summary**: Both changes follow migration guidelines correctly. The `nullForGC` pattern is exactly what's recommended for GC-only null assignments. Code simplification is safe.

Everything looks good to me.


---

#### [ ] library/src/scala/collection/Stepper.scala
**Changes**: +19/-19 (38 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**:

**Review**:


---

#### [x] library/src/scala/collection/StringOps.scala
**Changes**: +2/-2 (4 total)
**Status**: REVIEWED
**Reviewer**: CC1
**Notes**:

**Review**:
- **L4-8: stripPrefix return type** - Added explicit `: String` return type annotation ✅
  - Method returns `String` in both branches (substring or unchanged string)
  - No null handling involved
  - Pure type annotation, no behavioral change

- **L15-19: stripSuffix return type** - Added explicit `: String` return type annotation ✅
  - Method returns `String` in both branches (substring or unchanged string)
  - No null handling involved
  - Pure type annotation, no behavioral change

**Analysis**: Both changes are trivial type annotations making previously inferred return types explicit. No safety issues, no `.nn`, no `| Null`, no API changes beyond adding explicit types.

Everything looks good to me.


---

#### [x] library/src/scala/collection/View.scala
**Changes**: +8/-6 (14 total)
**Status**: REVIEWED
**Reviewer**: CC1
**Notes**:

**Review**:

- **L5→8: TakeRightIterator buf field** - Added `@annotation.stableNull` and `| Null` type ✅
  - OLD: `private[this] var buf: ArrayBuffer[AnyRef] = _`
  - NEW: `@annotation.stableNull private[this] var buf: ArrayBuffer[AnyRef] | Null = _`
  - Field initialized with `= _` (null), used as "not initialized" marker
  - Explicitly checked on L10: `if(buf eq null)`
  - `@stableNull` enables flow typing for this `private[this]` stable field
  - Follows **Guideline #4** (mutable fields with null state + @stableNull annotation)
  - Follows **Guideline #3** (add `| Null` when code checks null)

- **L17→19: GC cleanup** - Added explicit cast for null assignment ✅
  - OLD: `underlying = null`
  - NEW: `underlying = null.asInstanceOf[Iterator[A]] // allow GC of underlying iterator`
  - Comment confirms this is for GC cleanup (freeing memory after iteration)
  - Field `underlying` is non-nullable, so asInstanceOf needed
  - Follows **Guideline #4** (null for GC cleanup, use asInstanceOf)

- **L28→30: buf.nn access in TakeRightIterator.next** ✅
  - OLD: `val x = buf(pos).asInstanceOf[A]`
  - NEW: `val x = buf.nn(pos).asInstanceOf[A]`
  - Code flow: L24 calls `init()` which initializes buf if null
  - After init(), buf is guaranteed non-null
  - `.nn` is safe here - buf cannot be null at this point

- **L39→42: DropRightIterator buf field** - Same pattern as L5→8 ✅
  - `@annotation.stableNull` + `| Null` type
  - Checked on L44: `if(buf eq null)`
  - Correct for same reasons as TakeRightIterator

- **L51→53: buf.nn access in DropRightIterator.next (read)** ✅
  - OLD: `val x = buf(pos).asInstanceOf[A]`
  - NEW: `val x = buf.nn(pos).asInstanceOf[A]`
  - L48 checks hasNext which calls init()
  - After hasNext, buf is initialized
  - `.nn` is safe here

- **L57→59: buf.nn access in DropRightIterator.next (write)** ✅
  - OLD: `buf(pos) = underlying.next().asInstanceOf[AnyRef]`
  - NEW: `buf.nn(pos) = underlying.next().asInstanceOf[AnyRef]`
  - Inside next() after hasNext check
  - buf already initialized by this point
  - `.nn` is safe here

**Summary**:
- **2 fields**: Proper use of `@stableNull` + `| Null` for lazy-initialized buffers
- **1 GC cleanup**: Correct use of `null.asInstanceOf` for memory management
- **3 .nn usages**: All safe - buf guaranteed non-null after init()
- No binary compatibility issues
- No unsafe nullability issues

Everything looks good to me.


---

### Collections - Concurrent (scala.collection.concurrent.*)

#### [ ] library/src/scala/collection/concurrent/TrieMap.scala
**Changes**: +45/-44 (89 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**: Complex concurrent data structure - careful review of thread safety

**Review**:


---

### Collections - Convert (scala.collection.convert.*)

#### [ ] library/src/scala/collection/convert/AsJavaConverters.scala
**Changes**: +31/-26 (57 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**: Java interop - check null handling at boundaries

**Review**:


---

#### [ ] library/src/scala/collection/convert/AsScalaConverters.scala
**Changes**: +25/-20 (45 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**: Java interop - Exception to | Null rule may apply

**Review**:


---

#### [ ] library/src/scala/collection/convert/JavaCollectionWrappers.scala
**Changes**: +20/-21 (41 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**: Java interop - wrappers may handle null specially

**Review**:


---

#### [ ] library/src/scala/collection/convert/StreamExtensions.scala
**Changes**: +6/-6 (12 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**:

**Review**:


---

### Collections - Convert Implementation (scala.collection.convert.impl.*)

#### [ ] library/src/scala/collection/convert/impl/ArrayStepper.scala
**Changes**: +1/-1 (2 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**:

**Review**:


---

#### [ ] library/src/scala/collection/convert/impl/BinaryTreeStepper.scala
**Changes**: +29/-28 (57 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**: Tree traversal - check null node handling

**Review**:


---

#### [ ] library/src/scala/collection/convert/impl/BitSetStepper.scala
**Changes**: +5/-4 (9 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**:

**Review**:


---

#### [ ] library/src/scala/collection/convert/impl/ChampStepper.scala
**Changes**: +10/-10 (20 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**:

**Review**:


---

#### [ ] library/src/scala/collection/convert/impl/InOrderStepperBase.scala
**Changes**: +2/-2 (4 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**:

**Review**:


---

#### [ ] library/src/scala/collection/convert/impl/IndexedStepperBase.scala
**Changes**: +2/-2 (4 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**:

**Review**:


---

#### [ ] library/src/scala/collection/convert/impl/IteratorStepper.scala
**Changes**: +24/-23 (47 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**: Iterator wrapping - check hasNext/next null handling

**Review**:


---

#### [ ] library/src/scala/collection/convert/impl/RangeStepper.scala
**Changes**: +2/-2 (4 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**:

**Review**:


---

#### [ ] library/src/scala/collection/convert/impl/StringStepper.scala
**Changes**: +1/-1 (2 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**:

**Review**:


---

#### [ ] library/src/scala/collection/convert/impl/TableStepper.scala
**Changes**: +20/-20 (40 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**:

**Review**:


---

#### [ ] library/src/scala/collection/convert/impl/VectorStepper.scala
**Changes**: +6/-6 (12 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**:

**Review**:


---

### Collections - Immutable (scala.collection.immutable.*)

#### [x] library/src/scala/collection/immutable/ArraySeq.scala
**Changes**: +2/-2 (4 total)
**Status**: REVIEWED
**Reviewer**: @CC2
**Notes**:

**Review**:
- **L5→7**: `appendedAllArraySeq[B >: A](that: ArraySeq[B]): ArraySeq[B]` → `: ArraySeq[B] | Null` ✅
  - Documentation on L2 explicitly states: "@return null if optimisation not possible"
  - Private method that returns null when concatenation optimization cannot be applied
  - Follows Guideline #3 (add `| Null` when returning null)
  - Correctly reflects method's null-returning behavior

- **L16→18**: `ofRef[T <: AnyRef]` → `ofRef[T <: AnyRef | Null]` ⚠️
  - Widens type parameter bound to allow nullable reference types
  - Allows instantiation as `ofRef[String | Null]` for arrays that can contain null elements
  - Follows Guideline #6 (Array[T] for reference types may have null elements)
  - **Binary compatibility concern**: Changing public type parameter bounds may affect compatibility
    - This is a public final class in a stable API
    - Similar to IArray.scala issue (L33 in that review)
    - **Recommendation**: Verify binary compatibility with MiMa before merging
  - Semantically correct - makes explicit that array elements can be nullable

**Summary**: 1 correct nullable return type, 1 correct but potentially binary-incompatible type parameter change. The type parameter widening follows guidelines but needs binary compatibility verification.

**Verdict**: Changes follow migration guidelines. Binary compatibility verification needed for type parameter bound change.


---

#### [ ] library/src/scala/collection/immutable/HashMap.scala
**Changes**: +12/-11 (23 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**: Check hash collision handling and null keys

**Review**:


---

#### [ ] library/src/scala/collection/immutable/HashSet.scala
**Changes**: +11/-10 (21 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**:

**Review**:


---

#### [ ] library/src/scala/collection/immutable/LazyList.scala
**Changes**: +6/-5 (11 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**: Lazy evaluation - check thunk and state initialization

**Review**:


---

#### [ ] library/src/scala/collection/immutable/LazyListIterable.scala
**Changes**: +5/-5 (10 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**:

**Review**:


---

#### [ ] library/src/scala/collection/immutable/List.scala
**Changes**: +7/-7 (14 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**: Core collection - high impact

**Review**:


---

#### [ ] library/src/scala/collection/immutable/ListMap.scala
**Changes**: +8/-8 (16 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**:

**Review**:


---

#### [ ] library/src/scala/collection/immutable/RedBlackTree.scala
**Changes**: +210/-207 (417 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**: **LARGE FILE** - Complex tree operations, null node handling critical

**Review**:


---

#### [ ] library/src/scala/collection/immutable/Stream.scala
**Changes**: +4/-4 (8 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**: Deprecated but still in use

**Review**:


---

#### [ ] library/src/scala/collection/immutable/TreeMap.scala
**Changes**: +7/-7 (14 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**: Uses RedBlackTree - coordinate with that review

**Review**:


---

#### [ ] library/src/scala/collection/immutable/TreeSeqMap.scala
**Changes**: +5/-4 (9 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**:

**Review**:


---

#### [ ] library/src/scala/collection/immutable/TreeSet.scala
**Changes**: +4/-4 (8 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**: Uses RedBlackTree - coordinate with that review

**Review**:


---

#### [ ] library/src/scala/collection/immutable/Vector.scala
**Changes**: +27/-27 (54 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**: Core collection - check array node handling

**Review**:


---

#### [ ] library/src/scala/collection/immutable/VectorMap.scala
**Changes**: +2/-1 (3 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**:

**Review**:


---

### Collections - Mutable (scala.collection.mutable.*)

#### [ ] library/src/scala/collection/mutable/AnyRefMap.scala
**Changes**: +17/-16 (33 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**: Mutable map - check null key/value handling

**Review**:


---

#### [ ] library/src/scala/collection/mutable/ArrayBuilder.scala
**Changes**: +41/-41 (82 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**: Builder pattern - check array initialization

**Review**:


---

#### [ ] library/src/scala/collection/mutable/ArrayDeque.scala
**Changes**: +6/-6 (12 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**:

**Review**:


---

#### [ ] library/src/scala/collection/mutable/ArraySeq.scala
**Changes**: +1/-1 (2 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**:

**Review**:


---

#### [ ] library/src/scala/collection/mutable/BitSet.scala
**Changes**: +1/-1 (2 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**:

**Review**:


---

#### [ ] library/src/scala/collection/mutable/CollisionProofHashMap.scala
**Changes**: +104/-93 (197 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**: **LARGE FILE** - Complex hash table with collision handling

**Review**:


---

#### [ ] library/src/scala/collection/mutable/HashMap.scala
**Changes**: +40/-35 (75 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**: Mutable hash table - careful review of state and null handling

**Review**:


---

#### [ ] library/src/scala/collection/mutable/HashSet.scala
**Changes**: +18/-17 (35 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**:

**Review**:


---

#### [ ] library/src/scala/collection/mutable/HashTable.scala
**Changes**: +17/-16 (33 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**: Base implementation for hash-based collections

**Review**:


---

#### [ ] library/src/scala/collection/mutable/LinkedHashMap.scala
**Changes**: +36/-34 (70 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**: Linked list + hash table - check node linking and null

**Review**:


---

#### [ ] library/src/scala/collection/mutable/LinkedHashSet.scala
**Changes**: +24/-23 (47 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**:

**Review**:


---

#### [ ] library/src/scala/collection/mutable/ListBuffer.scala
**Changes**: +11/-10 (21 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**: Mutable list builder - check head/tail/last pointers

**Review**:


---

#### [ ] library/src/scala/collection/mutable/LongMap.scala
**Changes**: +20/-21 (41 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**: Specialized map - check null value handling

**Review**:


---

#### [ ] library/src/scala/collection/mutable/PriorityQueue.scala
**Changes**: +4/-4 (8 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**: Heap data structure

**Review**:


---

#### [ ] library/src/scala/collection/mutable/Queue.scala
**Changes**: +2/-2 (4 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**:

**Review**:


---

#### [ ] library/src/scala/collection/mutable/RedBlackTree.scala
**Changes**: +116/-107 (223 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**: **LARGE FILE** - Mutable tree, complex balancing operations

**Review**:


---

#### [ ] library/src/scala/collection/mutable/Stack.scala
**Changes**: +2/-2 (4 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**:

**Review**:


---

#### [ ] library/src/scala/collection/mutable/UnrolledBuffer.scala
**Changes**: +19/-19 (38 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**: Unrolled linked list - check node pointers

**Review**:


---

### Concurrent (scala.concurrent.*)

#### [ ] library/src/scala/concurrent/BatchingExecutor.scala
**Changes**: +14/-10 (24 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**: Thread safety critical

**Review**:


---

#### [ ] library/src/scala/concurrent/ExecutionContext.scala
**Changes**: +7/-7 (14 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**:

**Review**:


---

#### [ ] library/src/scala/concurrent/JavaConversions.scala
**Changes**: +2/-2 (4 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**:

**Review**:


---

#### [ ] library/src/scala/concurrent/impl/ExecutionContextImpl.scala
**Changes**: +3/-2 (5 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**:

**Review**:


---

#### [ ] library/src/scala/concurrent/impl/Promise.scala
**Changes**: +20/-20 (40 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**: Promise implementation - check state transitions and null

**Review**:


---

### IO (scala.io.*)

#### [ ] library/src/scala/io/BufferedSource.scala
**Changes**: +3/-3 (6 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**: IO resource - check null on close/error paths

**Review**:


---

#### [ ] library/src/scala/io/Codec.scala
**Changes**: +6/-6 (12 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**:

**Review**:


---

#### [ ] library/src/scala/io/Source.scala
**Changes**: +8/-6 (14 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**: IO resource - check null on error/EOF

**Review**:


---

### JDK Interop (scala.jdk.*)

#### [ ] library/src/scala/jdk/AnyAccumulator.scala
**Changes**: +1/-1 (2 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**:

**Review**:


---

#### [ ] library/src/scala/jdk/DoubleAccumulator.scala
**Changes**: +1/-1 (2 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**:

**Review**:


---

#### [ ] library/src/scala/jdk/FunctionExtensions.scala
**Changes**: +88/-88 (176 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**: **LARGE FILE** - Java function interop, null handling critical

**Review**:


---

#### [ ] library/src/scala/jdk/FunctionWrappers.scala
**Changes**: +222/-222 (444 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**: **LARGEST FILE** - Wrappers for Java functions, careful review needed

**Review**:


---

#### [ ] library/src/scala/jdk/IntAccumulator.scala
**Changes**: +1/-1 (2 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**:

**Review**:


---

#### [ ] library/src/scala/jdk/LongAccumulator.scala
**Changes**: +1/-1 (2 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**:

**Review**:


---

### Math (scala.math.*)

#### [ ] library/src/scala/math/BigDecimal.scala
**Changes**: +2/-2 (4 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**:

**Review**:


---

#### [ ] library/src/scala/math/BigInt.scala
**Changes**: +11/-9 (20 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**: Wraps Java BigInteger - check null from Java

**Review**:


---

### References & Reflection (scala.ref.*, scala.reflect.*)

#### [ ] library/src/scala/ref/ReferenceQueue.scala
**Changes**: +1/-1 (2 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**: GC-related - null is meaningful

**Review**:


---

#### [ ] library/src/scala/ref/SoftReference.scala
**Changes**: +2/-2 (4 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**: GC-related - reference can become null

**Review**:


---

#### [ ] library/src/scala/ref/WeakReference.scala
**Changes**: +2/-2 (4 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**: GC-related - reference can become null

**Review**:


---

#### [ ] library/src/scala/reflect/ClassManifestDeprecatedApis.scala
**Changes**: +2/-2 (4 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**:

**Review**:


---

#### [ ] library/src/scala/reflect/NameTransformer.scala
**Changes**: +7/-7 (14 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**:

**Review**:


---

### Runtime (scala.runtime.*)

#### [ ] library/src/scala/runtime/LambdaDeserializer.scala
**Changes**: +2/-2 (4 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**:

**Review**:


---

#### [ ] library/src/scala/runtime/MethodCache.scala
**Changes**: +5/-5 (10 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**: Reflection cache - check null method references

**Review**:


---

#### [ ] library/src/scala/runtime/ScalaRunTime.scala
**Changes**: +6/-6 (12 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**: Core runtime support

**Review**:


---

#### [ ] library/src/scala/runtime/StructuralCallSite.scala
**Changes**: +1/-1 (2 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**:

**Review**:


---

### System (scala.sys.*)

#### [ ] library/src/scala/sys/BooleanProp.scala
**Changes**: +1/-1 (2 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**:

**Review**:


---

#### [ ] library/src/scala/sys/Prop.scala
**Changes**: +1/-1 (2 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**:

**Review**:


---

#### [ ] library/src/scala/sys/PropImpl.scala
**Changes**: +4/-5 (9 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**:

**Review**:


---

#### [ ] library/src/scala/sys/SystemProperties.scala
**Changes**: +5/-6 (11 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**: System property access - Java interop, null possible

**Review**:


---

#### [ ] library/src/scala/sys/process/BasicIO.scala
**Changes**: +1/-1 (2 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**:

**Review**:


---

#### [ ] library/src/scala/sys/process/ProcessBuilderImpl.scala
**Changes**: +1/-1 (2 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**:

**Review**:


---

#### [ ] library/src/scala/sys/process/ProcessImpl.scala
**Changes**: +1/-1 (2 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**:

**Review**:


---

#### [ ] library/src/scala/sys/process/package.scala
**Changes**: +3/-3 (6 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**:

**Review**:


---

### Utilities (scala.util.*)

#### [ ] library/src/scala/util/Properties.scala
**Changes**: +13/-13 (26 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**: System properties - null from Java

**Review**:


---

#### [ ] library/src/scala/util/Sorting.scala
**Changes**: +3/-3 (6 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**:

**Review**:


---

#### [ ] library/src/scala/util/Using.scala
**Changes**: +4/-4 (8 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**: Resource management - check null in error paths

**Review**:


---

#### [ ] library/src/scala/util/control/ControlThrowable.scala
**Changes**: +1/-1 (2 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**:

**Review**:


---

#### [ ] library/src/scala/util/hashing/MurmurHash3.scala
**Changes**: +2/-2 (4 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**:

**Review**:


---

#### [ ] library/src/scala/util/matching/Regex.scala
**Changes**: +16/-16 (32 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**: Regex matching - check null from Java Pattern/Matcher

**Review**:


---

### Library-JS (library-js/src/scala/*)

#### [ ] library-js/src/scala/Console.scala
**Changes**: +1/-1 (2 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**: JS-specific implementation

**Review**:


---

#### [ ] library-js/src/scala/Enumeration.scala
**Changes**: +7/-7 (14 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**: JS-specific implementation

**Review**:


---

#### [ ] library-js/src/scala/collection/mutable/ArrayBuilder.scala
**Changes**: +42/-42 (84 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**: JS-specific implementation - compare with JVM version

**Review**:


---

#### [ ] library-js/src/scala/runtime/ScalaRunTime.scala
**Changes**: +23/-13 (36 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**: JS-specific runtime - compare with JVM version

**Review**:


---

## Review Guidelines Quick Reference

1. **`.nn` safety**: Can the value EVER be null at that point?
2. **`| Null` necessity**: Does code actually check for or return null?
3. **Binary compatibility**: No changes to public API signatures?
4. **Array nullability**: Reference types in arrays need `Array[T | Null]`?
5. **Mutable fields**: Should be nullable or use `@stableNull`?
6. **No `unsafeNull`**: Zero usages allowed

## Notes

- Mark files as `[x] IN PROGRESS - @name` when starting
- Mark as `[x] REVIEWED - @name` when complete
- Focus on **library/** and **library-js/** only (compiler/tests/scaladoc are out of scope)
- Related files should be reviewed together for consistency
- Large files (>100 changes) need extra attention
