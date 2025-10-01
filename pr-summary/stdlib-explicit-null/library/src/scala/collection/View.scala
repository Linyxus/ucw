  private final class TakeRightIterator[A](private[this] var underlying: Iterator[A]^, maxlen: Int) extends AbstractIterator[A] {
    private[this] var len: Int = -1
    private[this] var pos: Int = 0
<<<<<<< OLD
    private[this] var buf: ArrayBuffer[AnyRef] = _
=======
    @annotation.stableNull
    private[this] var buf: ArrayBuffer[AnyRef] | Null = _
>>>>>>> NEW
    def init(): Unit = if(buf eq null) {
      buf = new ArrayBuffer[AnyRef](maxlen min 256)
      len = 0
        if(pos == maxlen) pos = 0
        len += 1
      }
<<<<<<< OLD
      underlying = null
=======
      underlying = null.asInstanceOf[Iterator[A]] // allow GC of underlying iterator
>>>>>>> NEW
      if(len > maxlen) len = maxlen
      pos = pos - len
      if(pos < 0) pos += maxlen
      init()
      if(len == 0) Iterator.empty.next()
      else {
<<<<<<< OLD
        val x = buf(pos).asInstanceOf[A]
=======
        val x = buf.nn(pos).asInstanceOf[A]
>>>>>>> NEW
        pos += 1
        if(pos == maxlen) pos = 0
        len -= 1
  private final class DropRightIterator[A](private[this] var underlying: Iterator[A]^, maxlen: Int) extends AbstractIterator[A] {
    private[this] var len: Int = -1 // known size or -1 if the end of `underlying` has not been seen yet
    private[this] var pos: Int = 0
<<<<<<< OLD
    private[this] var buf: ArrayBuffer[AnyRef] = _
=======
    @annotation.stableNull
    private[this] var buf: ArrayBuffer[AnyRef] | Null = _
>>>>>>> NEW
    def init(): Unit = if(buf eq null) {
      buf = new ArrayBuffer[AnyRef](maxlen min 256)
      while(pos < maxlen && underlying.hasNext) {
    def next(): A = {
      if(!hasNext) Iterator.empty.next()
      else {
<<<<<<< OLD
        val x = buf(pos).asInstanceOf[A]
=======
        val x = buf.nn(pos).asInstanceOf[A]
>>>>>>> NEW
        if(len == -1) {
<<<<<<< OLD
          buf(pos) = underlying.next().asInstanceOf[AnyRef]
=======
          buf.nn(pos) = underlying.next().asInstanceOf[AnyRef]
>>>>>>> NEW
          if(!underlying.hasNext) len = 0
        } else len -= 1
        pos += 1