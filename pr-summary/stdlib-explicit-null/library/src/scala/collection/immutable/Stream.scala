  final class Cons[A](override val head: A, tl: => Stream[A]) extends Stream[A] {
    override def isEmpty: Boolean = false
    @volatile private[this] var tlVal: Stream[A] = _
<<<<<<< OLD
    @volatile private[this] var tlGen = () => tl
=======
    @volatile private[this] var tlGen: (() => Stream[A]) | Null = () => tl
>>>>>>> NEW
    protected def tailDefined: Boolean = tlGen eq null
    override def tail: Stream[A] = {
      if (!tailDefined)
        synchronized {
          if (!tailDefined) {
<<<<<<< OLD
            tlVal = tlGen()
=======
            tlVal = tlGen.nn()
>>>>>>> NEW
            tlGen = null
          }
        }
    new WithFilter[A](l, p)

  private[this] final class WithFilter[A](l: Stream[A] @uncheckedVariance, p: A => Boolean) extends collection.WithFilter[A, Stream] {
<<<<<<< OLD
    private[this] var s = l                                                // set to null to allow GC after filtered
    private[this] lazy val filtered: Stream[A] = { val f = s.filter(p); s = null.asInstanceOf[Stream[A]]; f } // don't set to null if throw during filter
=======
    private[this] var s: Stream[A] = l // set to null to allow GC after filtered
    private[this] lazy val filtered: Stream[A] = { val f = s.filter(p); s = nullForGC[Stream[A]]; f } // don't set to null if throw during filter
>>>>>>> NEW
    def map[B](f: A => B): Stream[B] = filtered.map(f)
    def flatMap[B](f: A => IterableOnce[B]): Stream[B] = filtered.flatMap(f)
    def foreach[U](f: A => U): Unit = filtered.foreach(f)