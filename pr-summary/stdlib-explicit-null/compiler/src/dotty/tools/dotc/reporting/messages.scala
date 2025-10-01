      val idx = paramNames.indexOf(name)
      if (idx >= 0) Some(i"${args(idx)}") else None
    """\$\{\s*([^}\s]+)\s*\}""".r.replaceAllIn(raw, (_: Regex.Match) match
<<<<<<< OLD
      case Regex.Groups(v) => quoteReplacement(translate(v).getOrElse("?" + v)).nn
=======
      case Regex.Groups(v: String) => quoteReplacement(translate(v).getOrElse("?" + v)).nn
>>>>>>> NEW
    )

  /** @param rawMsg           Message template with variables, e.g. "Variable A is ${A}"