      ans
    }

<<<<<<< OLD
  def trySplit(): LongStepper =
=======
  def trySplit(): LongStepper | Null =
>>>>>>> NEW
    if (N <= 1) null
    else {
      val half = N >> 1