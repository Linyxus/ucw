  *  @define mayNotTerminateInf
  *  @define willNotTerminateInf
  */
<<<<<<< OLD
final class TreeMap[K, +V] private (private val tree: RB.Tree[K, V])(implicit val ordering: Ordering[K])
=======
final class TreeMap[K, +V] private (private val tree: RB.Tree[K, V] | Null)(implicit val ordering: Ordering[K])
>>>>>>> NEW
  extends AbstractMap[K, V]
    with SortedMap[K, V]
    with StrictOptimizedSortedMapOps[K, V, TreeMap, TreeMap[K, V]]
    with DefaultSerializable {

  def this()(implicit ordering: Ordering[K]) = this(null)(ordering)
<<<<<<< OLD
  private[immutable] def tree0: RB.Tree[K, V] = tree
=======
  private[immutable] def tree0: RB.Tree[K, V] | Null = tree
>>>>>>> NEW

<<<<<<< OLD
  private[this] def newMapOrSelf[V1 >: V](t: RB.Tree[K, V1]): TreeMap[K, V1] = if(t eq tree) this else new TreeMap[K, V1](t)
=======
  private[this] def newMapOrSelf[V1 >: V](t: RB.Tree[K, V1] | Null): TreeMap[K, V1] = if(t eq tree) this else new TreeMap[K, V1](t)
>>>>>>> NEW

  override def sortedMapFactory: SortedMapFactory[TreeMap] = TreeMap


  private final class Adder[B1 >: V]
    extends RB.MapHelper[K, B1] with Function1[(K, B1), Unit] {
<<<<<<< OLD
    private var currentMutableTree: RB.Tree[K,B1] = tree0
=======
    private var currentMutableTree: RB.Tree[K,B1] | Null = tree0
>>>>>>> NEW
    def finalTree = beforePublish(currentMutableTree)
    override def apply(kv: (K, B1)): Unit = {
      currentMutableTree = mutableUpd(currentMutableTree, kv._1, kv._2)
      case sm: scala.collection.SortedMap[K, V] if ordering == sm.ordering =>
        new TreeMap[K, V](RB.fromOrderedEntries(sm.iterator, sm.size))
      case _ =>
<<<<<<< OLD
        var t: RB.Tree[K, V] = null
=======
        var t: RB.Tree[K, V] | Null = null
>>>>>>> NEW
        val i = it.iterator
        while (i.hasNext) {
          val (k, v) = i.next()
    extends RB.MapHelper[K, V]
      with ReusableBuilder[(K, V), TreeMap[K, V]] {
    type Tree = RB.Tree[K, V]
<<<<<<< OLD
    private var tree:Tree = null
=======
    private var tree: Tree | Null = null
>>>>>>> NEW

    def addOne(elem: (K, V)): this.type = {
      tree = mutableUpd(tree, elem._1, elem._2)
    private object adder extends AbstractFunction2[K, V, Unit] {
      // we cache tree to avoid the outer access to tree
      // in the hot path (apply)
<<<<<<< OLD
      private[this] var accumulator :Tree = null
=======
      private[this] var accumulator: Tree | Null = null
>>>>>>> NEW
      def addForEach(hasForEach: collection.Map[K, V]): Unit = {
        accumulator = tree
        hasForEach.foreachEntry(this)