
import scala.language.`2.13`
import language.experimental.captureChecking
<<<<<<< ADDED

>>>>>>> ADDED
import scala.{unchecked => uc}
import scala.annotation.{implicitNotFound, tailrec, unused}
import scala.annotation.unchecked.uncheckedVariance
  private[this] type LLNode = CollisionProofHashMap.LLNode[K, V]

  /** The actual hash table. */
<<<<<<< OLD
  private[this] var table: Array[Node] = new Array[Node](tableSizeFor(initialCapacity))
=======
  private[this] var table: Array[Node | Null] = new Array[Node | Null](tableSizeFor(initialCapacity))
>>>>>>> NEW

  /** The next size value at which to resize (capacity * load factor). */
  private[this] var threshold: Int = newThreshold(table.length)
    }
  }

<<<<<<< OLD
  @`inline` private[this] def findNode(elem: K): Node = {
=======
  @`inline` private[this] def findNode(elem: K): Node | Null = {
>>>>>>> NEW
    val hash = computeHash(elem)
    table(index(hash)) match {
      case null => null

  def addOne(elem: (K, V)): this.type = { put0(elem._1, elem._2, getOld = false); this }

<<<<<<< OLD
  @`inline` private[this] def put0(key: K, value: V, getOld: Boolean): Some[V] = {
=======
  @`inline` private[this] def put0(key: K, value: V, getOld: Boolean): Some[V] | Null = {
>>>>>>> NEW
    if(contentSize + 1 >= threshold) growTable(table.length * 2)
    val hash = computeHash(key)
    val idx = index(hash)
    put0(key, value, getOld, hash, idx)
  }

<<<<<<< OLD
  private[this] def put0(key: K, value: V, getOld: Boolean, hash: Int, idx: Int): Some[V] = {
=======
  private[this] def put0(key: K, value: V, getOld: Boolean, hash: Int, idx: Int): Some[V] | Null = {
>>>>>>> NEW
    val res = table(idx) match {
      case n: RBNode @uc =>
        insert(n, idx, key, hash, value)
      case _old =>
<<<<<<< OLD
        val old: LLNode = _old.asInstanceOf[LLNode]
=======
        val old: LLNode | Null = _old.asInstanceOf[LLNode | Null]
>>>>>>> NEW
        if(old eq null) {
          table(idx) = new LLNode(key, hash, value, null)
        } else {
          var remaining = CollisionProofHashMap.treeifyThreshold
<<<<<<< OLD
          var prev: LLNode = null
          var n = old
=======
          var prev: LLNode | Null = null
          var n: LLNode | Null = old
>>>>>>> NEW
          while((n ne null) && n.hash <= hash && remaining > 0) {
            if(n.hash == hash && key == n.key) {
              val old = n.value

  private[this] def treeify(old: LLNode, idx: Int): Unit = {
    table(idx) = CollisionProofHashMap.leaf(old.key, old.hash, old.value, red = false, null)
<<<<<<< OLD
    var n: LLNode = old.next
=======
    var n: LLNode | Null = old.next
>>>>>>> NEW
    while(n ne null) {
      val root = table(idx).asInstanceOf[RBNode]
      insertIntoExisting(root, idx, n.key, n.hash, n.value, root)
    protected[this] def extract(node: RBNode): R

    private[this] var i = 0
<<<<<<< OLD
    private[this] var node: Node = null
=======
    private[this] var node: Node | Null = null
>>>>>>> NEW
    private[this] val len = table.length

    def hasNext: Boolean = {
  }

  @`inline` private[this] def reallocTable(newlen: Int) = {
<<<<<<< OLD
    table = new Array(newlen)
=======
    table = new Array[Node | Null](newlen)
>>>>>>> NEW
    threshold = newThreshold(table.length)
  }

<<<<<<< OLD
  @`inline` private[this] def splitBucket(tree: Node, lowBucket: Int, highBucket: Int, mask: Int): Unit = tree match {
=======
  @`inline` private[this] def splitBucket(tree: Node | Null, lowBucket: Int, highBucket: Int, mask: Int): Unit = tree match {
>>>>>>> NEW
    case t: LLNode @uc => splitBucket(t, lowBucket, highBucket, mask)
    case t: RBNode @uc => splitBucket(t, lowBucket, highBucket, mask)
<<<<<<< ADDED
    case null =>
>>>>>>> ADDED
  }

  private[this] def splitBucket(list: LLNode, lowBucket: Int, highBucket: Int, mask: Int): Unit = {
    //preHigh.next = null
    var lastLow: LLNode = preLow
    var lastHigh: LLNode = preHigh
<<<<<<< OLD
    var n = list
=======
    var n: LLNode | Null = list
>>>>>>> NEW
    while(n ne null) {
      val next = n.next
      if((n.hash & mask) == 0) { // keep low

  ///////////////////// RedBlackTree code derived from mutable.RedBlackTree:

<<<<<<< OLD
  @`inline` private[this] def isRed(node: RBNode) = (node ne null) && node.red
  @`inline` private[this] def isBlack(node: RBNode) = (node eq null) || !node.red
=======
  @`inline` private[this] def isRed(node: RBNode | Null) = (node ne null) && node.red
  @`inline` private[this] def isBlack(node: RBNode | Null) = (node eq null) || !node.red
>>>>>>> NEW

  @unused @`inline` private[this] def compare(key: K, hash: Int, node: LLNode): Int = {
    val i = hash - node.hash
    }
  }

<<<<<<< OLD
  private[this] final def insert(tree: RBNode, bucket: Int, key: K, hash: Int, value: V): Boolean = {
=======
  private[this] final def insert(tree: RBNode | Null, bucket: Int, key: K, hash: Int, value: V): Boolean = {
>>>>>>> NEW
    if(tree eq null) {
      table(bucket) = CollisionProofHashMap.leaf(key, hash, value, red = false, null)
      true
    var root = _root
    var z = node
    while (isRed(z.parent)) {
<<<<<<< OLD
      if (z.parent eq z.parent.parent.left) {
        val y = z.parent.parent.right
=======
      if (z.parent eq z.parent.nn.parent.nn.left) {
        val y = z.parent.nn.parent.nn.right
>>>>>>> NEW
        if (isRed(y)) {
<<<<<<< OLD
          z.parent.red = false
          y.red = false
          z.parent.parent.red = true
          z = z.parent.parent
=======
          z.parent.nn.red = false
          y.nn.red = false
          z.parent.nn.parent.nn.red = true
          z = z.parent.nn.parent.nn
>>>>>>> NEW
        } else {
<<<<<<< OLD
          if (z eq z.parent.right) {
            z = z.parent
=======
          if (z eq z.parent.nn.right) {
            z = z.parent.nn
>>>>>>> NEW
            root = rotateLeft(root, z)
          }
<<<<<<< OLD
          z.parent.red = false
          z.parent.parent.red = true
          root = rotateRight(root, z.parent.parent)
=======
          z.parent.nn.red = false
          z.parent.nn.parent.nn.red = true
          root = rotateRight(root, z.parent.nn.parent.nn)
>>>>>>> NEW
        }
      } else { // symmetric cases
<<<<<<< OLD
        val y = z.parent.parent.left
=======
        val y = z.parent.nn.parent.nn.left
>>>>>>> NEW
        if (isRed(y)) {
<<<<<<< OLD
          z.parent.red = false
          y.red = false
          z.parent.parent.red = true
          z = z.parent.parent
=======
          z.parent.nn.red = false
          y.nn.red = false
          z.parent.nn.parent.nn.red = true
          z = z.parent.nn.parent.nn
>>>>>>> NEW
        } else {
<<<<<<< OLD
          if (z eq z.parent.left) {
            z = z.parent
=======
          if (z eq z.parent.nn.left) {
            z = z.parent.nn
>>>>>>> NEW
            root = rotateRight(root, z)
          }
<<<<<<< OLD
          z.parent.red = false
          z.parent.parent.red = true
          root = rotateLeft(root, z.parent.parent)
=======
          z.parent.nn.red = false
          z.parent.nn.parent.nn.red = true
          root = rotateLeft(root, z.parent.nn.parent.nn)
>>>>>>> NEW
        }
      }
    }
      val oldValue = z.value
      var y = z
      var yIsRed = y.red
<<<<<<< OLD
      var x: RBNode = null
      var xParent: RBNode = null
=======
      var x: RBNode | Null = null
      var xParent: RBNode | Null = null
>>>>>>> NEW

      if (z.left eq null) {
        x = z.right
<<<<<<< OLD
        root = transplant(root, z, z.right)
=======
        root = transplant(root, z, z.right.nn)
>>>>>>> NEW
        xParent = z.parent
      }
      else if (z.right eq null) {
        if (y.parent eq z) xParent = y
        else {
          xParent = y.parent
<<<<<<< OLD
          root = transplant(root, y, y.right)
=======
          root = transplant(root, y, y.right.nn)
>>>>>>> NEW
          y.right = z.right
<<<<<<< OLD
          y.right.parent = y
=======
          y.right.nn.parent = y
>>>>>>> NEW
        }
        root = transplant(root, z, y)
        y.left = z.left
<<<<<<< OLD
        y.left.parent = y
=======
        y.left.nn.parent = y
>>>>>>> NEW
        y.red = z.red
      }

    } else Statics.pfMarker
  }

<<<<<<< OLD
  private[this] def fixAfterDelete(_root: RBNode, node: RBNode, parent: RBNode): RBNode = {
=======
  private[this] def fixAfterDelete(_root: RBNode, node: RBNode | Null, parent: RBNode | Null): RBNode = {
>>>>>>> NEW
    var root = _root
    var x = node
    var xParent = parent
    while ((x ne root) && isBlack(x)) {
<<<<<<< OLD
      if (x eq xParent.left) {
        var w = xParent.right
=======
      if (x eq xParent.nn.left) {
        var w = xParent.nn.right
>>>>>>> NEW
        // assert(w ne null)

<<<<<<< OLD
        if (w.red) {
          w.red = false
          xParent.red = true
          root = rotateLeft(root, xParent)
          w = xParent.right
=======
        if (w.nn.red) {
          w.nn.red = false
          xParent.nn.red = true
          root = rotateLeft(root, xParent.nn)
          w = xParent.nn.right
>>>>>>> NEW
        }
<<<<<<< OLD
        if (isBlack(w.left) && isBlack(w.right)) {
          w.red = true
=======
        if (isBlack(w.nn.left) && isBlack(w.nn.right)) {
          w.nn.red = true
>>>>>>> NEW
          x = xParent
        } else {
<<<<<<< OLD
          if (isBlack(w.right)) {
            w.left.red = false
            w.red = true
            root = rotateRight(root, w)
            w = xParent.right
=======
          if (isBlack(w.nn.right)) {
            w.nn.left.nn.red = false
            w.nn.red = true
            root = rotateRight(root, w.nn)
            w = xParent.nn.right
>>>>>>> NEW
          }
<<<<<<< OLD
          w.red = xParent.red
          xParent.red = false
          w.right.red = false
          root = rotateLeft(root, xParent)
=======
          w.nn.red = xParent.nn.red
          xParent.nn.red = false
          w.nn.right.nn.red = false
          root = rotateLeft(root, xParent.nn)
>>>>>>> NEW
          x = root
        }
      } else { // symmetric cases
<<<<<<< OLD
        var w = xParent.left
=======
        var w = xParent.nn.left
>>>>>>> NEW
        // assert(w ne null)

<<<<<<< OLD
        if (w.red) {
          w.red = false
          xParent.red = true
          root = rotateRight(root, xParent)
          w = xParent.left
=======
        if (w.nn.red) {
          w.nn.red = false
          xParent.nn.red = true
          root = rotateRight(root, xParent.nn)
          w = xParent.nn.left
>>>>>>> NEW
        }
<<<<<<< OLD
        if (isBlack(w.right) && isBlack(w.left)) {
          w.red = true
=======
        if (isBlack(w.nn.right) && isBlack(w.nn.left)) {
          w.nn.red = true
>>>>>>> NEW
          x = xParent
        } else {
<<<<<<< OLD
          if (isBlack(w.left)) {
            w.right.red = false
            w.red = true
            root = rotateLeft(root, w)
            w = xParent.left
=======
          if (isBlack(w.nn.left)) {
            w.nn.right.nn.red = false
            w.nn.red = true
            root = rotateLeft(root, w.nn)
            w = xParent.nn.left
>>>>>>> NEW
          }
<<<<<<< OLD
          w.red = xParent.red
          xParent.red = false
          w.left.red = false
          root = rotateRight(root, xParent)
=======
          w.nn.red = xParent.nn.red
          xParent.nn.red = false
          w.nn.left.nn.red = false
          root = rotateRight(root, xParent.nn)
>>>>>>> NEW
          x = root
        }
      }
<<<<<<< OLD
      xParent = x.parent
=======
      xParent = x.nn.parent
>>>>>>> NEW
    }
    if (x ne null) x.red = false
    root

  @`inline` private[this] def rotateLeft(_root: RBNode, x: RBNode): RBNode = {
    var root = _root
<<<<<<< OLD
    val y = x.right
=======
    val y = x.right.nn
>>>>>>> NEW
    x.right = y.left

    val xp = x.parent

  @`inline` private[this] def rotateRight(_root: RBNode, x: RBNode): RBNode = {
    var root = _root
<<<<<<< OLD
    val y = x.left
=======
    val y = x.left.nn
>>>>>>> NEW
    x.left = y.right

    val xp = x.parent

  // building

<<<<<<< OLD
  def fromNodes(xs: Iterator[Node], size: Int): RBNode = {
=======
  def fromNodes(xs: Iterator[Node], size: Int): RBNode | Null = {
>>>>>>> NEW
    val maxUsedDepth = 32 - Integer.numberOfLeadingZeros(size) // maximum depth of non-leaf nodes
<<<<<<< OLD
    def f(level: Int, size: Int): RBNode = size match {
=======
    def f(level: Int, size: Int): RBNode | Null = size match {
>>>>>>> NEW
      case 0 => null
      case 1 =>
        val nn = xs.next()
        }
        val n = new RBNode(key, hash, value, red = false, left, right, null)
        if(left ne null) left.parent = n
<<<<<<< OLD
        right.parent = n
=======
        if(right ne null) right.parent = n
>>>>>>> NEW
        n
    }
    f(1, size)

  @SerialVersionUID(3L)
  private final class DeserializationFactory[K, V](val tableLength: Int, val loadFactor: Double, val ordering: Ordering[K]) extends Factory[(K, V), CollisionProofHashMap[K, V]] with Serializable {
<<<<<<< OLD
    def fromSpecific(it: IterableOnce[(K, V)]^): CollisionProofHashMap[K, V] = new CollisionProofHashMap[K, V](tableLength, loadFactor)(ordering) ++= it
=======
    def fromSpecific(it: IterableOnce[(K, V)]^): CollisionProofHashMap[K, V] = new CollisionProofHashMap[K, V](tableLength, loadFactor)(using ordering) ++= it
>>>>>>> NEW
    def newBuilder: Builder[(K, V), CollisionProofHashMap[K, V]] = CollisionProofHashMap.newBuilder(tableLength, loadFactor)(using ordering)
  }


  /////////////////////////// Red-Black Tree Node

<<<<<<< OLD
  final class RBNode[K, V](var key: K, var hash: Int, var value: V, var red: Boolean, var left: RBNode[K, V], var right: RBNode[K, V], var parent: RBNode[K, V]) extends Node {
=======
  final class RBNode[K, V](
      var key: K, var hash: Int, var value: V, var red: Boolean,
      @annotation.stableNull
      var left: RBNode[K, V] | Null,
      @annotation.stableNull
      var right: RBNode[K, V] | Null,
      @annotation.stableNull
      var parent: RBNode[K, V] | Null
    ) extends Node {
>>>>>>> NEW
    override def toString: String = "RBNode(" + key + ", " + hash + ", " + value + ", " + red + ", " + left + ", " + right + ")"

<<<<<<< OLD
    @tailrec def getNode(k: K, h: Int)(implicit ord: Ordering[K]): RBNode[K, V] = {
=======
    @tailrec def getNode(k: K, h: Int)(implicit ord: Ordering[K]): RBNode[K, V] | Null = {
>>>>>>> NEW
      val cmp = compare(k, h, this)
      if (cmp < 0) {
        if(left ne null) left.getNode(k, h) else null
    }
  }

<<<<<<< OLD
  @`inline` private def leaf[A, B](key: A, hash: Int, value: B, red: Boolean, parent: RBNode[A, B]): RBNode[A, B] =
=======
  @`inline` private def leaf[A, B](key: A, hash: Int, value: B, red: Boolean, parent: RBNode[A, B] | Null): RBNode[A, B] =
>>>>>>> NEW
    new RBNode(key, hash, value, red, null, null, parent)

  @tailrec private def minNodeNonNull[A, B](node: RBNode[A, B]): RBNode[A, B] =
    * Returns the node that follows `node` in an in-order tree traversal. If `node` has the maximum key (and is,
    * therefore, the last node), this method returns `null`.
    */
<<<<<<< OLD
  private def successor[A, B](node: RBNode[A, B]): RBNode[A, B] = {
=======
  private def successor[A, B](node: RBNode[A, B]): RBNode[A, B] | Null = {
>>>>>>> NEW
    if (node.right ne null) minNodeNonNull(node.right)
    else {
      var x = node
    }
  }

<<<<<<< OLD
  private final class RBNodesIterator[A, B](tree: RBNode[A, B])(implicit @unused ord: Ordering[A]) extends AbstractIterator[RBNode[A, B]] {
    private[this] var nextNode: RBNode[A, B] = if(tree eq null) null else minNodeNonNull(tree)
=======
  private final class RBNodesIterator[A, B](tree: RBNode[A, B] | Null)(implicit @unused ord: Ordering[A]) extends AbstractIterator[RBNode[A, B]] {
    private[this] var nextNode: RBNode[A, B] | Null = if(tree eq null) null else minNodeNonNull(tree)
>>>>>>> NEW

    def hasNext: Boolean = nextNode ne null


  /////////////////////////// Linked List Node

<<<<<<< OLD
  private final class LLNode[K, V](var key: K, var hash: Int, var value: V, var next: LLNode[K, V]) extends Node {
=======
  private final class LLNode[K, V](var key: K, var hash: Int, var value: V, @annotation.stableNull var next: LLNode[K, V] | Null) extends Node {
>>>>>>> NEW
    override def toString = s"LLNode($key, $value, $hash) -> $next"

    private[this] def eq(a: Any, b: Any): Boolean =
      if(a.asInstanceOf[AnyRef] eq null) b.asInstanceOf[AnyRef] eq null else a.asInstanceOf[AnyRef].equals(b)

<<<<<<< OLD
    @tailrec def getNode(k: K, h: Int)(implicit ord: Ordering[K]): LLNode[K, V] = {
=======
    @tailrec def getNode(k: K, h: Int)(implicit ord: Ordering[K]): LLNode[K, V] | Null = {
>>>>>>> NEW
      if(h == hash && eq(k, key) /*ord.compare(k, key) == 0*/) this
      else if((next eq null) || (hash > h)) null
      else next.getNode(k, h)
    }
  }
}
<<<<<<< ADDED

>>>>>>> ADDED