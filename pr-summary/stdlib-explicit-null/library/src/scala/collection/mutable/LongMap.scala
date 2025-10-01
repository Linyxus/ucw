
  private[this] var mask = 0
  private[this] var extraKeys: Int = 0
<<<<<<< OLD
  private[this] var zeroValue: AnyRef = null
  private[this] var minValue: AnyRef = null
=======
  @annotation.stableNull private[this] var zeroValue: AnyRef | Null = null
  @annotation.stableNull private[this] var minValue: AnyRef | Null = null
>>>>>>> NEW
  private[this] var _size = 0
  private[this] var _vacant = 0
<<<<<<< OLD
  private[this] var _keys: Array[Long] = null
  private[this] var _values: Array[AnyRef] = null
=======
  private[this] var _keys: Array[Long] = _
  private[this] var _values: Array[AnyRef | Null] = _
>>>>>>> NEW

  if (initBlank) defaultInitialize(initialBufferSize)

      if (n<0) 0x7
      else (((1 << (32 - java.lang.Integer.numberOfLeadingZeros(n-1))) - 1) & 0x3FFFFFFF) | 0x7
    _keys = new Array[Long](mask+1)
<<<<<<< OLD
    _values = new Array[AnyRef](mask+1)
=======
    _values = new Array[AnyRef | Null](mask+1)
>>>>>>> NEW
  }

  private[collection] def initializeTo(
<<<<<<< OLD
                                        m: Int, ek: Int, zv: AnyRef, mv: AnyRef, sz: Int, vc: Int, kz: Array[Long], vz: Array[AnyRef]
=======
                                        m: Int, ek: Int, zv: AnyRef | Null, mv: AnyRef | Null, sz: Int, vc: Int, kz: Array[Long], vz: Array[AnyRef | Null]
>>>>>>> NEW
                                      ): Unit = {
    mask = m; extraKeys = ek; zeroValue = zv; minValue = mv; _size = sz; _vacant = vc; _keys = kz; _values = vz
  }
    *  may not exist, if the default null/zero is acceptable.  For key/value
    *  pairs that do exist,  `apply` (i.e. `map(key)`) is equally fast.
    */
<<<<<<< OLD
  def getOrNull(key: Long): V = {
=======
  def getOrNull(key: Long): V | Null = {
>>>>>>> NEW
    if (key == -key) {
<<<<<<< OLD
      if ((((key>>>63).toInt+1) & extraKeys) == 0) null.asInstanceOf[V]
=======
      if ((((key>>>63).toInt+1) & extraKeys) == 0) null
>>>>>>> NEW
      else if (key == 0) zeroValue.asInstanceOf[V]
      else minValue.asInstanceOf[V]
    }
    else {
      val i = seekEntry(key)
<<<<<<< OLD
      if (i < 0) null.asInstanceOf[V] else _values(i).asInstanceOf[V]
=======
      if (i < 0) null else _values(i).asInstanceOf[V | Null]
>>>>>>> NEW
    }
  }

    val ov = _values
    mask = newMask
    _keys = new Array[Long](mask+1)
<<<<<<< OLD
    _values = new Array[AnyRef](mask+1)
=======
    _values = new Array[AnyRef | Null](mask+1)
>>>>>>> NEW
    _vacant = 0
    var i = 0
    while (i < ok.length) {
    private[this] val kz = _keys
    private[this] val vz = _values

<<<<<<< OLD
    private[this] var nextPair: (Long, V) =
=======
    private[this] var nextPair: (Long, V) | Null =
>>>>>>> NEW
      if (extraKeys==0) null
      else if ((extraKeys&1)==1) (0L, zeroValue.asInstanceOf[V])
      else (Long.MinValue, minValue.asInstanceOf[V])

<<<<<<< OLD
    private[this] var anotherPair: (Long, V) =
=======
    private[this] var anotherPair: (Long, V) | Null =
>>>>>>> NEW
      if (extraKeys==3) (Long.MinValue, minValue.asInstanceOf[V])
      else null

        anotherPair = null
      }
      else nextPair = null
<<<<<<< OLD
      ans
=======
      ans.nn
>>>>>>> NEW
    }
  }


  @deprecated("Use ++ with an explicit collection argument instead of + with varargs", "2.13.0")
  override def + [V1 >: V](elem1: (Long, V1), elem2: (Long, V1), elems: (Long, V1)*): LongMap[V1]^{} = {
<<<<<<< REMOVED
    // TODO: An empty capture annotation is needed in the result type to satisfy the overriding checker.
>>>>>>> REMOVED
    val m = this + elem1 + elem2
    if(elems.isEmpty) m else m.concat(elems)
  }
    *  collection immediately.
    */
  def mapValuesNow[V1](f: V => V1): LongMap[V1] = {
<<<<<<< OLD
    val zv = if ((extraKeys & 1) == 1) f(zeroValue.asInstanceOf[V]).asInstanceOf[AnyRef] else null
    val mv = if ((extraKeys & 2) == 2) f(minValue.asInstanceOf[V]).asInstanceOf[AnyRef] else null
=======
    val zv = if ((extraKeys & 1) == 1) f(zeroValue.asInstanceOf[V]).asInstanceOf[AnyRef | Null] else null
    val mv = if ((extraKeys & 2) == 2) f(minValue.asInstanceOf[V]).asInstanceOf[AnyRef | Null] else null
>>>>>>> NEW
    val lm = new LongMap[V1](LongMap.exceptionDefault,  1,  initBlank = false)
    val kz = java.util.Arrays.copyOf(_keys, _keys.length)
<<<<<<< OLD
    val vz = new Array[AnyRef](_values.length)
=======
    val vz = new Array[AnyRef | Null](_values.length)
>>>>>>> NEW
    var i,j = 0
    while (i < _keys.length & j < _size) {
      val k = _keys(i)
      if (k != -k) {
        j += 1
<<<<<<< OLD
        vz(i) = f(_values(i).asInstanceOf[V]).asInstanceOf[AnyRef]
=======
        vz(i) = f(_values(i).asInstanceOf[V]).asInstanceOf[AnyRef | Null]
>>>>>>> NEW
      }
      i += 1
    }
    *  Note: the default, if any,  is not transformed.
    */
  def transformValuesInPlace(f: V => V): this.type = {
<<<<<<< OLD
    if ((extraKeys & 1) == 1) zeroValue = f(zeroValue.asInstanceOf[V]).asInstanceOf[AnyRef]
    if ((extraKeys & 2) == 2) minValue = f(minValue.asInstanceOf[V]).asInstanceOf[AnyRef]
=======
    if ((extraKeys & 1) == 1) zeroValue = f(zeroValue.asInstanceOf[V]).asInstanceOf[AnyRef | Null]
    if ((extraKeys & 2) == 2) minValue = f(minValue.asInstanceOf[V]).asInstanceOf[AnyRef | Null]
>>>>>>> NEW
    var i,j = 0
    while (i < _keys.length & j < _size) {
      val k = _keys(i)
      if (k != -k) {
        j += 1
<<<<<<< OLD
        _values(i) = f(_values(i).asInstanceOf[V]).asInstanceOf[AnyRef]
=======
        _values(i) = f(_values(i).asInstanceOf[V]).asInstanceOf[AnyRef | Null]
>>>>>>> NEW
      }
      i += 1
    }