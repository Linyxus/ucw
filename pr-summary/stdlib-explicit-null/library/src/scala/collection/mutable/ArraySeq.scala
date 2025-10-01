  }).asInstanceOf[ArraySeq[T]]

  @SerialVersionUID(3L)
<<<<<<< OLD
  final class ofRef[T <: AnyRef](val array: Array[T]) extends ArraySeq[T] {
=======
  final class ofRef[T <: AnyRef | Null](val array: Array[T]) extends ArraySeq[T] {
>>>>>>> NEW
    def elemTag: ClassTag[T] = ClassTag[T](array.getClass.getComponentType)
    def length: Int = array.length
    def apply(index: Int): T = array(index)