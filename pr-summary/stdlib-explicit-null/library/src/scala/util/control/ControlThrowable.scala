 *  Instances of `ControlThrowable` should not normally have a cause.
 *  Legacy subclasses may set a cause using `initCause`.
 */
<<<<<<< OLD
abstract class ControlThrowable(message: String) extends Throwable(
=======
abstract class ControlThrowable(message: String | Null) extends Throwable(
>>>>>>> NEW
  message, /*cause*/ null, /*enableSuppression=*/ false, /*writableStackTrace*/ false) {

  def this() = this(message = null)