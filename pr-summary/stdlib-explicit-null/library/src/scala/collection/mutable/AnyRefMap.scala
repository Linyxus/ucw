  private[this] var mask = 0
  private[this] var _size = 0
  private[this] var _vacant = 0
<<<<<<< OLD
  private[this] var _hashes: Array[Int] = null
  private[this] var _keys: Array[AnyRef] = null
  private[this] var _values: Array[AnyRef] = null
=======
  private[this] var _hashes: Array[Int] = _
  private[this] var _keys: Array[AnyRef | Null] = _
  private[this] var _values: Array[AnyRef | Null] = _
>>>>>>> NEW

  if (initBlank) defaultInitialize(initialBufferSize)

      if (n<0) 0x7
      else (((1 << (32 - java.lang.Integer.numberOfLeadingZeros(n-1))) - 1) & 0x3FFFFFFF) | 0x7
    _hashes = new Array[Int](mask+1)
<<<<<<< OLD
    _keys = new Array[AnyRef](mask+1)
    _values = new Array[AnyRef](mask+1)
=======
    _keys = new Array[AnyRef | Null](mask+1)
    _values = new Array[AnyRef | Null](mask+1)
>>>>>>> NEW
  }

  private[collection] def initializeTo(
<<<<<<< OLD
    m: Int, sz: Int, vc: Int, hz: Array[Int], kz: Array[AnyRef], vz: Array[AnyRef]
=======
    m: Int, sz: Int, vc: Int, hz: Array[Int], kz: Array[AnyRef | Null], vz: Array[AnyRef | Null]
>>>>>>> NEW
  ): Unit = {
    mask = m; _size = sz; _vacant = vc; _hashes = hz; _keys = kz; _values = vz
  }
   *  may not exist, if the default null/zero is acceptable.  For key/value
   *  pairs that do exist, `apply` (i.e. `map(key)`) is equally fast.
   */
<<<<<<< OLD
  def getOrNull(key: K): V = {
=======
  def getOrNull(key: K): V | Null = {
>>>>>>> NEW
    val i = seekEntry(hashOf(key), key)
<<<<<<< OLD
    (if (i < 0) null else _values(i)).asInstanceOf[V]
=======
    if (i < 0) null else _values(i).asInstanceOf[V | Null]
>>>>>>> NEW
  }

  /** Retrieves the value associated with a key.
    val ov = _values
    mask = newMask
    _hashes = new Array[Int](mask+1)
<<<<<<< OLD
    _keys = new Array[AnyRef](mask+1)
    _values = new Array[AnyRef](mask+1)
=======
    _keys = new Array[AnyRef | Null](mask+1)
    _values = new Array[AnyRef | Null](mask+1)
>>>>>>> NEW
    _vacant = 0
    var i = 0
    while (i < oh.length) {

    private[this] var index = 0

<<<<<<< OLD
    def hasNext: Boolean = index<hz.length && {
=======
    def hasNext: Boolean = index < hz.length && {
>>>>>>> NEW
      var h = hz(index)
      while (h+h == 0) {
        index += 1
  override def clone(): AnyRefMap[K, V] = {
    val hz = java.util.Arrays.copyOf(_hashes, _hashes.length)
    val kz = java.util.Arrays.copyOf(_keys, _keys.length)
<<<<<<< OLD
    val vz = java.util.Arrays.copyOf(_values,  _values.length)
=======
    val vz = java.util.Arrays.copyOf(_values, _values.length)
>>>>>>> NEW
    val arm = new AnyRefMap[K, V](defaultEntry, 1, initBlank = false)
<<<<<<< OLD
    arm.initializeTo(mask, _size, _vacant, hz, kz,  vz)
=======
    arm.initializeTo(mask, _size, _vacant, hz, kz, vz)
>>>>>>> NEW
    arm
  }

  override def updated[V1 >: V](key: K, value: V1): AnyRefMap[K, V1] =
    clone().asInstanceOf[AnyRefMap[K, V1]].addOne(key, value)

<<<<<<< OLD
  private[this] def foreachElement[A,B](elems: Array[AnyRef], f: A => B): Unit = {
=======
  private[this] def foreachElement[A,B](elems: Array[AnyRef | Null], f: A => B): Unit = {
>>>>>>> NEW
    var i,j = 0
    while (i < _hashes.length & j < _size) {
      val h = _hashes(i)
   *  collection immediately.
   */
  def mapValuesNow[V1](f: V => V1): AnyRefMap[K, V1] = {
<<<<<<< OLD
    val arm = new AnyRefMap[K,V1](AnyRefMap.exceptionDefault,  1,  initBlank = false)
=======
    val arm = new AnyRefMap[K,V1](AnyRefMap.exceptionDefault, 1, initBlank = false)
>>>>>>> NEW
    val hz = java.util.Arrays.copyOf(_hashes, _hashes.length)
    val kz = java.util.Arrays.copyOf(_keys, _keys.length)
<<<<<<< OLD
    val vz = new Array[AnyRef](_values.length)
=======
    val vz = new Array[AnyRef | Null](_values.length)
>>>>>>> NEW
    var i,j = 0
    while (i < _hashes.length & j < _size) {
      val h = _hashes(i)
  implicit def iterableFactory[K <: AnyRef, V]: Factory[(K, V), AnyRefMap[K, V]] = toFactory[K, V](this)
  implicit def buildFromAnyRefMap[K <: AnyRef, V]: BuildFrom[AnyRefMap[_, _], (K, V), AnyRefMap[K, V]] = toBuildFrom(this)
}
<<<<<<< ADDED

>>>>>>> ADDED