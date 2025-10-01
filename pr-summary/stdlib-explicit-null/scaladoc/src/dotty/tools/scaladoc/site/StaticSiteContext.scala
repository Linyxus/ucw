
  var memberLinkResolver: String => Option[DRI] = _ => None

<<<<<<< OLD
  val docsPath = root.toPath.resolve("_docs")
  val blogPath = root.toPath.resolve("_blog")
=======
  val docsPath: Path = root.toPath.resolve("_docs")
  val blogPath: Path = root.toPath.resolve("_blog")
>>>>>>> NEW

  def resolveNewBlogPath(stringPath: String): Path =
    if stringPath.nonEmpty then root.toPath.resolve(stringPath)

    DRI.forPath(relativePath)

<<<<<<< OLD
  def pathFromRoot(myTemplate: LoadedTemplate) = root.toPath.relativize(myTemplate.file.toPath)
=======
  def pathFromRoot(myTemplate: LoadedTemplate): Path = root.toPath.relativize(myTemplate.file.toPath)
>>>>>>> NEW

  val projectWideProperties =
    Seq("projectName" -> args.name) ++