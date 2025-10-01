  *  @define willNotTerminateInf
  */
class ArrayDeque[A] protected (
<<<<<<< OLD
    protected var array: Array[AnyRef],
=======
    protected var array: Array[AnyRef | Null],
>>>>>>> NEW
    private[ArrayDeque] var start: Int,
    private[ArrayDeque] var end: Int
) extends AbstractBuffer[A]

  reset(array, start, end)

<<<<<<< OLD
  private[this] def reset(array: Array[AnyRef], start: Int, end: Int) = {
=======
  private[this] def reset(array: Array[AnyRef | Null], start: Int, end: Int) = {
>>>>>>> NEW
    assert((array.length & (array.length - 1)) == 0, s"Array.length must be power of 2")
    requireBounds(idx = start, until = array.length)
    requireBounds(idx = end, until = array.length)
    this
  }

<<<<<<< OLD
  protected def ofArray(array: Array[AnyRef], end: Int): ArrayDeque[A] =
=======
  protected def ofArray(array: Array[AnyRef | Null], end: Int): ArrayDeque[A] =
>>>>>>> NEW
    new ArrayDeque[A](array, start = 0, end)

  override def copyToArray[B >: A](dest: Array[B], destStart: Int, len: Int): Int = {
    require(len >= 0, s"Non-negative array size required")
    val size = (1 << 31) >>> java.lang.Integer.numberOfLeadingZeros(len) << 1
    require(size >= 0, s"ArrayDeque too big - cannot allocate ArrayDeque of length $len")
<<<<<<< OLD
    new Array[AnyRef](Math.max(size, DefaultInitialSize))
=======
    new Array[AnyRef | Null](Math.max(size, DefaultInitialSize))
>>>>>>> NEW
  }
}

transparent trait ArrayDequeOps[A, +CC[_] <: caps.Pure, +C <: AnyRef] extends StrictOptimizedSeqOps[A, CC, C] {
<<<<<<< OLD
  protected def array: Array[AnyRef]
=======
  protected def array: Array[AnyRef | Null]
>>>>>>> NEW

  final override def clone(): C = klone()

  protected def klone(): C

<<<<<<< OLD
  protected def ofArray(array: Array[AnyRef], end: Int): C
=======
  protected def ofArray(array: Array[AnyRef | Null], end: Int): C
>>>>>>> NEW

  protected def start_+(idx: Int): Int
