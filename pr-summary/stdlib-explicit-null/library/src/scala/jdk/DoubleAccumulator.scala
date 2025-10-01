      ans
    }

<<<<<<< OLD
  def trySplit(): DoubleStepper =
=======
  def trySplit(): DoubleStepper | Null =
>>>>>>> NEW
    if (N <= 1) null
    else {
      val half = N >> 1