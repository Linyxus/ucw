private[sys] class PropImpl[+T](val key: String, valueFn: String => T) extends Prop[T] {
  def value: T = if (isSet) valueFn(get) else zero
  def isSet    = underlying contains key
<<<<<<< OLD
  def set(newValue: String): String = {
    val old = if (isSet) get else null
=======
  def set(newValue: String | Null): String | Null = {
    val old: String | Null = if (isSet) get else null
>>>>>>> NEW
    underlying(key) = newValue
    old
  }
    old
  }
  def get: String =
<<<<<<< OLD
    if (isSet) underlying.getOrElse(key, "")
=======
    if (isSet) underlying.getOrElse(key, "").nn
>>>>>>> NEW
    else ""

  def clear(): Unit = underlying -= key
  def or[T1 >: T](alt: => T1): T1 = if (isSet) value else alt

  /** The underlying property map, in our case always sys.props */
<<<<<<< OLD
  protected def underlying: mutable.Map[String, String] = scala.sys.props
=======
  protected def underlying: mutable.Map[String, String | Null] = scala.sys.props
>>>>>>> NEW
  protected def zero: T = null.asInstanceOf[T]
  private def getString = if (isSet) "currently: " + get else "unset"
  override def toString = "%s (%s)".format(key, getString)
private[sys] abstract class CreatorImpl[+T](f: String => T) extends Prop.Creator[T] {
  def apply(key: String): Prop[T] = new PropImpl[T](key, f)
}
<<<<<<< REMOVED

>>>>>>> REMOVED