
/** This is private so it won't appear in the library API, but
  * abstracted to offer some hope of reusability.  */
<<<<<<< OLD
private[scala] abstract class UniquenessCache[K, V >: Null] {
=======
private[scala] abstract class UniquenessCache[K, V] {
>>>>>>> NEW
  import java.lang.ref.WeakReference
  import java.util.WeakHashMap
  import java.util.concurrent.locks.ReentrantReadWriteLock
  protected def keyFromValue(v: V): Option[K]

  def apply(name: K): V = {
<<<<<<< OLD
    def cached(): V = {
=======
    def cached(): V | Null = {
>>>>>>> NEW
      rlock.lock
      try {
        val reference = map get name