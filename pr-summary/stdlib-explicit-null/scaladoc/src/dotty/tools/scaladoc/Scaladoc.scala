    tastyFiles: Seq[File] = Nil,
    classpath: String = "",
    bootclasspath: String = "",
<<<<<<< OLD
    output: File,
=======
    output: File | Null,
>>>>>>> NEW
    docsRoot: Option[String] = None,
    projectVersion: Option[String] = None,
    projectLogo: Option[String] = None,
      if !ctx.reporter.hasErrors then
        val updatedArgs = parsedArgs.copy(tastyDirs = parsedArgs.tastyDirs, tastyFiles = tastyFiles)

<<<<<<< OLD
        if (parsedArgs.output.exists()) util.IO.delete(parsedArgs.output)
=======
        if (parsedArgs.output.nn.exists()) util.IO.delete(parsedArgs.output)
>>>>>>> NEW

        run(updatedArgs)
        report.inform("Done")
      else report.error("Failure")

<<<<<<< OLD
      if parsedArgs.generateInkuire then dumpInkuireDB(parsedArgs.output.getAbsolutePath, parsedArgs)
=======
      if parsedArgs.generateInkuire then dumpInkuireDB(parsedArgs.output.nn.getAbsolutePath, parsedArgs)
>>>>>>> NEW
    }

    ctx.reporter