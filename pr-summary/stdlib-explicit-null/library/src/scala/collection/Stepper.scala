    *
    * See method `trySplit` in [[java.util.Spliterator]].
    */
<<<<<<< OLD
  def trySplit(): Stepper[A]^{this}
=======
  def trySplit(): Stepper[A]^{this} | Null
>>>>>>> NEW

  /** Returns an estimate of the number of elements of this Stepper, or [[Long.MaxValue]]. See
    * method `estimateSize` in [[java.util.Spliterator]].
    def nextStep(): Double = st.nextStep()
    def estimateSize: Long = st.estimateSize
    def characteristics: Int = st.characteristics
<<<<<<< OLD
    def trySplit(): DoubleStepper^{this} = {
=======
    def trySplit(): DoubleStepper^{this} | Null = {
>>>>>>> NEW
      val s = st.trySplit()
      if (s == null) null else new UnboxingDoubleStepper(s)
    }
    def nextStep(): Int = st.nextStep()
    def estimateSize: Long = st.estimateSize
    def characteristics: Int = st.characteristics
<<<<<<< OLD
    def trySplit(): IntStepper^{this} = {
=======
    def trySplit(): IntStepper^{this} | Null = {
>>>>>>> NEW
      val s = st.trySplit()
      if (s == null) null else new UnboxingIntStepper(s)
    }
    def nextStep(): Long = st.nextStep()
    def estimateSize: Long = st.estimateSize
    def characteristics: Int = st.characteristics
<<<<<<< OLD
    def trySplit(): LongStepper^{this} = {
=======
    def trySplit(): LongStepper^{this} | Null = {
>>>>>>> NEW
      val s = st.trySplit()
      if (s == null) null else new UnboxingLongStepper(s)
    }
    def nextStep(): Int = st.nextStep()
    def estimateSize: Long = st.estimateSize
    def characteristics: Int = st.characteristics
<<<<<<< OLD
    def trySplit(): IntStepper^{this} = {
=======
    def trySplit(): IntStepper^{this} | Null = {
>>>>>>> NEW
      val s = st.trySplit()
      if (s == null) null else new UnboxingByteStepper(s)
    }
    def nextStep(): Int = st.nextStep()
    def estimateSize: Long = st.estimateSize
    def characteristics: Int = st.characteristics
<<<<<<< OLD
    def trySplit(): IntStepper^{this} = {
=======
    def trySplit(): IntStepper^{this} | Null = {
>>>>>>> NEW
      val s = st.trySplit()
      if (s == null) null else new UnboxingCharStepper(s)
    }
    def nextStep(): Int = st.nextStep()
    def estimateSize: Long = st.estimateSize
    def characteristics: Int = st.characteristics
<<<<<<< OLD
    def trySplit(): IntStepper^{this} = {
=======
    def trySplit(): IntStepper^{this} | Null = {
>>>>>>> NEW
      val s = st.trySplit()
      if (s == null) null else new UnboxingShortStepper(s)
    }
    def nextStep(): Double = st.nextStep()
    def estimateSize: Long = st.estimateSize
    def characteristics: Int = st.characteristics
<<<<<<< OLD
    def trySplit(): DoubleStepper^{this} = {
=======
    def trySplit(): DoubleStepper^{this} | Null = {
>>>>>>> NEW
      val s = st.trySplit()
      if (s == null) null else new UnboxingFloatStepper(s)
    }

/** A Stepper for arbitrary element types. See [[Stepper]]. */
trait AnyStepper[+A] extends Stepper[A] {
<<<<<<< OLD
  def trySplit(): AnyStepper[A]^{this}
=======
  def trySplit(): AnyStepper[A]^{this} | Null
>>>>>>> NEW

  def spliterator[B >: A]: Spliterator[B]^{this} = new AnyStepper.AnyStepperSpliterator(this)

