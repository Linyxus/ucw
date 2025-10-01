package dotty.tools.scaladoc.util

object Escape:
<<<<<<< OLD
  def escapeUrl(url: String) = url
=======
  def escapeUrl(url: String): String = url
>>>>>>> NEW
    .replace("#","%23")

<<<<<<< OLD
  def escapeFilename(filename: String) =
=======
  def escapeFilename(filename: String): String =
>>>>>>> NEW
    // from compiler/src/dotty/tools/dotc/util/NameTransformer.scala
    val escaped = filename
      .replace("~", "$tilde")