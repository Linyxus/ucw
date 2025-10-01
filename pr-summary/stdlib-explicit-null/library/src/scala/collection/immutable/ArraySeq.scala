    *
    * @return null if optimisation not possible.
    */
<<<<<<< OLD
  private def appendedAllArraySeq[B >: A](that: ArraySeq[B]): ArraySeq[B] = {
=======
  private def appendedAllArraySeq[B >: A](that: ArraySeq[B]): ArraySeq[B] | Null = {
>>>>>>> NEW
    // Optimise concatenation of two ArraySeqs
    // For ArraySeqs with sizes of [100, 1000, 10000] this is [3.5, 4.1, 5.2]x as fast
    if (isEmpty)
  }).asInstanceOf[ArraySeq[T]]

  @SerialVersionUID(3L)
<<<<<<< OLD
  final class ofRef[T <: AnyRef](val unsafeArray: Array[T]) extends ArraySeq[T] {
=======
  final class ofRef[T <: AnyRef | Null](val unsafeArray: Array[T]) extends ArraySeq[T] {
>>>>>>> NEW
    def elemTag: ClassTag[T] = ClassTag[T](unsafeArray.getClass.getComponentType)
    def length: Int = unsafeArray.length
    @throws[ArrayIndexOutOfBoundsException]