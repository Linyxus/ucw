  private[immutable] final class Node[K, V](
    override private[immutable] val key: K,
    private[immutable] var _value: V,
<<<<<<< OLD
    private[immutable] var _init: ListMap[K, V]
=======
    private[immutable] var _init: ListMap[K, V] | Null
>>>>>>> NEW
  ) extends ListMap[K, V] {
    releaseFence()


      if (found) {
        if (isDifferent) {
<<<<<<< OLD
          var newHead: ListMap.Node[K, V1] = null
          var prev: ListMap.Node[K, V1] = null
=======
          var newHead: ListMap.Node[K, V1] | Null = null
          var prev: ListMap.Node[K, V1] | Null = null
>>>>>>> NEW
          var curr: ListMap[K, V1] = this
          var i = 0
          while (i < index) {
            val temp = new ListMap.Node(curr.key, curr.value, null)
<<<<<<< OLD
            if (prev ne null) {
=======
            if (prev != null) {
>>>>>>> NEW
              prev._init = temp
            }
            prev = temp
            curr = curr.init
<<<<<<< OLD
            if (newHead eq null) {
=======
            if (newHead == null) {
>>>>>>> NEW
              newHead = prev
            }
            i += 1
          }
          val newNode = new ListMap.Node(curr.key, v, curr.init)
<<<<<<< OLD
          if (prev ne null) {
=======
          if (prev != null) {
>>>>>>> NEW
            prev._init = newNode
          }
          releaseFence()
<<<<<<< OLD
          if (newHead eq null) newNode else newHead
=======
          if (newHead == null) newNode else newHead
>>>>>>> NEW
        } else {
          this
        }

    override def removed(k: K): ListMap[K, V] = removeInternal(k, this, Nil)

<<<<<<< OLD
    override private[immutable] def next: ListMap[K, V] = _init
=======
    override private[immutable] def next: ListMap[K, V] = _init.nn
>>>>>>> NEW

    override def last: (K, V) = (key, value)
    override def init: ListMap[K, V] = next