object Console extends AnsiColor {
  private[this] val outVar = new DynamicVariable[PrintStream](java.lang.System.out)
  private[this] val errVar = new DynamicVariable[PrintStream](java.lang.System.err)
<<<<<<< OLD
  private[this] val inVar  = new DynamicVariable[BufferedReader](null)
=======
  private[this] val inVar  = new DynamicVariable[BufferedReader](null.asInstanceOf[BufferedReader])
>>>>>>> NEW
    //new BufferedReader(new InputStreamReader(java.lang.System.in)))

  protected def setOutDirect(out: PrintStream): Unit  = outVar.value = out