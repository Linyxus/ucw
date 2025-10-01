  @transient private[this] var mutationCount: Int = 0

  private var first: List[A] = Nil
<<<<<<< OLD
  private var last0: ::[A] = null // last element (`last0` just because the name `last` is already taken)
=======
  @annotation.stableNull
  private var last0: ::[A] | Null = null // last element (`last0` just because the name `last` is already taken)
>>>>>>> NEW
  private[this] var aliased = false
  private[this] var len = 0

<<<<<<< OLD
  private type Predecessor = ::[A] /*| Null*/
=======
  private type Predecessor = ::[A] | Null
>>>>>>> NEW

  def iterator: Iterator[A] = new MutationTracker.CheckedIterator(first.iterator, mutationCount)

    if (isEmpty) xs
    else {
      ensureUnaliased()
<<<<<<< OLD
      last0.next = xs
=======
      last0.nn.next = xs
>>>>>>> NEW
      toList
    }
  }
  final def addOne(elem: A): this.type = {
    ensureUnaliased()
    val last1 = new ::[A](elem, Nil)
<<<<<<< OLD
    if (len == 0) first = last1 else last0.next = last1
=======
    if (len == 0) first = last1 else last0.nn.next = last1
>>>>>>> NEW
    last0 = last1
    len += 1
    this
      val fresh = new ListBuffer[A].freshFrom(it)
      ensureUnaliased()
      if (len == 0) first = fresh.first
<<<<<<< OLD
      else last0.next = fresh.first
=======
      else last0.nn.next = fresh.first
>>>>>>> NEW
      last0 = fresh.last0
      len += fresh.length
    }
      first = newElem
    } else {
      // `p` can not be `null` because the case where `idx == 0` is handled above
<<<<<<< OLD
      val p = predecessor(idx)
=======
      val p = predecessor(idx).nn
>>>>>>> NEW
      val newElem = new :: (elem, p.tail.tail)
      if (last0 eq p.tail) {
        last0 = newElem
    if (!fresh.isEmpty) {
      val follow = getNext(prev)
      if (prev eq null) first = fresh.first else prev.next = fresh.first
<<<<<<< OLD
      fresh.last0.next = follow
=======
      fresh.last0.nn.next = follow
>>>>>>> NEW
      if (follow.isEmpty) last0 = fresh.last0
      len += fresh.length
    }
   *  @param f the mapping function
   *  @return this $coll
   */
<<<<<<< OLD
  def flatMapInPlace(f: A => IterableOnce[A]^): this.type = {
=======
  def flatMapInPlace(f: A => IterableOnce[A]): this.type = {
>>>>>>> NEW
    mutationCount += 1
    var src = first
<<<<<<< OLD
    var dst: List[A] = null
=======
    var dst: List[A] | Null = null
>>>>>>> NEW
    last0 = null
    len = 0
    while(!src.isEmpty) {
      val it = f(src.head).iterator
      while(it.hasNext) {
        val v = new ::(it.next(), Nil)
<<<<<<< OLD
        if(dst eq null) dst = v else last0.next = v
=======
        if(dst eq null) dst = v else last0.nn.next = v
>>>>>>> NEW
        last0 = v
        len += 1
      }