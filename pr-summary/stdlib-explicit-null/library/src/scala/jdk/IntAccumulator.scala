      ans
    }

<<<<<<< OLD
  def trySplit(): IntStepper =
=======
  def trySplit(): IntStepper | Null =
>>>>>>> NEW
    if (N <= 1) null
    else {
      val half = N >> 1