
  def loadBlog(): Option[LoadedTemplate] = {
    val blogConfig = BlogParser.readYml(root)
<<<<<<< OLD
    val rootPath = Option(blogConfig.input).map(input => ctx.resolveNewBlogPath(input)).getOrElse(ctx.blogPath)
    val defaultDirectory = Option(blogConfig.output).getOrElse("blog")
=======
    val rootPath = Option.fromNullable(blogConfig.input).map(input => ctx.resolveNewBlogPath(input)).getOrElse(ctx.blogPath)
    val defaultDirectory = Option.fromNullable(blogConfig.output).getOrElse("blog")
>>>>>>> NEW

    type Date = (String, String, String)
    if (!Files.exists(rootPath) || blogConfig.hidden) None
      val indexDest = ctx.docsPath.resolve(defaultDirectory).resolve("index.html")
      val regex = raw"(\d*)-(\d*)-(\d*)-(.*)".r
      def splitDateName(tf: TemplateFile): (Date, String) = tf.file.getName match
<<<<<<< OLD
          case regex(year, month, day, name) => ((year, month, day), name)
=======
          case regex(year: String, month: String, day: String, name: String) => ((year, month, day), name)
>>>>>>> NEW
          case name =>
            report.warn("Incorrect file name for blog post. Post file name should be in format <year>-<month>-<day>-<name>", tf.file)
            (("1900","01","01"), name)