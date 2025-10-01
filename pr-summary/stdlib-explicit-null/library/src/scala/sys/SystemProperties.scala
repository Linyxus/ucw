 *  @define coll mutable map
 */
class SystemProperties
<<<<<<< OLD
extends mutable.AbstractMap[String, String] {
=======
extends mutable.AbstractMap[String, String | Null] {
>>>>>>> NEW

<<<<<<< OLD
  override def empty: mutable.Map[String, String] = mutable.Map[String, String]()
  override def default(key: String): String = null
=======
  override def empty: mutable.Map[String, String | Null] = mutable.Map[String, String | Null]()
  override def default(key: String): String | Null = null
>>>>>>> NEW

<<<<<<< OLD
  def iterator: Iterator[(String, String)] = wrapAccess {
=======
  def iterator: Iterator[(String, String | Null)] = wrapAccess {
>>>>>>> NEW
    val ps = System.getProperties()
    names map (k => (k, ps getProperty k)) filter (_._2 ne null)
  } getOrElse Iterator.empty

  override def clear(): Unit = wrapAccess(System.getProperties().clear())
  def subtractOne (key: String): this.type = { wrapAccess(System.clearProperty(key)) ; this }
<<<<<<< OLD
  def addOne (kv: (String, String)): this.type = { wrapAccess(System.setProperty(kv._1, kv._2)) ; this }
=======
  def addOne (kv: (String, String | Null)): this.type = { wrapAccess(System.setProperty(kv._1, kv._2)) ; this }
>>>>>>> NEW

  @annotation.nowarn("cat=deprecation") // AccessControlException is deprecated on JDK 17
  def wrapAccess[T](body: => T): Option[T] =
  lazy val preferIPv6Addresses: BooleanProp = BooleanProp.keyExists(PreferIPv6AddressesKey)
  lazy val noTraceSuppression: BooleanProp  = BooleanProp.valueIsTrue(NoTraceSuppressionKey)
}
<<<<<<< REMOVED

>>>>>>> REMOVED