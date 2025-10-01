  }

  // Caller is required to pass iN >= i0, else math will fail.  Also, i0 >= 0.
<<<<<<< OLD
  private def mergeSort[@specialized T: ClassTag](a: Array[T], i0: Int, iN: Int, ord: Ordering[T], scratch: Array[T] = null): Unit = {
=======
  private def mergeSort[@specialized T: ClassTag](a: Array[T], i0: Int, iN: Int, ord: Ordering[T], scratch: Array[T] | Null = null): Unit = {
>>>>>>> NEW
    if (iN - i0 < mergeThreshold) insertionSort(a, i0, iN, ord)
    else {
      val iK = (i0 + iN) >>> 1   // Bit shift equivalent to unsigned math, no overflow

  // TODO: add upper bound: T <: AnyRef, propagate to callers below (not binary compatible)
  // Maybe also rename all these methods to `sort`.
<<<<<<< OLD
  @inline private def sort[T](a: Array[T], from: Int, until: Int, ord: Ordering[T]): Unit = (a: @unchecked) match {
=======
  @inline private def sort[T](a: Array[T] | Null, from: Int, until: Int, ord: Ordering[T]): Unit = (a: @unchecked) match {
>>>>>>> NEW
    case _: Array[AnyRef]  =>
      // Note that runtime matches are covariant, so could actually be any Array[T] s.t. T is not primitive (even boxed value classes)
<<<<<<< OLD
      if (a.length > 1 && (ord eq null)) throw new NullPointerException("Ordering")
=======
      if (a.nn.length > 1 && (ord eq null)) throw new NullPointerException("Ordering")
>>>>>>> NEW
      java.util.Arrays.sort(a, from, until, ord)
    case a: Array[Int]     => if (ord eq Ordering.Int) java.util.Arrays.sort(a, from, until) else mergeSort[Int](a, from, until, ord)
    case a: Array[Double]  => mergeSort[Double](a, from, until, ord)  // Because not all NaNs are identical, stability is meaningful!