    private[this] val bdr = new MapBuilderImpl[K, (Int, V)]
    private[this] var ong = Ordering.empty[K]
    private[this] var ord = 0
<<<<<<< OLD
    private[this] var aliased: TreeSeqMap[K, V] = _
=======
    @annotation.stableNull
    private[this] var aliased: TreeSeqMap[K, V] | Null = null
>>>>>>> NEW

    override def addOne(elem: (K, V)): this.type = addOne(elem._1, elem._2)
    def addOne(key: K, value: V): this.type = {
    }

    @inline private[collection] final def appendInPlace[S >: T](ordinal: Int, value: S): Ordering[S] = appendInPlace1(null, ordinal, value)
<<<<<<< OLD
    private[collection] final def appendInPlace1[S >: T](parent: Bin[S], ordinal: Int, value: S): Ordering[S] = this match {
=======
    private[collection] final def appendInPlace1[S >: T](parent: Bin[S] | Null, ordinal: Int, value: S): Ordering[S] = this match {
>>>>>>> NEW
      case Zero =>
        Tip(ordinal, value)
      case Tip(o, _) if o >= ordinal =>
      case Tip(o, _) if parent == null =>
        join(ordinal, Tip(ordinal, value), o, this)
      case Tip(o, _) =>
<<<<<<< OLD
        parent.right = join(ordinal, Tip(ordinal, value), o, this)
        parent
=======
        parent.nn.right = join(ordinal, Tip(ordinal, value), o, this)
        parent.nn
>>>>>>> NEW
      case b @ Bin(p, m, _, r) =>
        if (!hasMatch(ordinal, p, m)) {
          val b2 = join(ordinal, Tip(ordinal, value), p, this)