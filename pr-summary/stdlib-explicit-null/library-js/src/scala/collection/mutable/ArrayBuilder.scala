  extends ReusableBuilder[T, Array[T]]
    with Serializable {
  protected[this] var capacity: Int = 0
<<<<<<< OLD
  protected[this] def elems: Array[T]
=======
  protected[this] def elems: Array[T] | Null // may not be allocated at size = capacity = 0
>>>>>>> NEW
  protected var size: Int = 0

  def length: Int = size
  /** Add a slice of an array */
  def addAll(xs: Array[_ <: T], offset: Int, length: Int): this.type = {
    ensureSize(this.size + length)
<<<<<<< OLD
    Array.copy(xs, offset, elems, this.size, length)
=======
    Array.copy(xs, offset, elems.nn, this.size, length)
>>>>>>> NEW
    size += length
    this
  }
    if(k > 0) {
      ensureSize(this.size + k)
      xs match {
<<<<<<< OLD
        case xs: Iterable[T] => xs.copyToArray(elems, this.size)
        case _ => xs.iterator.copyToArray(elems, this.size)
=======
        case xs: Iterable[T] => xs.copyToArray(elems.nn, this.size)
        case _ => xs.iterator.copyToArray(elems.nn, this.size)
>>>>>>> NEW
      }
      size += k
    } else if(k < 0) super.addAll(xs)
   *  @tparam T     type of elements for the array builder, subtype of `AnyRef` with a `ClassTag` context bound.
   */
  @SerialVersionUID(3L)
<<<<<<< OLD
  final class ofRef[T <: AnyRef](implicit ct: ClassTag[T]) extends ArrayBuilder[T] {
=======
  final class ofRef[T <: AnyRef | Null](implicit ct: ClassTag[T]) extends ArrayBuilder[T] {
>>>>>>> NEW

<<<<<<< OLD
    protected var elems: Array[T] = _
=======
    protected var elems: Array[T] | Null = null
>>>>>>> NEW

    private def mkArray(size: Int): Array[T] = {
<<<<<<< OLD
      if (capacity == size && capacity > 0) elems
=======
      if (capacity == size && capacity > 0) elems.nn
>>>>>>> NEW
      else if (elems eq null) new Array[T](size)
      else java.util.Arrays.copyOf[T](elems, size)
    }

    def addOne(elem: T): this.type = {
      ensureSize(size + 1)
<<<<<<< OLD
      elems(size) = elem
=======
      elems.nn(size) = elem
>>>>>>> NEW
      size += 1
      this
    }
    def result() = {
      if (capacity != 0 && capacity == size) {
        capacity = 0
<<<<<<< OLD
        val res = elems
=======
        val res = elems.nn
>>>>>>> NEW
        elems = null
        res
      }
  @SerialVersionUID(3L)
  final class ofByte extends ArrayBuilder[Byte] {

<<<<<<< OLD
    protected var elems: Array[Byte] = _
=======
    protected var elems: Array[Byte] | Null = null
>>>>>>> NEW

    private def mkArray(size: Int): Array[Byte] = {
      val newelems = new Array[Byte](size)
<<<<<<< OLD
      if (this.size > 0) Array.copy(elems, 0, newelems, 0, this.size)
=======
      if (this.size > 0) Array.copy(elems.nn, 0, newelems, 0, this.size)
>>>>>>> NEW
      newelems
    }


    def addOne(elem: Byte): this.type = {
      ensureSize(size + 1)
<<<<<<< OLD
      elems(size) = elem
=======
      elems.nn(size) = elem
>>>>>>> NEW
      size += 1
      this
    }
    def result() = {
      if (capacity != 0 && capacity == size) {
        capacity = 0
<<<<<<< OLD
        val res = elems
=======
        val res = elems.nn
>>>>>>> NEW
        elems = null
        res
      }
  @SerialVersionUID(3L)
  final class ofShort extends ArrayBuilder[Short] {

<<<<<<< OLD
    protected var elems: Array[Short] = _
=======
    protected var elems: Array[Short] | Null = null
>>>>>>> NEW

    private def mkArray(size: Int): Array[Short] = {
      val newelems = new Array[Short](size)
<<<<<<< OLD
      if (this.size > 0) Array.copy(elems, 0, newelems, 0, this.size)
=======
      if (this.size > 0) Array.copy(elems.nn, 0, newelems, 0, this.size)
>>>>>>> NEW
      newelems
    }


    def addOne(elem: Short): this.type = {
      ensureSize(size + 1)
<<<<<<< OLD
      elems(size) = elem
=======
      elems.nn(size) = elem
>>>>>>> NEW
      size += 1
      this
    }
    def result() = {
      if (capacity != 0 && capacity == size) {
        capacity = 0
<<<<<<< OLD
        val res = elems
=======
        val res = elems.nn
>>>>>>> NEW
        elems = null
        res
      }
  @SerialVersionUID(3L)
  final class ofChar extends ArrayBuilder[Char] {

<<<<<<< OLD
    protected var elems: Array[Char] = _
=======
    protected var elems: Array[Char] | Null = null
>>>>>>> NEW

    private def mkArray(size: Int): Array[Char] = {
      val newelems = new Array[Char](size)
<<<<<<< OLD
      if (this.size > 0) Array.copy(elems, 0, newelems, 0, this.size)
=======
      if (this.size > 0) Array.copy(elems.nn, 0, newelems, 0, this.size)
>>>>>>> NEW
      newelems
    }


    def addOne(elem: Char): this.type = {
      ensureSize(size + 1)
<<<<<<< OLD
      elems(size) = elem
=======
      elems.nn(size) = elem
>>>>>>> NEW
      size += 1
      this
    }
    def result() = {
      if (capacity != 0 && capacity == size) {
        capacity = 0
<<<<<<< OLD
        val res = elems
=======
        val res = elems.nn
>>>>>>> NEW
        elems = null
        res
      }
  @SerialVersionUID(3L)
  final class ofInt extends ArrayBuilder[Int] {

<<<<<<< OLD
    protected var elems: Array[Int] = _
=======
    protected var elems: Array[Int] | Null = null
>>>>>>> NEW

    private def mkArray(size: Int): Array[Int] = {
      val newelems = new Array[Int](size)
<<<<<<< OLD
      if (this.size > 0) Array.copy(elems, 0, newelems, 0, this.size)
=======
      if (this.size > 0) Array.copy(elems.nn, 0, newelems, 0, this.size)
>>>>>>> NEW
      newelems
    }


    def addOne(elem: Int): this.type = {
      ensureSize(size + 1)
<<<<<<< OLD
      elems(size) = elem
=======
      elems.nn(size) = elem
>>>>>>> NEW
      size += 1
      this
    }
    def result() = {
      if (capacity != 0 && capacity == size) {
        capacity = 0
<<<<<<< OLD
        val res = elems
=======
        val res = elems.nn
>>>>>>> NEW
        elems = null
        res
      }
  @SerialVersionUID(3L)
  final class ofLong extends ArrayBuilder[Long] {

<<<<<<< OLD
    protected var elems: Array[Long] = _
=======
    protected var elems: Array[Long] | Null = null
>>>>>>> NEW

    private def mkArray(size: Int): Array[Long] = {
      val newelems = new Array[Long](size)
<<<<<<< OLD
      if (this.size > 0) Array.copy(elems, 0, newelems, 0, this.size)
=======
      if (this.size > 0) Array.copy(elems.nn, 0, newelems, 0, this.size)
>>>>>>> NEW
      newelems
    }


    def addOne(elem: Long): this.type = {
      ensureSize(size + 1)
<<<<<<< OLD
      elems(size) = elem
=======
      elems.nn(size) = elem
>>>>>>> NEW
      size += 1
      this
    }
    def result() = {
      if (capacity != 0 && capacity == size) {
        capacity = 0
<<<<<<< OLD
        val res = elems
=======
        val res = elems.nn
>>>>>>> NEW
        elems = null
        res
      }
  @SerialVersionUID(3L)
  final class ofFloat extends ArrayBuilder[Float] {

<<<<<<< OLD
    protected var elems: Array[Float] = _
=======
    protected var elems: Array[Float] | Null = null
>>>>>>> NEW

    private def mkArray(size: Int): Array[Float] = {
      val newelems = new Array[Float](size)
<<<<<<< OLD
      if (this.size > 0) Array.copy(elems, 0, newelems, 0, this.size)
=======
      if (this.size > 0) Array.copy(elems.nn, 0, newelems, 0, this.size)
>>>>>>> NEW
      newelems
    }


    def addOne(elem: Float): this.type = {
      ensureSize(size + 1)
<<<<<<< OLD
      elems(size) = elem
=======
      elems.nn(size) = elem
>>>>>>> NEW
      size += 1
      this
    }
    def result() = {
      if (capacity != 0 && capacity == size) {
        capacity = 0
<<<<<<< OLD
        val res = elems
=======
        val res = elems.nn
>>>>>>> NEW
        elems = null
        res
      }
  @SerialVersionUID(3L)
  final class ofDouble extends ArrayBuilder[Double] {

<<<<<<< OLD
    protected var elems: Array[Double] = _
=======
    protected var elems: Array[Double] | Null = null
>>>>>>> NEW

    private def mkArray(size: Int): Array[Double] = {
      val newelems = new Array[Double](size)
<<<<<<< OLD
      if (this.size > 0) Array.copy(elems, 0, newelems, 0, this.size)
=======
      if (this.size > 0) Array.copy(elems.nn, 0, newelems, 0, this.size)
>>>>>>> NEW
      newelems
    }


    def addOne(elem: Double): this.type = {
      ensureSize(size + 1)
<<<<<<< OLD
      elems(size) = elem
=======
      elems.nn(size) = elem
>>>>>>> NEW
      size += 1
      this
    }
    def result() = {
      if (capacity != 0 && capacity == size) {
        capacity = 0
<<<<<<< OLD
        val res = elems
=======
        val res = elems.nn
>>>>>>> NEW
        elems = null
        res
      }
  @SerialVersionUID(3L)
  class ofBoolean extends ArrayBuilder[Boolean] {

<<<<<<< OLD
    protected var elems: Array[Boolean] = _
=======
    protected var elems: Array[Boolean] | Null = null
>>>>>>> NEW

    private def mkArray(size: Int): Array[Boolean] = {
      val newelems = new Array[Boolean](size)
<<<<<<< OLD
      if (this.size > 0) Array.copy(elems, 0, newelems, 0, this.size)
=======
      if (this.size > 0) Array.copy(elems.nn, 0, newelems, 0, this.size)
>>>>>>> NEW
      newelems
    }


    def addOne(elem: Boolean): this.type = {
      ensureSize(size + 1)
<<<<<<< OLD
      elems(size) = elem
=======
      elems.nn(size) = elem
>>>>>>> NEW
      size += 1
      this
    }
    def result() = {
      if (capacity != 0 && capacity == size) {
        capacity = 0
<<<<<<< OLD
        val res = elems
=======
        val res = elems.nn
>>>>>>> NEW
        elems = null
        res
      }
  @SerialVersionUID(3L)
  final class ofUnit extends ArrayBuilder[Unit] {

<<<<<<< OLD
    protected def elems: Array[Unit] = throw new UnsupportedOperationException()
=======
    protected def elems: Array[Unit] | Null = throw new UnsupportedOperationException()
>>>>>>> NEW

    def addOne(elem: Unit): this.type = {
      size += 1