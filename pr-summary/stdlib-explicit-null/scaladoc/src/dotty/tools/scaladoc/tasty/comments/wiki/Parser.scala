  val CLOSE_TAG = "^</([A-Za-z]+)>$".r
  private def readHTMLFrom(begin: HtmlTag): String = {
    val list = mutable.ListBuffer.empty[String]
<<<<<<< OLD
    val stack = mutable.ListBuffer.empty[String]
=======
    val stack = mutable.ListBuffer.empty[String | Null]
>>>>>>> NEW

    begin.close match {
      case Some(HtmlTag(CLOSE_TAG(s))) =>