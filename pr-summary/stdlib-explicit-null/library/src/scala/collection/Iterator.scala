    private[this] var hd: A = _
    private[this] var hdDefined: Boolean = false

<<<<<<< REMOVED

>>>>>>> REMOVED
    def head: A = {
      if (!hdDefined) {
        hd = next()

    require(size >= 1 && step >= 1, f"size=$size%d and step=$step%d, but both must be positive")

<<<<<<< OLD
    private[this] var buffer: Array[B] = null                 // current result
    private[this] var prev: Array[B] = null                   // if sliding, overlap from previous result
=======
    private[this] var buffer: Array[B] | Null = null          // current result
    private[this] var prev: Array[B] | Null = null            // if sliding, overlap from previous result
>>>>>>> NEW
    private[this] var first = true                            // if !first, advancing may skip ahead
    private[this] var filled = false                          // whether the buffer is "hot"
    private[this] var partial = true                          // whether to emit partial sequence
<<<<<<< OLD
    private[this] var padding: () -> B = null                 // what to pad short sequences with
=======
    private[this] var padding: (() -> B) | Null = null        // what to pad short sequences with
>>>>>>> NEW
    private[this] def pad = padding != null                   // irrespective of partial flag
    private[this] def newBuilder = {
      val b = ArrayBuilder.make[Any]
      val builder = newBuilder
      var done = false
      // keep prefix of previous buffer if stepping
<<<<<<< OLD
      if (prev != null) builder.addAll(prev)
=======
      if (prev != null) builder.addAll(prev.nn)
>>>>>>> NEW
      // skip ahead
      if (!first && step > size) {
        var dropping = step - size
        if (index < size && pad) {
          builder.sizeHint(size)
          while (index < size) {
<<<<<<< OLD
            builder.addOne(padding())
=======
            builder.addOne(padding.nn())
>>>>>>> NEW
            index += 1
          }
        }
      if (!fill()) Iterator.empty.next()
      else {
        filled = false
<<<<<<< ADDED
        val buffer = this.buffer.nn
>>>>>>> ADDED
        // if stepping, retain overlap in prev
        if (step < size) {
          if (first) prev = buffer.drop(step)
<<<<<<< OLD
          else if (buffer.length == size) Array.copy(src = buffer, srcPos = step, dest = prev, destPos = 0, length = size - step)
=======
          else if (buffer.length == size) Array.copy(src = buffer, srcPos = step, dest = prev.nn, destPos = 0, length = size - step)
>>>>>>> NEW
          else prev = null
        }
        val res = immutable.ArraySeq.unsafeWrapArray(buffer).asInstanceOf[immutable.ArraySeq[B]]
<<<<<<< OLD
        buffer = null
=======
        this.buffer = null
>>>>>>> NEW
        first = false
        res
      }
     * handling of structural calls. It's not what's intended here.
     */
    final class Leading extends AbstractIterator[A] {
<<<<<<< OLD
      private[this] var lookahead: mutable.Queue[A] = null
=======
      private[this] var lookahead: mutable.Queue[A] | Null = null
>>>>>>> NEW
      private[this] var hd: A = _
      /* Status is kept with magic numbers
       *   1 means next element is in hd and we're still reading into this iterator
      private[this] var status = 0
      private def store(a: A): Unit = {
        if (lookahead == null) lookahead = new mutable.Queue[A]
<<<<<<< OLD
        lookahead += a
=======
        lookahead.nn += a
>>>>>>> NEW
      }
      def hasNext = {
<<<<<<< OLD
        if (status < 0) (lookahead ne null) && lookahead.nonEmpty
=======
        if (status < 0) (lookahead ne null) && lookahead.nn.nonEmpty
>>>>>>> NEW
        else if (status > 0) true
        else {
          if (self.hasNext) {
      def next() = {
        if (hasNext) {
          if (status == 1) { status = 0; hd }
<<<<<<< OLD
          else lookahead.dequeue()
=======
          else lookahead.nn.dequeue()
>>>>>>> NEW
        }
        else Iterator.empty.next()
      }
        case 1 => if (self.hasNext) { status = 2 ; true } else { status = 3 ; false }
        case 0 => true
        case _ =>
<<<<<<< OLD
          if (myLeading.finish()) { status = 0 ; true } else { status = 1 ; myLeading = null ; hasNext }
=======
          if (myLeading.finish()) { status = 0 ; true } else { status = 1 ; myLeading = null.asInstanceOf[Leading]; hasNext }
>>>>>>> NEW
      }
      def next() = {
        if (hasNext) {
          if (status == 0) {
            status = 1
            val res = myLeading.trailer
<<<<<<< OLD
            myLeading = null
=======
            myLeading = null.asInstanceOf[Leading]
>>>>>>> NEW
            res
          } else {
            status = 1
    */
  def duplicate: (Iterator[A]^{this}, Iterator[A]^{this}) = {
    val gap = new scala.collection.mutable.Queue[A]
<<<<<<< OLD
    var ahead: Iterator[A]^ = null
=======
    var ahead: (Iterator[A]^) | Null = null
>>>>>>> NEW
    class Partner extends AbstractIterator[A] {
      override def knownSize: Int = self.synchronized {
        val thisSize = self.knownSize
  /** Creates an iterator to which other iterators can be appended efficiently.
   *  Nested ConcatIterators are merged to avoid blowing the stack.
   */
<<<<<<< OLD
  private final class ConcatIterator[+A](val from: Iterator[A @uncheckedVariance]^) extends AbstractIterator[A] {
    private var current: Iterator[A]^{from} = from
    private var tail: ConcatIteratorCell[A @uncheckedVariance] = null
    private var last: ConcatIteratorCell[A @uncheckedVariance] = null
=======
  private final class ConcatIterator[+A](val from: (Iterator[A @uncheckedVariance]^) | Null) extends AbstractIterator[A] {
    @annotation.stableNull
    private var current: Iterator[A]^{from} | Null = from
    @annotation.stableNull
    private var tail: ConcatIteratorCell[A @uncheckedVariance] | Null = null
    @annotation.stableNull
    private var last: ConcatIteratorCell[A @uncheckedVariance] | Null = null
>>>>>>> NEW
    private var currentHasNextChecked = false

    def hasNext =
            currentHasNextChecked = c.currentHasNextChecked
            if (c.tail != null) {
              if (last == null) last = c.last
<<<<<<< OLD
              c.last.tail = tail
=======
              c.last.nn.tail = tail
>>>>>>> NEW
              tail = c.tail
            }
            merge()
          }
          else {
            current = tail.headIterator
<<<<<<< OLD
            if (last eq tail) last = last.tail
=======
            if (last eq tail) last = last.nn.tail
>>>>>>> NEW
            tail = tail.tail
            merge()
            if (currentHasNextChecked) true
    def next()  =
      if (hasNext) {
        currentHasNextChecked = false
<<<<<<< OLD
        current.next()
=======
        current.nn.next()
>>>>>>> NEW
      } else Iterator.empty.next()

    override def concat[B >: A](that: => IterableOnce[B]^): Iterator[B]^{this, that} = {
        last = c
      }
      else {
<<<<<<< OLD
        last.tail = c
=======
        last.nn.tail = c
>>>>>>> NEW
        last = c
      }
      if (current == null) current = Iterator.empty
    }
  }

<<<<<<< OLD
  private[this] final class ConcatIteratorCell[A](head: => IterableOnce[A]^, var tail: ConcatIteratorCell[A]^) {
=======
  private[this] final class ConcatIteratorCell[A](head: => IterableOnce[A]^, var tail: (ConcatIteratorCell[A]^) | Null) {
>>>>>>> NEW
    def headIterator: Iterator[A]^{this} = head.iterator
  }

    */
  private final class UnfoldIterator[A, S](init: S)(f: S => Option[(A, S)]) extends AbstractIterator[A] {
    private[this] var state: S = init
<<<<<<< OLD
    private[this] var nextResult: Option[(A, S)] = null
=======
    private[this] var nextResult: Option[(A, S)] | Null = null
>>>>>>> NEW

    override def hasNext: Boolean = {
      if (nextResult eq null) {
        }
        state = null.asInstanceOf[S] // allow GC
      }
<<<<<<< OLD
      nextResult.isDefined
=======
      nextResult.nn.isDefined
>>>>>>> NEW
    }

    override def next(): A = {
      if (hasNext) {
<<<<<<< OLD
        val (value, newState) = nextResult.get
=======
        val (value, newState) = nextResult.nn.get
>>>>>>> NEW
        state = newState
        nextResult = null
        value