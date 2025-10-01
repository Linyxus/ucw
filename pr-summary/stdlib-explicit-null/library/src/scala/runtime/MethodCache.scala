   *  `null` is returned. If `null` is returned, find's caller should look-
   *  up the right method using whichever means it prefers, and add it to
   *  the cache for later use. */
<<<<<<< OLD
  def find(forReceiver: JClass[_]): JMethod
=======
  def find(forReceiver: JClass[_]): JMethod | Null
>>>>>>> NEW
  def add(forReceiver: JClass[_], forMethod: JMethod): MethodCache
}

private[scala] final class EmptyMethodCache extends MethodCache {

<<<<<<< OLD
  def find(forReceiver: JClass[_]): JMethod = null
=======
  def find(forReceiver: JClass[_]): JMethod | Null = null
>>>>>>> NEW

  def add(forReceiver: JClass[_], forMethod: JMethod): MethodCache =
    new PolyMethodCache(this, forReceiver, forMethod, 1)
  private[this] val forParameterTypes: Array[JClass[_]]
) extends MethodCache {

<<<<<<< OLD
  def find(forReceiver: JClass[_]): JMethod =
=======
  def find(forReceiver: JClass[_]): JMethod | Null =
>>>>>>> NEW
    forReceiver.getMethod(forName, forParameterTypes:_*)

  def add(forReceiver: JClass[_], forMethod: JMethod): MethodCache = this
  /** To achieve tail recursion this must be a separate method
   *  from `find`, because the type of next is not `PolyMethodCache`.
   */
<<<<<<< OLD
  @tailrec private def findInternal(forReceiver: JClass[_]): JMethod =
=======
  @tailrec private def findInternal(forReceiver: JClass[_]): JMethod | Null =
>>>>>>> NEW
    if (forReceiver eq receiver) method
    else next match {
      case x: PolyMethodCache => x findInternal forReceiver
      case _                  => next find forReceiver
    }

<<<<<<< OLD
  def find(forReceiver: JClass[_]): JMethod = findInternal(forReceiver)
=======
  def find(forReceiver: JClass[_]): JMethod | Null = findInternal(forReceiver)
>>>>>>> NEW

  // TODO: come up with a more realistic number
  final private val MaxComplexity = 160