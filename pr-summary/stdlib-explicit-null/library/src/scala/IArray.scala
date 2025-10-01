  extension [T, U >: T: ClassTag](x: T)
    def +:(arr: IArray[U]): IArray[U] = genericArrayOps(arr).prepended(x)

<<<<<<< OLD
  // For backwards compatibility with code compiled without -Yexplicit-nulls
=======
  // For backward compatibility with code compiled without -Yexplicit-nulls.
  // If `a` is null, return null; otherwise, return `f`.
  // Have to add a private mapNull here to avoid errors
>>>>>>> NEW
  private inline def mapNull[A, B](a: A, inline f: B): B =
<<<<<<< OLD
    if((a: A|Null) == null) null.asInstanceOf[B] else f
=======
    if((a: A | Null) == null) null.asInstanceOf[B] else f

  // For the following functions, both the parameter and the return type are non-nullable.
  // However, if a null reference is passed explicitly, this method will still return null.
  // We intentionally keep this signature to discourage passing nulls implicitly while
  // preserving the previous behavior for backward compatibility.
>>>>>>> NEW

  /** Conversion from IArray to immutable.ArraySeq */
  implicit def genericWrapArray[T](arr: IArray[T]): ArraySeq[T] =
    mapNull(arr, ArraySeq.unsafeWrapArray(arr))

  /** Conversion from IArray to immutable.ArraySeq */
<<<<<<< OLD
  implicit def wrapRefArray[T <: AnyRef](arr: IArray[T]): ArraySeq.ofRef[T] =
    // Since the JVM thinks arrays are covariant, one 0-length Array[AnyRef]
    // is as good as another for all T <: AnyRef.  Instead of creating 100,000,000
=======
  import scala.language.unsafeNulls // TODO!!! only for stdliib migration!
  implicit def wrapRefArray[T <: AnyRef | Null](arr: IArray[T]): ArraySeq.ofRef[T] =
    // Since the JVM thinks arrays are covariant, one 0-length Array[AnyRef | Null]
    // is as good as another for all T <: AnyRef | Null.  Instead of creating 100,000,000
>>>>>>> NEW
    // unique ones by way of this implicit, let's share one.
<<<<<<< ADDED
    // import scala.language.unsafeNulls
>>>>>>> ADDED
    mapNull(arr,
<<<<<<< OLD
      if (arr.length == 0) ArraySeq.empty[AnyRef].asInstanceOf[ArraySeq.ofRef[T]]
      else ArraySeq.ofRef(arr.asInstanceOf[Array[T]])
=======
      if (arr.length == 0) ArraySeq.empty[AnyRef | Null].asInstanceOf[ArraySeq.ofRef[T]]
      else ArraySeq.ofRef[AnyRef](arr.asInstanceOf[Array[AnyRef]]).asInstanceOf[ArraySeq.ofRef[T]]
>>>>>>> NEW
    )

  /** Conversion from IArray to immutable.ArraySeq */