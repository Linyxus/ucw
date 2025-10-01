  *  @define mayNotTerminateInf
  *  @define willNotTerminateInf
  */
<<<<<<< OLD
final class TreeSet[A] private[immutable] (private[immutable] val tree: RB.Tree[A, Any])(implicit val ordering: Ordering[A])
=======
final class TreeSet[A] private[immutable] (private[immutable] val tree: RB.Tree[A, Any] | Null)(implicit val ordering: Ordering[A])
>>>>>>> NEW
  extends AbstractSet[A]
    with SortedSet[A]
    with SortedSetOps[A, TreeSet, TreeSet[A]]

  override def sortedIterableFactory: TreeSet.type = TreeSet

<<<<<<< OLD
  private[this] def newSetOrSelf(t: RB.Tree[A, Any]) = if(t eq tree) this else new TreeSet[A](t)
=======
  private[this] def newSetOrSelf(t: RB.Tree[A, Any] | Null) = if(t eq tree) this else new TreeSet[A](t)
>>>>>>> NEW

  override def size: Int = RB.count(tree)

          // Dotty doesn't infer that E =:= Int, since instantiation of covariant GADTs is unsound
        new TreeSet[E](tree)
      case _ =>
<<<<<<< OLD
        var t: RB.Tree[E, Null] = null
=======
        var t: RB.Tree[E, Null] | Null = null
>>>>>>> NEW
        val i = it.iterator
        while (i.hasNext) t = RB.update(t, i.next(), null, overwrite = false)
        new TreeSet[E](t)
    extends RB.SetHelper[A]
      with ReusableBuilder[A, TreeSet[A]] {
    type Tree = RB.Tree[A, Any]
<<<<<<< OLD
    private [this] var tree:RB.Tree[A, Any] = null
=======
    private [this] var tree:RB.Tree[A, Any] | Null = null
>>>>>>> NEW

    override def addOne(elem: A): this.type = {
      tree = mutableUpd(tree, elem)