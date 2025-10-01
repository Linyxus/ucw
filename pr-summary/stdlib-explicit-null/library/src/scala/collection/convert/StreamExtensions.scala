    * `noAccumulatorFactoryInfo` is passed.
    */
  trait AccumulatorFactoryInfo[A, C] {
<<<<<<< OLD
    val companion: AnyRef
=======
    val companion: AnyRef | Null
>>>>>>> NEW
  }
  trait LowPriorityAccumulatorFactoryInfo {
    implicit def noAccumulatorFactoryInfo[A, C]: AccumulatorFactoryInfo[A, C] = noAccumulatorFactoryInfoPrototype.asInstanceOf[AccumulatorFactoryInfo[A, C]]
    private val noAccumulatorFactoryInfoPrototype: AccumulatorFactoryInfo[AnyRef, AnyRef] = new AccumulatorFactoryInfo[AnyRef, AnyRef] {
<<<<<<< OLD
      val companion: AnyRef = null
=======
      val companion: AnyRef | Null = null
>>>>>>> NEW
    }
  }
  object AccumulatorFactoryInfo extends LowPriorityAccumulatorFactoryInfo {
    implicit def anyAccumulatorFactoryInfo[A]: AccumulatorFactoryInfo[A, AnyAccumulator[A]] = anyAccumulatorFactoryInfoPrototype.asInstanceOf[AccumulatorFactoryInfo[A, AnyAccumulator[A]]]

    private object anyAccumulatorFactoryInfoPrototype extends AccumulatorFactoryInfo[AnyRef, AnyAccumulator[AnyRef]] {
<<<<<<< OLD
      val companion: AnyRef = AnyAccumulator
=======
      val companion: AnyRef | Null = null
>>>>>>> NEW
    }

    implicit val intAccumulatorFactoryInfo: AccumulatorFactoryInfo[Int, IntAccumulator] = new AccumulatorFactoryInfo[Int, IntAccumulator] {
<<<<<<< OLD
      val companion: AnyRef = IntAccumulator
=======
      val companion: AnyRef | Null = IntAccumulator
>>>>>>> NEW
    }

    implicit val longAccumulatorFactoryInfo: AccumulatorFactoryInfo[Long, LongAccumulator] = new AccumulatorFactoryInfo[Long, LongAccumulator] {
<<<<<<< OLD
      val companion: AnyRef = LongAccumulator
=======
      val companion: AnyRef | Null = LongAccumulator
>>>>>>> NEW
    }

    implicit val doubleAccumulatorFactoryInfo: AccumulatorFactoryInfo[Double, DoubleAccumulator] = new AccumulatorFactoryInfo[Double, DoubleAccumulator] {
<<<<<<< OLD
      val companion: AnyRef = DoubleAccumulator
=======
      val companion: AnyRef | Null = DoubleAccumulator
>>>>>>> NEW
    }

    implicit val jIntegerAccumulatorFactoryInfo: AccumulatorFactoryInfo[jl.Integer, IntAccumulator] = intAccumulatorFactoryInfo.asInstanceOf[AccumulatorFactoryInfo[jl.Integer, IntAccumulator]]