  class AnyStepperSpliterator[A](s: AnyStepper[A]^) extends Spliterator[A] {
    def tryAdvance(c: Consumer[_ >: A]): Boolean =
      if (s.hasStep) { c.accept(s.nextStep()); true } else false
<<<<<<< OLD
    def trySplit(): Spliterator[A]^{this} = {
=======
    def trySplit(): Spliterator[A]^{this} | Null = {
>>>>>>> NEW
      val sp = s.trySplit()
      if (sp == null) null else sp.spliterator
    }
    def nextStep(): Double = st.nextStep()
    def estimateSize: Long = st.estimateSize
    def characteristics: Int = st.characteristics
<<<<<<< OLD
    def trySplit(): AnyStepper[Double] = {
=======
    def trySplit(): AnyStepper[Double] | Null = {
>>>>>>> NEW
      val s = st.trySplit()
      if (s == null) null else new BoxedDoubleStepper(s)
    }
    def nextStep(): Int = st.nextStep()
    def estimateSize: Long = st.estimateSize
    def characteristics: Int = st.characteristics
<<<<<<< OLD
    def trySplit(): AnyStepper[Int] = {
=======
    def trySplit(): AnyStepper[Int] | Null = {
>>>>>>> NEW
      val s = st.trySplit()
      if (s == null) null else new BoxedIntStepper(s)
    }
    def nextStep(): Long = st.nextStep()
    def estimateSize: Long = st.estimateSize
    def characteristics: Int = st.characteristics
<<<<<<< OLD
    def trySplit(): AnyStepper[Long] = {
=======
    def trySplit(): AnyStepper[Long] | Null = {
>>>>>>> NEW
      val s = st.trySplit()
      if (s == null) null else new BoxedLongStepper(s)
    }

/** A Stepper for Ints. See [[Stepper]]. */
trait IntStepper extends Stepper[Int] {
<<<<<<< OLD
  def trySplit(): IntStepper^{this}
=======
  def trySplit(): IntStepper^{this} | Null
>>>>>>> NEW

  def spliterator[B >: Int]: Spliterator.OfInt^{this} = new IntStepper.IntStepperSpliterator(this)

      case _ => if (s.hasStep) { c.accept(jl.Integer.valueOf(s.nextStep())); true } else false
    }
    // override required for dotty#6152
<<<<<<< OLD
    override def trySplit(): Spliterator.OfInt^{this} = {
=======
    override def trySplit(): Spliterator.OfInt^{this} | Null = {
>>>>>>> NEW
      val sp = s.trySplit()
      if (sp == null) null else sp.spliterator
    }

/** A Stepper for Doubles. See [[Stepper]]. */
trait DoubleStepper extends Stepper[Double] {
<<<<<<< OLD
  def trySplit(): DoubleStepper^{this}
=======
  def trySplit(): DoubleStepper^{this} | Null
>>>>>>> NEW

  def spliterator[B >: Double]: Spliterator.OfDouble^{this} = new DoubleStepper.DoubleStepperSpliterator(this)

      case _ => if (s.hasStep) { c.accept(java.lang.Double.valueOf(s.nextStep())); true } else false
    }
    // override required for dotty#6152
<<<<<<< OLD
    override def trySplit(): Spliterator.OfDouble^{this} = {
=======
    override def trySplit(): Spliterator.OfDouble^{this} | Null = {
>>>>>>> NEW
      val sp = s.trySplit()
      if (sp == null) null else sp.spliterator
    }

/** A Stepper for Longs. See [[Stepper]]. */
trait LongStepper extends Stepper[Long] {
<<<<<<< OLD
  def trySplit(): LongStepper^{this}
=======
  def trySplit(): LongStepper^{this} | Null
>>>>>>> NEW

  def spliterator[B >: Long]: Spliterator.OfLong^{this} = new LongStepper.LongStepperSpliterator(this)

      case _ => if (s.hasStep) { c.accept(java.lang.Long.valueOf(s.nextStep())); true } else false
    }
    // override required for dotty#6152
<<<<<<< OLD
    override def trySplit(): Spliterator.OfLong^{this} = {
=======
    override def trySplit(): Spliterator.OfLong^{this} | Null = {
>>>>>>> NEW
      val sp = s.trySplit()
      if (sp == null) null else sp.spliterator
    }