
import scala.language.`2.13`
import language.experimental.captureChecking
<<<<<<< ADDED

>>>>>>> ADDED
import scala.annotation.{nowarn, tailrec}
import scala.collection.Stepper.EfficientSplit
import scala.collection.generic.DefaultSerializationProxy
  import HashMap.Node

  /** The actual hash table. */
<<<<<<< OLD
  private[this] var table = new Array[Node[K, V]](tableSizeFor(initialCapacity))
=======
  private[this] var table = new Array[Node[K, V] | Null](tableSizeFor(initialCapacity))
>>>>>>> NEW

  /** The next size value at which to resize (capacity * load factor). */
  private[this] var threshold: Int = newThreshold(table.length)

  override def contains(key: K): Boolean = findNode(key) ne null

<<<<<<< OLD
  @`inline` private[this] def findNode(key: K): Node[K, V] = {
=======
  @`inline` private[this] def findNode(key: K): Node[K, V] | Null = {
>>>>>>> NEW
    val hash = computeHash(key)
    table(index(hash)) match {
      case null => null
      val hash = computeHash(key)
      val indexedHash = index(hash)

<<<<<<< OLD
      var foundNode: Node[K, V] = null
      var previousNode: Node[K, V] = null
=======
      var foundNode: Node[K, V] | Null = null
      var previousNode: Node[K, V] | Null = null
>>>>>>> NEW
      table(indexedHash) match {
        case null =>
        case nd =>
          @tailrec
<<<<<<< OLD
          def findNode(prev: Node[K, V], nd: Node[K, V], k: K, h: Int): Unit = {
=======
          def findNode(prev: Node[K, V] | Null, nd: Node[K, V], k: K, h: Int): Unit = {
>>>>>>> NEW
            if (h == nd.hash && k == nd.key) {
              previousNode = prev
              foundNode = nd
            }
<<<<<<< OLD
            else if ((nd.next eq null) || (nd.hash > h)) ()
            else findNode(nd, nd.next, k, h)
=======
            else {
              val ndNext = nd.next
              if ((ndNext eq null) || (nd.hash > h)) ()
              else findNode(nd, ndNext, k, h)
            }
>>>>>>> NEW
          }

          findNode(null, nd, key, hash)
        case (None, None) => // do nothing

        case (Some(_), None) =>
<<<<<<< OLD
          if (previousNode != null) previousNode.next = foundNode.next
          else table(indexedHash) = foundNode.next
=======
          if (previousNode != null) previousNode.nn.next = foundNode.nn.next
          else table(indexedHash) = foundNode.nn.next
>>>>>>> NEW
          contentSize -= 1

        case (None, Some(value)) =>
            } else indexedHash
          put0(key, value, getOld = false, hash, newIndexedHash)

<<<<<<< OLD
        case (Some(_), Some(newValue)) => foundNode.value = newValue
=======
        case (Some(_), Some(newValue)) => foundNode.nn.value = newValue
>>>>>>> NEW
      }
      nextValue
    }
    * @param hash the **improved** hashcode of `key` (see computeHash)
    * @param getOld if true, then the previous value for `key` will be returned, otherwise, false
    */
<<<<<<< OLD
  private[this] def put0(key: K, value: V, hash: Int, getOld: Boolean): Some[V] = {
=======
  private[this] def put0(key: K, value: V, hash: Int, getOld: Boolean): Some[V] | Null = {
>>>>>>> NEW
    if(contentSize + 1 >= threshold) growTable(table.length * 2)
    val idx = index(hash)
    put0(key, value, getOld, hash, idx)
  }

<<<<<<< OLD
  private[this] def put0(key: K, value: V, getOld: Boolean): Some[V] = {
=======
  private[this] def put0(key: K, value: V, getOld: Boolean): Some[V] | Null = {
>>>>>>> NEW
    if(contentSize + 1 >= threshold) growTable(table.length * 2)
    val hash = computeHash(key)
    val idx = index(hash)
  }


<<<<<<< OLD
  private[this] def put0(key: K, value: V, getOld: Boolean, hash: Int, idx: Int): Some[V] = {
=======
  private[this] def put0(key: K, value: V, getOld: Boolean, hash: Int, idx: Int): Some[V] | Null = {
>>>>>>> NEW
    table(idx) match {
      case null =>
        table(idx) = new Node[K, V](key, hash, value, null)
      case old =>
<<<<<<< OLD
        var prev: Node[K, V] = null
        var n = old
=======
        var prev: Node[K, V] | Null = null
        var n: Node[K, V] | Null = old
>>>>>>> NEW
        while((n ne null) && n.hash <= hash) {
          if(n.hash == hash && key == n.key) {
            val old = n.value
    null
  }

<<<<<<< OLD
  private def remove0(elem: K) : Node[K, V] = remove0(elem, computeHash(elem))
=======
  private def remove0(elem: K) : Node[K, V] | Null = remove0(elem, computeHash(elem))
>>>>>>> NEW

  /** Removes a key from this map if it exists
    *
    * @param hash the **improved** hashcode of `element` (see computeHash)
    * @return the node that contained element if it was present, otherwise null
    */
<<<<<<< OLD
  private[this] def remove0(elem: K, hash: Int) : Node[K, V] = {
=======
  private[this] def remove0(elem: K, hash: Int) : Node[K, V] | Null = {
>>>>>>> NEW
    val idx = index(hash)
    table(idx) match {
      case null => null

  private[this] abstract class HashMapIterator[A] extends AbstractIterator[A] {
    private[this] var i = 0
<<<<<<< OLD
    private[this] var node: Node[K, V] = null
=======
    private[this] var node: Node[K, V] | Null = null
>>>>>>> NEW
    private[this] val len = table.length

    protected[this] def extract(nd: Node[K, V]): A
    def next(): A =
      if(!hasNext) Iterator.empty.next()
      else {
<<<<<<< OLD
        val r = extract(node)
        node = node.next
=======
        val r = extract(node.nn)
        node = node.nn.next
>>>>>>> NEW
        r
      }
  }

  override def stepper[S <: Stepper[_]](implicit shape: StepperShape[(K, V), S]): S with EfficientSplit =
    shape.
<<<<<<< OLD
      parUnbox(new convert.impl.AnyTableStepper[(K, V), Node[K, V]](size, table, _.next, node => (node.key, node.value), 0, table.length)).
=======
      parUnbox(new convert.impl.AnyTableStepper[(K, V), Node[K, V]](size, table, _.next.nn, node => (node.key, node.value), 0, table.length)).
>>>>>>> NEW
      asInstanceOf[S with EfficientSplit]

  override def keyStepper[S <: Stepper[_]](implicit shape: StepperShape[K, S]): S with EfficientSplit = {
    import convert.impl._
    val s = shape.shape match {
<<<<<<< OLD
      case StepperShape.IntShape    => new IntTableStepper[Node[K, V]]   (size, table, _.next, _.key.asInstanceOf[Int],    0, table.length)
      case StepperShape.LongShape   => new LongTableStepper[Node[K, V]]  (size, table, _.next, _.key.asInstanceOf[Long],   0, table.length)
      case StepperShape.DoubleShape => new DoubleTableStepper[Node[K, V]](size, table, _.next, _.key.asInstanceOf[Double], 0, table.length)
      case _         => shape.parUnbox(new AnyTableStepper[K, Node[K, V]](size, table, _.next, _.key,                      0, table.length))
=======
      case StepperShape.IntShape    => new IntTableStepper[Node[K, V]]   (size, table, _.next.nn, _.key.asInstanceOf[Int],    0, table.length)
      case StepperShape.LongShape   => new LongTableStepper[Node[K, V]]  (size, table, _.next.nn, _.key.asInstanceOf[Long],   0, table.length)
      case StepperShape.DoubleShape => new DoubleTableStepper[Node[K, V]](size, table, _.next.nn, _.key.asInstanceOf[Double], 0, table.length)
      case _         => shape.parUnbox(new AnyTableStepper[K, Node[K, V]](size, table, _.next.nn, _.key,                      0, table.length))
>>>>>>> NEW
    }
    s.asInstanceOf[S with EfficientSplit]
  }
  override def valueStepper[S <: Stepper[_]](implicit shape: StepperShape[V, S]): S with EfficientSplit = {
    import convert.impl._
    val s = shape.shape match {
<<<<<<< OLD
      case StepperShape.IntShape    => new IntTableStepper[Node[K, V]]   (size, table, _.next, _.value.asInstanceOf[Int],    0, table.length)
      case StepperShape.LongShape   => new LongTableStepper[Node[K, V]]  (size, table, _.next, _.value.asInstanceOf[Long],   0, table.length)
      case StepperShape.DoubleShape => new DoubleTableStepper[Node[K, V]](size, table, _.next, _.value.asInstanceOf[Double], 0, table.length)
      case _         => shape.parUnbox(new AnyTableStepper[V, Node[K, V]](size, table, _.next, _.value,                      0, table.length))
=======
      case StepperShape.IntShape    => new IntTableStepper[Node[K, V]]   (size, table, _.next.nn, _.value.asInstanceOf[Int],    0, table.length)
      case StepperShape.LongShape   => new LongTableStepper[Node[K, V]]  (size, table, _.next.nn, _.value.asInstanceOf[Long],   0, table.length)
      case StepperShape.DoubleShape => new DoubleTableStepper[Node[K, V]](size, table, _.next.nn, _.value.asInstanceOf[Double], 0, table.length)
      case _         => shape.parUnbox(new AnyTableStepper[V, Node[K, V]](size, table, _.next.nn, _.value,                      0, table.length))
>>>>>>> NEW
    }
    s.asInstanceOf[S with EfficientSplit]
  }
      throw new RuntimeException(s"new HashMap table size $newlen exceeds maximum")
    var oldlen = table.length
    threshold = newThreshold(newlen)
<<<<<<< OLD
    if(size == 0) table = new Array(newlen)
=======
    if(size == 0) table = new Array[Node[K, V] | Null](newlen)
>>>>>>> NEW
    else {
      table = java.util.Arrays.copyOf(table, newlen)
      val preLow: Node[K, V] = new Node(null.asInstanceOf[K], 0, null.asInstanceOf[V], null)
            preHigh.next = null
            var lastLow: Node[K, V] = preLow
            var lastHigh: Node[K, V] = preHigh
<<<<<<< OLD
            var n = old
=======
            var n: Node[K, V] | Null = old
>>>>>>> NEW
            while(n ne null) {
              val next = n.next
              if((n.hash & oldlen) == 0) { // keep low
    def newBuilder: Builder[(K, V), HashMap[K, V]] = HashMap.newBuilder(tableLength, loadFactor)
  }

<<<<<<< OLD
  private[collection] final class Node[K, V](_key: K, _hash: Int, private[this] var _value: V, private[this] var _next: Node[K, V]) {
=======
  private[collection] final class Node[K, V](_key: K, _hash: Int, private[this] var _value: V, @annotation.stableNull private[this] var _next: Node[K, V] | Null) {
>>>>>>> NEW
    def key: K = _key
    def hash: Int = _hash
    def value: V = _value
    def value_= (v: V): Unit = _value = v
<<<<<<< OLD
    def next: Node[K, V] = _next
    def next_= (n: Node[K, V]): Unit = _next = n
=======
    def next: Node[K, V] | Null = _next
    def next_= (n: Node[K, V] | Null): Unit = _next = n
>>>>>>> NEW

    @tailrec
<<<<<<< OLD
    def findNode(k: K, h: Int): Node[K, V] =
=======
    def findNode(k: K, h: Int): Node[K, V] | Null =
>>>>>>> NEW
      if(h == _hash && k == _key) this
      else if((_next eq null) || (_hash > h)) null
      else _next.findNode(k, h)
    override def toString = s"Node($key, $value, $hash) -> $next"
  }
}
<<<<<<< ADDED

>>>>>>> ADDED