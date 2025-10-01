import scala.util.Try

case class BlogConfig(
<<<<<<< OLD
  @BeanProperty input: String,
  @BeanProperty output: String,
=======
  @BeanProperty input: String | Null,
  @BeanProperty output: String | Null,
>>>>>>> NEW
  @BooleanBeanProperty hidden: Boolean
):
  def this() = this(null, null, false)