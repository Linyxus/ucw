      processArgs(tail, settings.noSave)
    case "-with-compiler" :: tail =>
      processArgs(tail, settings.withCompiler)
<<<<<<< OLD
    case (o @ javaOption(striped)) :: tail =>
=======
    case (o @ javaOption(striped: String)) :: tail =>
>>>>>>> NEW
      processArgs(tail, settings.withJavaArgs(striped).withScalaArgs(o))
    case (o @ scalaOption(_*)) :: tail =>
      val remainingArgs = CommandLineParser.expandArg(o) ++ tail