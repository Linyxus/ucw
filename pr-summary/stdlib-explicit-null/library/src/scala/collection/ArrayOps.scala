    val s = (shape.shape: @unchecked) match {
      case StepperShape.ReferenceShape => (xs: Any) match {
        case bs: Array[Boolean] => new BoxedBooleanArrayStepper(bs, 0, xs.length)
<<<<<<< OLD
        case _ => new ObjectArrayStepper[AnyRef](xs.asInstanceOf[Array[AnyRef ]], 0, xs.length)
=======
        case _ => new ObjectArrayStepper[AnyRef](xs.asInstanceOf[Array[AnyRef]], 0, xs.length)
>>>>>>> NEW
      }
      case StepperShape.IntShape    => new IntArrayStepper           (xs.asInstanceOf[Array[Int    ]], 0, xs.length)
      case StepperShape.LongShape   => new LongArrayStepper          (xs.asInstanceOf[Array[Long   ]], 0, xs.length)