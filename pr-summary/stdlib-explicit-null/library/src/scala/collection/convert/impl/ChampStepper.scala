  * to the end of all trees.
  */
private[collection] abstract class ChampStepperBase[
<<<<<<< OLD
  A, T <: Node[T], Sub >: Null, Semi <: Sub with ChampStepperBase[A, T, _, _]
=======
  A, T <: Node[T], Sub, Semi <: Sub with ChampStepperBase[A, T, _, _]
>>>>>>> NEW
](protected var maxSize: Int)
extends EfficientSplit {
  import Node.MaxDepth
    ans
  }

<<<<<<< OLD
  final def trySplit(): Sub =
=======
  final def trySplit(): Sub | Null =
>>>>>>> NEW
    if (!hasStep) null
    else {
      var fork = 0
}


<<<<<<< OLD
private[collection] final class AnyChampStepper[A, T >: Null <: Node[T]](_maxSize: Int, protected val extract: (T, Int) => A)
=======
private[collection] final class AnyChampStepper[A, T <: Node[T]](_maxSize: Int, protected val extract: (T, Int) => A)
>>>>>>> NEW
extends ChampStepperBase[A, T, AnyStepper[A], AnyChampStepper[A, T]](_maxSize)
with AnyStepper[A] {
  def nextStep(): A =
  def semiclone(): AnyChampStepper[A, T] = new AnyChampStepper[A, T](0, extract)
}
private[collection] object AnyChampStepper {
<<<<<<< OLD
  def from[A, T >: Null <: Node[T]](maxSize: Int, root: T, extract: (T, Int) => A): AnyChampStepper[A, T] = {
=======
  def from[A, T <: Node[T]](maxSize: Int, root: T, extract: (T, Int) => A): AnyChampStepper[A, T] = {
>>>>>>> NEW
    val ans = new AnyChampStepper[A, T](maxSize, extract)
    ans.initRoot(root)
    ans
  }
}

<<<<<<< OLD
private[collection] final class DoubleChampStepper[T >: Null <: Node[T]](_maxSize: Int, protected val extract: (T, Int) => Double)
=======
private[collection] final class DoubleChampStepper[T <: Node[T]](_maxSize: Int, protected val extract: (T, Int) => Double)
>>>>>>> NEW
extends ChampStepperBase[Double, T, DoubleStepper, DoubleChampStepper[T]](_maxSize)
with DoubleStepper {
  def nextStep(): Double =
  def semiclone(): DoubleChampStepper[T] = new DoubleChampStepper[T](0, extract)
}
private[collection] object DoubleChampStepper {
<<<<<<< OLD
  def from[T >: Null <: Node[T]](maxSize: Int, root: T, extract: (T, Int) => Double): DoubleChampStepper[T] = {
=======
  def from[T <: Node[T]](maxSize: Int, root: T, extract: (T, Int) => Double): DoubleChampStepper[T] = {
>>>>>>> NEW
    val ans = new DoubleChampStepper[T](maxSize, extract)
    ans.initRoot(root)
    ans
  }
}

<<<<<<< OLD
private[collection] final class IntChampStepper[T >: Null <: Node[T]](_maxSize: Int, protected val extract: (T, Int) => Int)
=======
private[collection] final class IntChampStepper[T <: Node[T]](_maxSize: Int, protected val extract: (T, Int) => Int)
>>>>>>> NEW
extends ChampStepperBase[Int, T, IntStepper, IntChampStepper[T]](_maxSize)
with IntStepper {
  def nextStep(): Int =
  def semiclone(): IntChampStepper[T] = new IntChampStepper[T](0, extract)
}
private[collection] object IntChampStepper {
<<<<<<< OLD
  def from[T >: Null <: Node[T]](maxSize: Int, root: T, extract: (T, Int) => Int): IntChampStepper[T] = {
=======
  def from[T <: Node[T]](maxSize: Int, root: T, extract: (T, Int) => Int): IntChampStepper[T] = {
>>>>>>> NEW
    val ans = new IntChampStepper[T](maxSize, extract)
    ans.initRoot(root)
    ans
  }
}

<<<<<<< OLD
private[collection] final class LongChampStepper[T >: Null <: Node[T]](_maxSize: Int, protected val extract: (T, Int) => Long)
=======
private[collection] final class LongChampStepper[T <: Node[T]](_maxSize: Int, protected val extract: (T, Int) => Long)
>>>>>>> NEW
extends ChampStepperBase[Long, T, LongStepper, LongChampStepper[T]](_maxSize)
with LongStepper {
  def nextStep(): Long =
  def semiclone(): LongChampStepper[T] = new LongChampStepper[T](0, extract)
}
private[collection] object LongChampStepper {
<<<<<<< OLD
  def from[T >: Null <: Node[T]](maxSize: Int, root: T, extract: (T, Int) => Long): LongChampStepper[T] = {
=======
  def from[T <: Node[T]](maxSize: Int, root: T, extract: (T, Int) => Long): LongChampStepper[T] = {
>>>>>>> NEW
    val ans = new LongChampStepper[T](maxSize, extract)
    ans.initRoot(root)
    ans