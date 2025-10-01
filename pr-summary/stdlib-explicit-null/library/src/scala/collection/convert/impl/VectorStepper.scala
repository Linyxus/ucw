import scala.language.`2.13`
import scala.collection._

<<<<<<< OLD
private[convert] abstract class VectorStepperBase[Sub >: Null, Semi <: Sub](
=======
private[convert] abstract class VectorStepperBase[Sub, Semi <: Sub](
>>>>>>> NEW
  _i0: Int,
  _iN: Int,
  protected val displayN: Int,
)
extends IndexedStepperBase[Sub, Semi](_i0, _iN) {
  protected var index: Int = 32  // Force an advanceData on the first element
<<<<<<< OLD
  protected var leaves: Array[AnyRef] = null
=======
  protected var leaves: Array[AnyRef] = _
>>>>>>> NEW
  protected var index1: Int = 32 // Force advanceData to defer to initTo on the first element
<<<<<<< OLD
  protected var twigs: Array[AnyRef] = null
=======
  protected var twigs: Array[AnyRef] = _
>>>>>>> NEW

  protected final def advanceData(iX: Int): Unit = {
    index1 += 1
    index1 = 32
    i0 = half
    ans
<<<<<<< OLD
  }    
=======
  }
>>>>>>> NEW
}

private[collection] class IntVectorStepper(_i0: Int, _iN: Int, _displayN: Int, _trunk: Array[AnyRef])
    index1 = 32
    i0 = half
    ans
<<<<<<< OLD
  }    
=======
  }
>>>>>>> NEW
}

private[collection] class LongVectorStepper(_i0: Int, _iN: Int, _displayN: Int, _trunk: Array[AnyRef])
    index1 = 32
    i0 = half
    ans
<<<<<<< OLD
  }    
=======
  }
>>>>>>> NEW
}