   * @return The runtime [[Class]] representation of type `T`.
   * @group utilities
   */
<<<<<<< OLD
  def classOf[T]: Class[T] = null // This is a stub method. The actual implementation is filled in by the compiler.
=======
  def classOf[T]: Class[T] = null.asInstanceOf[Class[T]] // This is a stub method. The actual implementation is filled in by the compiler.
>>>>>>> NEW

  /**
   * Retrieve the single value of a type with a unique inhabitant.
  @inline implicit def floatArrayOps(xs: Array[Float]): ArrayOps[Float]       = new ArrayOps(xs)
  @inline implicit def intArrayOps(xs: Array[Int]): ArrayOps[Int]             = new ArrayOps(xs)
  @inline implicit def longArrayOps(xs: Array[Long]): ArrayOps[Long]          = new ArrayOps(xs)
<<<<<<< OLD
  @inline implicit def refArrayOps[T <: AnyRef](xs: Array[T]): ArrayOps[T]    = new ArrayOps(xs)
=======
  @inline implicit def refArrayOps[T <: AnyRef | Null](xs: Array[T]): ArrayOps[T]    = new ArrayOps(xs)
>>>>>>> NEW
  @inline implicit def shortArrayOps(xs: Array[Short]): ArrayOps[Short]       = new ArrayOps(xs)
  @inline implicit def unitArrayOps(xs: Array[Unit]): ArrayOps[Unit]          = new ArrayOps(xs)

    @experimental
    inline def fromNullable[T](t: T | Null): Option[T] = Option(t).asInstanceOf[Option[T]]

<<<<<<< ADDED
  // For backward compatibility with code compiled without -Yexplicit-nulls.
  // If `a` is null, return null; otherwise, return `f`.
  private[scala] inline def mapNull[A, B](a: A, inline f: B): B =
    if((a: A | Null) == null) null.asInstanceOf[B] else f

  // Use `null` in places where we want to make sure the reference is cleared.
  private[scala] inline def nullForGC[T]: T = null.asInstanceOf[T]

>>>>>>> ADDED
  /** A type supporting Self-based type classes.
   *
   *    A is TC

  /** @group conversions-array-to-wrapped-array */
  implicit def genericWrapArray[T](xs: Array[T]): ArraySeq[T] =
<<<<<<< OLD
    if (xs eq null) null
    else ArraySeq.make(xs)
=======
    mapNull(xs, ArraySeq.make(xs))
>>>>>>> NEW

  // Since the JVM thinks arrays are covariant, one 0-length Array[AnyRef]
  // is as good as another for all T <: AnyRef.  Instead of creating 100,000,000
  // unique ones by way of this implicit, let's share one.
  /** @group conversions-array-to-wrapped-array */
<<<<<<< OLD
  implicit def wrapRefArray[T <: AnyRef](xs: Array[T]): ArraySeq.ofRef[T] = {
    if (xs eq null) null
    else if (xs.length == 0) ArraySeq.empty[AnyRef].asInstanceOf[ArraySeq.ofRef[T]]
    else new ArraySeq.ofRef[T](xs)
  }
=======
  implicit def wrapRefArray[T <: AnyRef | Null](xs: Array[T]): ArraySeq.ofRef[T] =
    mapNull(xs,
      if (xs.length == 0) ArraySeq.empty[AnyRef].asInstanceOf[ArraySeq.ofRef[T]]
      else new ArraySeq.ofRef[T](xs))
>>>>>>> NEW

  /** @group conversions-array-to-wrapped-array */
<<<<<<< OLD
  implicit def wrapIntArray(xs: Array[Int]): ArraySeq.ofInt = if (xs ne null) new ArraySeq.ofInt(xs) else null
=======
  implicit def wrapIntArray(xs: Array[Int]): ArraySeq.ofInt = mapNull(xs, new ArraySeq.ofInt(xs))
>>>>>>> NEW
  /** @group conversions-array-to-wrapped-array */
<<<<<<< OLD
  implicit def wrapDoubleArray(xs: Array[Double]): ArraySeq.ofDouble = if (xs ne null) new ArraySeq.ofDouble(xs) else null
