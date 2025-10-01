  @annotation.nowarn("msg=package object inheritance")
  object `package` extends ProcessImplicits {
    /** The input stream of this process */
<<<<<<< OLD
    def stdin  = java.lang.System.in
=======
    def stdin: java.io.InputStream = java.lang.System.in
>>>>>>> NEW
    /** The output stream of this process */
<<<<<<< OLD
    def stdout = java.lang.System.out
=======
    def stdout: java.io.PrintStream = java.lang.System.out
>>>>>>> NEW
    /** The error stream of this process */
<<<<<<< OLD
    def stderr = java.lang.System.err
=======
    def stderr: java.io.PrintStream = java.lang.System.err
>>>>>>> NEW
  }
  // private val shell: String => Array[String] =
  //   if (isWin) Array("cmd.exe", "/C", _)