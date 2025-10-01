  // Therefore, while obtaining the size of the whole tree is O(1), knowing the number of entries inside a range is O(n)
  // on the size of the range.

<<<<<<< OLD
  final class Tree[A, B](var root: Node[A, B], var size: Int) {
=======
  final class Tree[A, B](var root: Node[A, B] | Null, var size: Int) {
>>>>>>> NEW
    def treeCopy(): Tree[A, B] = new Tree(copyTree(root), size)
  }

<<<<<<< OLD
  final class Node[A, B](var key: A, var value: B, var red: Boolean, var left: Node[A, B], var right: Node[A, B], var parent: Node[A, B]) {
=======
  final class Node[A, B](
      var key: A, var value: B, var red: Boolean,
      @annotation.stableNull
      var left: Node[A, B] | Null,
      @annotation.stableNull
      var right: Node[A, B] | Null,
      @annotation.stableNull
      var parent: Node[A, B] | Null
    ) {
>>>>>>> NEW
    override def toString: String = "Node(" + key + ", " + value + ", " + red + ", " + left + ", " + right + ")"
  }

  object Node {

    @`inline` def apply[A, B](key: A, value: B, red: Boolean,
<<<<<<< OLD
                            left: Node[A, B], right: Node[A, B], parent: Node[A, B]): Node[A, B] =
=======
                            left: Node[A, B], right: Node[A, B], parent: Node[A, B] | Null): Node[A, B] =
>>>>>>> NEW
      new Node(key, value, red, left, right, parent)

<<<<<<< OLD
    @`inline` def leaf[A, B](key: A, value: B, red: Boolean, parent: Node[A, B]): Node[A, B] =
=======
    @`inline` def leaf[A, B](key: A, value: B, red: Boolean, parent: Node[A, B] | Null): Node[A, B] =
>>>>>>> NEW
      new Node(key, value, red, null, null, parent)

    def unapply[A, B](t: Node[A, B]) = Some((t.key, t.value, t.left, t.right, t.parent))

  // ---- getters ----

<<<<<<< OLD
  def isRed(node: Node[_, _]) = (node ne null) && node.red
  def isBlack(node: Node[_, _]) = (node eq null) || !node.red
=======
  def isRed(node: Node[_, _] | Null) = (node ne null) && node.red
  def isBlack(node: Node[_, _] | Null) = (node eq null) || !node.red
>>>>>>> NEW

  // ---- size ----

<<<<<<< OLD
  def size(node: Node[_, _]): Int = if (node eq null) 0 else 1 + size(node.left) + size(node.right)
=======
  def size(node: Node[_, _] | Null): Int = if (node eq null) 0 else 1 + size(node.left) + size(node.right)
>>>>>>> NEW
  def size(tree: Tree[_, _]): Int = tree.size
  def isEmpty(tree: Tree[_, _]) = tree.root eq null
  def clear(tree: Tree[_, _]): Unit = { tree.root = null; tree.size = 0 }
    case node => Some(node.value)
  }

<<<<<<< OLD
  @tailrec private[this] def getNode[A, B](node: Node[A, B], key: A)(implicit ord: Ordering[A]): Node[A, B] =
=======
  @tailrec private[this] def getNode[A, B](node: Node[A, B] | Null, key: A)(implicit ord: Ordering[A]): Node[A, B] | Null =
>>>>>>> NEW
    if (node eq null) null
    else {
      val cmp = ord.compare(key, node.key)
    case node => Some(node.key)
  }

<<<<<<< OLD
  private def minNode[A, B](node: Node[A, B]): Node[A, B] =
=======
  private def minNode[A, B](node: Node[A, B] | Null): Node[A, B] | Null =
>>>>>>> NEW
    if (node eq null) null else minNodeNonNull(node)

  @tailrec def minNodeNonNull[A, B](node: Node[A, B]): Node[A, B] =
    case node => Some(node.key)
  }

<<<<<<< OLD
  private def maxNode[A, B](node: Node[A, B]): Node[A, B] =
=======
  private def maxNode[A, B](node: Node[A, B] | Null): Node[A, B] | Null =
