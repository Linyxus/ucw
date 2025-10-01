  /** Returns this string with the given `prefix` stripped. If this string does not
    *  start with `prefix`, it is returned unchanged.
    */
<<<<<<< OLD
  def stripPrefix(prefix: String) =
=======
  def stripPrefix(prefix: String): String =
>>>>>>> NEW
    if (s startsWith prefix) s.substring(prefix.length)
    else s

  /** Returns this string with the given `suffix` stripped. If this string does not
    *  end with `suffix`, it is returned unchanged.
    */
<<<<<<< OLD
  def stripSuffix(suffix: String) =
=======
  def stripSuffix(suffix: String): String =
>>>>>>> NEW
    if (s endsWith suffix) s.substring(0, s.length - suffix.length)
    else s
