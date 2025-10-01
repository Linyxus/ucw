 * `scala.concurrent.ExecutionContext.Implicits.global`.
 * The recommended approach is to add `(implicit ec: ExecutionContext)` to methods,
 * or class constructor parameters, which need an `ExecutionContext`.
<<<<<<< OLD
 * 
=======
 *
>>>>>>> NEW
 * Then locally import a specific `ExecutionContext` in one place for the entire
 * application or module, passing it implicitly to individual methods.
 * Alternatively define a local implicit val with the required `ExecutionContext`.
   *
   * @return the global [[ExecutionContext]]
   */
<<<<<<< OLD
  final lazy val global: ExecutionContextExecutor = impl.ExecutionContextImpl.fromExecutor(null: Executor)
=======
  final lazy val global: ExecutionContextExecutor = impl.ExecutionContextImpl.fromExecutor(null: Executor | Null)
>>>>>>> NEW

  /**
   * WARNING: Only ever execute logic which will quickly return control to the caller.
   *
   * Do *not* call any blocking code in the `Runnable`s submitted to this `ExecutionContext`
   * as it will prevent progress by other enqueued `Runnable`s and the calling `Thread`.
<<<<<<< OLD
   * 
=======
   *
>>>>>>> NEW
   * Symptoms of misuse of this `ExecutionContext` include, but are not limited to, deadlocks
   * and severe performance problems.
   *
   *  @param reporter  a function for error reporting
   *  @return          the `ExecutionContext` using the given `ExecutorService`
   */
<<<<<<< OLD
  def fromExecutorService(e: ExecutorService, reporter: Throwable => Unit): ExecutionContextExecutorService =
=======
  def fromExecutorService(e: ExecutorService | Null, reporter: Throwable => Unit): ExecutionContextExecutorService =
>>>>>>> NEW
    impl.ExecutionContextImpl.fromExecutorService(e, reporter)

  /** Creates an `ExecutionContext` from the given `ExecutorService` with the [[scala.concurrent.ExecutionContext$.defaultReporter default reporter]].
   *  @param e the `ExecutorService` to use. If `null`, a new `ExecutorService` is created with [[scala.concurrent.ExecutionContext$.global default configuration]].
   *  @return  the `ExecutionContext` using the given `ExecutorService`
   */
<<<<<<< OLD
  def fromExecutorService(e: ExecutorService): ExecutionContextExecutorService = fromExecutorService(e, defaultReporter)
=======
  def fromExecutorService(e: ExecutorService | Null): ExecutionContextExecutorService = fromExecutorService(e, defaultReporter)
>>>>>>> NEW

  /** Creates an `ExecutionContext` from the given `Executor`.
   *
   *  @param reporter  a function for error reporting
   *  @return          the `ExecutionContext` using the given `Executor`
   */
<<<<<<< OLD
  def fromExecutor(e: Executor, reporter: Throwable => Unit): ExecutionContextExecutor =
=======
  def fromExecutor(e: Executor | Null, reporter: Throwable => Unit): ExecutionContextExecutor =
>>>>>>> NEW
    impl.ExecutionContextImpl.fromExecutor(e, reporter)

  /** Creates an `ExecutionContext` from the given `Executor` with the [[scala.concurrent.ExecutionContext$.defaultReporter default reporter]].
   *  @param e the `Executor` to use. If `null`, a new `Executor` is created with [[scala.concurrent.ExecutionContext$.global default configuration]].
   *  @return  the `ExecutionContext` using the given `Executor`
   */
<<<<<<< OLD
  def fromExecutor(e: Executor): ExecutionContextExecutor = fromExecutor(e, defaultReporter)
=======
  def fromExecutor(e: Executor | Null): ExecutionContextExecutor = fromExecutor(e, defaultReporter)
>>>>>>> NEW

  /** The default reporter simply prints the stack trace of the `Throwable` to [[java.lang.System#err System.err]].
   *