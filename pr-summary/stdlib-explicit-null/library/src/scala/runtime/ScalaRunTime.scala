    classTag[T].runtimeClass.asInstanceOf[jClass[T]]

  /** Retrieve generic array element */
<<<<<<< OLD
  def array_apply(xs: AnyRef, idx: Int): Any = {
=======
  def array_apply(xs: AnyRef | Null, idx: Int): Any = {
>>>>>>> NEW
    (xs: @unchecked) match {
      case x: Array[AnyRef]  => x(idx).asInstanceOf[Any]
      case x: Array[Int]     => x(idx).asInstanceOf[Any]
  }

  /** update generic array element */
<<<<<<< OLD
  def array_update(xs: AnyRef, idx: Int, value: Any): Unit = {
=======
  def array_update(xs: AnyRef | Null, idx: Int, value: Any): Unit = {
>>>>>>> NEW
    (xs: @unchecked) match {
      case x: Array[AnyRef]  => x(idx) = value.asInstanceOf[AnyRef]
      case x: Array[Int]     => x(idx) = value.asInstanceOf[Int]
  }

  /** Get generic array length */
<<<<<<< OLD
  @inline def array_length(xs: AnyRef): Int = java.lang.reflect.Array.getLength(xs)
=======
  @inline def array_length(xs: AnyRef | Null): Int = java.lang.reflect.Array.getLength(xs)
>>>>>>> NEW

  // TODO: bytecode Object.clone() will in fact work here and avoids
  // the type switch. See Array_clone comment in BCodeBodyBuilder.
<<<<<<< OLD
  def array_clone(xs: AnyRef): AnyRef = (xs: @unchecked) match {
=======
  def array_clone(xs: AnyRef | Null): AnyRef = (xs: @unchecked) match {
>>>>>>> NEW
    case x: Array[AnyRef]  => x.clone()
    case x: Array[Int]     => x.clone()
    case x: Array[Double]  => x.clone()
   *  Needed to deal with vararg arguments of primitive types that are passed
   *  to a generic Java vararg parameter T ...
   */
<<<<<<< OLD
  def toObjectArray(src: AnyRef): Array[Object] = {
=======
  def toObjectArray(src: AnyRef | Null): Array[Object] = {
>>>>>>> NEW
    def copy[@specialized T <: AnyVal](src: Array[T]): Array[Object] = {
      val length = src.length
      if (length == 0) Array.emptyObjectArray
  // Synthetic Java varargs forwarders (@annotation.varargs or varargs bridges when overriding) may pass
  // `null` to these methods; but returning `null` or `ArraySeq(null)` makes little difference in practice.
  def genericWrapArray[T](xs: Array[T]): ArraySeq[T] = ArraySeq.unsafeWrapArray(xs)
<<<<<<< OLD
  def wrapRefArray[T <: AnyRef](xs: Array[T]): ArraySeq[T] = new ArraySeq.ofRef[T](xs)
=======
  def wrapRefArray[T <: AnyRef | Null](xs: Array[T]): ArraySeq[T] = new ArraySeq.ofRef[T](xs)
>>>>>>> NEW
  def wrapIntArray(xs: Array[Int]): ArraySeq[Int] = new ArraySeq.ofInt(xs)
  def wrapDoubleArray(xs: Array[Double]): ArraySeq[Double] = new ArraySeq.ofDouble(xs)
  def wrapLongArray(xs: Array[Long]): ArraySeq[Long] = new ArraySeq.ofLong(xs)