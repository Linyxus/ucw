
  def iterator: Iterator[T] = new AbstractIterator[T] {
    var pos: Int = -1
<<<<<<< OLD
    var node: Unrolled[T] = headptr
=======
    var node: Unrolled[T] | Null = headptr
>>>>>>> NEW
    scan()

    private def scan(): Unit = {
      pos += 1
<<<<<<< OLD
      while (pos >= node.size) {
=======
      while (pos >= node.nn.size) {
>>>>>>> NEW
        pos = 0
<<<<<<< OLD
        node = node.next
=======
        node = node.nn.next
>>>>>>> NEW
        if (node eq null) return
      }
    }
    def hasNext = node ne null
    def next() = if (hasNext) {
<<<<<<< OLD
      val r = node.array(pos)
=======
      val r = node.nn.array(pos)
>>>>>>> NEW
      scan()
      r
    } else Iterator.empty.next()

  /** Unrolled buffer node.
    */
<<<<<<< OLD
  class Unrolled[T: ClassTag] private[collection] (var size: Int, var array: Array[T], var next: Unrolled[T], val buff: UnrolledBuffer[T] = null) {
=======
  class Unrolled[T: ClassTag] private[collection] (var size: Int, var array: Array[T], var next: Unrolled[T] | Null, val buff: UnrolledBuffer[T] | Null = null) {
>>>>>>> NEW
    this: Unrolled[T]^{} =>
    private[collection] def this() = this(0, new Array[T](unrolledlength), null, null)
<<<<<<< OLD
    private[collection] def this(b: UnrolledBuffer[T]) = this(0, new Array[T](unrolledlength), null, b)
=======
    private[collection] def this(b: UnrolledBuffer[T] | Null) = this(0, new Array[T](unrolledlength), null, b)
>>>>>>> NEW

    private def nextlength = if (buff eq null) unrolledlength else buff.calcNextLength(array.length)

      this
    } else {
      next = new Unrolled[T](0, new Array[T](nextlength), null, buff)
<<<<<<< OLD
      next append elem
=======
      next.nn append elem
>>>>>>> NEW
    }
    def foreach[U](f: T => U): Unit = {
<<<<<<< OLD
      var unrolled = this
=======
      var unrolled: Unrolled[T] | Null = this
>>>>>>> NEW
      var i = 0
      while (unrolled ne null) {
        val chunkarr = unrolled.array
      }
    }
    def mapInPlace(f: T => T): Unit = {
<<<<<<< OLD
      var unrolled = this
=======
      var unrolled: Unrolled[T] | Null = this
>>>>>>> NEW
      var i = 0
      while (unrolled ne null) {
        val chunkarr = unrolled.array
      }
    }
    @tailrec final def apply(idx: Int): T =
<<<<<<< OLD
      if (idx < size) array(idx) else next.apply(idx - size)
=======
      if (idx < size) array(idx) else next.nn.apply(idx - size)
>>>>>>> NEW
    @tailrec final def update(idx: Int, newelem: T): Unit =
<<<<<<< OLD
      if (idx < size) array(idx) = newelem else next.update(idx - size, newelem)
=======
      if (idx < size) array(idx) = newelem else next.nn.update(idx - size, newelem)
>>>>>>> NEW
    @tailrec final def locate(idx: Int): Unrolled[T] =
<<<<<<< OLD
      if (idx < size) this else next.locate(idx - size)
=======
      if (idx < size) this else next.nn.locate(idx - size)
>>>>>>> NEW
    def prepend(elem: T) = if (size < array.length) {
      // shift the elements of the array right
      // then insert the element
        size -= 1
        if (tryMergeWithNext()) buffer.lastPtr = this
        r
<<<<<<< OLD
      } else next.remove(idx - size, buffer)
=======
      } else next.nn.remove(idx - size, buffer)
>>>>>>> NEW

    @tailrec final def subtractOne(elem: T, buffer: UnrolledBuffer[T]): Boolean = {
      var i = 0
        }
        i += 1
      }
<<<<<<< OLD
      if(next ne null) next.subtractOne(elem, buffer) else false
=======
      if(next ne null) next.nn.subtractOne(elem, buffer) else false
>>>>>>> NEW
    }

    // shifts left elements after `leftb` (overwrites `leftb`)
      }
      nullout(i, i + 1)
    }
<<<<<<< OLD
    protected def tryMergeWithNext() = if (next != null && (size + next.size) < (array.length * waterline / waterlineDenom)) {
=======
    protected def tryMergeWithNext() = if (next != null && (size + next.nn.size) < (array.length * waterline / waterlineDenom)) {
>>>>>>> NEW
      // copy the next array, then discard the next node
<<<<<<< OLD
      Array.copy(next.array, 0, array, size, next.size)
      size = size + next.size
      next = next.next
=======
      Array.copy(next.nn.array, 0, array, size, next.nn.size)
      size = size + next.nn.size
      next = next.nn.next
>>>>>>> NEW
      if (next eq null) true else false // checks if last node was thrown out
    } else false

        }
        appended
      }
<<<<<<< OLD
      else next.insertAll(idx - size, t, buffer)
=======
      else next.nn.insertAll(idx - size, t, buffer)
>>>>>>> NEW
    }

    private def nullout(from: Int, until: Int): Unit = {