  private[sys]
  class ConstantImpl(val key: String, val value: Boolean) extends BooleanProp {
    val isSet = value
<<<<<<< OLD
    def set(newValue: String) = "" + value
=======
    def set(newValue: String | Null) = "" + value
>>>>>>> NEW
    def setValue[T1 >: Boolean](newValue: T1): Boolean = value
    def get: String = "" + value
    def option = if (isSet) Some(value) else None