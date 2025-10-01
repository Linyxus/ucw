import scala.util.matching.Regex

object Test extends App {
<<<<<<< OLD
  def head(s: String, r: Regex): Option[(String, String)] =
=======
  def head(s: String, r: Regex): Option[(String | Null, String | Null)] =
>>>>>>> NEW
    s.trim match {
      case r(hd, tl) => Some((hd, tl))  // error // error // error
      case _ => None