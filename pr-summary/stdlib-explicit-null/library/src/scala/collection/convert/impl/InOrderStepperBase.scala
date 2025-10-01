  *
  * For collections that are guaranteed to not have gaps, use `IndexedStepperBase` instead.
  */
<<<<<<< OLD
private[convert] abstract class InOrderStepperBase[Sub >: Null, Semi <: Sub](protected var i0: Int, protected var iN: Int)
=======
private[convert] abstract class InOrderStepperBase[Sub, Semi <: Sub](protected var i0: Int, protected var iN: Int)
>>>>>>> NEW
extends EfficientSplit {
  /** Set `true` if the element at `i0` is known to be there.  `false` if either not known or is a gap.
    */

  def estimateSize: Long = iN - i0

<<<<<<< OLD
  def trySplit(): Sub = {
=======
  def trySplit(): Sub | Null = {
>>>>>>> NEW
    if (iN-1 > i0) {
      val half = (i0 + iN) >>> 1
      val ans = semiclone(half)