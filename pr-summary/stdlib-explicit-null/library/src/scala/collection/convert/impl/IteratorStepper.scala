import scala.collection.{AnyStepper, DoubleStepper, IntStepper, LongStepper, Stepper}
import scala.jdk.{AnyAccumulator, DoubleAccumulator, IntAccumulator, LongAccumulator}

<<<<<<< OLD
private[collection] class AnyIteratorStepper[A](_underlying: Iterator[A])
=======
private[collection] class AnyIteratorStepper[A](_underlying: Iterator[A] | Null)
>>>>>>> NEW
  extends IteratorStepperBase[A, AnyStepper[A], AnyIteratorStepper[A]](_underlying)
    with AnyStepper[A] {
  protected def semiclone(): AnyIteratorStepper[A] = new AnyIteratorStepper(null)

<<<<<<< OLD
  def nextStep(): A = if (proxied ne null) proxied.nextStep() else underlying.next()
=======
  def nextStep(): A = if (proxied ne null) proxied.nextStep() else underlying.nn.next()
>>>>>>> NEW

<<<<<<< OLD
  def trySplit(): AnyStepper[A] = if (proxied ne null) proxied.trySplit() else {
=======
  def trySplit(): AnyStepper[A] | Null = if (proxied ne null) proxied.trySplit() else {
>>>>>>> NEW
    val acc = new AnyAccumulator[A]
    var i = 0
    val n = nextChunkSize & 0xFFFFFFFC
<<<<<<< OLD
    while (i < n && underlying.hasNext) { acc += underlying.next(); i += 1 }
    if (i < n || !underlying.hasNext) {
=======
    while (i < n && underlying.nn.hasNext) { acc += underlying.nn.next(); i += 1 }
    if (i < n || !underlying.nn.hasNext) {
>>>>>>> NEW
      proxied = acc.stepper
      proxied.trySplit()
    }
  }
}

<<<<<<< OLD
private[collection] class DoubleIteratorStepper(_underlying: Iterator[Double])
=======
private[collection] class DoubleIteratorStepper(_underlying: Iterator[Double] | Null)
>>>>>>> NEW
  extends IteratorStepperBase[Double, DoubleStepper, DoubleIteratorStepper](_underlying)
    with DoubleStepper {
  protected def semiclone(): DoubleIteratorStepper = new DoubleIteratorStepper(null)

<<<<<<< OLD
  def nextStep(): Double = if (proxied ne null) proxied.nextStep() else underlying.next()
=======
  def nextStep(): Double = if (proxied ne null) proxied.nextStep() else underlying.nn.next()
>>>>>>> NEW

<<<<<<< OLD
  def trySplit(): DoubleStepper = if (proxied ne null) proxied.trySplit() else {
=======
  def trySplit(): DoubleStepper | Null = if (proxied ne null) proxied.trySplit() else {
>>>>>>> NEW
    val acc = new DoubleAccumulator
    var i = 0
    val n = nextChunkSize & 0xFFFFFFFC
<<<<<<< OLD
    while (i < n && underlying.hasNext) { acc += underlying.next(); i += 1 }
    if (i < n || !underlying.hasNext) {
=======
    while (i < n && underlying.nn.hasNext) { acc += underlying.nn.next(); i += 1 }
    if (i < n || !underlying.nn.hasNext) {
>>>>>>> NEW
      proxied = acc.stepper
      proxied.trySplit()
    }
  }
}

<<<<<<< OLD
private[collection] class IntIteratorStepper(_underlying: Iterator[Int])
=======
private[collection] class IntIteratorStepper(_underlying: Iterator[Int] | Null)
>>>>>>> NEW
  extends IteratorStepperBase[Int, IntStepper, IntIteratorStepper](_underlying)
    with IntStepper {
  protected def semiclone(): IntIteratorStepper = new IntIteratorStepper(null)

<<<<<<< OLD
  def nextStep(): Int = if (proxied ne null) proxied.nextStep() else underlying.next()
=======
  def nextStep(): Int = if (proxied ne null) proxied.nextStep() else underlying.nn.next()
>>>>>>> NEW

<<<<<<< OLD
  def trySplit(): IntStepper = if (proxied ne null) proxied.trySplit() else {
=======
  def trySplit(): IntStepper | Null = if (proxied ne null) proxied.trySplit() else {
>>>>>>> NEW
    val acc = new IntAccumulator
    var i = 0
    val n = nextChunkSize & 0xFFFFFFFC
<<<<<<< OLD
    while (i < n && underlying.hasNext) { acc += underlying.next(); i += 1 }
    if (i < n || !underlying.hasNext) {
=======
    while (i < n && underlying.nn.hasNext) { acc += underlying.nn.next(); i += 1 }
    if (i < n || !underlying.nn.hasNext) {
>>>>>>> NEW
      proxied = acc.stepper
      proxied.trySplit()
    }
  }
}

<<<<<<< OLD
private[collection] class LongIteratorStepper(_underlying: Iterator[Long])
=======
private[collection] class LongIteratorStepper(_underlying: Iterator[Long] | Null)
>>>>>>> NEW
  extends IteratorStepperBase[Long, LongStepper, LongIteratorStepper](_underlying)
    with LongStepper {
  protected def semiclone(): LongIteratorStepper = new LongIteratorStepper(null)

<<<<<<< OLD
  def nextStep(): Long = if (proxied ne null) proxied.nextStep() else underlying.next()
=======
  def nextStep(): Long = if (proxied ne null) proxied.nextStep() else underlying.nn.next()
>>>>>>> NEW

<<<<<<< OLD
  def trySplit(): LongStepper = if (proxied ne null) proxied.trySplit() else {
=======
  def trySplit(): LongStepper | Null = if (proxied ne null) proxied.trySplit() else {
>>>>>>> NEW
    val acc = new LongAccumulator
    var i = 0
    val n = nextChunkSize & 0xFFFFFFFC
<<<<<<< OLD
    while (i < n && underlying.hasNext) { acc += underlying.next(); i += 1 }
    if (i < n || !underlying.hasNext) {
=======
    while (i < n && underlying.nn.hasNext) { acc += underlying.nn.next(); i += 1 }
    if (i < n || !underlying.nn.hasNext) {
>>>>>>> NEW
      proxied = acc.stepper
      proxied.trySplit()
    }
}

/** Common functionality for Steppers that step through an Iterator, caching the results as needed when a split is requested. */
<<<<<<< OLD
private[convert] abstract class IteratorStepperBase[A, SP >: Null <: Stepper[A], Semi <: SP](final protected val underlying: Iterator[A]) {
=======
private[convert] abstract class IteratorStepperBase[A, SP <: Stepper[A], Semi <: SP](final protected val underlying: Iterator[A] | Null) {
>>>>>>> NEW
  final protected var nextChunkSize = 16
<<<<<<< OLD
  final protected var proxied: SP = null
=======
  @annotation.stableNull
  final protected var proxied: SP | Null = null
>>>>>>> NEW
  protected def semiclone(): Semi        // Must initialize with null iterator!
  def characteristics: Int = if (proxied ne null) Spliterator.ORDERED | Spliterator.SIZED | Spliterator.SUBSIZED else Spliterator.ORDERED
  def estimateSize: Long = if (proxied ne null) proxied.estimateSize else Long.MaxValue
<<<<<<< OLD
  def hasStep: Boolean = if (proxied ne null) proxied.hasStep else underlying.hasNext
=======
  def hasStep: Boolean = if (proxied ne null) proxied.hasStep else underlying.nn.hasNext
>>>>>>> NEW
}