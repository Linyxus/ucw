        catch   { case _: IOException => }
    }

<<<<<<< OLD
  def propIsSet(name: String)                   = System.getProperty(name) != null
  def propIsSetTo(name: String, value: String)  = propOrNull(name) == value
  def propOrElse(name: String, alt: => String)  = Option(System.getProperty(name)).getOrElse(alt)
  def propOrEmpty(name: String)                 = propOrElse(name, "")
  def propOrNull(name: String)                  = propOrElse(name, null)
  def propOrNone(name: String)                  = Option(propOrNull(name))
  def propOrFalse(name: String)                 = propOrNone(name) exists (x => List("yes", "on", "true") contains x.toLowerCase)
  def setProp(name: String, value: String)      = System.setProperty(name, value)
  def clearProp(name: String)                   = System.clearProperty(name)

  def envOrElse(name: String, alt: => String)   = Option(System getenv name) getOrElse alt
  def envOrNone(name: String)                   = Option(System getenv name)
=======
  def propIsSet(name: String): Boolean                   = System.getProperty(name) != null
  def propIsSetTo(name: String, value: String)           = propOrNull(name) == value
  def propOrNone(name: String): Option[String]           = Option[String](System.getProperty(name))
  def propOrElse(name: String, alt: => String): String   = propOrNone(name).getOrElse(alt)
  def propOrEmpty(name: String): String                  = propOrElse(name, "")
  def propOrNull(name: String): String | Null            = propOrNone(name).orNull
  def propOrFalse(name: String): Boolean                 = propOrNone(name) exists (x => List("yes", "on", "true") contains x.toLowerCase)
  def setProp(name: String, value: String): String       = System.setProperty(name, value)
  def clearProp(name: String): String                    = System.clearProperty(name)

  def envOrElse(name: String, alt: => String): String    = Option(System getenv name) getOrElse alt
  def envOrNone(name: String): Option[String]            = Option(System getenv name)
>>>>>>> NEW

  def envOrSome(name: String, alt: => Option[String])    = envOrNone(name) orElse alt


  /** The default end of line character.
   */
<<<<<<< OLD
  def lineSeparator         = System.lineSeparator()
=======
  def lineSeparator: String = System.lineSeparator()
>>>>>>> NEW

  /* Various well-known properties. */
  def javaClassPath         = propOrEmpty("java.class.path")