>>>>>>> NEW
    if (node eq null) null else maxNodeNonNull(node)

  @tailrec def maxNodeNonNull[A, B](node: Node[A, B]): Node[A, B] =
      case node => Some(node.key)
    }

<<<<<<< OLD
  private[this] def minNodeAfter[A, B](node: Node[A, B], key: A)(implicit ord: Ordering[A]): Node[A, B] = {
=======
  private[this] def minNodeAfter[A, B](node: Node[A, B] | Null, key: A)(implicit ord: Ordering[A]): Node[A, B] | Null = {
>>>>>>> NEW
    if (node eq null) null
    else {
<<<<<<< OLD
      var y: Node[A, B] = null
      var x = node
=======
      var y: Node[A, B] | Null = null
      var x: Node[A, B] | Null = node
>>>>>>> NEW
      var cmp = 1
      while ((x ne null) && cmp != 0) {
        y = x
      case node => Some(node.key)
    }

<<<<<<< OLD
  private[this] def maxNodeBefore[A, B](node: Node[A, B], key: A)(implicit ord: Ordering[A]): Node[A, B] = {
=======
  private[this] def maxNodeBefore[A, B](node: Node[A, B] | Null, key: A)(implicit ord: Ordering[A]): Node[A, B] | Null = {
>>>>>>> NEW
    if (node eq null) null
    else {
<<<<<<< OLD
      var y: Node[A, B] = null
      var x = node
=======
      var y: Node[A, B] | Null = null
      var x: Node[A, B] | Null = node
>>>>>>> NEW
      var cmp = 1
      while ((x ne null) && cmp != 0) {
        y = x
  // ---- insertion ----

  def insert[A, B](tree: Tree[A, B], key: A, value: B)(implicit ord: Ordering[A]): Unit = {
<<<<<<< OLD
    var y: Node[A, B] = null
=======
    var y: Node[A, B] | Null = null
>>>>>>> NEW
    var x = tree.root
    var cmp = 1
    while ((x ne null) && cmp != 0) {
      x = if (cmp < 0) x.left else x.right
    }

<<<<<<< OLD
    if (cmp == 0) y.value = value
=======
    if (cmp == 0) y.nn.value = value
>>>>>>> NEW
    else {
      val z = Node.leaf(key, value, red = true, y)

  private[this] def fixAfterInsert[A, B](tree: Tree[A, B], node: Node[A, B]): Unit = {
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
            rotateLeft(tree, z)
          }
<<<<<<< OLD
          z.parent.red = false
          z.parent.parent.red = true
          rotateRight(tree, z.parent.parent)
=======
          z.parent.nn.red = false
          z.parent.nn.parent.nn.red = true
          rotateRight(tree, z.parent.nn.parent.nn)
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
            rotateRight(tree, z)
          }
<<<<<<< OLD
          z.parent.red = false
          z.parent.parent.red = true
          rotateLeft(tree, z.parent.parent)
=======
          z.parent.nn.red = false
          z.parent.nn.parent.nn.red = true
          rotateLeft(tree, z.parent.nn.parent.nn)
>>>>>>> NEW
        }
      }
    }
<<<<<<< OLD
    tree.root.red = false
=======
    tree.root.nn.red = false
>>>>>>> NEW
  }

  // ---- deletion ----
    if (z ne null) {
      var y = z
      var yIsRed = y.red
<<<<<<< OLD
      var x: Node[A, B] = null
      var xParent: Node[A, B] = null
=======
      var x: Node[A, B] | Null = null
      var xParent: Node[A, B] | Null = null
>>>>>>> NEW

      if (z.left eq null) {
        x = z.right
      else if (z.right eq null) {
        x = z.left
        transplant(tree, z, z.left)
<<<<<<< OLD
        xParent = z.parent
=======
        xParent = z.left.parent
>>>>>>> NEW
      }
      else {
        y = minNodeNonNull(z.right)
          xParent = y.parent
          transplant(tree, y, y.right)
          y.right = z.right
<<<<<<< OLD
          y.right.parent = y
=======
          y.right.nn.parent = y
>>>>>>> NEW
        }
        transplant(tree, z, y)
        y.left = z.left
<<<<<<< OLD
        y.left.parent = y
=======
        y.left.nn.parent = y
>>>>>>> NEW
        y.red = z.red
      }

    }
  }

<<<<<<< OLD
  private[this] def fixAfterDelete[A, B](tree: Tree[A, B], node: Node[A, B], parent: Node[A, B]): Unit = {
=======
  private[this] def fixAfterDelete[A, B](tree: Tree[A, B], node: Node[A, B] | Null, parent: Node[A, B] | Null): Unit = {
>>>>>>> NEW
    var x = node
    var xParent = parent
    while ((x ne tree.root) && isBlack(x)) {
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
          rotateLeft(tree, xParent)
          w = xParent.right
=======
        if (w.nn.red) {
          w.nn.red = false
          xParent.nn.red = true
          rotateLeft(tree, xParent.nn)
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
            rotateRight(tree, w)
            w = xParent.right
=======
          if (isBlack(w.nn.right)) {
            w.nn.left.nn.red = false
            w.nn.red = true
            rotateRight(tree, w.nn)
            w = xParent.nn.right
>>>>>>> NEW
          }
<<<<<<< OLD
          w.red = xParent.red
          xParent.red = false
          w.right.red = false
          rotateLeft(tree, xParent)
=======
          w.nn.red = xParent.nn.red
          xParent.nn.red = false
          w.nn.right.nn.red = false
          rotateLeft(tree, xParent.nn)
>>>>>>> NEW
          x = tree.root
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
          rotateRight(tree, xParent)
          w = xParent.left
=======
        if (w.nn.red) {
          w.nn.red = false
          xParent.nn.red = true
          rotateRight(tree, xParent.nn)
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
            rotateLeft(tree, w)
            w = xParent.left
=======
          if (isBlack(w.nn.left)) {
            w.nn.right.nn.red = false
            w.nn.red = true
            rotateLeft(tree, w.nn)
            w = xParent.nn.left
>>>>>>> NEW
          }
<<<<<<< OLD
          w.red = xParent.red
          xParent.red = false
          w.left.red = false
          rotateRight(tree, xParent)
=======
          w.nn.red = xParent.nn.red
          xParent.nn.red = false
          w.nn.left.nn.red = false
          rotateRight(tree, xParent.nn)
>>>>>>> NEW
          x = tree.root
        }
      }
<<<<<<< OLD
      xParent = x.parent
=======
      xParent = x.nn.parent
>>>>>>> NEW
    }
    if (x ne null) x.red = false
  }
   * Returns the node that follows `node` in an in-order tree traversal. If `node` has the maximum key (and is,
   * therefore, the last node), this method returns `null`.
   */
<<<<<<< OLD
  private[this] def successor[A, B](node: Node[A, B]): Node[A, B] = {
    if (node.right ne null) minNodeNonNull(node.right)
=======
  private[this] def successor[A, B](node: Node[A, B] | Null): Node[A, B] | Null = {
    if (node eq null) null
    else if (node.right ne null) minNodeNonNull(node.right)
>>>>>>> NEW
    else {
      var x = node
      var y = x.parent
<<<<<<< OLD
      while ((y ne null) && (x eq y.right)) {
=======
      while ((y ne null) && (x eq y.nn.right)) {
>>>>>>> NEW
        x = y
        y = y.parent
      }
   * Returns the node that precedes `node` in an in-order tree traversal. If `node` has the minimum key (and is,
   * therefore, the first node), this method returns `null`.
   */
<<<<<<< OLD
  private[this] def predecessor[A, B](node: Node[A, B]): Node[A, B] = {
    if (node.left ne null) maxNodeNonNull(node.left)
=======
  private[this] def predecessor[A, B](node: Node[A, B] | Null): Node[A, B] | Null = {
    if (node eq null) null
    else if (node.left ne null) maxNodeNonNull(node.left)
>>>>>>> NEW
    else {
      var x = node
      var y = x.parent

  private[this] def rotateLeft[A, B](tree: Tree[A, B], x: Node[A, B]): Unit = if (x ne null) {
    // assert(x.right ne null)
<<<<<<< OLD
    val y = x.right
=======
    val y = x.right.nn
>>>>>>> NEW
    x.right = y.left

    if (y.left ne null) y.left.parent = x
    y.parent = x.parent

    if (x.parent eq null) tree.root = y
<<<<<<< OLD
    else if (x eq x.parent.left) x.parent.left = y
=======
    else if (x eq x.parent.nn.left) x.parent.left = y
>>>>>>> NEW
    else x.parent.right = y

    y.left = x

  private[this] def rotateRight[A, B](tree: Tree[A, B], x: Node[A, B]): Unit = if (x ne null) {
    // assert(x.left ne null)
<<<<<<< OLD
    val y = x.left
=======
    val y = x.left.nn
>>>>>>> NEW
    x.left = y.right

    if (y.right ne null) y.right.parent = x
   * Transplant the node `from` to the place of node `to`. This is done by setting `from` as a child of `to`'s previous
   * parent and setting `from`'s parent to the `to`'s previous parent. The children of `from` are left unchanged.
   */
<<<<<<< OLD
  private[this] def transplant[A, B](tree: Tree[A, B], to: Node[A, B], from: Node[A, B]): Unit = {
=======
  private[this] def transplant[A, B](tree: Tree[A, B], to: Node[A, B], from: Node[A, B] | Null): Unit = {
>>>>>>> NEW
    if (to.parent eq null) tree.root = from
<<<<<<< OLD
    else if (to eq to.parent.left) to.parent.left = from
=======
    else if (to eq to.parent.nn.left) to.parent.left = from
>>>>>>> NEW
    else to.parent.right = from

    if (from ne null) from.parent = to.parent

  def foreach[A, B, U](tree: Tree[A, B], f: ((A, B)) => U): Unit = foreachNode(tree.root, f)

<<<<<<< OLD
  private[this] def foreachNode[A, B, U](node: Node[A, B], f: ((A, B)) => U): Unit =
=======
  private[this] def foreachNode[A, B, U](node: Node[A, B] | Null, f: ((A, B)) => U): Unit =
>>>>>>> NEW
    if (node ne null) foreachNodeNonNull(node, f)

  private[this] def foreachNodeNonNull[A, B, U](node: Node[A, B], f: ((A, B)) => U): Unit = {

  def transform[A, B](tree: Tree[A, B], f: (A, B) => B): Unit = transformNode(tree.root, f)

<<<<<<< OLD
  private[this] def transformNode[A, B, U](node: Node[A, B], f: (A, B) => B): Unit =
=======
  private[this] def transformNode[A, B, U](node: Node[A, B] | Null, f: (A, B) => B): Unit =
>>>>>>> NEW
    if (node ne null) transformNodeNonNull(node, f)

  private[this] def transformNodeNonNull[A, B, U](node: Node[A, B], f: (A, B) => B): Unit = {
        nextResult(node)
    }

<<<<<<< OLD
    private[this] var nextNode: Node[A, B] = start match {
=======
    private[this] var nextNode: Node[A, B] | Null = start match {
>>>>>>> NEW
      case None => minNode(tree.root)
      case Some(from) => minNodeAfter(tree.root, from)
    }

    private[this] def setNullIfAfterEnd(): Unit =
<<<<<<< OLD
      if (end.isDefined && (nextNode ne null) && ord.compare(nextNode.key, end.get) >= 0)
=======
      if (end.isDefined && (nextNode ne null) && ord.compare(nextNode.nn.key, end.get) >= 0)
>>>>>>> NEW
        nextNode = null

    setNullIfAfterEnd()
  }
<<<<<<< REMOVED

>>>>>>> REMOVED
  private[this] final class EntriesIterator[A: Ordering, B](tree: Tree[A, B], start: Option[A], end: Option[A])
    extends TreeIterator[A, B, (A, B)](tree, start, end) {

   */
  private[this] def hasProperParentRefs[A, B](tree: Tree[A, B]): Boolean = {

<<<<<<< OLD
    def hasProperParentRefs(node: Node[A, B]): Boolean = {
=======
    def hasProperParentRefs(node: Node[A, B] | Null): Boolean = {
>>>>>>> NEW
      if (node eq null) true
      else {
        if ((node.left ne null) && (node.left.parent ne node) ||
    }

    if(tree.root eq null) true
<<<<<<< OLD
    else (tree.root.parent eq null) && hasProperParentRefs(tree.root)
=======
    else (tree.root.nn.parent eq null) && hasProperParentRefs(tree.root)
>>>>>>> NEW
  }

  /**
   * Returns true if this node follows the properties of a binary search tree.
   */
<<<<<<< OLD
  private[this] def isValidBST[A, B](node: Node[A, B])(implicit ord: Ordering[A]): Boolean = {
=======
  private[this] def isValidBST[A, B](node: Node[A, B] | Null)(implicit ord: Ordering[A]): Boolean = {
>>>>>>> NEW
    if (node eq null) true
    else {
      if ((node.left ne null) && (ord.compare(node.key, node.left.key) <= 0) ||
   */
  private[this] def isValidRedBlackTree[A, B](tree: Tree[A, B]): Boolean = {

<<<<<<< OLD
    def noRedAfterRed(node: Node[A, B]): Boolean = {
=======
    def noRedAfterRed(node: Node[A, B] | Null): Boolean = {
>>>>>>> NEW
      if (node eq null) true
      else if (node.red && (isRed(node.left) || isRed(node.right))) false
      else noRedAfterRed(node.left) && noRedAfterRed(node.right)
    }

<<<<<<< OLD
    def blackHeight(node: Node[A, B]): Int = {
=======
    def blackHeight(node: Node[A, B] | Null): Int = {
>>>>>>> NEW
      if (node eq null) 1
      else {
        val lh = blackHeight(node.left)
  /** Build a Tree suitable for a TreeSet from an ordered sequence of keys */
  def fromOrderedKeys[A](xs: Iterator[A]^, size: Int): Tree[A, Null] = {
    val maxUsedDepth = 32 - Integer.numberOfLeadingZeros(size) // maximum depth of non-leaf nodes
<<<<<<< OLD
    def f(level: Int, size: Int): Node[A, Null] = size match {
=======
    def f(level: Int, size: Int): Node[A, Null] | Null = size match {
>>>>>>> NEW
      case 0 => null
      case 1 => new Node(xs.next(), null, level == maxUsedDepth && level != 1, null, null, null)
      case n =>
        val right = f(level+1, size-1-leftSize)
        val n = new Node(x, null, red = false, left, right, null)
        if(left ne null) left.parent = n
<<<<<<< OLD
        right.parent = n
=======
        right.nn.parent = n
>>>>>>> NEW
        n
    }
    new Tree(f(1, size), size)
  /** Build a Tree suitable for a TreeMap from an ordered sequence of key/value pairs */
  def fromOrderedEntries[A, B](xs: Iterator[(A, B)]^, size: Int): Tree[A, B] = {
    val maxUsedDepth = 32 - Integer.numberOfLeadingZeros(size) // maximum depth of non-leaf nodes
<<<<<<< OLD
    def f(level: Int, size: Int): Node[A, B] = size match {
=======
    def f(level: Int, size: Int): Node[A, B] | Null = size match {
>>>>>>> NEW
      case 0 => null
      case 1 =>
        val (k, v) = xs.next()
        val right = f(level+1, size-1-leftSize)
        val n = new Node(k, v, red = false, left, right, null)
        if(left ne null) left.parent = n
<<<<<<< OLD
        right.parent = n
=======
        right.nn.parent = n
>>>>>>> NEW
        n
    }
    new Tree(f(1, size), size)
  }

<<<<<<< OLD
  def copyTree[A, B](n: Node[A, B]): Node[A, B] =
=======
  def copyTree[A, B](n: Node[A, B] | Null): Node[A, B] | Null =
>>>>>>> NEW
    if(n eq null) null else {
      val c = new Node(n.key, n.value, n.red, copyTree(n.left), copyTree(n.right), null)
      if(c.left != null) c.left.parent = c