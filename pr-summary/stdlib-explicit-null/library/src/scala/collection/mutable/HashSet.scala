
import scala.language.`2.13`
import language.experimental.captureChecking
<<<<<<< ADDED

>>>>>>> ADDED
import scala.annotation.tailrec
import scala.collection.Stepper.EfficientSplit
import scala.collection.generic.DefaultSerializationProxy
   * - The sum of the lengths of all buckets is equal to contentSize.
   */
  /** The actual hash table. */
<<<<<<< OLD
  private[this] var table = new Array[Node[A]](tableSizeFor(initialCapacity))
=======
  private[this] var table = new Array[Node[A] | Null](tableSizeFor(initialCapacity))
>>>>>>> NEW

  /** The next size value at which to resize (capacity * load factor). */
  private[this] var threshold: Int = newThreshold(table.length)

  override def contains(elem: A): Boolean = findNode(elem) ne null

<<<<<<< OLD
  @`inline` private[this] def findNode(elem: A): Node[A] = {
=======
  @`inline` private[this] def findNode(elem: A): Node[A] | Null = {
>>>>>>> NEW
    val hash = computeHash(elem)
    table(index(hash)) match {
      case null => null
      case null =>
        table(idx) = new Node(elem, hash, null)
      case old =>
<<<<<<< OLD
        var prev: Node[A] = null
        var n = old
=======
        var prev: Node[A] | Null = null
        var n: Node[A] | Null = old
>>>>>>> NEW
        while((n ne null) && n.hash <= hash) {
          if(n.hash == hash && elem == n.key) return false
          prev = n

  private[this] abstract class HashSetIterator[B] extends AbstractIterator[B] {
    private[this] var i = 0
<<<<<<< OLD
    private[this] var node: Node[A] = null
=======
    private[this] var node: Node[A] | Null = null
>>>>>>> NEW
    private[this] val len = table.length

    protected[this] def extract(nd: Node[A]): B
    def next(): B =
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
  override def stepper[S <: Stepper[_]](implicit shape: StepperShape[A, S]): S with EfficientSplit = {
    import convert.impl._
    val s = shape.shape match {
<<<<<<< OLD
      case StepperShape.IntShape    => new IntTableStepper[Node[A]]   (size, table, _.next, _.key.asInstanceOf[Int],    0, table.length)
      case StepperShape.LongShape   => new LongTableStepper[Node[A]]  (size, table, _.next, _.key.asInstanceOf[Long],   0, table.length)
      case StepperShape.DoubleShape => new DoubleTableStepper[Node[A]](size, table, _.next, _.key.asInstanceOf[Double], 0, table.length)
      case _         => shape.parUnbox(new AnyTableStepper[A, Node[A]](size, table, _.next, _.key,                      0, table.length))
=======
      case StepperShape.IntShape    => new IntTableStepper[Node[A]]   (size, table, _.next.nn, _.key.asInstanceOf[Int],    0, table.length)
      case StepperShape.LongShape   => new LongTableStepper[Node[A]]  (size, table, _.next.nn, _.key.asInstanceOf[Long],   0, table.length)
      case StepperShape.DoubleShape => new DoubleTableStepper[Node[A]](size, table, _.next.nn, _.key.asInstanceOf[Double], 0, table.length)
      case _         => shape.parUnbox(new AnyTableStepper[A, Node[A]](size, table, _.next.nn, _.key,                      0, table.length))
>>>>>>> NEW
    }
    s.asInstanceOf[S with EfficientSplit]
  }
  private[this] def growTable(newlen: Int) = {
    var oldlen = table.length
    threshold = newThreshold(newlen)
<<<<<<< OLD
    if(size == 0) table = new Array(newlen)
=======
    if(size == 0) table = new Array[Node[A] | Null](newlen)
>>>>>>> NEW
    else {
      table = java.util.Arrays.copyOf(table, newlen)
      val preLow: Node[A] = new Node(null.asInstanceOf[A], 0, null)
            preHigh.next = null
            var lastLow: Node[A] = preLow
            var lastHigh: Node[A] = preHigh
<<<<<<< OLD
            var n = old
=======
            var n: Node[A] | Null = old
>>>>>>> NEW
            while(n ne null) {
              val next = n.next
              if((n.hash & oldlen) == 0) { // keep low
    def newBuilder: Builder[A, HashSet[A]] = HashSet.newBuilder(tableLength, loadFactor)
  }

<<<<<<< OLD
  private[collection] final class Node[K](_key: K, _hash: Int, private[this] var _next: Node[K]) {
=======
  private[collection] final class Node[K](_key: K, _hash: Int, @annotation.stableNull private[this] var _next: Node[K] | Null) {
>>>>>>> NEW
    def key: K = _key
    def hash: Int = _hash
<<<<<<< OLD
    def next: Node[K] = _next
    def next_= (n: Node[K]): Unit = _next = n
=======
    def next: Node[K] | Null = _next
    def next_= (n: Node[K] | Null): Unit = _next = n
>>>>>>> NEW

    @tailrec
<<<<<<< OLD
    def findNode(k: K, h: Int): Node[K] =
=======
    def findNode(k: K, h: Int): Node[K] | Null =
>>>>>>> NEW
      if(h == _hash && k == _key) this
      else if((_next eq null) || (_hash > h)) null
      else _next.findNode(k, h)