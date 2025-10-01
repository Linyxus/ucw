import scala.language.`2.13`
import scala.collection._

<<<<<<< OLD
private[collection] class ObjectArrayStepper[A <: Object](underlying: Array[A], _i0: Int, _iN: Int)
=======
private[collection] class ObjectArrayStepper[A <: Object | Null](underlying: Array[A], _i0: Int, _iN: Int)
>>>>>>> NEW
  extends IndexedStepperBase[AnyStepper[A], ObjectArrayStepper[A]](_i0, _iN)
    with AnyStepper[A] {
  def nextStep(): A = if (hasStep) { val j = i0; i0 += 1; underlying(j) } else Stepper.throwNSEE()