 *  optimizations behind a reasonably clean API.
 */
private[collection] object RedBlackTree {
<<<<<<< OLD
  def validate[A](tree: Tree[A, _])(implicit ordering: Ordering[A]): tree.type = {
=======
  def validate[A](tree: Tree[A, _] | Null)(implicit ordering: Ordering[A]): tree.type = {
>>>>>>> NEW
    def impl(tree: Tree[A, _], keyProp: A => Boolean): Int = {
      assert(keyProp(tree.key), s"key check failed: $tree")
      if (tree.isRed) {
<<<<<<< OLD
        assert(tree.left == null || tree.left.isBlack, s"red-red left $tree")
        assert(tree.right == null || tree.right.isBlack, s"red-red right $tree")
=======
        assert(tree.left == null || tree.left.nn.isBlack, s"red-red left $tree")
        assert(tree.right == null || tree.right.nn.isBlack, s"red-red right $tree")
>>>>>>> NEW
      }
<<<<<<< OLD
      val leftBlacks = if (tree.left == null) 0 else impl(tree.left, k => keyProp(k) && ordering.compare(k, tree.key) < 0)
      val rightBlacks = if (tree.right == null) 0 else impl(tree.right, k => keyProp(k) && ordering.compare(k, tree.key) > 0)
=======
      val leftBlacks = if (tree.left == null) 0 else impl(tree.left.nn, k => keyProp(k) && ordering.compare(k, tree.key) < 0)
      val rightBlacks = if (tree.right == null) 0 else impl(tree.right.nn, k => keyProp(k) && ordering.compare(k, tree.key) > 0)
>>>>>>> NEW
      assert(leftBlacks == rightBlacks, s"not balanced: $tree")
      leftBlacks + (if (tree.isBlack) 1 else 0)
    }
    tree
  }

<<<<<<< OLD
  def isEmpty(tree: Tree[_, _]): Boolean = tree eq null
=======
  def isEmpty(tree: Tree[_, _] | Null): Boolean = tree eq null
>>>>>>> NEW

<<<<<<< OLD
  def contains[A: Ordering](tree: Tree[A, _], x: A): Boolean = lookup(tree, x) ne null
  def get[A: Ordering, B](tree: Tree[A, B], x: A): Option[B] = lookup(tree, x) match {
=======
  def contains[A: Ordering](tree: Tree[A, _] | Null, x: A): Boolean = lookup(tree, x) ne null
  def get[A: Ordering, B](tree: Tree[A, B] | Null, x: A): Option[B] = lookup(tree, x) match {
>>>>>>> NEW
    case null  => None
    case found => Some(found.value)
  }

  @tailrec
<<<<<<< OLD
  def lookup[A, B](tree: Tree[A, B], x: A)(implicit ordering: Ordering[A]): Tree[A, B] = if (tree eq null) null else {
=======
  def lookup[A, B](tree: Tree[A, B] | Null, x: A)(implicit ordering: Ordering[A]): Tree[A, B] | Null = if (tree eq null) null else {
>>>>>>> NEW
    val cmp = ordering.compare(x, tree.key)
    if (cmp < 0) lookup(tree.left, x)
    else if (cmp > 0) lookup(tree.right, x)
    else tree
  }
  private[immutable] abstract class Helper[A](implicit val ordering: Ordering[A]) {
<<<<<<< OLD
    def beforePublish[B](tree: Tree[A, B]): Tree[A, B] = {
=======
    def beforePublish[B](tree: Tree[A, B] | Null): Tree[A, B] | Null = {
>>>>>>> NEW
      if (tree eq null) tree
      else if (tree.isMutable) {
        val res = tree.mutableBlack.makeImmutable
          //                      RED
          //    black(nl.L)      nl.KV      black
          //                          nl.R    KV   R
<<<<<<< OLD
          val resultLeft = newLeft_left.mutableBlack
=======
          val resultLeft = newLeft_left.nn.mutableBlack
>>>>>>> NEW
          val resultRight = tree.mutableBlackWithLeft(newLeft_right)

          newLeft.mutableWithLeftRight(resultLeft, resultRight)
          //           black            nl.R.KV      black
          //    nl.L   nl.KV  nl.R.L           nl.R.R  KV   R

<<<<<<< OLD
          val newLeft_right_right = newLeft_right.right
=======
          val newLeft_right_right = newLeft_right.nn.right
>>>>>>> NEW

<<<<<<< OLD
          val resultLeft = newLeft.mutableBlackWithRight(newLeft_right.left)
=======
          val resultLeft = newLeft.mutableBlackWithRight(newLeft_right.nn.left)
>>>>>>> NEW
          val resultRight = tree.mutableBlackWithLeft(newLeft_right_right)

<<<<<<< OLD
          newLeft_right.mutableWithLeftRight(resultLeft, resultRight)
=======
          newLeft_right.nn.mutableWithLeftRight(resultLeft, resultRight)
>>>>>>> NEW
        } else {
          //               tree
          //    newLeft      KV         R
          //              black           nr.L.KV          black
          //     L         KV   nr.L.L             nr.L.R  nr.KV    nr.R

<<<<<<< OLD
          val resultLeft = tree.mutableBlackWithRight(newRight_left.left)
          val resultRight = newRight.mutableBlackWithLeft(newRight_left.right)
=======
          val resultLeft = tree.mutableBlackWithRight(newRight_left.nn.left)
          val resultRight = newRight.mutableBlackWithLeft(newRight_left.nn.right)
>>>>>>> NEW

<<<<<<< OLD
          newRight_left.mutableWithLeftRight(resultLeft, resultRight)
=======
          newRight_left.nn.mutableWithLeftRight(resultLeft, resultRight)
>>>>>>> NEW

        } else {
          val newRight_right = newRight.right
            //     L         KV   nr.L

            val resultLeft = tree.mutableBlackWithRight(newRight_left)
<<<<<<< OLD
            val resultRight = newRight_right.mutableBlack
=======
            val resultRight = newRight_right.nn.mutableBlack
>>>>>>> NEW

            newRight.mutableWithLeftRight(resultLeft, resultRight)
          } else {
    }
  }
  private[immutable] class SetHelper[A](implicit ordering: Ordering[A]) extends Helper[A] {
<<<<<<< OLD
    protected[this] final def mutableUpd(tree: Tree[A, Any], k: A): Tree[A, Any] =
=======
    protected[this] final def mutableUpd(tree: Tree[A, Any] | Null, k: A): Tree[A, Any] =
>>>>>>> NEW
      if (tree eq null) {
        mutableRedTree(k, (), null, null)
      } else if (k.asInstanceOf[AnyRef] eq tree.key.asInstanceOf[AnyRef]) {
      }
  }
  private[immutable] class MapHelper[A, B](implicit ordering: Ordering[A]) extends Helper[A] {
<<<<<<< OLD
    protected[this] final def mutableUpd[B1 >: B](tree: Tree[A, B], k: A, v: B1): Tree[A, B1] =
=======
    protected[this] final def mutableUpd[B1 >: B](tree: Tree[A, B] | Null, k: A, v: B1): Tree[A, B1] =
>>>>>>> NEW
      if (tree eq null) {
        mutableRedTree(k, v, null, null)
      } else if (k.asInstanceOf[AnyRef] eq tree.key.asInstanceOf[AnyRef]) {
      }
  }

<<<<<<< OLD
  def count(tree: Tree[_, _]) = if (tree eq null) 0 else tree.count
  def update[A: Ordering, B, B1 >: B](tree: Tree[A, B], k: A, v: B1, overwrite: Boolean): Tree[A, B1] = blacken(upd(tree, k, v, overwrite))
  def delete[A: Ordering, B](tree: Tree[A, B], k: A): Tree[A, B] = blacken(del(tree, k))
  def rangeImpl[A: Ordering, B](tree: Tree[A, B], from: Option[A], until: Option[A]): Tree[A, B] = (from, until) match {
=======
  def count(tree: Tree[_, _] | Null) = if (tree eq null) 0 else tree.count
  def update[A: Ordering, B, B1 >: B](tree: Tree[A, B] | Null, k: A, v: B1, overwrite: Boolean): Tree[A, B1] | Null = blacken(upd(tree, k, v, overwrite))
  def delete[A: Ordering, B](tree: Tree[A, B] | Null, k: A): Tree[A, B] | Null = blacken(del(tree, k))
  def rangeImpl[A: Ordering, B](tree: Tree[A, B] | Null, from: Option[A], until: Option[A]): Tree[A, B] | Null = (from, until) match {
>>>>>>> NEW
    case (Some(from), Some(until)) => this.range(tree, from, until)
    case (Some(from), None)        => this.from(tree, from)
    case (None,       Some(until)) => this.until(tree, until)
    case (None,       None)        => tree
  }
<<<<<<< OLD
  def range[A: Ordering, B](tree: Tree[A, B], from: A, until: A): Tree[A, B] = blacken(doRange(tree, from, until))
  def from[A: Ordering, B](tree: Tree[A, B], from: A): Tree[A, B] = blacken(doFrom(tree, from))
  def to[A: Ordering, B](tree: Tree[A, B], to: A): Tree[A, B] = blacken(doTo(tree, to))
  def until[A: Ordering, B](tree: Tree[A, B], key: A): Tree[A, B] = blacken(doUntil(tree, key))
=======
  def range[A: Ordering, B](tree: Tree[A, B] | Null, from: A, until: A): Tree[A, B] | Null = blacken(doRange(tree, from, until))
  def from[A: Ordering, B](tree: Tree[A, B] | Null, from: A): Tree[A, B] | Null = blacken(doFrom(tree, from))
  def to[A: Ordering, B](tree: Tree[A, B] | Null, to: A): Tree[A, B] | Null = blacken(doTo(tree, to))
  def until[A: Ordering, B](tree: Tree[A, B] | Null, key: A): Tree[A, B] | Null = blacken(doUntil(tree, key))
>>>>>>> NEW

<<<<<<< OLD
  def drop[A: Ordering, B](tree: Tree[A, B], n: Int): Tree[A, B] = blacken(doDrop(tree, n))
  def take[A: Ordering, B](tree: Tree[A, B], n: Int): Tree[A, B] = blacken(doTake(tree, n))
  def slice[A: Ordering, B](tree: Tree[A, B], from: Int, until: Int): Tree[A, B] = blacken(doSlice(tree, from, until))
=======
  def drop[A: Ordering, B](tree: Tree[A, B] | Null, n: Int): Tree[A, B] | Null = blacken(doDrop(tree, n))
  def take[A: Ordering, B](tree: Tree[A, B] | Null, n: Int): Tree[A, B] | Null = blacken(doTake(tree, n))
  def slice[A: Ordering, B](tree: Tree[A, B] | Null, from: Int, until: Int): Tree[A, B] | Null = blacken(doSlice(tree, from, until))
>>>>>>> NEW

<<<<<<< OLD
  def smallest[A, B](tree: Tree[A, B]): Tree[A, B] = {
=======
  def smallest[A, B](tree: Tree[A, B] | Null): Tree[A, B] = {
>>>>>>> NEW
    if (tree eq null) throw new NoSuchElementException("empty tree")
    var result = tree
<<<<<<< OLD
    while (result.left ne null) result = result.left
=======
    while (result.left ne null) result = result.left.nn
>>>>>>> NEW
    result
  }
<<<<<<< OLD
  def greatest[A, B](tree: Tree[A, B]): Tree[A, B] = {
=======
  def greatest[A, B](tree: Tree[A, B] | Null): Tree[A, B] = {
>>>>>>> NEW
    if (tree eq null) throw new NoSuchElementException("empty tree")
    var result = tree
<<<<<<< OLD
    while (result.right ne null) result = result.right
=======
    while (result.right ne null) result = result.right.nn
>>>>>>> NEW
    result
  }

<<<<<<< OLD
  def tail[A, B](tree: Tree[A, B]): Tree[A, B] = {
    def _tail(tree: Tree[A, B]): Tree[A, B] =
=======
  def tail[A, B](tree: Tree[A, B] | Null): Tree[A, B] | Null = {
    def _tail(tree: Tree[A, B] | Null): Tree[A, B] | Null=
>>>>>>> NEW
      if (tree eq null) throw new NoSuchElementException("empty tree")
      else {
        val tl = tree.left
    blacken(_tail(tree))
  }

<<<<<<< OLD
  def init[A, B](tree: Tree[A, B]): Tree[A, B] = {
    def _init(tree: Tree[A, B]): Tree[A, B] =
=======
  def init[A, B](tree: Tree[A, B] | Null): Tree[A, B] | Null = {
    def _init(tree: Tree[A, B] | Null): Tree[A, B] | Null =
>>>>>>> NEW
      if (tree eq null) throw new NoSuchElementException("empty tree")
      else {
        val tr = tree.right
  /**
    * Returns the smallest node with a key larger than or equal to `x`. Returns `null` if there is no such node.
    */
<<<<<<< OLD
  def minAfter[A, B](tree: Tree[A, B], x: A)(implicit ordering: Ordering[A]): Tree[A, B] = if (tree eq null) null else {
=======
  def minAfter[A, B](tree: Tree[A, B] | Null, x: A)(implicit ordering: Ordering[A]): Tree[A, B] | Null = if (tree eq null) null else {
>>>>>>> NEW
    val cmp = ordering.compare(x, tree.key)
    if (cmp == 0) tree
    else if (cmp < 0) {
  /**
    * Returns the largest node with a key smaller than `x`. Returns `null` if there is no such node.
    */
<<<<<<< OLD
  def maxBefore[A, B](tree: Tree[A, B], x: A)(implicit ordering: Ordering[A]): Tree[A, B] = if (tree eq null) null else {
=======
  def maxBefore[A, B](tree: Tree[A, B] | Null, x: A)(implicit ordering: Ordering[A]): Tree[A, B] | Null = if (tree eq null) null else {
>>>>>>> NEW
    val cmp = ordering.compare(x, tree.key)
    if (cmp <= 0) maxBefore(tree.left, x)
    else {
    }
  }

<<<<<<< OLD
  def foreach[A,B,U](tree:Tree[A,B], f:((A,B)) => U):Unit = if (tree ne null) _foreach(tree,f)
=======
  def foreach[A,B,U](tree:Tree[A,B] | Null, f:((A,B)) => U):Unit = if (tree ne null) _foreach(tree,f)
>>>>>>> NEW

<<<<<<< OLD
  def keysEqual[A: Ordering, X, Y](a: Tree[A, X], b: Tree[A, Y]): Boolean = {
=======
  def keysEqual[A: Ordering, X, Y](a: Tree[A, X] | Null, b: Tree[A, Y] | Null): Boolean = {
>>>>>>> NEW
    if (a eq b) true
    else if (a eq null) false
    else if (b eq null) false
    else a.count == b.count && (new EqualsIterator(a)).sameKeys(new EqualsIterator(b))
  }
<<<<<<< OLD
  def valuesEqual[A: Ordering, X, Y](a: Tree[A, X], b: Tree[A, Y]): Boolean = {
=======
  def valuesEqual[A: Ordering, X, Y](a: Tree[A, X] | Null, b: Tree[A, Y] | Null): Boolean = {
>>>>>>> NEW
    if (a eq b) true
    else if (a eq null) false
    else if (b eq null) false
    else a.count == b.count && (new EqualsIterator(a)).sameValues(new EqualsIterator(b))
  }
<<<<<<< OLD
  def entriesEqual[A: Ordering, X, Y](a: Tree[A, X], b: Tree[A, Y]): Boolean = {
=======
  def entriesEqual[A: Ordering, X, Y](a: Tree[A, X] | Null, b: Tree[A, Y] | Null): Boolean = {
>>>>>>> NEW
    if (a eq b) true
    else if (a eq null) false
    else if (b eq null) false
  }

  private[this] def _foreach[A, B, U](tree: Tree[A, B], f: ((A, B)) => U): Unit = {
<<<<<<< OLD
    if (tree.left ne null) _foreach(tree.left, f)
=======
    if (tree.left ne null) _foreach(tree.left.nn, f)
>>>>>>> NEW
    f((tree.key, tree.value))
<<<<<<< OLD
    if (tree.right ne null) _foreach(tree.right, f)
=======
    if (tree.right ne null) _foreach(tree.right.nn, f)
>>>>>>> NEW
  }

<<<<<<< OLD
  def foreachKey[A, U](tree:Tree[A,_], f: A => U):Unit = if (tree ne null) _foreachKey(tree,f)
=======
  def foreachKey[A, U](tree: Tree[A,_] | Null, f: A => U):Unit = if (tree ne null) _foreachKey(tree,f)
>>>>>>> NEW

  private[this] def _foreachKey[A, U](tree: Tree[A, _], f: A => U): Unit = {
<<<<<<< OLD
    if (tree.left ne null) _foreachKey(tree.left, f)
=======
    if (tree.left ne null) _foreachKey(tree.left.nn, f)
>>>>>>> NEW
    f((tree.key))
<<<<<<< OLD
    if (tree.right ne null) _foreachKey(tree.right, f)
=======
    if (tree.right ne null) _foreachKey(tree.right.nn, f)
>>>>>>> NEW
  }

<<<<<<< OLD
  def foreachEntry[A, B, U](tree:Tree[A,B], f: (A, B) => U):Unit = if (tree ne null) _foreachEntry(tree,f)
=======
  def foreachEntry[A, B, U](tree: Tree[A,B] | Null, f: (A, B) => U):Unit = if (tree ne null) _foreachEntry(tree,f)
>>>>>>> NEW

  private[this] def _foreachEntry[A, B, U](tree: Tree[A, B], f: (A, B) => U): Unit = {
<<<<<<< OLD
    if (tree.left ne null) _foreachEntry(tree.left, f)
=======
    if (tree.left ne null) _foreachEntry(tree.left.nn, f)
>>>>>>> NEW
    f(tree.key, tree.value)
<<<<<<< OLD
    if (tree.right ne null) _foreachEntry(tree.right, f)
=======
    if (tree.right ne null) _foreachEntry(tree.right.nn, f)
>>>>>>> NEW
  }

<<<<<<< OLD
  def iterator[A: Ordering, B](tree: Tree[A, B], start: Option[A] = None): Iterator[(A, B)] = new EntriesIterator(tree, start)
  def keysIterator[A: Ordering](tree: Tree[A, _], start: Option[A] = None): Iterator[A] = new KeysIterator(tree, start)
  def valuesIterator[A: Ordering, B](tree: Tree[A, B], start: Option[A] = None): Iterator[B] = new ValuesIterator(tree, start)
=======
  def iterator[A: Ordering, B](tree: Tree[A, B] | Null, start: Option[A] = None): Iterator[(A, B)] = new EntriesIterator(tree, start)
  def keysIterator[A: Ordering](tree: Tree[A, _] | Null, start: Option[A] = None): Iterator[A] = new KeysIterator(tree, start)
  def valuesIterator[A: Ordering, B](tree: Tree[A, B] | Null, start: Option[A] = None): Iterator[B] = new ValuesIterator(tree, start)
>>>>>>> NEW

  @tailrec
  def nth[A, B](tree: Tree[A, B], n: Int): Tree[A, B] = {
    val count = this.count(tree.left)
<<<<<<< OLD
    if (n < count) nth(tree.left, n)
    else if (n > count) nth(tree.right, n - count - 1)
=======
    if (n < count) nth(tree.left.nn, n)
    else if (n > count) nth(tree.right.nn, n - count - 1)
>>>>>>> NEW
    else tree
  }

<<<<<<< OLD
  def isBlack(tree: Tree[_, _]) = (tree eq null) || tree.isBlack
=======
  def isBlack(tree: Tree[_, _] | Null) = (tree eq null) || tree.isBlack
>>>>>>> NEW

<<<<<<< OLD
  @`inline` private[this] def isRedTree(tree: Tree[_, _]) = (tree ne null) && tree.isRed
  @`inline` private[this] def isBlackTree(tree: Tree[_, _]) = (tree ne null) && tree.isBlack
=======
  @`inline` private[this] def isRedTree(tree: Tree[_, _] | Null) = (tree ne null) && tree.isRed
  @`inline` private[this] def isBlackTree(tree: Tree[_, _] | Null) = (tree ne null) && tree.isBlack
>>>>>>> NEW

<<<<<<< OLD
  private[this] def blacken[A, B](t: Tree[A, B]): Tree[A, B] = if (t eq null) null else t.black
=======
  private[this] def blacken[A, B](t: Tree[A, B] | Null): Tree[A, B] | Null = if (t eq null) null else t.black
>>>>>>> NEW

  // Blacken if the tree is red and has a red child. This is necessary when using methods such as `upd` or `updNth`
  // for building subtrees. Use `blacken` instead when building top-level trees.
  private[this] def maybeBlacken[A, B](t: Tree[A, B]): Tree[A, B] =
    if(isBlack(t)) t else if(isRedTree(t.left) || isRedTree(t.right)) t.black else t

<<<<<<< OLD
  private[this] def mkTree[A, B](isBlack: Boolean, key: A, value: B, left: Tree[A, B], right: Tree[A, B]) = {
=======
  private[this] def mkTree[A, B](isBlack: Boolean, key: A, value: B, left: Tree[A, B] | Null, right: Tree[A, B] | Null) = {
>>>>>>> NEW
    val sizeAndColour = sizeOf(left) + sizeOf(right) + 1 | (if(isBlack) initialBlackCount else initialRedCount)
    new Tree(key, value.asInstanceOf[AnyRef], left, right, sizeAndColour)
  }
          //                      RED
          //    black(nl.L)      nl.KV      black
          //                          nl.R    KV   R
<<<<<<< OLD
          val resultLeft = newLeft_left.black
=======
          val resultLeft = newLeft_left.nn.black
>>>>>>> NEW
          val resultRight = tree.blackWithLeft(newLeft_right)

          newLeft.withLeftRight(resultLeft, resultRight)
          //                              RED
          //           black            nl.R.KV      black
          //    nl.L   nl.KV  nl.R.L           nl.R.R  KV   R
<<<<<<< OLD
          val newLeft_right_right = newLeft_right.right
=======
          val newLeft_right_right = newLeft_right.nn.right
>>>>>>> NEW

<<<<<<< OLD
          val resultLeft = newLeft.blackWithRight(newLeft_right.left)
=======
          val resultLeft = newLeft.blackWithRight(newLeft_right.nn.left)
>>>>>>> NEW
          val resultRight = tree.blackWithLeft(newLeft_right_right)

<<<<<<< OLD
          newLeft_right.withLeftRight(resultLeft, resultRight)
=======
          newLeft_right.nn.withLeftRight(resultLeft, resultRight)
>>>>>>> NEW
        } else {
          //               tree
          //    newLeft      KV         R
          //                                RED
          //              black           nr.L.KV          black
          //     L         KV   nr.L.L             nr.L.R  nr.KV    nr.R
<<<<<<< OLD
          val resultLeft = tree.blackWithRight(newRight_left.left)
          val resultRight = newRight.blackWithLeft(newRight_left.right)
=======
          val resultLeft = tree.blackWithRight(newRight_left.nn.left)
          val resultRight = newRight.blackWithLeft(newRight_left.nn.right)
>>>>>>> NEW

<<<<<<< OLD
          newRight_left.withLeftRight(resultLeft, resultRight)
=======
          newRight_left.nn.withLeftRight(resultLeft, resultRight)
>>>>>>> NEW
        } else {
          val newRight_right = newRight.right
          if (isRedTree(newRight_right)) {
            //              black           nr.KV            black(nr.R)
            //     L         KV   nr.L
            val resultLeft = tree.blackWithRight(newRight_left)
<<<<<<< OLD
            val resultRight = newRight_right.black
=======
            val resultRight = newRight_right.nn.black
>>>>>>> NEW

            newRight.withLeftRight(resultLeft, resultRight)
          } else {
    }
  }

<<<<<<< OLD
  private[this] def upd[A, B, B1 >: B](tree: Tree[A, B], k: A, v: B1, overwrite: Boolean)(implicit ordering: Ordering[A]): Tree[A, B1] = if (tree eq null) {
    RedTree(k, v, null, null)
=======
  private[this] def upd[A, B, B1 >: B](tree: Tree[A, B] | Null, k: A, v: B1, overwrite: Boolean)(implicit ordering: Ordering[A]): Tree[A, B1] = if (tree eq null) {
    RedTree[A, B1](k, v, null, null)
>>>>>>> NEW
  } else if (k.asInstanceOf[AnyRef] eq tree.key.asInstanceOf[AnyRef]) {
    if (overwrite)
      tree.withV(v)
                        tree.withV(v)
    else tree
  }
<<<<<<< OLD
  private[this] def updNth[A, B, B1 >: B](tree: Tree[A, B], idx: Int, k: A, v: B1): Tree[A, B1] = if (tree eq null) {
    RedTree(k, v, null, null)
=======
  private[this] def updNth[A, B, B1 >: B](tree: Tree[A, B] | Null, idx: Int, k: A, v: B1): Tree[A, B1] = if (tree eq null) {
    RedTree(k, v, null: Tree[A, B1] | Null, null: Tree[A, B1] | Null)
>>>>>>> NEW
  } else {
    val rank = count(tree.left) + 1
    if (idx < rank)
    else tree
  }

<<<<<<< OLD
  private[this] def doFrom[A, B](tree: Tree[A, B], from: A)(implicit ordering: Ordering[A]): Tree[A, B] = {
=======
  private[this] def doFrom[A, B](tree: Tree[A, B] | Null, from: A)(implicit ordering: Ordering[A]): Tree[A, B] | Null = {
>>>>>>> NEW
    if (tree eq null) return null
    if (ordering.lt(tree.key, from)) return doFrom(tree.right, from)
    val newLeft = doFrom(tree.left, from)
    else if (newLeft eq null) maybeBlacken(upd(tree.right, tree.key, tree.value, overwrite = false))
    else join(newLeft, tree.key, tree.value, tree.right)
  }
<<<<<<< OLD
  private[this] def doTo[A, B](tree: Tree[A, B], to: A)(implicit ordering: Ordering[A]): Tree[A, B] = {
=======
  private[this] def doTo[A, B](tree: Tree[A, B] | Null, to: A)(implicit ordering: Ordering[A]): Tree[A, B] | Null = {
>>>>>>> NEW
    if (tree eq null) return null
    if (ordering.lt(to, tree.key)) return doTo(tree.left, to)
    val newRight = doTo(tree.right, to)
    else if (newRight eq null) maybeBlacken(upd(tree.left, tree.key, tree.value, overwrite = false))
    else join(tree.left, tree.key, tree.value, newRight)
  }
<<<<<<< OLD
  private[this] def doUntil[A, B](tree: Tree[A, B], until: A)(implicit ordering: Ordering[A]): Tree[A, B] = {
=======
  private[this] def doUntil[A, B](tree: Tree[A, B] | Null, until: A)(implicit ordering: Ordering[A]): Tree[A, B] | Null = {
>>>>>>> NEW
    if (tree eq null) return null
    if (ordering.lteq(until, tree.key)) return doUntil(tree.left, until)
    val newRight = doUntil(tree.right, until)
    else join(tree.left, tree.key, tree.value, newRight)
  }

<<<<<<< OLD
  private[this] def doRange[A, B](tree: Tree[A, B], from: A, until: A)(implicit ordering: Ordering[A]): Tree[A, B] = {
=======
  private[this] def doRange[A, B](tree: Tree[A, B] | Null, from: A, until: A)(implicit ordering: Ordering[A]): Tree[A, B] | Null = {
>>>>>>> NEW
    if (tree eq null) return null
    if (ordering.lt(tree.key, from)) return doRange(tree.right, from, until)
    if (ordering.lteq(until, tree.key)) return doRange(tree.left, from, until)
    else join(newLeft, tree.key, tree.value, newRight)
  }

<<<<<<< OLD
  private[this] def doDrop[A, B](tree: Tree[A, B], n: Int): Tree[A, B] =
=======
  private[this] def doDrop[A, B](tree: Tree[A, B] | Null, n: Int): Tree[A, B] | Null =
>>>>>>> NEW
    if((tree eq null) || (n <= 0)) tree
    else if(n >= tree.count) null
    else {
      else join(doDrop(tree.left, n), tree.key, tree.value, tree.right)
    }

<<<<<<< OLD
  private[this] def doTake[A, B](tree: Tree[A, B], n: Int): Tree[A, B] =
=======
  private[this] def doTake[A, B](tree: Tree[A, B] | Null, n: Int): Tree[A, B] | Null =
>>>>>>> NEW
    if((tree eq null) || (n <= 0)) null
    else if(n >= tree.count) tree
    else {
      else join(tree.left, tree.key, tree.value, doTake(tree.right, n-l-1))
    }

<<<<<<< OLD
  private[this] def doSlice[A, B](tree: Tree[A, B], from: Int, until: Int): Tree[A, B] =
=======
  private[this] def doSlice[A, B](tree: Tree[A, B] | Null, from: Int, until: Int): Tree[A, B] | Null =
>>>>>>> NEW
    if((tree eq null) || (from >= until) || (from >= tree.count) || (until <= 0)) null
    else if((from <= 0) && (until >= tree.count)) tree
    else {
   */
  private[immutable] final class Tree[A, +B](
                           @(`inline` @getter @setter)     private var _key: A,
<<<<<<< OLD
                           @(`inline` @getter @setter)     private var _value: AnyRef,
                           @(`inline` @getter @setter)     private var _left: Tree[A, _],
                           @(`inline` @getter @setter)     private var _right: Tree[A, _],
=======
                           @(`inline` @getter @setter)     private var _value: AnyRef | Null,
                           @(`inline` @getter @setter)     private var _left: Tree[A, _] | Null,
                           @(`inline` @getter @setter)     private var _right: Tree[A, _] | Null,
>>>>>>> NEW
                           @(`inline` @getter @setter)     private var _count: Int)
  {
    @`inline` private[RedBlackTree] def isMutable: Boolean = (_count & colourMask) == 0
    @`inline` private def mutableRetainingColour = _count & colourBit

    //inlined here to avoid outer object null checks
<<<<<<< OLD
    @`inline` private[RedBlackTree] final def sizeOf(tree:Tree[_,_]) = if (tree eq null) 0 else tree.count
=======
    @`inline` private[RedBlackTree] final def sizeOf(tree: Tree[_,_] | Null) = if (tree eq null) 0 else tree.count
>>>>>>> NEW
    @`inline` private[immutable] final def key = _key
    @`inline` private[immutable] final def value = _value.asInstanceOf[B]
<<<<<<< OLD
    @`inline` private[immutable] final def left = _left.asInstanceOf[Tree[A, B]]
    @`inline` private[immutable] final def right = _right.asInstanceOf[Tree[A, B]]
=======
    @`inline` private[immutable] final def left = _left.asInstanceOf[Tree[A, B] | Null]
    @`inline` private[immutable] final def right = _right.asInstanceOf[Tree[A, B] | Null]
>>>>>>> NEW
    //Note - only used in tests outside RedBlackTree
    @`inline` private[immutable] final def isBlack = _count < 0
    //Note - only used in tests outside RedBlackTree
        if (isMutable) {
          var size = 1
          if (_left ne null) {
<<<<<<< OLD
            _left.makeImmutable
            size += _left.count
=======
            _left.nn.makeImmutable
            size += _left.nn.count
>>>>>>> NEW
          }
          if (_right ne null) {
<<<<<<< OLD
            _right.makeImmutable
            size += _right.count
=======
            _right.nn.makeImmutable
            size += _right.nn.count
>>>>>>> NEW
          }
          _count |= size //retains colour
        }
      } else new Tree(_key, newValue.asInstanceOf[AnyRef], _left, _right, mutableRetainingColour)
    }

<<<<<<< OLD
    private[RedBlackTree] def mutableWithLeft[B1 >: B](newLeft: Tree[A, B1]): Tree[A, B1] = {
=======
    private[RedBlackTree] def mutableWithLeft[B1 >: B](newLeft: Tree[A, B1] | Null): Tree[A, B1] = {
>>>>>>> NEW
      if (_left eq newLeft) this
      else if (isMutable) {
        _left = newLeft
        this
      } else new Tree(_key, _value, newLeft, _right, mutableRetainingColour)
    }
<<<<<<< OLD
    private[RedBlackTree] def mutableWithRight[B1 >: B](newRight: Tree[A, B1]): Tree[A, B1] = {
=======
    private[RedBlackTree] def mutableWithRight[B1 >: B](newRight: Tree[A, B1] | Null): Tree[A, B1] = {
>>>>>>> NEW
      if (_right eq newRight) this
      else if (isMutable) {
        _right = newRight
        this
      } else new Tree(_key, _value, _left, newRight, mutableRetainingColour)
    }
<<<<<<< OLD
    private[RedBlackTree] def mutableWithLeftRight[B1 >: B](newLeft: Tree[A, B1], newRight: Tree[A, B1]): Tree[A, B1] = {
=======
    private[RedBlackTree] def mutableWithLeftRight[B1 >: B](newLeft: Tree[A, B1] | Null, newRight: Tree[A, B1] | Null): Tree[A, B1] = {
>>>>>>> NEW
      if ((_left eq newLeft) && (_right eq newRight)) this
      else if (isMutable) {
        _left = newLeft
        this
      } else new Tree(_key, _value, newLeft, newRight, mutableRetainingColour)
    }
<<<<<<< OLD
    private[RedBlackTree] def mutableBlackWithLeft[B1 >: B](newLeft: Tree[A, B1]): Tree[A, B1] = {
=======
    private[RedBlackTree] def mutableBlackWithLeft[B1 >: B](newLeft: Tree[A, B1] | Null): Tree[A, B1] = {
>>>>>>> NEW
      if ((_left eq newLeft) && isBlack) this
      else if (isMutable) {
        _count = initialBlackCount
        this
      } else new Tree(_key, _value, newLeft, _right, initialBlackCount)
    }
<<<<<<< OLD
    private[RedBlackTree] def mutableBlackWithRight[B1 >: B](newRight: Tree[A, B1]): Tree[A, B1] = {
=======
    private[RedBlackTree] def mutableBlackWithRight[B1 >: B](newRight: Tree[A, B1] | Null): Tree[A, B1] = {
>>>>>>> NEW
      if ((_right eq newRight) && isBlack) this
      else if (isMutable) {
        _count = initialBlackCount
      else new Tree(_key, newValue.asInstanceOf[AnyRef], _left, _right, _count)
    }

<<<<<<< OLD
    private[RedBlackTree] def withLeft[B1 >: B](newLeft: Tree[A, B1]): Tree[A, B1] = {
=======
    private[RedBlackTree] def withLeft[B1 >: B](newLeft: Tree[A, B1] | Null): Tree[A, B1] = {
>>>>>>> NEW
      //assertNotMutable(this)
      //assertNotMutable(newLeft)
      if (newLeft eq _left) this
        new Tree(key, value.asInstanceOf[AnyRef], newLeft, _right, (_count & colourBit) | size)
      }
    }
<<<<<<< OLD
    private[RedBlackTree] def withRight[B1 >: B](newRight: Tree[A, B1]): Tree[A, B1] = {
=======
    private[RedBlackTree] def withRight[B1 >: B](newRight: Tree[A, B1] | Null): Tree[A, B1] = {
>>>>>>> NEW
      //assertNotMutable(this)
      //assertNotMutable(newRight)
      if (newRight eq _right) this
        new Tree(key, value.asInstanceOf[AnyRef], _left, newRight, (_count & colourBit) | size)
      }
    }
<<<<<<< OLD
    private[RedBlackTree] def blackWithLeft[B1 >: B](newLeft: Tree[A, B1]): Tree[A, B1] = {
=======
    private[RedBlackTree] def blackWithLeft[B1 >: B](newLeft: Tree[A, B1] | Null): Tree[A, B1] = {
>>>>>>> NEW
      //assertNotMutable(this)
      //assertNotMutable(newLeft)
      if ((newLeft eq _left) && isBlack) this
        new Tree(key, value.asInstanceOf[AnyRef], newLeft, _right, initialBlackCount | size)
      }
    }
<<<<<<< OLD
    private[RedBlackTree] def redWithLeft[B1 >: B](newLeft: Tree[A, B1]): Tree[A, B1] = {
=======
    private[RedBlackTree] def redWithLeft[B1 >: B](newLeft: Tree[A, B1] | Null): Tree[A, B1] = {
>>>>>>> NEW
      //assertNotMutable(this)
      //assertNotMutable(newLeft)
      if ((newLeft eq _left) && isRed) this
        new Tree(key, value.asInstanceOf[AnyRef], newLeft, _right, initialRedCount | size)
      }
    }
<<<<<<< OLD
    private[RedBlackTree] def blackWithRight[B1 >: B](newRight: Tree[A, B1]): Tree[A, B1] = {
=======
    private[RedBlackTree] def blackWithRight[B1 >: B](newRight: Tree[A, B1] | Null): Tree[A, B1] = {
>>>>>>> NEW
      //assertNotMutable(this)
      //assertNotMutable(newRight)
      if ((newRight eq _right) && isBlack) this
        new Tree(key, value.asInstanceOf[AnyRef], _left, newRight, initialBlackCount | size)
      }
    }
<<<<<<< OLD
    private[RedBlackTree] def redWithRight[B1 >: B](newRight: Tree[A, B1]): Tree[A, B1] = {
=======
    private[RedBlackTree] def redWithRight[B1 >: B](newRight: Tree[A, B1] | Null): Tree[A, B1] = {
>>>>>>> NEW
      //assertNotMutable(this)
      //assertNotMutable(newLeft)
      if ((newRight eq _right) && isRed) this
        new Tree(key, value.asInstanceOf[AnyRef], _left, newRight, initialRedCount | size)
      }
    }
<<<<<<< OLD
    private[RedBlackTree] def withLeftRight[B1 >: B](newLeft: Tree[A, B1], newRight: Tree[A, B1]): Tree[A, B1] = {
=======
    private[RedBlackTree] def withLeftRight[B1 >: B](newLeft: Tree[A, B1] | Null, newRight: Tree[A, B1] | Null): Tree[A, B1] = {
>>>>>>> NEW
      //assertNotMutable(this)
      //assertNotMutable(newLeft)
      //assertNotMutable(newRight)
        new Tree(key, value.asInstanceOf[AnyRef], newLeft, newRight, (_count & colourBit) | size)
      }
    }
<<<<<<< OLD
    private[RedBlackTree] def redWithLeftRight[B1 >: B](newLeft: Tree[A, B1], newRight: Tree[A, B1]): Tree[A, B1] = {
=======
    private[RedBlackTree] def redWithLeftRight[B1 >: B](newLeft: Tree[A, B1] | Null, newRight: Tree[A, B1] | Null): Tree[A, B1] = {
>>>>>>> NEW
      //assertNotMutable(this)
      //assertNotMutable(newLeft)
      //assertNotMutable(newRight)
        new Tree(key, value.asInstanceOf[AnyRef], newLeft, newRight, initialRedCount | size)
      }
    }
<<<<<<< OLD
    private[RedBlackTree] def blackWithLeftRight[B1 >: B](newLeft: Tree[A, B1], newRight: Tree[A, B1]): Tree[A, B1] = {
=======
    private[RedBlackTree] def blackWithLeftRight[B1 >: B](newLeft: Tree[A, B1] | Null, newRight: Tree[A, B1] | Null): Tree[A, B1] = {
>>>>>>> NEW
      //assertNotMutable(this)
      //assertNotMutable(newLeft)
      //assertNotMutable(newRight)
  private[RedBlackTree] final val initialBlackCount = colourBit
  private[RedBlackTree] final val initialRedCount   = 0

<<<<<<< OLD
  @`inline` private[RedBlackTree] def mutableRedTree[A, B](key: A, value: B, left: Tree[A, B], right: Tree[A, B]) = new Tree[A,B](key, value.asInstanceOf[AnyRef], left, right, initialRedCount)
  @`inline` private[RedBlackTree] def mutableBlackTree[A, B](key: A, value: B, left: Tree[A, B], right: Tree[A, B]) = new Tree[A,B](key, value.asInstanceOf[AnyRef], left, right, initialBlackCount)
=======
  @`inline` private[RedBlackTree] def mutableRedTree[A, B](key: A, value: B, left: Tree[A, B] | Null, right: Tree[A, B] | Null) = new Tree[A,B](key, value.asInstanceOf[AnyRef], left, right, initialRedCount)
  @`inline` private[RedBlackTree] def mutableBlackTree[A, B](key: A, value: B, left: Tree[A, B] | Null, right: Tree[A, B] | Null) = new Tree[A,B](key, value.asInstanceOf[AnyRef], left, right, initialBlackCount)
>>>>>>> NEW

  /** create a new immutable red tree.
   * left and right may be null
   */
<<<<<<< OLD
  private[immutable] def RedTree[A, B](key: A, value: B, left: Tree[A, B], right: Tree[A, B]): Tree[A, B] = {
=======
  private[immutable] def RedTree[A, B](key: A, value: B, left: Tree[A, B] | Null, right: Tree[A, B] | Null): Tree[A, B] = {
>>>>>>> NEW
    //assertNotMutable(left)
    //assertNotMutable(right)
    val size = sizeOf(left) + sizeOf(right) + 1
    new Tree(key, value.asInstanceOf[AnyRef], left, right, initialRedCount | size)
  }
<<<<<<< OLD
  private[immutable] def BlackTree[A, B](key: A, value: B, left: Tree[A, B], right: Tree[A, B]): Tree[A, B] = {
=======
  private[immutable] def BlackTree[A, B](key: A, value: B, left: Tree[A, B] | Null, right: Tree[A, B] | Null): Tree[A, B] = {
>>>>>>> NEW
    //assertNotMutable(left)
    //assertNotMutable(right)
    val size = sizeOf(left) + sizeOf(right) + 1
    new Tree(key, value.asInstanceOf[AnyRef], left, right, initialBlackCount | size)
  }
<<<<<<< OLD
  @`inline` private def sizeOf(tree:Tree[_,_]) = if (tree eq null) 0 else tree.count
=======
  @`inline` private def sizeOf(tree:Tree[_,_] | Null) = if (tree eq null) 0 else tree.count
>>>>>>> NEW
  //immutable APIs
  //assertions - uncomment decls and callers  when changing functionality
  //  private def devTimeAssert(assertion: Boolean) = {
  //  private def assertNotMutable(t:Tree[_,_]) = {
  //    devTimeAssert ((t eq null) || t.count > 0)
  //  }
<<<<<<< OLD
  private[this] abstract class TreeIterator[A, B, R](root: Tree[A, B], start: Option[A])(protected implicit val ordering: Ordering[A]) extends AbstractIterator[R] {
=======
  private[this] abstract class TreeIterator[A, B, R](root: Tree[A, B] | Null, start: Option[A])(protected implicit val ordering: Ordering[A]) extends AbstractIterator[R] {
>>>>>>> NEW
    protected[this] def nextResult(tree: Tree[A, B]): R

    override def hasNext: Boolean = lookahead ne null
    }

    @tailrec
<<<<<<< OLD
    protected final def findLeftMostOrPopOnEmpty(tree: Tree[A, B]): Tree[A, B] =
=======
    protected final def findLeftMostOrPopOnEmpty(tree: Tree[A, B] | Null): Tree[A, B] | Null =
>>>>>>> NEW
      if (tree eq null) popNext()
      else if (tree.left eq null) tree
      else findLeftMostOrPopOnEmpty(goLeft(tree))

    @`inline` private[this] def pushNext(tree: Tree[A, B]): Unit = {
<<<<<<< OLD
      stackOfNexts(index) = tree
=======
      stackOfNexts.nn(index) = tree
>>>>>>> NEW
      index += 1
    }
<<<<<<< OLD
    @`inline` protected final def popNext(): Tree[A, B] = if (index == 0) null else {
=======
    @`inline` protected final def popNext(): Tree[A, B] | Null = if (index == 0) null else {
>>>>>>> NEW
      index -= 1
<<<<<<< OLD
      stackOfNexts(index)
=======
      stackOfNexts.nn(index)
>>>>>>> NEW
    }

<<<<<<< OLD
    protected[this] val stackOfNexts = if (root eq null) null else {
=======
    protected[this] val stackOfNexts: Array[Tree[A, B]] | Null = if (root eq null) null else {
>>>>>>> NEW
      /*
       * According to "Ralf Hinze. Constructing red-black trees" [https://www.cs.ox.ac.uk/ralf.hinze/publications/#P5]
       * the maximum height of a red-black tree is 2*log_2(n + 2) - 2.
      new Array[Tree[A, B]](maximumHeight)
    }
    private[this] var index = 0
<<<<<<< OLD
    protected var lookahead: Tree[A, B] = if (start.isDefined) startFrom(start.get) else findLeftMostOrPopOnEmpty(root)
=======
    protected var lookahead: Tree[A, B] | Null = if (start.isDefined) startFrom(start.get) else findLeftMostOrPopOnEmpty(root)
>>>>>>> NEW

    /**
      * Find the leftmost subtree whose key is equal to the given key, or if no such thing,
      * to the ordering. Along the way build up the iterator's path stack so that "next"
      * functionality works.
      */
<<<<<<< OLD
    private[this] def startFrom(key: A) : Tree[A,B] = if (root eq null) null else {
      @tailrec def find(tree: Tree[A, B]): Tree[A, B] =
=======
    private[this] def startFrom(key: A) : Tree[A,B] | Null = if (root eq null) null else {
      @tailrec def find(tree: Tree[A, B] | Null): Tree[A, B] | Null =
>>>>>>> NEW
        if (tree eq null) popNext()
        else find(
          if (ordering.lteq(key, tree.key)) goLeft(tree)
          this.lookahead = this.popNext()
          that.lookahead = that.popNext()
        } else {
<<<<<<< OLD
          equal = (this.lookahead.key.asInstanceOf[AnyRef] eq that.lookahead.key.asInstanceOf[AnyRef]) ||
            ordering.equiv(this.lookahead.key, that.lookahead.key)
          this.lookahead =  this.findLeftMostOrPopOnEmpty(this.goRight(this.lookahead))
          that.lookahead =  that.findLeftMostOrPopOnEmpty(that.goRight(that.lookahead))
=======
          equal = (this.lookahead.nn.key.asInstanceOf[AnyRef] eq that.lookahead.nn.key.asInstanceOf[AnyRef]) ||
            ordering.equiv(this.lookahead.nn.key, that.lookahead.nn.key)
          this.lookahead =  this.findLeftMostOrPopOnEmpty(this.goRight(this.lookahead.nn))
          that.lookahead =  that.findLeftMostOrPopOnEmpty(that.goRight(that.lookahead.nn))
>>>>>>> NEW
        }
      }
      equal && (this.lookahead eq null) && (that.lookahead eq null)
          this.lookahead = this.popNext()
          that.lookahead = that.popNext()
        } else {
<<<<<<< OLD
          equal = this.lookahead.value == that.lookahead.value
          this.lookahead =  this.findLeftMostOrPopOnEmpty(this.goRight(this.lookahead))
          that.lookahead =  that.findLeftMostOrPopOnEmpty(that.goRight(that.lookahead))
=======
          equal = this.lookahead.nn.value == that.lookahead.nn.value
          this.lookahead =  this.findLeftMostOrPopOnEmpty(this.goRight(this.lookahead.nn))
          that.lookahead =  that.findLeftMostOrPopOnEmpty(that.goRight(that.lookahead.nn))
>>>>>>> NEW
        }
      }
      equal && (this.lookahead eq null) && (that.lookahead eq null)
          this.lookahead = this.popNext()
          that.lookahead = that.popNext()
        } else {
<<<<<<< OLD
          equal = ((this.lookahead.key.asInstanceOf[AnyRef] eq that.lookahead.key.asInstanceOf[AnyRef]) ||
            ordering.equiv(this.lookahead.key, that.lookahead.key)) && this.lookahead.value == that.lookahead.value
          this.lookahead =  this.findLeftMostOrPopOnEmpty(this.goRight(this.lookahead))
          that.lookahead =  that.findLeftMostOrPopOnEmpty(that.goRight(that.lookahead))
=======
          equal = ((this.lookahead.nn.key.asInstanceOf[AnyRef] eq that.lookahead.nn.key.asInstanceOf[AnyRef]) ||
            ordering.equiv(this.lookahead.nn.key, that.lookahead.nn.key)) && this.lookahead.nn.value == that.lookahead.nn.value
          this.lookahead =  this.findLeftMostOrPopOnEmpty(this.goRight(this.lookahead.nn))
          that.lookahead =  that.findLeftMostOrPopOnEmpty(that.goRight(that.lookahead.nn))
>>>>>>> NEW
        }
      }
      equal && (this.lookahead eq null) && (that.lookahead eq null)
    }
  }
<<<<<<< OLD
  private[this] class EntriesIterator[A: Ordering, B](tree: Tree[A, B], focus: Option[A]) extends TreeIterator[A, B, (A, B)](tree, focus) {
=======
  private[this] class EntriesIterator[A: Ordering, B](tree: Tree[A, B] | Null, focus: Option[A]) extends TreeIterator[A, B, (A, B)](tree, focus) {
>>>>>>> NEW
    override def nextResult(tree: Tree[A, B]) = (tree.key, tree.value)
  }

<<<<<<< OLD
  private[this] class KeysIterator[A: Ordering, B](tree: Tree[A, B], focus: Option[A]) extends TreeIterator[A, B, A](tree, focus) {
=======
  private[this] class KeysIterator[A: Ordering, B](tree: Tree[A, B] | Null, focus: Option[A]) extends TreeIterator[A, B, A](tree, focus) {
>>>>>>> NEW
    override def nextResult(tree: Tree[A, B]) = tree.key
  }

<<<<<<< OLD
  private[this] class ValuesIterator[A: Ordering, B](tree: Tree[A, B], focus: Option[A]) extends TreeIterator[A, B, B](tree, focus) {
=======
  private[this] class ValuesIterator[A: Ordering, B](tree: Tree[A, B] | Null, focus: Option[A]) extends TreeIterator[A, B, B](tree, focus) {
>>>>>>> NEW
    override def nextResult(tree: Tree[A, B]) = tree.value
  }

  /** Build a Tree suitable for a TreeSet from an ordered sequence of keys */
<<<<<<< OLD
  def fromOrderedKeys[A](xs: Iterator[A]^, size: Int): Tree[A, Null] = {
=======
  def fromOrderedKeys[A](xs: Iterator[A]^, size: Int): Tree[A, Null] | Null = {
>>>>>>> NEW
    val maxUsedDepth = 32 - Integer.numberOfLeadingZeros(size) // maximum depth of non-leaf nodes
<<<<<<< OLD
    def f(level: Int, size: Int): Tree[A, Null] = size match {
=======
    def f(level: Int, size: Int): Tree[A, Null] | Null = size match {
>>>>>>> NEW
      case 0 => null
      case 1 => mkTree(level != maxUsedDepth || level == 1, xs.next(), null, null, null)
      case n =>
  }

  /** Build a Tree suitable for a TreeMap from an ordered sequence of key/value pairs */
<<<<<<< OLD
  def fromOrderedEntries[A, B](xs: Iterator[(A, B)]^, size: Int): Tree[A, B] = {
=======
  def fromOrderedEntries[A, B](xs: Iterator[(A, B)]^, size: Int): Tree[A, B] | Null = {
>>>>>>> NEW
    val maxUsedDepth = 32 - Integer.numberOfLeadingZeros(size) // maximum depth of non-leaf nodes
<<<<<<< OLD
    def f(level: Int, size: Int): Tree[A, B] = size match {
=======
    def f(level: Int, size: Int): Tree[A, B] | Null = size match {
>>>>>>> NEW
      case 0 => null
      case 1 =>
        val (k, v) = xs.next()
    f(1, size)
  }

<<<<<<< OLD
  def transform[A, B, C](t: Tree[A, B], f: (A, B) => C): Tree[A, C] =
=======
  def transform[A, B, C](t: Tree[A, B] | Null, f: (A, B) => C): Tree[A, C] | Null =
>>>>>>> NEW
    if(t eq null) null
    else {
      val k = t.key
      else mkTree(t.isBlack, k, v2, l2, r2)
    }

<<<<<<< OLD
  def filterEntries[A, B](t: Tree[A, B], f: (A, B) => Boolean): Tree[A, B] = if(t eq null) null else {
    def fk(t: Tree[A, B]): Tree[A, B] = {
=======
  def filterEntries[A, B](t: Tree[A, B] | Null, f: (A, B) => Boolean): Tree[A, B] | Null = if(t eq null) null else {
    def fk(t: Tree[A, B]): Tree[A, B] | Null = {
>>>>>>> NEW
      val k = t.key
      val v = t.value
      val l = t.left

  private[this] val null2 = (null, null)

<<<<<<< OLD
  def partitionEntries[A, B](t: Tree[A, B], p: (A, B) => Boolean): (Tree[A, B], Tree[A, B]) = if(t eq null) (null, null) else {
=======
  def partitionEntries[A, B](t: Tree[A, B] | Null, p: (A, B) => Boolean): (Tree[A, B] | Null, Tree[A, B] | Null) = if(t eq null) (null, null) else {
>>>>>>> NEW
    if (t eq null) null2
    else {
      object partitioner {
<<<<<<< OLD
        var tmpk, tmpd = null: Tree[A, B] // shared vars to avoid returning tuples from fk
=======
        var tmpk, tmpd = null: Tree[A, B] | Null // shared vars to avoid returning tuples from fk
>>>>>>> NEW
        def fk(t: Tree[A, B]): Unit = {
          val k                  = t.key
          val v                  = t.value
<<<<<<< OLD
          val l                  = t.left
          val r                  = t.right
          var l2k, l2d, r2k, r2d = null: Tree[A, B]
=======
          var l                  = t.left
          var r                  = t.right
          var l2k, l2d, r2k, r2d = null: Tree[A, B] | Null
>>>>>>> NEW
          if (l ne null) {
            fk(l)
            l2k = tmpk
  // Constructing Red-Black Trees, Ralf Hinze: [[https://www.cs.ox.ac.uk/ralf.hinze/publications/WAAAPL99b.ps.gz]]
  // Red-Black Trees in a Functional Setting, Chris Okasaki: [[https://wiki.rice.edu/confluence/download/attachments/2761212/Okasaki-Red-Black.pdf]] */

<<<<<<< OLD
  private[this] def del[A, B](tree: Tree[A, B], k: A)(implicit ordering: Ordering[A]): Tree[A, B] = if (tree eq null) null else {
=======
  private[this] def del[A, B](tree: Tree[A, B] | Null, k: A)(implicit ordering: Ordering[A]): Tree[A, B] | Null = if (tree eq null) null else {
>>>>>>> NEW
    val cmp = ordering.compare(k, tree.key)
    if (cmp < 0) {
      val newLeft = del(tree.left, k)
    } else append(tree.left, tree.right)
  }

<<<<<<< OLD
  private[this] def balance[A, B](tree: Tree[A,B], tl: Tree[A, B], tr: Tree[A, B]): Tree[A, B] =
=======
  private[this] def balance[A, B](tree: Tree[A,B], tl: Tree[A, B] | Null, tr: Tree[A, B] | Null): Tree[A, B] =
>>>>>>> NEW
    if (isRedTree(tl)) {
<<<<<<< OLD
      if (isRedTree(tr)) tree.redWithLeftRight(tl.black, tr.black)
      else if (isRedTree(tl.left))  tl.withLeftRight(tl.left.black, tree.blackWithLeftRight(tl.right, tr))
      else if (isRedTree(tl.right)) tl.right.withLeftRight(tl.blackWithRight(tl.right.left), tree.blackWithLeftRight(tl.right.right, tr))
=======
      if (isRedTree(tr)) tree.redWithLeftRight(tl.nn.black, tr.nn.black)
      else if (isRedTree(tl.nn.left))  tl.nn.withLeftRight(tl.nn.left.nn.black, tree.blackWithLeftRight(tl.nn.right, tr))
      else if (isRedTree(tl.nn.right)) tl.nn.right.nn.withLeftRight(tl.nn.blackWithRight(tl.nn.right.nn.left), tree.blackWithLeftRight(tl.nn.right.nn.right, tr))
>>>>>>> NEW
      else tree.blackWithLeftRight(tl, tr)
    } else if (isRedTree(tr)) {
<<<<<<< OLD
      if (isRedTree(tr.right))     tr.withLeftRight(tree.blackWithLeftRight(tl, tr.left), tr.right.black)
      else if (isRedTree(tr.left)) tr.left.withLeftRight(tree.blackWithLeftRight(tl, tr.left.left), tr.blackWithLeftRight(tr.left.right, tr.right))
=======
      if (isRedTree(tr.nn.right))     tr.nn.withLeftRight(tree.blackWithLeftRight(tl, tr.nn.left), tr.nn.right.nn.black)
      else if (isRedTree(tr.nn.left)) tr.nn.left.nn.withLeftRight(tree.blackWithLeftRight(tl, tr.nn.left.nn.left), tr.nn.blackWithLeftRight(tr.nn.left.nn.right, tr.nn.right))
>>>>>>> NEW
      else tree.blackWithLeftRight(tl, tr)
    } else tree.blackWithLeftRight(tl, tr)

<<<<<<< OLD
  private[this] def balLeft[A, B](tree: Tree[A,B], tl: Tree[A, B], tr: Tree[A, B]): Tree[A, B] =
    if (isRedTree(tl)) tree.redWithLeftRight(tl.black, tr)
    else if (isBlackTree(tr)) balance(tree, tl, tr.red)
    else if (isRedTree(tr) && isBlackTree(tr.left))
         tr.left.redWithLeftRight(tree.blackWithLeftRight(tl, tr.left.left), balance(tr, tr.left.right, tr.right.red))
=======
  private[this] def balLeft[A, B](tree: Tree[A,B], tl: Tree[A, B] | Null, tr: Tree[A, B] | Null): Tree[A, B] =
    if (isRedTree(tl)) tree.redWithLeftRight(tl.nn.black, tr)
    else if (isBlackTree(tr)) balance(tree, tl, tr.nn.red)
    else if (isRedTree(tr) && isBlackTree(tr.nn.left))
         tr.nn.left.nn.redWithLeftRight(tree.blackWithLeftRight(tl, tr.nn.left.nn.left), balance(tr.nn, tr.nn.left.nn.right, tr.nn.right.nn.red))
>>>>>>> NEW
    else sys.error("Defect: invariance violation")

<<<<<<< OLD
  private[this] def balRight[A, B](tree: Tree[A,B], tl: Tree[A, B], tr: Tree[A, B]): Tree[A, B] =
    if (isRedTree(tr)) tree.redWithLeftRight(tl, tr.black)
    else if (isBlackTree(tl)) balance(tree, tl.red, tr)
    else if (isRedTree(tl) && isBlackTree(tl.right))
         tl.right.redWithLeftRight(balance(tl, tl.left.red, tl.right.left), tree.blackWithLeftRight(tl.right.right, tr))
=======
  private[this] def balRight[A, B](tree: Tree[A,B], tl: Tree[A, B] | Null, tr: Tree[A, B] | Null): Tree[A, B] =
    if (isRedTree(tr)) tree.redWithLeftRight(tl, tr.nn.black)
    else if (isBlackTree(tl)) balance(tree, tl.nn.red, tr)
    else if (isRedTree(tl) && isBlackTree(tl.nn.right))
         tl.nn.right.nn.redWithLeftRight(balance(tl.nn, tl.nn.left.nn.red, tl.nn.right.nn.left), tree.blackWithLeftRight(tl.nn.right.nn.right, tr))
>>>>>>> NEW
    else sys.error("Defect: invariance violation")

  /** `append` is similar to `join2` but requires that both subtrees have the same black height */
<<<<<<< OLD
  private[this] def append[A, B](tl: Tree[A, B], tr: Tree[A, B]): Tree[A, B] = {
=======
  private[this] def append[A, B](tl: Tree[A, B] | Null, tr: Tree[A, B] | Null): Tree[A, B] | Null = {
>>>>>>> NEW
    if (tl eq null) tr
    else if (tr eq null) tl
    else if (tl.isRed) {
<<<<<<< OLD
           if (tr.isRed) {
             //tl is red, tr is red
             val bc = append(tl.right, tr.left)
             if (isRedTree(bc)) bc.withLeftRight(tl.withRight(bc.left), tr.withLeft(bc.right))
             else tl.withRight(tr.withLeft(bc))
           } else {
             //tl is red, tr is black
             tl.withRight(append(tl.right, tr))
           }
         } else {
           if (tr.isBlack) {
             //tl is black tr is black
             val bc = append(tl.right, tr.left)
             if (isRedTree(bc)) bc.withLeftRight(tl.withRight(bc.left), tr.withLeft(bc.right))
             else balLeft(tl, tl.left, tr.withLeft(bc))
           } else {
             //tl is black tr is red
             tr.withLeft(append(tl, tr.left))
           }
         }
=======
      if (tr.isRed) {
        //tl is red, tr is red
        val bc = append(tl.right, tr.left)
        if (isRedTree(bc)) bc.nn.withLeftRight(tl.withRight(bc.nn.left), tr.withLeft(bc.nn.right))
        else tl.withRight(tr.withLeft(bc))
      } else {
        //tl is red, tr is black
        tl.withRight(append(tl.right, tr))
      }
    } else {
      if (tr.isBlack) {
        //tl is black tr is black
        val bc = append(tl.right, tr.left)
        if (isRedTree(bc)) bc.nn.withLeftRight(tl.withRight(bc.nn.left), tr.withLeft(bc.nn.right))
        else balLeft(tl, tl.left, tr.withLeft(bc))
      } else {
        //tl is black tr is red
        tr.withLeft(append(tl, tr.left))
      }
    }
>>>>>>> NEW
  }


  // of child nodes from it. Where possible the black height is used directly instead of deriving the rank from it.
  // Our trees are supposed to have a black root so we always blacken as the last step of union/intersect/difference.

<<<<<<< OLD
  def union[A, B](t1: Tree[A, B], t2: Tree[A, B])(implicit ordering: Ordering[A]): Tree[A, B] = blacken(_union(t1, t2))
=======
  def union[A, B](t1: Tree[A, B] | Null, t2: Tree[A, B] | Null)(implicit ordering: Ordering[A]): Tree[A, B] | Null = blacken(_union(t1, t2))
>>>>>>> NEW

<<<<<<< OLD
  def intersect[A, B](t1: Tree[A, B], t2: Tree[A, B])(implicit ordering: Ordering[A]): Tree[A, B] = blacken(_intersect(t1, t2))
=======
  def intersect[A, B](t1: Tree[A, B] | Null, t2: Tree[A, B] | Null)(implicit ordering: Ordering[A]): Tree[A, B] | Null = blacken(_intersect(t1, t2))
>>>>>>> NEW

<<<<<<< OLD
  def difference[A, B](t1: Tree[A, B], t2: Tree[A, _])(implicit ordering: Ordering[A]): Tree[A, B] =
=======
  def difference[A, B](t1: Tree[A, B] | Null, t2: Tree[A, _] | Null)(implicit ordering: Ordering[A]): Tree[A, B] | Null =
>>>>>>> NEW
    blacken(_difference(t1, t2.asInstanceOf[Tree[A, B]]))

  /** Compute the rank from a tree and its black height */
<<<<<<< OLD
  @`inline` private[this] def rank(t: Tree[_, _], bh: Int): Int = {
=======
  @`inline` private[this] def rank(t: Tree[_, _] | Null, bh: Int): Int = {
>>>>>>> NEW
    if(t eq null) 0
    else if(t.isBlack) 2*(bh-1)
    else 2*bh-1
  }

<<<<<<< OLD
  private[this] def joinRight[A, B](tl: Tree[A, B], k: A, v: B, tr: Tree[A, B], bhtl: Int, rtr: Int): Tree[A, B] = {
=======
  private[this] def joinRight[A, B](tl: Tree[A, B] | Null, k: A, v: B, tr: Tree[A, B] | Null, bhtl: Int, rtr: Int): Tree[A, B] = {
>>>>>>> NEW
    val rtl = rank(tl, bhtl)
    if(rtl == (rtr/2)*2) RedTree(k, v, tl, tr)
    else {
<<<<<<< ADDED
      val tlnn = tl.nn
>>>>>>> ADDED
      val tlBlack = isBlackTree(tl)
      val bhtlr = if(tlBlack) bhtl-1 else bhtl
<<<<<<< OLD
      val ttr = joinRight(tl.right, k, v, tr, bhtlr, rtr)
=======
      val ttr = joinRight(tlnn.right, k, v, tr, bhtlr, rtr)
>>>>>>> NEW
      if(tlBlack && isRedTree(ttr) && isRedTree(ttr.right))
        RedTree(ttr.key, ttr.value,
<<<<<<< OLD
          BlackTree(tl.key, tl.value, tl.left, ttr.left),
          ttr.right.black)
      else mkTree(tlBlack, tl.key, tl.value, tl.left, ttr)
=======
          BlackTree(tlnn.key, tlnn.value, tlnn.left, ttr.left),
          ttr.right.nn.black)
      else mkTree(tlBlack, tlnn.key, tlnn.value, tlnn.left, ttr)
>>>>>>> NEW
    }
  }

<<<<<<< OLD
  private[this] def joinLeft[A, B](tl: Tree[A, B], k: A, v: B, tr: Tree[A, B], rtl: Int, bhtr: Int): Tree[A, B] = {
=======
  private[this] def joinLeft[A, B](tl: Tree[A, B] | Null, k: A, v: B, tr: Tree[A, B] | Null, rtl: Int, bhtr: Int): Tree[A, B] = {
>>>>>>> NEW
    val rtr = rank(tr, bhtr)
    if(rtr == (rtl/2)*2) RedTree(k, v, tl, tr)
    else {
<<<<<<< ADDED
      val trnn = tr.nn
>>>>>>> ADDED
      val trBlack = isBlackTree(tr)
      val bhtrl = if(trBlack) bhtr-1 else bhtr
<<<<<<< OLD
      val ttl = joinLeft(tl, k, v, tr.left, rtl, bhtrl)
=======
      val ttl = joinLeft(tl, k, v, trnn.left, rtl, bhtrl)
>>>>>>> NEW
      if(trBlack && isRedTree(ttl) && isRedTree(ttl.left))
        RedTree(ttl.key, ttl.value,
<<<<<<< OLD
          ttl.left.black,
          BlackTree(tr.key, tr.value, ttl.right, tr.right))
      else mkTree(trBlack, tr.key, tr.value, ttl, tr.right)
=======
          ttl.left.nn.black,
          BlackTree(trnn.key, trnn.value, ttl.right, trnn.right))
      else mkTree(trBlack, trnn.key, trnn.value, ttl, trnn.right)
>>>>>>> NEW
    }
  }

<<<<<<< OLD
  private[this] def join[A, B](tl: Tree[A, B], k: A, v: B, tr: Tree[A, B]): Tree[A, B] = {
    @tailrec def h(t: Tree[_, _], i: Int): Int =
=======
  private[this] def join[A, B](tl: Tree[A, B] | Null, k: A, v: B, tr: Tree[A, B] | Null): Tree[A, B] = {
    @tailrec def h(t: Tree[_, _] | Null, i: Int): Int =
>>>>>>> NEW
      if(t eq null) i+1 else h(t.left, if(t.isBlack) i+1 else i)
    val bhtl = h(tl, 0)
    val bhtr = h(tr, 0)
    } else mkTree(isRedTree(tl) || isRedTree(tr), k, v, tl, tr)
  }

<<<<<<< OLD
  private[this] def split[A, B](t: Tree[A, B], k2: A)(implicit ordering: Ordering[A]): (Tree[A, B], Tree[A, B], Tree[A, B], A) =
=======
  private[this] def split[A, B](t: Tree[A, B] | Null, k2: A)(implicit ordering: Ordering[A]): (Tree[A, B] | Null, Tree[A, B] | Null, Tree[A, B] | Null, A) =
>>>>>>> NEW
    if(t eq null) (null, null, null, k2)
    else {
      val cmp = ordering.compare(k2, t.key)
    }

  private[this] def splitLast[A, B](t: Tree[A, B]): (Tree[A, B], A, B) =
<<<<<<< OLD
    if(t.right eq null) (t.left, t.key, t.value)
=======
    if(t.right eq null) (t.left.nn, t.key, t.value)
>>>>>>> NEW
    else {
<<<<<<< OLD
      val (tt, kk, vv) = splitLast(t.right)
=======
      val (tt, kk, vv) = splitLast(t.right.nn)
>>>>>>> NEW
      (join(t.left, t.key, t.value, tt), kk, vv)
    }

<<<<<<< OLD
  private[this] def join2[A, B](tl: Tree[A, B], tr: Tree[A, B]): Tree[A, B] =
=======
  private[this] def join2[A, B](tl: Tree[A, B] | Null, tr: Tree[A, B] | Null): Tree[A, B] | Null =
>>>>>>> NEW
    if(tl eq null) tr
    else if(tr eq null) tl
    else {
      join(ttl, k, v, tr)
    }

<<<<<<< OLD
  private[this] def _union[A, B](t1: Tree[A, B], t2: Tree[A, B])(implicit ordering: Ordering[A]): Tree[A, B] =
=======
  private[this] def _union[A, B](t1: Tree[A, B] | Null, t2: Tree[A, B] | Null)(implicit ordering: Ordering[A]): Tree[A, B] | Null =
>>>>>>> NEW
    if((t1 eq null) || (t1 eq t2)) t2
    else if(t2 eq null) t1
    else {
      join(tl, k1, t2.value, tr)
    }

<<<<<<< OLD
  private[this] def _intersect[A, B](t1: Tree[A, B], t2: Tree[A, B])(implicit ordering: Ordering[A]): Tree[A, B] =
=======
  private[this] def _intersect[A, B](t1: Tree[A, B] | Null, t2: Tree[A, B] | Null)(implicit ordering: Ordering[A]): Tree[A, B] | Null =
>>>>>>> NEW
    if((t1 eq null) || (t2 eq null)) null
    else if (t1 eq t2) t1
    else {
      else join2(tl, tr)
    }

<<<<<<< OLD
  private[this] def _difference[A, B](t1: Tree[A, B], t2: Tree[A, B])(implicit ordering: Ordering[A]): Tree[A, B] =
=======
  private[this] def _difference[A, B](t1: Tree[A, B] | Null, t2: Tree[A, B] | Null)(implicit ordering: Ordering[A]): Tree[A, B] | Null =
>>>>>>> NEW
    if((t1 eq null) || (t2 eq null)) t1
    else if (t1 eq t2) null
    else {
      join2(tl, tr)
    }
}
<<<<<<< ADDED

>>>>>>> ADDED