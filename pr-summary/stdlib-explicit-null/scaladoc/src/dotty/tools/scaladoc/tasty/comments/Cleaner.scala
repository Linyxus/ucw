    def cleanLine(line: String): String = {
      // Remove trailing whitespaces
      TrailingWhitespace.replaceAllIn(line, "") match {
<<<<<<< OLD
        case CleanCommentLine(ctl) => ctl
=======
        case CleanCommentLine(ctl: String) => ctl
>>>>>>> NEW
        case tl => tl
      }
    }