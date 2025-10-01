    }
  }

<<<<<<< OLD
  def fromExecutor(e: Executor, reporter: Throwable => Unit = ExecutionContext.defaultReporter): ExecutionContextExecutor =
=======
  def fromExecutor(e: Executor | Null, reporter: Throwable => Unit = ExecutionContext.defaultReporter): ExecutionContextExecutor =
>>>>>>> NEW
    e match {
      case null => createDefaultExecutorService(reporter)
      case some => new ExecutionContextImpl(some, reporter)
    }

<<<<<<< OLD
  def fromExecutorService(es: ExecutorService, reporter: Throwable => Unit = ExecutionContext.defaultReporter):
=======
  def fromExecutorService(es: ExecutorService | Null, reporter: Throwable => Unit = ExecutionContext.defaultReporter):
>>>>>>> NEW
    ExecutionContextExecutorService = es match {
      case null => createDefaultExecutorService(reporter)
      case some =>
<<<<<<< ADDED
        // This is a anonymous class extending a Java class, so we left inferred flexible types in the signatures.
>>>>>>> ADDED
        new ExecutionContextImpl(some, reporter) with ExecutionContextExecutorService {
            private[this] final def asExecutorService: ExecutorService = executor.asInstanceOf[ExecutorService]
            final override def shutdown() = asExecutorService.shutdown()