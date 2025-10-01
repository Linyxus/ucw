  private[this] val nops = 128
  private[this] val ncodes = 26 * 26

<<<<<<< OLD
  private class OpCodes(val op: Char, val code: String, val next: OpCodes)
=======
  private class OpCodes(val op: Char, val code: String, val next: OpCodes | Null)
>>>>>>> NEW

<<<<<<< OLD
  private[this] val op2code = new Array[String](nops)
  private[this] val code2op = new Array[OpCodes](ncodes)
=======
  private[this] val op2code = new Array[String | Null](nops)
  private[this] val code2op = new Array[OpCodes | Null](ncodes)
>>>>>>> NEW
  private def enterOp(op: Char, code: String) = {
    op2code(op.toInt) = code
    val c = (code.charAt(1) - 'a') * 26 + code.charAt(2) - 'a'
   *  @return     the string with all recognized opchars replaced with their encoding
   */
  def encode(name: String): String = {
<<<<<<< OLD
    var buf: StringBuilder = null
=======
    var buf: StringBuilder | Null = null
>>>>>>> NEW
    val len = name.length()
    var i = 0
    while (i < len) {
          buf = new StringBuilder()
          buf.append(name.substring(0, i))
        }
<<<<<<< OLD
        buf.append(op2code(c.toInt))
=======
        buf.append(op2code(c.toInt).nn)
>>>>>>> NEW
      /* Handle glyphs that are not valid Java/JVM identifiers */
      }
      else if (!Character.isJavaIdentifierPart(c)) {
    //System.out.println("decode: " + name);//DEBUG
    val name = if (name0.endsWith("<init>")) name0.stripSuffix("<init>") + "this"
               else name0
<<<<<<< OLD
    var buf: StringBuilder = null
=======
    var buf: StringBuilder | Null = null
>>>>>>> NEW
    val len = name.length()
    var i = 0
    while (i < len) {
<<<<<<< OLD
      var ops: OpCodes = null
=======
      var ops: OpCodes | Null = null
>>>>>>> NEW
      var unicode = false
      val c = name charAt i
      if (c == '$' && i + 2 < len) {