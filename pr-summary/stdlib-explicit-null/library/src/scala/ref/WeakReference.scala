 *  The new functionality is (1) results are Option values, instead of using null.
 *  (2) There is an extractor that maps the weak reference itself into an option.
 */
<<<<<<< OLD
class WeakReference[+T <: AnyRef](value: T, queue: ReferenceQueue[T]) extends ReferenceWrapper[T] {
=======
class WeakReference[+T <: AnyRef](value: T, queue: ReferenceQueue[T] | Null) extends ReferenceWrapper[T] {
>>>>>>> NEW
  def this(value: T) = this(value, null)
  val underlying: java.lang.ref.WeakReference[_ <: T] =
    new WeakReferenceWithWrapper[T](value, queue, this)
  def unapply[T <: AnyRef](wr: WeakReference[T]): Option[T] = Option(wr.underlying.get)
}

<<<<<<< OLD
private class WeakReferenceWithWrapper[T <: AnyRef](value: T, queue: ReferenceQueue[T], val wrapper: WeakReference[T])
=======
private class WeakReferenceWithWrapper[T <: AnyRef](value: T, queue: ReferenceQueue[T] | Null, val wrapper: WeakReference[T])
>>>>>>> NEW
  extends java.lang.ref.WeakReference[T](value, if (queue == null) null else queue.underlying.asInstanceOf[java.lang.ref.ReferenceQueue[T]]) with ReferenceWithWrapper[T]