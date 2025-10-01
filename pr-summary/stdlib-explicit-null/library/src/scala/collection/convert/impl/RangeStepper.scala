      val ans = myNext
      myNext += myStep
      i0 += 1
<<<<<<< OLD
      ans 
=======
      ans
>>>>>>> NEW
    }
    else Stepper.throwNSEE()
  protected def semiclone(half: Int): RangeStepper = new RangeStepper(myNext, myStep, i0, half)
<<<<<<< OLD
  override def trySplit(): IntStepper = {
=======
  override def trySplit(): IntStepper | Null = {
>>>>>>> NEW
    val old_i0 = i0
    val ans = super.trySplit()
    myNext += (i0 - old_i0) * myStep