      writer.close()
  end writeJarfile

<<<<<<< OLD
  def pathsep = sys.props("path.separator")
=======
  def pathsep: String = sys.props("path.separator").nn
>>>>>>> NEW

  extension(path: String) {
    // Normalize path separator, convert relative path to absolute
    def secondChar: String = path.take(2).drop(1).mkString("")
  }

<<<<<<< OLD
  lazy val userDir = sys.props("user.dir").norm
=======
  lazy val userDir: String = sys.props("user.dir").nn.norm
>>>>>>> NEW