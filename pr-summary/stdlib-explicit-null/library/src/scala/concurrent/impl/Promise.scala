  */
private[impl] final class CompletionLatch[T] extends AbstractQueuedSynchronizer with (Try[T] => Unit) {
  //@volatie not needed since we use acquire/release
<<<<<<< OLD
  /*@volatile*/ private[this] var _result: Try[T] = null
  final def result: Try[T] = _result
=======
  /*@volatile*/ @annotation.stableNull private[this] var _result: Try[T] | Null = null
  final def result: Try[T] | Null = _result
>>>>>>> NEW
  override protected def tryAcquireShared(ignored: Int): Int = if (getState != 0) 1 else -1
  override protected def tryReleaseShared(ignore: Int): Boolean = {
    setState(1)
      else /*if (state.isInstanceOf[Callbacks[T]]) */ "Future(<not completed>)"
    }

<<<<<<< OLD
    private[this] final def tryAwait0(atMost: Duration): Try[T] =
=======
    private[this] final def tryAwait0(atMost: Duration): Try[T] | Null =
>>>>>>> NEW
      if (atMost ne Duration.Undefined) {
        val v = value0
        if (v ne null) v

    @throws(classOf[Exception])
    final def result(atMost: Duration)(implicit permit: CanAwait): T =
<<<<<<< OLD
      tryAwait0(atMost).get // returns the value, or throws the contained exception
=======
      tryAwait0(atMost).nn.get // returns the value, or throws the contained exception
>>>>>>> NEW

    override final def isCompleted: Boolean = value0 ne null

<<<<<<< OLD
    override final def value: Option[Try[T]] = Option(value0)
=======
    override final def value: Option[Try[T]] = Option(value0).asInstanceOf[Option[Try[T]]]
>>>>>>> NEW

    @tailrec // returns null if not completed
<<<<<<< OLD
    private final def value0: Try[T] = {
=======
    private final def value0: Try[T] | Null = {
>>>>>>> NEW
      val state = get()
      if (state.isInstanceOf[Try[_]]) state.asInstanceOf[Try[T]]
      else if (state.isInstanceOf[Link[_]]) state.asInstanceOf[Link[T]].promise(this).value0
        concatCallbacks(m.rest, new ManyCallbacks(m.first, right))
      }

<<<<<<< OLD
    @tailrec private[this] final def removeCallback(cs: Callbacks[T], t: Transformation[_, _], result: Callbacks[T] = null): AnyRef =
=======
    @tailrec private[this] final def removeCallback(cs: Callbacks[T], t: Transformation[_, _], result: Callbacks[T] | Null = null): AnyRef =
>>>>>>> NEW
      if (cs eq t) {
        if (result == null) Noop
        else result

    /** Link this promise to the root of another promise.
     */
<<<<<<< OLD
    @tailrec private[concurrent] final def linkRootOf(target: DefaultPromise[T], link: Link[T]): Unit =
=======
    @tailrec private[concurrent] final def linkRootOf(target: DefaultPromise[T], link: Link[T] | Null): Unit =
>>>>>>> NEW
      if (this ne target) {
        val state = get()
        if (state.isInstanceOf[Try[_]]) {
    override final def toString: String = "ManyCallbacks"
  }

<<<<<<< OLD
  private[this] final val Noop = new Transformation[Nothing, Nothing](Xform_noop, null, ExecutionContext.parasitic)
=======
  private[this] final val Noop = new Transformation[Nothing, Nothing](Xform_noop, null: (Any => Any) | Null, ExecutionContext.parasitic)
>>>>>>> NEW

  /**
   * A Transformation[F, T] receives an F (it is a Callback[F]) and applies a transformation function to that F,
   * function's type parameters are erased, and the _xform tag will be used to reify them.
   **/
  final class Transformation[-F, T] private[this] (
<<<<<<< OLD
    private[this] final var _fun: Any => Any,
    private[this] final var _ec: ExecutionContext,
    private[this] final var _arg: Try[F],
=======
    @annotation.stableNull private[this] final var _fun: (Any => Any) | Null,
    @annotation.stableNull private[this] final var _ec: ExecutionContext | Null,
    @annotation.stableNull private[this] final var _arg: Try[F] | Null,
>>>>>>> NEW
    private[this] final val _xform: Int
  ) extends DefaultPromise[T]() with Callbacks[F] with Runnable with Batchable {
<<<<<<< OLD
    final def this(xform: Int, f: _ => _, ec: ExecutionContext) =
      this(f.asInstanceOf[Any => Any], ec.prepare(): @nowarn("cat=deprecation"), null, xform)
=======
    final def this(xform: Int, f: (_ => _) | Null, ec: ExecutionContext) =
      this(f.asInstanceOf[(Any => Any) | Null], ec.prepare(): @nowarn("cat=deprecation"), null, xform)
>>>>>>> NEW

    final def benefitsFromBatching: Boolean = _xform != Xform_onComplete && _xform != Xform_foreach

    final def submitWithValue(resolved: Try[F]): this.type = {
      _arg = resolved
      val e = _ec
<<<<<<< OLD
      try e.execute(this) /* Safe publication of _arg, _fun, _ec */
=======
      try e.nn.execute(this) /* Safe publication of _arg, _fun, _ec */
>>>>>>> NEW
      catch {
        case t: Throwable =>
          _fun = null // allow to GC
          _arg = null // see above
          _ec  = null // see above again
<<<<<<< OLD
          handleFailure(t, e)
=======
          handleFailure(t, e.nn)
>>>>>>> NEW
      }

      this

    // Gets invoked by the ExecutionContext, when we have a value to transform.
    override final def run(): Unit = {
<<<<<<< OLD
      val v   = _arg
      val fun = _fun
      val ec  = _ec
=======
      val v   = _arg.nn
      val fun = _fun.nn
      val ec  = _ec.nn
>>>>>>> NEW
      _fun = null // allow to GC
      _arg = null // see above
      _ec  = null // see above
      try {
<<<<<<< OLD
        val resolvedResult: Try[_] =
=======
        val resolvedResult: Try[_] | Null =
>>>>>>> NEW
          (_xform: @switch) match {
            case Xform_noop          =>
              null