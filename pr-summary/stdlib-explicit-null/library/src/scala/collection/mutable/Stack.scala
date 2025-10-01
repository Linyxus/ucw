 *  @define willNotTerminateInf
 */
@migration("Stack is now based on an ArrayDeque instead of a linked list", "2.13.0")
<<<<<<< OLD
class Stack[A] protected (array: Array[AnyRef], start: Int, end: Int)
=======
class Stack[A] protected (array: Array[AnyRef | Null], start: Int, end: Int)
>>>>>>> NEW
  extends ArrayDeque[A](array, start, end)
    with IndexedSeqOps[A, Stack, Stack[A]]
    with StrictOptimizedSeqOps[A, Stack, Stack[A]]
    bf.result()
  }

<<<<<<< OLD
  override protected def ofArray(array: Array[AnyRef], end: Int): Stack[A] =
=======
  override protected def ofArray(array: Array[AnyRef | Null], end: Int): Stack[A] =
>>>>>>> NEW
    new Stack(array, start = 0, end)

}