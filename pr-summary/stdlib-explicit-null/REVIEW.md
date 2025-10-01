# Explicit-Null Standard Library Migration Review

## Progress Overview

**Total Files**: 108
**Reviewed**: 0
**In Progress**: 0
**Remaining**: 108

Last Updated: 2025-10-01

---

## Review Status by Module

- **Core Library** (9/9 files remaining)
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

#### [ ] library/src/scala/Enumeration.scala
**Changes**: +8/-8 (16 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**:

**Review**:


---

#### [ ] library/src/scala/IArray.scala
**Changes**: +16/-7 (23 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**:

**Review**:


---

#### [ ] library/src/scala/MatchError.scala
**Changes**: +2/-2 (4 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**:

**Review**:


---

#### [ ] library/src/scala/Predef.scala
**Changes**: +26/-21 (47 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**: High impact file - careful review needed

**Review**:


---

#### [ ] library/src/scala/Specializable.scala
**Changes**: +11/-11 (22 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**:

**Review**:


---

#### [ ] library/src/scala/Symbol.scala
**Changes**: +2/-2 (4 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**:

**Review**:


---

### Collections - Core (scala.collection.*)

#### [ ] library/src/scala/collection/ArrayOps.scala
**Changes**: +1/-1 (2 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**:

**Review**:


---

#### [ ] library/src/scala/collection/Iterator.scala
**Changes**: +30/-27 (57 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**: Large file - complex iteration logic

**Review**:


---

#### [ ] library/src/scala/collection/LazyZipOps.scala
**Changes**: +3/-3 (6 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**:

**Review**:


---

#### [ ] library/src/scala/collection/SeqView.scala
**Changes**: +2/-3 (5 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**:

**Review**:


---

#### [ ] library/src/scala/collection/Stepper.scala
**Changes**: +19/-19 (38 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**:

**Review**:


---

#### [ ] library/src/scala/collection/StringOps.scala
**Changes**: +2/-2 (4 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**:

**Review**:


---

#### [ ] library/src/scala/collection/View.scala
**Changes**: +8/-6 (14 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**:

**Review**:


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

#### [ ] library/src/scala/collection/immutable/ArraySeq.scala
**Changes**: +2/-2 (4 total)
**Status**: TODO
**Reviewer**: _Unassigned_
**Notes**:

**Review**:


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
