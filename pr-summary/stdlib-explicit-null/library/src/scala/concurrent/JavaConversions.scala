   * Creates a new `ExecutionContext` which uses the provided `ExecutorService`.
   */
  @deprecated("Use `ExecutionContext.fromExecutorService` instead", "2.13.0")
<<<<<<< OLD
  implicit def asExecutionContext(exec: ExecutorService): ExecutionContextExecutorService =
=======
  implicit def asExecutionContext(exec: ExecutorService | Null): ExecutionContextExecutorService =
>>>>>>> NEW
    ExecutionContext.fromExecutorService(exec)

  /**
   * Creates a new `ExecutionContext` which uses the provided `Executor`.
   */
  @deprecated("Use `ExecutionContext.fromExecutor` instead", "2.13.0")
<<<<<<< OLD
  implicit def asExecutionContext(exec: Executor): ExecutionContextExecutor =
=======
  implicit def asExecutionContext(exec: Executor | Null): ExecutionContextExecutor =
>>>>>>> NEW
    ExecutionContext.fromExecutor(exec)

}