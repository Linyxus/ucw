}

private[concurrent] object BatchingExecutorStatics {
<<<<<<< OLD
  final val emptyBatchArray: Array[Runnable] = new Array[Runnable](0)
=======
  final val emptyBatchArray: Array[Runnable | Null] = new Array[Runnable | Null](0)
>>>>>>> NEW

  // Max number of Runnables executed nested before starting to batch (to prevent stack exhaustion)
  final val syncPreBatchDepth = 16
   * In order to conserve allocations, the first element in the batch is stored "unboxed" in
   * the `first` field. Subsequent Runnables are stored in the array called `other`.
  */
<<<<<<< OLD
  private[this] sealed abstract class AbstractBatch protected (protected final var first: Runnable, protected final var other: Array[Runnable], protected final var size: Int) {
=======
  private[this] sealed abstract class AbstractBatch protected (
    @annotation.stableNull protected final var first: Runnable | Null,
    @annotation.stableNull protected final var other: Array[Runnable | Null],
    protected final var size: Int
  ) {
>>>>>>> NEW

<<<<<<< OLD
    private[this] final def ensureCapacity(curSize: Int): Array[Runnable] = {
=======
    private[this] final def ensureCapacity(curSize: Int): Array[Runnable | Null] = {
>>>>>>> NEW
      val curOther = this.other
      val curLen = curOther.length
      if (curSize <= curLen) curOther
        val newLen = if (curLen == 0) 4 else curLen << 1

        if (newLen <= curLen) throw new StackOverflowError("Space limit of asynchronous stack reached: " + curLen)
<<<<<<< OLD
        val newOther = new Array[Runnable](newLen)
=======
        val newOther = new Array[Runnable | Null](newLen)
>>>>>>> NEW
        System.arraycopy(curOther, 0, newOther, 0, curLen)
        this.other = newOther
        newOther
        (this.size: @switch) match {
          case 0 =>
          case 1 =>
<<<<<<< OLD
            val next = this.first
=======
            val next = this.first.nn
>>>>>>> NEW
            this.first = null
            this.size = 0
            next.run()
            runN(n - 1)
          case sz =>
            val o = this.other
<<<<<<< OLD
            val next = o(sz - 2)
=======
            val next = o(sz - 2).nn
>>>>>>> NEW
            o(sz - 2) = null
            this.size = sz - 1
            next.run()
          }
  }

<<<<<<< OLD
  private[this] final class AsyncBatch private(_first: Runnable, _other: Array[Runnable], _size: Int) extends AbstractBatch(_first, _other, _size) with Runnable with BlockContext with (BlockContext => Throwable) {
    private[this] final var parentBlockContext: BlockContext = BatchingExecutorStatics.MissingParentBlockContext
=======
  private[this] final class AsyncBatch private(_first: Runnable | Null, _other: Array[Runnable | Null], _size: Int) extends AbstractBatch(_first, _other, _size) with Runnable with BlockContext with (BlockContext => Throwable | Null) {
    @annotation.stableNull private[this] final var parentBlockContext: BlockContext = BatchingExecutorStatics.MissingParentBlockContext
>>>>>>> NEW

    final def this(runnable: Runnable) = this(runnable, BatchingExecutorStatics.emptyBatchArray, 1)

    }

    /* LOGIC FOR ASYNCHRONOUS BATCHES */
<<<<<<< OLD
    override final def apply(prevBlockContext: BlockContext): Throwable = try {
=======
    override final def apply(prevBlockContext: BlockContext): Throwable | Null = try {
>>>>>>> NEW
      parentBlockContext = prevBlockContext
      runN(BatchingExecutorStatics.runLimit)
      null
     * Only attempt to resubmit when there are `Runnables` left to process.
     * Note that `cause` can be `null`.
     */
<<<<<<< OLD
    private[this] final def resubmit(cause: Throwable): Throwable =
=======
    private[this] final def resubmit(cause: Throwable | Null): Throwable | Null =
>>>>>>> NEW
      if (this.size > 0) {
        try { submitForExecution(this); cause } catch {
          case inner: Throwable =>