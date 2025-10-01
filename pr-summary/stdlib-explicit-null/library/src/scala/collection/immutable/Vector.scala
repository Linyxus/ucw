  /** Number of slices */
  protected[immutable] def vectorSliceCount: Int
  /** Slice at index */
<<<<<<< OLD
  protected[immutable] def vectorSlice(idx: Int): Array[_ <: AnyRef]
=======
  protected[immutable] def vectorSlice(idx: Int): Array[_ <: AnyRef | Null]
>>>>>>> NEW
  /** Length of all slices up to and including index */
  protected[immutable] def vectorSlicePrefixLength(idx: Int): Int

  protected[this] def slice0(lo: Int, hi: Int): Vector[Nothing] = this

  protected[immutable] def vectorSliceCount: Int = 0
<<<<<<< OLD
  protected[immutable] def vectorSlice(idx: Int): Array[_ <: AnyRef] = null
=======
  protected[immutable] def vectorSlice(idx: Int): Array[_ <: AnyRef | Null] = null.asInstanceOf[Array[_ <: AnyRef | Null]]
>>>>>>> NEW
  protected[immutable] def vectorSlicePrefixLength(idx: Int): Int = 0

  override def equals(o: Any): Boolean = {
    else new Vector1(copyInit(prefix1))

  protected[immutable] def vectorSliceCount: Int = 1
<<<<<<< OLD
  protected[immutable] def vectorSlice(idx: Int): Array[_ <: AnyRef] = prefix1
=======
  protected[immutable] def vectorSlice(idx: Int): Array[_ <: AnyRef | Null] = prefix1
>>>>>>> NEW
  protected[immutable] def vectorSlicePrefixLength(idx: Int): Int = prefix1.length

  override protected[this] def prependedAll0[B >: A](prefix: collection.IterableOnce[B]^, k: Int): Vector[B] =
    else slice0(0, length0-1)

  protected[immutable] def vectorSliceCount: Int = 3
<<<<<<< OLD
  protected[immutable] def vectorSlice(idx: Int): Array[_ <: AnyRef] = (idx: @switch) match {
=======
  protected[immutable] def vectorSlice(idx: Int): Array[_ <: AnyRef | Null] = (idx: @switch) match {
>>>>>>> NEW
    case 0 => prefix1
    case 1 => data2
    case 2 => suffix1
    else slice0(0, length0-1)

  protected[immutable] def vectorSliceCount: Int = 5
<<<<<<< OLD
  protected[immutable] def vectorSlice(idx: Int): Array[_ <: AnyRef] = (idx: @switch) match {
=======
  protected[immutable] def vectorSlice(idx: Int): Array[_ <: AnyRef | Null] = (idx: @switch) match {
>>>>>>> NEW
    case 0 => prefix1
    case 1 => prefix2
    case 2 => data3
    else slice0(0, length0-1)

  protected[immutable] def vectorSliceCount: Int = 7
<<<<<<< OLD
  protected[immutable] def vectorSlice(idx: Int): Array[_ <: AnyRef] = (idx: @switch) match {
=======
  protected[immutable] def vectorSlice(idx: Int): Array[_ <: AnyRef | Null] = (idx: @switch) match {
>>>>>>> NEW
    case 0 => prefix1
    case 1 => prefix2
    case 2 => prefix3
    else slice0(0, length0-1)

  protected[immutable] def vectorSliceCount: Int = 9
<<<<<<< OLD
  protected[immutable] def vectorSlice(idx: Int): Array[_ <: AnyRef] = (idx: @switch) match {
=======
  protected[immutable] def vectorSlice(idx: Int): Array[_ <: AnyRef | Null] = (idx: @switch) match {
>>>>>>> NEW
    case 0 => prefix1
    case 1 => prefix2
    case 2 => prefix3
    else slice0(0, length0-1)

  protected[immutable] def vectorSliceCount: Int = 11
<<<<<<< OLD
  protected[immutable] def vectorSlice(idx: Int): Array[_ <: AnyRef] = (idx: @switch) match {
=======
  protected[immutable] def vectorSlice(idx: Int): Array[_ <: AnyRef | Null] = (idx: @switch) match {
>>>>>>> NEW
    case 0 => prefix1
    case 1 => prefix2
    case 2 => prefix3
private final class VectorSliceBuilder(lo: Int, hi: Int) {
  //println(s"***** VectorSliceBuilder($lo, $hi)")

<<<<<<< OLD
  private[this] val slices = new Array[Array[AnyRef]](11)
=======
  private[this] val slices = new Array[Array[AnyRef] | Null](11)
>>>>>>> NEW
  private[this] var len, pos, maxDim = 0

  @inline private[this] def prefixIdx(n: Int) = n-1
          // A single highest-dimensional slice could have length WIDTH-1 if it came from a prefix or suffix but we
          // only allow WIDTH-2 for the main data, so increase the dimension in this case
          val one = if(pre ne null) pre else suf
<<<<<<< OLD
          if(one.length > WIDTH-2) resultDim += 1
=======
          if(one.nn.length > WIDTH-2) resultDim += 1
>>>>>>> NEW
        }
      }
<<<<<<< OLD
      val prefix1 = slices(prefixIdx(1))
      val suffix1 = slices(suffixIdx(1))
=======
      val prefix1 = slices(prefixIdx(1)).nn
      val suffix1 = slices(suffixIdx(1)).nn
>>>>>>> NEW
      val len1 = prefix1.length
      val res = (resultDim: @switch) match {
        case 2 =>
  override def toString: String =
    s"VectorSliceBuilder(lo=$lo, hi=$hi, len=$len, pos=$pos, maxDim=$maxDim)"

<<<<<<< OLD
  private[immutable] def getSlices: Array[Array[AnyRef]] = slices
=======
  private[immutable] def getSlices: Array[Array[AnyRef] | Null] = slices
>>>>>>> NEW
}


  @inline def nonEmpty: Boolean = knownSize != 0

  def clear(): Unit = {
<<<<<<< OLD
    a6 = null
    a5 = null
    a4 = null
    a3 = null
    a2 = null
=======
    a6 = null.asInstanceOf[Arr6]
    a5 = null.asInstanceOf[Arr5]
    a4 = null.asInstanceOf[Arr4]
    a3 = null.asInstanceOf[Arr3]
    a2 = null.asInstanceOf[Arr2]
>>>>>>> NEW
    a1 = new Arr1(WIDTH)
    len1 = 0
    lenRest = 0
      lenRest -= offset - newOffset
      offset = newOffset
    }
<<<<<<< OLD
    var a: Array[AnyRef] = null // the array we modify
    var aParent: Array[AnyRef] = null // a's parent, so aParent(0) == a
=======
    var a: Array[AnyRef] = null.asInstanceOf[Array[AnyRef]] // the array we modify
    var aParent: Array[AnyRef] = null.asInstanceOf[Array[AnyRef]] // a's parent, so aParent(0) == a
>>>>>>> NEW
    if (depth >= 6) {
      a = a6.asInstanceOf[Array[AnyRef]]
      val i = offset >>> BITS5
  final val empty5: Arr5 = new Array(0)
  final val empty6: Arr6 = new Array(0)

<<<<<<< OLD
  final def foreachRec[T <: AnyRef, A, U](level: Int, a: Array[T], f: A => U): Unit = {
=======
  final def foreachRec[T <: AnyRef | Null, A, U](level: Int, a: Array[T], f: A => U): Unit = {
>>>>>>> NEW
    var i = 0
    val len = a.length
    if(level == 0) {
    } else {
      val l = level-1
      while(i < len) {
<<<<<<< OLD
        foreachRec(l, a(i).asInstanceOf[Array[AnyRef]], f)
=======
        foreachRec(l, a(i).asInstanceOf[Array[AnyRef | Null]], f)
>>>>>>> NEW
        i += 1
      }
    }
    ac.asInstanceOf[Array[T]]
  }

<<<<<<< OLD
  final def prepend1IfSpace(prefix1: Arr1, xs: IterableOnce[_]^): Arr1 = xs match {
=======
  final def prepend1IfSpace(prefix1: Arr1, xs: IterableOnce[_]^): Arr1 | Null = xs match {
>>>>>>> NEW
    case it: Iterable[_] =>
      if(it.sizeCompare(WIDTH-prefix1.length) <= 0) {
        it.size match {
      } else null
  }

<<<<<<< OLD
  final def append1IfSpace(suffix1: Arr1, xs: IterableOnce[_]^): Arr1 = xs match {
=======
  final def append1IfSpace(suffix1: Arr1, xs: IterableOnce[_]^): Arr1 | Null = xs match {
>>>>>>> NEW
    case it: Iterable[_] =>
      if(it.sizeCompare(WIDTH-suffix1.length) <= 0) {
        it.size match {
  private[this] def advanceSlice(): Unit = {
    if(!hasNext) Iterator.empty.next()
    sliceIdx += 1
<<<<<<< OLD
    var slice: Array[_ <: AnyRef] = v.vectorSlice(sliceIdx)
=======
    var slice: Array[_ <: AnyRef | Null] = v.vectorSlice(sliceIdx)
>>>>>>> NEW
    while(slice.length == 0) {
      sliceIdx += 1
      slice = v.vectorSlice(sliceIdx)
}


<<<<<<< OLD
private abstract class VectorStepperBase[A, Sub >: Null <: Stepper[A], Semi <: Sub](it: NewVectorIterator[A])
=======
private abstract class VectorStepperBase[A, Sub <: Stepper[A], Semi <: Sub](it: NewVectorIterator[A])
>>>>>>> NEW
  extends Stepper[A] with EfficientSplit {

  protected[this] def build(it: NewVectorIterator[A]): Semi

  final def estimateSize: Long = it.knownSize

<<<<<<< OLD
  def trySplit(): Sub = {
=======
  def trySplit(): Sub | Null = {
>>>>>>> NEW
    val len = it.knownSize
    if(len > 1) build(it.split(len >>> 1))
    else null