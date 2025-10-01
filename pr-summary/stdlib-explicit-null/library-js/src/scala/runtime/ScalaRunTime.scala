      case s => s + "\n"
    }

<<<<<<< ADDED
  // For backward compatibility with code compiled without -Yexplicit-nulls.
  // If `a` is null, return null; otherwise, return `f`.
  // Have to add a private mapNull here to avoid errors
  private inline def mapNull[A, B](a: A, inline f: B): B =
    if((a: A | Null) == null) null.asInstanceOf[B] else f

  // For the following functions, both the parameter and the return type are non-nullable.
  // However, if a null reference is passed explicitly, this method will still return null.
  // We intentionally keep this signature to discourage passing nulls implicitly while
  // preserving the previous behavior for backward compatibility.

>>>>>>> ADDED
  // Convert arrays to immutable.ArraySeq for use with Java varargs:
  def genericWrapArray[T](xs: Array[T]): ArraySeq[T] =
<<<<<<< OLD
    if (xs eq null) null
    else ArraySeq.unsafeWrapArray(xs)
  def wrapRefArray[T <: AnyRef](xs: Array[T]): ArraySeq[T] = {
    if (xs eq null) null
=======
    mapNull(xs, ArraySeq.unsafeWrapArray(xs))
  def wrapRefArray[T <: AnyRef | Null](xs: Array[T]): ArraySeq[T] = {
    if (xs eq null) null.asInstanceOf[ArraySeq[T]]
>>>>>>> NEW
    else if (xs.length == 0) ArraySeq.empty[AnyRef].asInstanceOf[ArraySeq[T]]
    else new ArraySeq.ofRef[T](xs)
  }
<<<<<<< OLD
  def wrapIntArray(xs: Array[Int]): ArraySeq[Int] = if (xs ne null) new ArraySeq.ofInt(xs) else null
  def wrapDoubleArray(xs: Array[Double]): ArraySeq[Double] = if (xs ne null) new ArraySeq.ofDouble(xs) else null
  def wrapLongArray(xs: Array[Long]): ArraySeq[Long] = if (xs ne null) new ArraySeq.ofLong(xs) else null
  def wrapFloatArray(xs: Array[Float]): ArraySeq[Float] = if (xs ne null) new ArraySeq.ofFloat(xs) else null
  def wrapCharArray(xs: Array[Char]): ArraySeq[Char] = if (xs ne null) new ArraySeq.ofChar(xs) else null
  def wrapByteArray(xs: Array[Byte]): ArraySeq[Byte] = if (xs ne null) new ArraySeq.ofByte(xs) else null
  def wrapShortArray(xs: Array[Short]): ArraySeq[Short] = if (xs ne null) new ArraySeq.ofShort(xs) else null
  def wrapBooleanArray(xs: Array[Boolean]): ArraySeq[Boolean] = if (xs ne null) new ArraySeq.ofBoolean(xs) else null
  def wrapUnitArray(xs: Array[Unit]): ArraySeq[Unit] = if (xs ne null) new ArraySeq.ofUnit(xs) else null
=======
  def wrapIntArray(xs: Array[Int]): ArraySeq[Int] = mapNull(xs, new ArraySeq.ofInt(xs))
  def wrapDoubleArray(xs: Array[Double]): ArraySeq[Double] = mapNull(xs, new ArraySeq.ofDouble(xs))
  def wrapLongArray(xs: Array[Long]): ArraySeq[Long] = mapNull(xs, new ArraySeq.ofLong(xs))
  def wrapFloatArray(xs: Array[Float]): ArraySeq[Float] = mapNull(xs, new ArraySeq.ofFloat(xs))
  def wrapCharArray(xs: Array[Char]): ArraySeq[Char] = mapNull(xs, new ArraySeq.ofChar(xs))
  def wrapByteArray(xs: Array[Byte]): ArraySeq[Byte] = mapNull(xs, new ArraySeq.ofByte(xs))
  def wrapShortArray(xs: Array[Short]): ArraySeq[Short] = mapNull(xs, new ArraySeq.ofShort(xs))
  def wrapBooleanArray(xs: Array[Boolean]): ArraySeq[Boolean] = mapNull(xs, new ArraySeq.ofBoolean(xs))
  def wrapUnitArray(xs: Array[Unit]): ArraySeq[Unit] = mapNull(xs, new ArraySeq.ofUnit(xs))
>>>>>>> NEW
}