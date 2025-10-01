  *  @define mayNotTerminateInf
  *  @define willNotTerminateInf
  */
<<<<<<< OLD
class Queue[A] protected (array: Array[AnyRef], start: Int, end: Int)
=======
class Queue[A] protected (array: Array[AnyRef | Null], start: Int, end: Int)
>>>>>>> NEW
  extends ArrayDeque[A](array, start, end)
    with IndexedSeqOps[A, Queue, Queue[A]]
    with StrictOptimizedSeqOps[A, Queue, Queue[A]]
    bf.result()
  }

<<<<<<< OLD
  override protected def ofArray(array: Array[AnyRef], end: Int): Queue[A] =
=======
  override protected def ofArray(array: Array[AnyRef | Null], end: Int): Queue[A] =
>>>>>>> NEW
    new Queue(array, start = 0, end)

}