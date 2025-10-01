
    def tryAsDriPlain(str: String): Option[String] =
      val (path, prefix) = str match
<<<<<<< OLD
        case HashRegex(path, prefix) => (path, prefix)
=======
        case HashRegex(path: String, prefix: String) => (path, prefix)
>>>>>>> NEW
        case _ => (str, "")
      val res = ctx.driForLink(content.template.file, path).filter(driExists)
      res.headOption.map(pathToPage(pageDri, _) + prefix)
          case _ => str

      val (path, prefix) = newStr match
<<<<<<< OLD
        case HashRegex(path, prefix) => (path, prefix)
=======
        case HashRegex(path: String, prefix: String) => (path, prefix)
>>>>>>> NEW
        case _ => (newStr, "")

      val res = ctx.driForLink(content.template.file, path).filter(driExists)