import scala.collection.Stepper.EfficientSplit

/** Abstracts all the generic operations of stepping over an indexable collection */
<<<<<<< OLD
private[convert] abstract class IndexedStepperBase[Sub >: Null, Semi <: Sub](protected var i0: Int, protected var iN: Int)
=======
private[convert] abstract class IndexedStepperBase[Sub, Semi <: Sub](protected var i0: Int, protected var iN: Int)
>>>>>>> NEW
  extends EfficientSplit {
  protected def semiclone(half: Int): Semi


  def estimateSize: Long = iN - i0

<<<<<<< OLD
  def trySplit(): Sub = {
=======
  def trySplit(): Sub | Null = {
>>>>>>> NEW
    if (iN-1 > i0) {
      val half = (i0+iN) >>> 1
      val ans = semiclone(half)