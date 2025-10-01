
/** Defines converter methods from Java to Scala collections.
  * These methods are available through the [[scala.jdk.javaapi.CollectionConverters]] object.
<<<<<<< ADDED
  *
  * Note: Both the parameter and the return type are non-nullable. However, if a null
  * reference is passed explicitly, this method will still return null. We intentionally
  * keep this signature to discourage passing nulls implicitly while preserving the
  * previous behavior for backward compatibility.
>>>>>>> ADDED
  */
trait AsScalaConverters {
  import JavaCollectionWrappers._
   * @param i The Java `Iterator` to be converted.
   * @return  A Scala `Iterator` view of the argument.
   */
<<<<<<< OLD
  def asScala[A](i: ju.Iterator[A]): Iterator[A] = i match {
    case null                            => null
=======
  def asScala[A](i: ju.Iterator[A]): Iterator[A] = (i: ju.Iterator[A] | Null) match {
    case null                            => null.asInstanceOf[Iterator[A]]
>>>>>>> NEW
    case wrapper: IteratorWrapper[A @uc] => wrapper.underlying.unsafeAssumePure // TODO: Remove when pattern matching recognizes this is safe
    case _                               => new JIteratorWrapper(i)
  }
   * @param e The Java `Enumeration` to be converted.
   * @return  A Scala `Iterator` view of the argument.
   */
<<<<<<< OLD
  def asScala[A](e: ju.Enumeration[A]): Iterator[A] = e match {
    case null                            => null
=======
  def asScala[A](e: ju.Enumeration[A]): Iterator[A] = (e: ju.Enumeration[A] | Null) match {
    case null                            => null.asInstanceOf[Iterator[A]]
>>>>>>> NEW
    case wrapper: IteratorWrapper[A @uc] => wrapper.underlying.unsafeAssumePure // TODO: Remove when pattern matching recognizes this is safe
    case _                               => new JEnumerationWrapper(e)
  }
   * @param i The Java `Iterable` to be converted.
   * @return  A Scala `Iterable` view of the argument.
   */
<<<<<<< OLD
  def asScala[A](i: jl.Iterable[A]): Iterable[A] = i match {
    case null                            => null
=======
  def asScala[A](i: jl.Iterable[A]): Iterable[A] = (i: jl.Iterable[A] | Null) match {
    case null                            => null.asInstanceOf[Iterable[A]]
>>>>>>> NEW
    case wrapper: IterableWrapper[A @uc] => wrapper.underlying.unsafeAssumePure // TODO: Remove when pattern matching recognizes this is safe
    case _                               => new JIterableWrapper(i)
  }
   * @param c The Java `Collection` to be converted.
   * @return  A Scala `Iterable` view of the argument.
   */
<<<<<<< OLD
  def asScala[A](c: ju.Collection[A]): Iterable[A] = c match {
    case null                            => null
=======
  def asScala[A](c: ju.Collection[A]): Iterable[A] = (c: ju.Collection[A] | Null) match {
    case null                            => null.asInstanceOf[Iterable[A]]
>>>>>>> NEW
    case wrapper: IterableWrapper[A @uc] => wrapper.underlying.unsafeAssumePure // TODO: Remove when pattern matching recognizes this is safe
    case _                               => new JCollectionWrapper(c)
  }
   * @param l The Java `List` to be converted.
   * @return A Scala mutable `Buffer` view of the argument.
   */
<<<<<<< OLD
  def asScala[A](l: ju.List[A]): mutable.Buffer[A] = l match {
    case null                                 => null
=======
  def asScala[A](l: ju.List[A]): mutable.Buffer[A] = (l: ju.List[A] | Null) match {
    case null                                 => null.asInstanceOf[mutable.Buffer[A]]
>>>>>>> NEW
    case wrapper: MutableBufferWrapper[A @uc] => wrapper.underlying
    case _                                    => new JListWrapper(l)
  }
   * @param s The Java `Set` to be converted.
   * @return  A Scala mutable `Set` view of the argument.
   */
<<<<<<< OLD
  def asScala[A](s: ju.Set[A]): mutable.Set[A] = s match {
    case null                              => null
=======
  def asScala[A](s: ju.Set[A]): mutable.Set[A] = (s: ju.Set[A] | Null) match {
    case null                              => null.asInstanceOf[mutable.Set[A]]
>>>>>>> NEW
    case wrapper: MutableSetWrapper[A @uc] => wrapper.underlying
    case _                                 => new JSetWrapper(s)
  }
   * @param m The Java `Map` to be converted.
   * @return  A Scala mutable `Map` view of the argument.
   */
<<<<<<< OLD
  def asScala[K, V](m: ju.Map[K, V]): mutable.Map[K, V] = m match {
    case null                                     => null
=======
  def asScala[K, V](m: ju.Map[K, V]): mutable.Map[K, V] = (m: ju.Map[K, V] | Null) match {
    case null                                     => null.asInstanceOf[mutable.Map[K, V]]
>>>>>>> NEW
    case wrapper: MutableMapWrapper[K @uc, V @uc] => wrapper.underlying
    case _                                        => new JMapWrapper(m)
  }
   * @param m The Java `ConcurrentMap` to be converted.
   * @return  A Scala mutable `ConcurrentMap` view of the argument.
   */
<<<<<<< OLD
  def asScala[K, V](m: juc.ConcurrentMap[K, V]): concurrent.Map[K, V] = m match {
    case null                                        => null
=======
  def asScala[K, V](m: juc.ConcurrentMap[K, V]): concurrent.Map[K, V] = (m: juc.ConcurrentMap[K, V] | Null) match {
    case null                                        => null.asInstanceOf[concurrent.Map[K, V]]
>>>>>>> NEW
    case wrapper: ConcurrentMapWrapper[K @uc, V @uc] => wrapper.underlyingConcurrentMap
    case _                                           => new JConcurrentMapWrapper(m)
  }
   * @param d The Java `Dictionary` to be converted.
   * @return  A Scala mutable `Map` view of the argument.
   */
<<<<<<< OLD
  def asScala[K, V](d: ju.Dictionary[K, V]): mutable.Map[K, V] = d match {
    case null                                     => null
=======
  def asScala[K, V](d: ju.Dictionary[K, V]): mutable.Map[K, V] = (d: ju.Dictionary[K, V] | Null) match {
    case null                                     => null.asInstanceOf[mutable.Map[K, V]]
>>>>>>> NEW
    case wrapper: DictionaryWrapper[K @uc, V @uc] => wrapper.underlying
    case _                                        => new JDictionaryWrapper(d)
  }
   * @param p The Java `Properties` to be converted.
   * @return  A Scala mutable `Map[String, String]` view of the argument.
   */
<<<<<<< OLD
  def asScala(p: ju.Properties): mutable.Map[String, String] = p match {
    case null => null
=======
  def asScala(p: ju.Properties): mutable.Map[String, String] = (p: ju.Properties | Null) match {
    case null => null.asInstanceOf[mutable.Map[String, String]]
>>>>>>> NEW
    case _    => new JPropertiesWrapper(p)
  }
}