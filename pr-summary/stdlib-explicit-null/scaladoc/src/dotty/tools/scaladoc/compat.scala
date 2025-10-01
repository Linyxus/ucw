type JHashMap[K, V] = java.util.HashMap[K, V]
type JMapEntry[K, V] = java.util.Map.Entry[K, V]

<<<<<<< OLD
private val emptyListInst = Collections.emptyList
=======
private val emptyListInst: JList[AnyRef] = Collections.emptyList
>>>>>>> NEW
def JNil[A] = emptyListInst.asInstanceOf[JList[A]]

<<<<<<< OLD
private val emptyMapInst = Collections.emptyMap
=======
private val emptyMapInst: JMap[AnyRef, AnyRef] = Collections.emptyMap
>>>>>>> NEW
def emptyJMap[A, B] = emptyMapInst.asInstanceOf[JMap[A, B]]

enum DocLink: