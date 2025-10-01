    val sourceCode = source.content().mkString
    sourceCode match {
      case "" => Newline
<<<<<<< OLD
      case CommandExtract(cmd, arg) => {
=======
      case CommandExtract(cmd: String, arg: String) => {
>>>>>>> NEW
        val matchingCommands = commands.filter((command, _) => command.startsWith(cmd))
        matchingCommands match {
          case Nil => UnknownCommand(cmd)