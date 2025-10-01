
/** Defines converter methods from Scala to Java collections.
  * These methods are available through the [[scala.jdk.javaapi.CollectionConverters]] object.
<<<<<<< ADDED
  *
  * Note: Both the parameter and the return type are non-nullable. However, if a null
  * reference is passed explicitly, this method will still return null. We intentionally
  * keep this signature to discourage passing nulls implicitly while preserving the
  * previous behavior for backward compatibility.
>>>>>>> ADDED
  */
trait AsJavaConverters {
  import JavaCollectionWrappers._
   * @param i The Scala `Iterator` to be converted.
   * @return  A Java `Iterator` view of the argument.
   */
<<<<<<< OLD
  def asJava[A](i: Iterator[A]): ju.Iterator[A] = i match {
    case null                             => null
=======
  def asJava[A](i: Iterator[A]): ju.Iterator[A] = (i: Iterator[A] | Null) match {
    case null                             => null.asInstanceOf[ju.Iterator[A]]
>>>>>>> NEW
    case wrapper: JIteratorWrapper[A @uc] => wrapper.underlying
    case _                                => new IteratorWrapper(i)
  }
   * @param i The Scala `Iterator` to be converted.
   * @return  A Java `Enumeration` view of the argument.
   */
<<<<<<< OLD
  def asJavaEnumeration[A](i: Iterator[A]): ju.Enumeration[A] = i match {
    case null                                => null
=======
  def asJavaEnumeration[A](i: Iterator[A]): ju.Enumeration[A] = (i: Iterator[A] | Null) match {
    case null                                => null.asInstanceOf[ju.Enumeration[A]]
>>>>>>> NEW
    case wrapper: JEnumerationWrapper[A @uc] => wrapper.underlying
    case _                                   => new IteratorWrapper(i)
  }
   * @param i The Scala `Iterable` to be converted.
   * @return  A Java `Iterable` view of the argument.
   */
<<<<<<< OLD
  def asJava[A](i: Iterable[A]): jl.Iterable[A] = i match {
    case null                             => null
=======
  def asJava[A](i: Iterable[A]): jl.Iterable[A] = (i: Iterable[A] | Null) match {
    case null                             => null.asInstanceOf[jl.Iterable[A]]
>>>>>>> NEW
    case wrapper: JIterableWrapper[A @uc] => wrapper.underlying
    case _                                => new IterableWrapper(i)
  }
   * @param i The Scala `Iterable` to be converted.
   * @return  A Java `Collection` view of the argument.
   */
<<<<<<< OLD
  def asJavaCollection[A](i: Iterable[A]): ju.Collection[A] = i match {
    case null                               => null
=======
  def asJavaCollection[A](i: Iterable[A]): ju.Collection[A] = (i: Iterable[A] | Null) match {
    case null                               => null.asInstanceOf[ju.Collection[A]]
>>>>>>> NEW
    case wrapper: JCollectionWrapper[A @uc] => wrapper.underlying
    case _                                  => new IterableWrapper(i)
  }
   * @param b The Scala `Buffer` to be converted.
   * @return A Java `List` view of the argument.
   */
<<<<<<< OLD
  def asJava[A](b: mutable.Buffer[A]): ju.List[A] = b match {
    case null                         => null
=======
  def asJava[A](b: mutable.Buffer[A]): ju.List[A] = (b: mutable.Buffer[A] | Null) match {
    case null                         => null.asInstanceOf[ju.List[A]]
>>>>>>> NEW
    case wrapper: JListWrapper[A @uc] => wrapper.underlying
    case _                            => new MutableBufferWrapper(b)
  }
   * @param s The Scala `Seq` to be converted.
   * @return  A Java `List` view of the argument.
   */
<<<<<<< OLD
  def asJava[A](s: mutable.Seq[A]): ju.List[A] = s match {
    case null                         => null
=======
  def asJava[A](s: mutable.Seq[A]): ju.List[A] = (s: mutable.Seq[A] | Null) match {
    case null                         => null.asInstanceOf[ju.List[A]]
>>>>>>> NEW
    case wrapper: JListWrapper[A @uc] => wrapper.underlying
    case _                            => new MutableSeqWrapper(s)
  }
   * @param s The Scala `Seq` to be converted.
   * @return  A Java `List` view of the argument.
   */
<<<<<<< OLD
  def asJava[A](s: Seq[A]): ju.List[A] = s match {
    case null                         => null
=======
  def asJava[A](s: Seq[A]): ju.List[A] = (s: Seq[A] | Null) match {
    case null                         => null.asInstanceOf[ju.List[A]]
>>>>>>> NEW
    case wrapper: JListWrapper[A @uc] => wrapper.underlying
    case _                            => new SeqWrapper(s)
  }
   * @param s The Scala mutable `Set` to be converted.
   * @return  A Java `Set` view of the argument.
   */
<<<<<<< OLD
  def asJava[A](s: mutable.Set[A]): ju.Set[A] = s match {
    case null                        => null
=======
  def asJava[A](s: mutable.Set[A]): ju.Set[A] = (s: mutable.Set[A] | Null) match {
    case null                        => null.asInstanceOf[ju.Set[A]]
>>>>>>> NEW
    case wrapper: JSetWrapper[A @uc] => wrapper.underlying
    case _                           => new MutableSetWrapper(s)
  }
   * @param s The Scala `Set` to be converted.
   * @return  A Java `Set` view of the argument.
   */
<<<<<<< OLD
  def asJava[A](s: Set[A]): ju.Set[A] = s match {
    case null                        => null
=======
  def asJava[A](s: Set[A]): ju.Set[A] = (s: Set[A] | Null) match {
    case null                        => null.asInstanceOf[ju.Set[A]]
>>>>>>> NEW
    case wrapper: JSetWrapper[A @uc] => wrapper.underlying
    case _                           => new SetWrapper(s)
  }
   * @param m The Scala mutable `Map` to be converted.
   * @return  A Java `Map` view of the argument.
   */
<<<<<<< OLD
  def asJava[K, V](m: mutable.Map[K, V]): ju.Map[K, V] = m match {
    case null                               => null
=======
  def asJava[K, V](m: mutable.Map[K, V]): ju.Map[K, V] = (m: mutable.Map[K, V] | Null) match {
    case null                               => null.asInstanceOf[ju.Map[K, V]]
>>>>>>> NEW
    case wrapper: JMapWrapper[K @uc, V @uc] => wrapper.underlying
    case _                                  => new MutableMapWrapper(m)
  }
   * @param m The Scala `Map` to be converted.
   * @return  A Java `Dictionary` view of the argument.
   */
<<<<<<< OLD
  def asJavaDictionary[K, V](m: mutable.Map[K, V]): ju.Dictionary[K, V] = m match {
    case null                                      => null
=======
  def asJavaDictionary[K, V](m: mutable.Map[K, V]): ju.Dictionary[K, V] = (m: mutable.Map[K, V] | Null) match {
    case null                                      => null.asInstanceOf[ju.Dictionary[K, V]]
>>>>>>> NEW
    case wrapper: JDictionaryWrapper[K @uc, V @uc] => wrapper.underlying
    case _                                         => new DictionaryWrapper(m)
  }
   * @param m The Scala `Map` to be converted.
   * @return  A Java `Map` view of the argument.
   */
<<<<<<< OLD
  def asJava[K, V](m: Map[K, V]): ju.Map[K, V] = m match {
    case null                               => null
=======
  def asJava[K, V](m: Map[K, V]): ju.Map[K, V] = (m: Map[K, V] | Null) match {
    case null                               => null.asInstanceOf[ju.Map[K, V]]
>>>>>>> NEW
    case wrapper: JMapWrapper[K @uc, V @uc] => wrapper.underlying
    case _                                  => new MapWrapper(m)
  }
   * @param m The Scala `concurrent.Map` to be converted.
   * @return  A Java `ConcurrentMap` view of the argument.
   */
<<<<<<< OLD
  def asJava[K, V](m: concurrent.Map[K, V]): juc.ConcurrentMap[K, V] = m match {
    case null                                         => null
=======
  def asJava[K, V](m: concurrent.Map[K, V]): juc.ConcurrentMap[K, V] = (m: concurrent.Map[K, V] | Null) match {
    case null                                         => null.asInstanceOf[juc.ConcurrentMap[K, V]]
>>>>>>> NEW
    case wrapper: JConcurrentMapWrapper[K @uc, V @uc] => wrapper.underlying
    case _                                            => new ConcurrentMapWrapper(m)
  }