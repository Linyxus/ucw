      ans
    }

<<<<<<< OLD
  def trySplit(): AnyStepper[A] =
=======
  def trySplit(): AnyStepper[A] | Null =
>>>>>>> NEW
    if (N <= 1) null
    else {
      val half = N >> 1