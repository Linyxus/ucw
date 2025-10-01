  final val BufferSize = 8192

  /** Used to separate lines in the `processFully` function that takes `Appendable`. */
<<<<<<< OLD
  final val Newline    = System.lineSeparator
=======
  final val Newline: String = System.lineSeparator
>>>>>>> NEW

  private[process] final class LazilyListed[T](
    val  process:   T => Unit,