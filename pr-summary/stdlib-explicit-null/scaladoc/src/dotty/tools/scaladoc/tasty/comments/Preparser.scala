      remaining: List[String],
      inCodeBlock: Boolean,
    )(using strippedLinesBeforeNo: Int = 0): PreparsedComment = remaining match {
<<<<<<< OLD
      case CodeBlockStartRegex(before, marker, after) :: ls if !inCodeBlock =>
=======
      case CodeBlockStartRegex(before: String, marker: String, after: String) :: ls if !inCodeBlock =>
>>>>>>> NEW
        if (!before.trim.isEmpty && !after.trim.isEmpty && marker == "```")
          go(docBody, tags, lastTagKey, before :: (marker + after) :: ls, inCodeBlock = false)
        else if (!before.trim.isEmpty && !after.trim.isEmpty)
            go(docBody append endOfLine append (marker + after), tags, lastTagKey, ls, inCodeBlock = true)
        }

<<<<<<< OLD
      case CodeBlockEndRegex(before, marker, after) :: ls =>
=======
      case CodeBlockEndRegex(before: String, marker: String, after: String) :: ls =>
>>>>>>> NEW
        if (!before.trim.isEmpty && !after.trim.isEmpty)
          go(docBody, tags, lastTagKey, before :: marker :: after :: ls, inCodeBlock = true)
        else if (!before.trim.isEmpty)
        }


<<<<<<< OLD
      case SymbolTagRegex(name, sym, body) :: ls if !inCodeBlock =>
=======
      case SymbolTagRegex(name: String, sym: String, body: String) :: ls if !inCodeBlock =>
>>>>>>> NEW
        val key = SymbolTagKey(name, sym)
        val value = body :: tags.getOrElse(key, Nil)
        go(docBody, tags + (key -> value), Some(key), ls, inCodeBlock)

<<<<<<< OLD
      case SimpleTagRegex(name, body) :: ls if !inCodeBlock =>
=======
      case SimpleTagRegex(name: String, body: String) :: ls if !inCodeBlock =>
>>>>>>> NEW
        val key = SimpleTagKey(name)
        val value = body :: tags.getOrElse(key, Nil)
        go(docBody, tags + (key -> value), Some(key), ls, inCodeBlock)


<<<<<<< OLD
      case SingleTagRegex(name) :: ls if !inCodeBlock =>
=======
      case SingleTagRegex(name: String) :: ls if !inCodeBlock =>
>>>>>>> NEW
        val key = SimpleTagKey(name)
        val value = "" :: tags.getOrElse(key, Nil)
        go(docBody, tags + (key -> value), Some(key), ls, inCodeBlock)