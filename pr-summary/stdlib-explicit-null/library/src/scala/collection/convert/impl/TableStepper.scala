import scala.collection.Stepper.EfficientSplit
import scala.collection._

<<<<<<< OLD
private[collection] abstract class TableStepperBase[A, I >: Null <: AnyRef, Sub >: Null, Semi <: Sub with TableStepperBase[A, I, _, _]](
  protected var maxLength: Int, protected val table: Array[I], protected var i0: Int, protected val iN: Int
=======
private[collection] abstract class TableStepperBase[A, I <: AnyRef, Sub, Semi <: Sub with TableStepperBase[A, I, _, _]](
  protected var maxLength: Int, protected val table: Array[I | Null], protected var i0: Int, protected val iN: Int
>>>>>>> NEW
)
extends EfficientSplit {
  // Always holds table(i0); if `null` it is time to switch to the next element
<<<<<<< OLD
  protected var myCurrent: I = if (i0 < iN) table(i0) else null
=======
  protected var myCurrent: I | Null = if (i0 < iN) table(i0) else null
>>>>>>> NEW

  // Only call this when `myCurrent` is null (meaning we need to advance)
  @annotation.tailrec

  def hasStep: Boolean = (myCurrent ne null) || findNextCurrent()

<<<<<<< OLD
  def trySplit(): Sub = {
=======
  def trySplit(): Sub | Null = {
>>>>>>> NEW
    if (iN-1 > i0 && maxLength > 0) {
      val half = (i0 + iN) >>> 1
      val ans = semiclone(half)
}


<<<<<<< OLD
private[collection] final class AnyTableStepper[A, I >: Null <: AnyRef](
  _maxLength: Int, _table: Array[I], iterate: I => I, extract: I => A, _i0: Int, _iN: Int
=======
private[collection] final class AnyTableStepper[A, I <: AnyRef](
  _maxLength: Int, _table: Array[I | Null], iterate: I => I, extract: I => A, _i0: Int, _iN: Int
>>>>>>> NEW
)
extends TableStepperBase[A, I, AnyStepper[A], AnyTableStepper[A, I]](_maxLength, _table, _i0, _iN)
with AnyStepper[A] {
  def nextStep(): A =
    if (hasStep) {
<<<<<<< OLD
      val ans = extract(myCurrent)
      myCurrent = iterate(myCurrent)
=======
      val ans = extract(myCurrent.nn)
      myCurrent = iterate(myCurrent.nn)
>>>>>>> NEW
      ans
    }
    else Stepper.throwNSEE()
}


<<<<<<< OLD
private[collection] final class DoubleTableStepper[I >: Null <: AnyRef](
  _maxLength: Int, _table: Array[I], iterate: I => I, extract: I => Double, _i0: Int, _iN: Int
=======
private[collection] final class DoubleTableStepper[I <: AnyRef](
  _maxLength: Int, _table: Array[I | Null], iterate: I => I, extract: I => Double, _i0: Int, _iN: Int
>>>>>>> NEW
)
extends TableStepperBase[Double, I, DoubleStepper, DoubleTableStepper[I]](_maxLength, _table, _i0, _iN)
with DoubleStepper {
  def nextStep(): Double =
    if (hasStep) {
<<<<<<< OLD
      val ans = extract(myCurrent)
      myCurrent = iterate(myCurrent)
=======
      val ans = extract(myCurrent.nn)
      myCurrent = iterate(myCurrent.nn)
>>>>>>> NEW
      ans
    }
    else Stepper.throwNSEE()
}


<<<<<<< OLD
private[collection] final class IntTableStepper[I >: Null <: AnyRef](
  _maxLength: Int, _table: Array[I], iterate: I => I, extract: I => Int, _i0: Int, _iN: Int
=======
private[collection] final class IntTableStepper[I <: AnyRef](
  _maxLength: Int, _table: Array[I | Null], iterate: I => I, extract: I => Int, _i0: Int, _iN: Int
>>>>>>> NEW
)
extends TableStepperBase[Int, I, IntStepper, IntTableStepper[I]](_maxLength, _table, _i0, _iN)
with IntStepper {
  def nextStep(): Int =
    if (hasStep) {
<<<<<<< OLD
      val ans = extract(myCurrent)
      myCurrent = iterate(myCurrent)
=======
      val ans = extract(myCurrent.nn)
      myCurrent = iterate(myCurrent.nn)
>>>>>>> NEW
      ans
    }
    else Stepper.throwNSEE()
}


<<<<<<< OLD
private[collection] final class LongTableStepper[I >: Null <: AnyRef](
  _maxLength: Int, _table: Array[I], iterate: I => I, extract: I => Long, _i0: Int, _iN: Int
=======
private[collection] final class LongTableStepper[I <: AnyRef](
  _maxLength: Int, _table: Array[I | Null], iterate: I => I, extract: I => Long, _i0: Int, _iN: Int
>>>>>>> NEW
)
extends TableStepperBase[Long, I, LongStepper, LongTableStepper[I]](_maxLength, _table, _i0, _iN)
with LongStepper {
  def nextStep(): Long =
    if (hasStep) {
<<<<<<< OLD
      val ans = extract(myCurrent)
      myCurrent = iterate(myCurrent)
=======
      val ans = extract(myCurrent.nn)
      myCurrent = iterate(myCurrent.nn)
>>>>>>> NEW
      ans
    }
    else Stepper.throwNSEE()