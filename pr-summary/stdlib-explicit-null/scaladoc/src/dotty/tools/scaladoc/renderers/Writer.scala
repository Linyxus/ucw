  private val args = summon[DocContext].args

  private def dest(path: String) =
<<<<<<< OLD
    val absPath = args.output.toPath.resolve(path)
=======
    val absPath = args.output.nn.toPath.resolve(path)
>>>>>>> NEW
    if !Files.exists(absPath.getParent) then Files.createDirectories(absPath.getParent)
    absPath
