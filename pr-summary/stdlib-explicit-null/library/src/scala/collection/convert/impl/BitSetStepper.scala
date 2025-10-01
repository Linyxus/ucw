

private[collection] final class BitSetStepper(
<<<<<<< OLD
  private var underlying: BitSetOps[_], 
  private var cache0: Long, private var cache1: Long, 
=======
  @annotation.stableNull
  private var underlying: BitSetOps[_] | Null,
  private var cache0: Long, private var cache1: Long,
>>>>>>> NEW
  _i0: Int, _iN: Int,
  private var cacheIndex: Int
)
          findNext()
        }
      }
<<<<<<< OLD
      else if (underlying eq null) { 
=======
      else if (underlying eq null) {
>>>>>>> NEW
        i0 = iN
        found = false
        found
    else scanLong(bits, from + 1)

  def nextStep(): Int =
<<<<<<< OLD
    if (found || findNext()) { 
=======
    if (found || findNext()) {
>>>>>>> NEW
      found = false
      val ans = i0
      i0 += 1