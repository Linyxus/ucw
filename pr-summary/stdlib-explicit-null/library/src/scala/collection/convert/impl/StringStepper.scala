    }
    else Stepper.throwNSEE()
  }
<<<<<<< OLD
  def trySplit(): CodePointStringStepper =
=======
  def trySplit(): CodePointStringStepper | Null =
>>>>>>> NEW
    if (iN - 3 > i0) {
      var half = (i0 + iN) >>> 1
      if (isLowSurrogate(underlying.charAt(half))) half -= 1