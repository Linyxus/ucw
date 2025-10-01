  private[ref] val underlying: java.lang.ref.ReferenceQueue[_ <: T] = new java.lang.ref.ReferenceQueue[T]
  override def toString: String = underlying.toString

<<<<<<< OLD
  protected def Wrapper(jref: java.lang.ref.Reference[_]): Option[Reference[T]] =
=======
  protected def Wrapper(jref: java.lang.ref.Reference[_] | Null): Option[Reference[T]] =
>>>>>>> NEW
    jref match {
      case null => None
      case ref => Some(ref.asInstanceOf[ReferenceWithWrapper[T]].wrapper)