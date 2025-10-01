      val raw = ctx.docCtx.flatMap(_.docstring(sym).map(_.raw)).getOrElse("")
      defs(sym) ++= defines(raw).map { str =>
        val start = skipWhitespace(str, "@define".length)
<<<<<<< OLD
        val (key, Trim(value)) = str.splitAt(skipVariable(str, start)): @unchecked
=======
        val (key, Trim(value: String)) = str.splitAt(skipVariable(str, start)): @unchecked
>>>>>>> NEW
        variableName(key.drop(start)) -> value.replaceAll("\\s+\\*+$", "")
      }
    }