      //  return at runtime a SetNode[A], or a tuple of (A, Int, Int)

      // the queue of single-element, post-filter nodes
<<<<<<< OLD
      var nodesToMigrateToData: mutable.Queue[SetNode[A]] = null
=======
      var nodesToMigrateToData: mutable.Queue[SetNode[A]] | Null = null
>>>>>>> NEW

      // bitmap of all nodes which, when filtered, returned themselves. They are passed forward to the returned node
      var nodesToPassThroughMap = 0
      // not named `newNodesMap` (plural) to avoid confusion with `newNodeMap` (singular)
      var mapOfNewNodes = 0
      // each bit in `mapOfNewNodes` corresponds to one element in this queue
<<<<<<< OLD
      var newNodes: mutable.Queue[SetNode[A]] = null
=======
      var newNodes: mutable.Queue[SetNode[A]] | Null = null
>>>>>>> NEW

      var newDataMap = 0
      var newNodeMap = 0
        // bitmap of nodes which, when filtered, returned a single-element node. These must be migrated to data
        var nodeMigrateToDataTargetMap = 0
        // the queue of single-element, post-filter nodes
<<<<<<< OLD
        var nodesToMigrateToData: mutable.Queue[SetNode[A]] = null
=======
        var nodesToMigrateToData: mutable.Queue[SetNode[A]] | Null = null
>>>>>>> NEW

        // bitmap of all nodes which, when filtered, returned themselves. They are passed forward to the returned node
        var nodesToPassThroughMap = 0
        // not named `newNodesMap` (plural) to avoid confusion with `newNodeMap` (singular)
        var mapOfNewNodes = 0
        // each bit in `mapOfNewNodes` corresponds to one element in this queue
<<<<<<< OLD
        var newNodes: mutable.Queue[SetNode[A]] = null
=======
        var newNodes: mutable.Queue[SetNode[A]] | Null = null
>>>>>>> NEW

        var newDataMap = 0
        var newNodeMap = 0
    oldDataPassThrough: Int,
    nodesToPassThroughMap: Int,
    nodeMigrateToDataTargetMap: Int,
<<<<<<< OLD
    nodesToMigrateToData: mutable.Queue[SetNode[A]],
=======
    nodesToMigrateToData: mutable.Queue[SetNode[A]] | Null,
>>>>>>> NEW
    mapOfNewNodes: Int,
<<<<<<< OLD
    newNodes: mutable.Queue[SetNode[A]],
=======
    newNodes: mutable.Queue[SetNode[A]] | Null,
>>>>>>> NEW
    newCachedHashCode: Int): BitmapIndexedSetNode[A] = {
    if (newSize == 0) {
      SetNode.empty
          oldNodeIndex += 1
        } else if ((bitpos & nodeMigrateToDataTargetMap) != 0) {
          // we need not check for null here. If nodeMigrateToDataTargetMap != 0, then nodesMigrateToData must not be null
<<<<<<< OLD
          val node = nodesToMigrateToData.dequeue()
=======
          val node = nodesToMigrateToData.nn.dequeue()
>>>>>>> NEW
          newContent(newDataIndex) = node.getPayload(0)
          newOriginalHashes(newDataIndex) = node.getHash(0)
          newDataIndex += 1
          oldNodeIndex += 1
        } else if ((bitpos & mapOfNewNodes) != 0) {
          // we need not check for null here. If mapOfNewNodes != 0, then newNodes must not be null
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
        var newContent: VectorBuilder[A] = null
=======
        var newContent: VectorBuilder[A] | Null = null
>>>>>>> NEW
        val iter = hc.content.iterator
        while (iter.hasNext) {
          val nextPayload = iter.next()
  /** The last given out HashSet as a return value of `result()`, if any, otherwise null.
    * Indicates that on next add, the elements should be copied to an identical structure, before continuing
    * mutations. */
<<<<<<< OLD
  private var aliased: HashSet[A] = _
=======
  @annotation.stableNull
  private var aliased: HashSet[A] | Null = null
>>>>>>> NEW

  private def isAliased: Boolean = aliased != null
