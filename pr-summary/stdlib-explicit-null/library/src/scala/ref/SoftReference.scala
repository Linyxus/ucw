
import scala.language.`2.13`

<<<<<<< OLD
class SoftReference[+T <: AnyRef](value : T, queue : ReferenceQueue[T]) extends ReferenceWrapper[T] {
=======
class SoftReference[+T <: AnyRef](value : T, queue : ReferenceQueue[T] | Null) extends ReferenceWrapper[T] {
>>>>>>> NEW
  def this(value : T) = this(value, null)

  val underlying: java.lang.ref.SoftReference[_ <: T] =
  def unapply[T <: AnyRef](sr: SoftReference[T]): Option[T] = Option(sr.underlying.get)
}

<<<<<<< OLD
private class SoftReferenceWithWrapper[T <: AnyRef](value: T, queue: ReferenceQueue[T], val wrapper: SoftReference[T])
=======
private class SoftReferenceWithWrapper[T <: AnyRef](value: T, queue: ReferenceQueue[T] | Null, val wrapper: SoftReference[T])
>>>>>>> NEW
  extends java.lang.ref.SoftReference[T](value, if (queue == null) null else queue.underlying.asInstanceOf[java.lang.ref.ReferenceQueue[T]]) with ReferenceWithWrapper[T]