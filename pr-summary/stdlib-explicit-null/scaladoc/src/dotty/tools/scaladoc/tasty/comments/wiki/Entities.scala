final case class HtmlTag(data: String) extends Inline {
  private val Pattern = """(?ms)\A<(/?)(.*?)[\s>].*\z""".r
  private val (isEnd, tagName) = data match {
<<<<<<< OLD
    case Pattern(s1, s2) =>
=======
    case Pattern(s1: String, s2: String) =>
>>>>>>> NEW
      (! s1.isEmpty, Some(s2.toLowerCase))
    case _ =>
      (false, None)