  @SerialVersionUID(3L)
  class IteratorWrapper[A](val underlying: Iterator[A]^) extends ju.Iterator[A] with ju.Enumeration[A] with Serializable {
    def hasNext = underlying.hasNext
<<<<<<< OLD
    def next() = underlying.next()
=======
    def next(): A = underlying.next()
>>>>>>> NEW
    def hasMoreElements = underlying.hasNext
<<<<<<< OLD
    def nextElement() = underlying.next()
=======
    def nextElement(): A = underlying.next()
>>>>>>> NEW
    override def remove(): Nothing = throw new UnsupportedOperationException
    override def equals(other: Any): Boolean = other match {
      case that: IteratorWrapper[_] => this.underlying == that.underlying
  @SerialVersionUID(3L)
  class JIteratorWrapper[A](val underlying: ju.Iterator[A]) extends AbstractIterator[A] with Serializable {
    def hasNext = underlying.hasNext
<<<<<<< OLD
    def next() = underlying.next
=======
    def next(): A = underlying.next
>>>>>>> NEW
    override def equals(other: Any): Boolean = other match {
      case that: JIteratorWrapper[_] => this.underlying == that.underlying
      case _ => false
  @SerialVersionUID(3L)
  class JEnumerationWrapper[A](val underlying: ju.Enumeration[A]) extends AbstractIterator[A] with Serializable {
    def hasNext = underlying.hasMoreElements
<<<<<<< OLD
    def next() = underlying.nextElement
=======
    def next(): A = underlying.nextElement
>>>>>>> NEW
    override def equals(other: Any): Boolean = other match {
      case that: JEnumerationWrapper[_] => this.underlying == that.underlying
      case _ => false
    extends AbstractIterable[A]
      with StrictOptimizedIterableOps[A, Iterable, Iterable[A]]
      with Serializable {
<<<<<<< OLD
    def iterator = underlying.iterator.asScala
=======
    def iterator: Iterator[A] = underlying.iterator.asScala
>>>>>>> NEW
    override def size = underlying.size
    override def knownSize: Int = if (underlying.isEmpty) 0 else super.knownSize
    override def isEmpty = underlying.isEmpty

  @SerialVersionUID(3L)
  class SeqWrapper[A](val underlying: Seq[A]) extends ju.AbstractList[A] with IterableWrapperTrait[A] with Serializable {
<<<<<<< OLD
    def get(i: Int) = underlying(i)
=======
    def get(i: Int): A = underlying(i)
>>>>>>> NEW
  }

  @SerialVersionUID(3L)
  class MutableSeqWrapper[A](val underlying: mutable.Seq[A]) extends ju.AbstractList[A] with IterableWrapperTrait[A] with Serializable {
<<<<<<< OLD
    def get(i: Int) = underlying(i)
    override def set(i: Int, elem: A) = {
=======
    def get(i: Int): A = underlying(i)
    override def set(i: Int, elem: A): A = {
>>>>>>> NEW
      val p = underlying(i)
      underlying(i) = elem
      p

  @SerialVersionUID(3L)
  class MutableBufferWrapper[A](val underlying: mutable.Buffer[A]) extends ju.AbstractList[A] with IterableWrapperTrait[A] with Serializable {
<<<<<<< OLD
    def get(i: Int) = underlying(i)
    override def set(i: Int, elem: A) = { val p = underlying(i); underlying(i) = elem; p }
=======
    def get(i: Int): A = underlying(i)
    override def set(i: Int, elem: A): A = { val p = underlying(i); underlying(i) = elem; p }
>>>>>>> NEW
    override def add(elem: A) = { underlying += elem; true }
<<<<<<< OLD
    override def remove(i: Int) = underlying remove i
=======
    override def remove(i: Int): A = underlying remove i
>>>>>>> NEW
  }

  @SerialVersionUID(3L)
    override def knownSize: Int = if (underlying.isEmpty) 0 else super.knownSize
    override def isEmpty = underlying.isEmpty
    override def iterator: Iterator[A] = underlying.iterator.asScala
<<<<<<< OLD
    def apply(i: Int) = underlying.get(i)
=======
    def apply(i: Int): A = underlying.get(i)
>>>>>>> NEW
    def update(i: Int, elem: A) = underlying.set(i, elem)
    def prepend(elem: A) = { underlying.subList(0, 0) add elem; this }
    def addOne(elem: A): this.type = { underlying add elem; this }
      val ui = underlying.iterator
      var prev: Option[A] = None
      def hasNext = ui.hasNext
<<<<<<< OLD
      def next = { val e = ui.next(); prev = Some(e); e }
=======
      def next: A = { val e = ui.next(); prev = Some(e); e }
>>>>>>> NEW
      override def remove() = prev match {
        case Some(e) =>
          underlying match {

  @SerialVersionUID(3L)
  class MutableMapWrapper[K, V](val underlying: mutable.Map[K, V]) extends MapWrapper[K, V](underlying) {
<<<<<<< OLD
    override def put(k: K, v: V) = underlying.put(k, v) match {
=======
    override def put(k: K, v: V): V = underlying.put(k, v) match {
>>>>>>> NEW
      case Some(v1) => v1
      case None => null.asInstanceOf[V]
    }

    def underlyingConcurrentMap: concurrent.Map[K, V] = underlying

<<<<<<< OLD
    override def putIfAbsent(k: K, v: V) = underlying.putIfAbsent(k, v).getOrElse(null.asInstanceOf[V])
=======
    override def putIfAbsent(k: K, v: V): V = underlying.putIfAbsent(k, v).getOrElse(null.asInstanceOf[V])
>>>>>>> NEW

    override def remove(k: AnyRef, v: AnyRef) =
      try underlying.remove(k.asInstanceOf[K], v.asInstanceOf[V])
    def isEmpty: Boolean = underlying.isEmpty
    def keys: ju.Enumeration[K] = underlying.keysIterator.asJavaEnumeration
    def elements: ju.Enumeration[V] = underlying.valuesIterator.asJavaEnumeration
<<<<<<< OLD
    def get(key: AnyRef) = try {
=======
    def get(key: AnyRef): V = try {
>>>>>>> NEW
      underlying get key.asInstanceOf[K] match {
        case None => null.asInstanceOf[V]
        case Some(v) => v
      case Some(v) => v
      case None => null.asInstanceOf[V]
    }
<<<<<<< OLD
    override def remove(key: AnyRef) = try {
=======
    override def remove(key: AnyRef): V = try {
>>>>>>> NEW
      underlying remove key.asInstanceOf[K] match {
        case None => null.asInstanceOf[V]
        case Some(v) => v

    override def empty: JPropertiesWrapper = new JPropertiesWrapper(new ju.Properties)

<<<<<<< OLD
    def getProperty(key: String) = underlying.getProperty(key)
=======
    def getProperty(key: String): String | Null = underlying.getProperty(key)
>>>>>>> NEW

<<<<<<< OLD
    def getProperty(key: String, defaultValue: String) =
      underlying.getProperty(key, defaultValue)
=======
    def getProperty(key: String, defaultValue: String): String = underlying.getProperty(key, defaultValue)
>>>>>>> NEW

<<<<<<< OLD
    def setProperty(key: String, value: String) =
=======
    def setProperty(key: String, value: String): AnyRef | Null =
>>>>>>> NEW
      underlying.setProperty(key, value)

    override def mapFactory: mutable.HashMap.type = mutable.HashMap