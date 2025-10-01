  }

  override def transform[W](f: (K, V) => W): BitmapIndexedMapNode[K, W] = {
<<<<<<< OLD
    var newContent: Array[Any] = null
=======
    @annotation.stableNull var newContent: Array[Any] | Null = null
>>>>>>> NEW
    val iN = payloadArity // arity doesn't change during this operation
    val jN = nodeArity // arity doesn't change during this operation
    val newContentLength = content.length
      // bitmap of nodes which, when filtered, returned a single-element node. These must be migrated to data
      var nodeMigrateToDataTargetMap = 0
      // the queue of single-element, post-filter nodes
<<<<<<< OLD
      var nodesToMigrateToData: mutable.Queue[MapNode[K, V]] = null
=======
      @annotation.stableNull var nodesToMigrateToData: mutable.Queue[MapNode[K, V]] | Null = null
>>>>>>> NEW

      // bitmap of all nodes which, when filtered, returned themselves. They are passed forward to the returned node
      var nodesToPassThroughMap = 0
      // not named `newNodesMap` (plural) to avoid confusion with `newNodeMap` (singular)
      var mapOfNewNodes = 0
      // each bit in `mapOfNewNodes` corresponds to one element in this queue
<<<<<<< OLD
      var newNodes: mutable.Queue[MapNode[K, V]] = null
=======
      @annotation.stableNull var newNodes: mutable.Queue[MapNode[K, V]] | Null = null
>>>>>>> NEW

      var newDataMap = 0
      var newNodeMap = 0
              nodesToPassThroughMap |= bitpos
            } else {
              mapOfNewNodes |= bitpos
<<<<<<< OLD
              if (newNodes eq null) {
=======
              if (newNodes == null) {
>>>>>>> NEW
                newNodes = mutable.Queue.empty
              }
              newNodes += newSubNode
          } else if (newSubNode.size == 1) {
            newDataMap |= bitpos
            nodeMigrateToDataTargetMap |= bitpos
<<<<<<< OLD
            if (nodesToMigrateToData eq null) {
=======
            if (nodesToMigrateToData == null) {
>>>>>>> NEW
              nodesToMigrateToData = mutable.Queue()
            }
            nodesToMigrateToData += newSubNode
            oldNodeIndex += 1
          } else if ((bitpos & nodeMigrateToDataTargetMap) != 0) {
            // we need not check for null here. If nodeMigrateToDataTargetMap != 0, then nodesMigrateToData must not be null
<<<<<<< OLD
            val node = nodesToMigrateToData.dequeue()
=======
            val node = nodesToMigrateToData.nn.dequeue()
>>>>>>> NEW
            newContent(TupleLength * newDataIndex) = node.getKey(0)
            newContent(TupleLength * newDataIndex + 1) = node.getValue(0)
            newOriginalHashes(newDataIndex) = node.getHash(0)
            newDataIndex += 1
            oldNodeIndex += 1
          } else if ((bitpos & mapOfNewNodes) != 0) {
<<<<<<< OLD
            newContent(newContentSize - newNodeIndex - 1) = newNodes.dequeue()
=======
            newContent(newContentSize - newNodeIndex - 1) = newNodes.nn.dequeue()
>>>>>>> NEW
            newNodeIndex += 1
            oldNodeIndex += 1
          } else if ((bitpos & dataMap) != 0) {
      if (hc eq this) {
        this
      } else {
<<<<<<< OLD
        var newContent: VectorBuilder[(K, V1)] = null
=======
        var newContent: VectorBuilder[(K, V1)] | Null = null
>>>>>>> NEW
        val iter = content.iterator
        while (iter.hasNext) {
          val nextPayload = iter.next()
          if (hc.indexOf(nextPayload._1) < 0) {
<<<<<<< OLD
            if (newContent eq null) {
=======
            if (newContent == null) {
>>>>>>> NEW
              newContent = new VectorBuilder[(K, V1)]()
              newContent.addAll(hc.content)
            }
  override def mergeInto[V1 >: V](that: MapNode[K, V1], builder: HashMapBuilder[K, V1], shift: Int)(mergef: ((K, V), (K, V1)) => (K, V1)): Unit = that match {
    case hc: HashCollisionMapNode[K, V1] =>
      val iter = content.iterator
<<<<<<< OLD
      val rightArray = hc.content.toArray[AnyRef] // really Array[(K, V1)]
=======
      val rightArray: Array[AnyRef | Null] = hc.content.toArray[AnyRef | Null] // really Array[(K, V1)]
>>>>>>> NEW

      def rightIndexOf(key: K): Int = {
        var i = 0
  /** The last given out HashMap as a return value of `result()`, if any, otherwise null.
    * Indicates that on next add, the elements should be copied to an identical structure, before continuing
    * mutations. */
<<<<<<< OLD
  private var aliased: HashMap[K, V] = _
=======
  @annotation.stableNull
  private var aliased: HashMap[K, V] | Null = _
>>>>>>> NEW

  private def isAliased: Boolean = aliased != null
