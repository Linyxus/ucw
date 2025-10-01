  def createBufferedSource(
    inputStream: InputStream,
    bufferSize: Int = DefaultBufSize,
<<<<<<< OLD
    reset: () => Source = null,
    close: () => Unit = null
=======
    reset: (() => Source) | Null = null,
    close: (() => Unit) | Null = null
>>>>>>> NEW
  )(implicit codec: Codec): BufferedSource = {
    // workaround for default arguments being unable to refer to other parameters
    val resetFn = if (reset == null) () => createBufferedSource(inputStream, bufferSize, reset, close)(codec) else reset
    report(pos, "warning! " + msg, out)
  }

<<<<<<< OLD
  private[this] var resetFunction: () => Source = null
  private[this] var closeFunction: () => Unit = null
=======
  @annotation.stableNull
  private[this] var resetFunction: (() => Source) | Null = null
  @annotation.stableNull
  private[this] var closeFunction: (() => Unit) | Null = null
>>>>>>> NEW
  private[this] var positioner: Positioner = RelaxedPositioner

<<<<<<< OLD
  def withReset(f: () => Source): this.type = {
=======
  def withReset(f: (() => Source) | Null): this.type = {
>>>>>>> NEW
    resetFunction = f
    this
  }
<<<<<<< OLD
  def withClose(f: () => Unit): this.type = {
=======
  def withClose(f: (() => Unit) | Null): this.type = {
>>>>>>> NEW
    closeFunction = f
    this
  }