=======
  implicit def wrapDoubleArray(xs: Array[Double]): ArraySeq.ofDouble = mapNull(xs, new ArraySeq.ofDouble(xs))
>>>>>>> NEW
  /** @group conversions-array-to-wrapped-array */
<<<<<<< OLD
  implicit def wrapLongArray(xs: Array[Long]): ArraySeq.ofLong = if (xs ne null) new ArraySeq.ofLong(xs) else null
=======
  implicit def wrapLongArray(xs: Array[Long]): ArraySeq.ofLong = mapNull(xs, new ArraySeq.ofLong(xs))
>>>>>>> NEW
  /** @group conversions-array-to-wrapped-array */
<<<<<<< OLD
  implicit def wrapFloatArray(xs: Array[Float]): ArraySeq.ofFloat = if (xs ne null) new ArraySeq.ofFloat(xs) else null
=======
  implicit def wrapFloatArray(xs: Array[Float]): ArraySeq.ofFloat = mapNull(xs, new ArraySeq.ofFloat(xs))
>>>>>>> NEW
  /** @group conversions-array-to-wrapped-array */
<<<<<<< OLD
  implicit def wrapCharArray(xs: Array[Char]): ArraySeq.ofChar = if (xs ne null) new ArraySeq.ofChar(xs) else null
=======
  implicit def wrapCharArray(xs: Array[Char]): ArraySeq.ofChar = mapNull(xs, new ArraySeq.ofChar(xs))
>>>>>>> NEW
  /** @group conversions-array-to-wrapped-array */
<<<<<<< OLD
  implicit def wrapByteArray(xs: Array[Byte]): ArraySeq.ofByte = if (xs ne null) new ArraySeq.ofByte(xs) else null
=======
  implicit def wrapByteArray(xs: Array[Byte]): ArraySeq.ofByte = mapNull(xs, new ArraySeq.ofByte(xs))
>>>>>>> NEW
  /** @group conversions-array-to-wrapped-array */
<<<<<<< OLD
  implicit def wrapShortArray(xs: Array[Short]): ArraySeq.ofShort = if (xs ne null) new ArraySeq.ofShort(xs) else null
=======
  implicit def wrapShortArray(xs: Array[Short]): ArraySeq.ofShort = mapNull(xs, new ArraySeq.ofShort(xs))
>>>>>>> NEW
  /** @group conversions-array-to-wrapped-array */
<<<<<<< OLD
  implicit def wrapBooleanArray(xs: Array[Boolean]): ArraySeq.ofBoolean = if (xs ne null) new ArraySeq.ofBoolean(xs) else null
=======
  implicit def wrapBooleanArray(xs: Array[Boolean]): ArraySeq.ofBoolean = mapNull(xs, new ArraySeq.ofBoolean(xs))
>>>>>>> NEW
  /** @group conversions-array-to-wrapped-array */
<<<<<<< OLD
  implicit def wrapUnitArray(xs: Array[Unit]): ArraySeq.ofUnit = if (xs ne null) new ArraySeq.ofUnit(xs) else null
=======
  implicit def wrapUnitArray(xs: Array[Unit]): ArraySeq.ofUnit = mapNull(xs, new ArraySeq.ofUnit(xs))
>>>>>>> NEW

  /** @group conversions-string */
<<<<<<< OLD
  implicit def wrapString(s: String): WrappedString = if (s ne null) new WrappedString(s) else null
=======
  implicit def wrapString(s: String): WrappedString = mapNull(s, new WrappedString(s))
>>>>>>> NEW
}

private[scala] abstract class LowPriorityImplicits2 {
  @deprecated("implicit conversions from Array to immutable.IndexedSeq are implemented by copying; use `toIndexedSeq` explicitly if you want to copy, or use the more efficient non-copying ArraySeq.unsafeWrapArray", since="2.13.0")
  implicit def copyArrayToImmutableIndexedSeq[T](xs: Array[T]): IndexedSeq[T] =
<<<<<<< OLD
    if (xs eq null) null
    else new ArrayOps(xs).toIndexedSeq
=======
    mapNull(xs, new ArrayOps(xs).toIndexedSeq)
>>>>>>> NEW
}