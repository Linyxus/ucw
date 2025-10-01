      val tStopAtLvl="-XX:TieredStopAtLevel=1"
      println(s"ignoring deprecated -Oshort flag, please add `-J$addTC` and `-J$tStopAtLvl` flags manually")
      process(tail, settings)
<<<<<<< OLD
    case javaOption(stripped) :: tail =>
=======
    case javaOption(stripped: String) :: tail =>
>>>>>>> NEW
      process(tail, settings.withJavaArgs(stripped))
<<<<<<< OLD
    case javaPropOption(opt, value) :: tail =>
=======
    case javaPropOption(opt: String, value: String) :: tail =>
>>>>>>> NEW
      process(tail, settings.withJavaProps(opt -> value))
    case arg :: tail =>
      process(tail, settings.withResidualArgs(arg))