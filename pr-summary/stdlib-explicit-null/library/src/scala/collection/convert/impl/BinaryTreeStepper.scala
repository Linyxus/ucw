package impl

import scala.language.`2.13`
<<<<<<< ADDED

>>>>>>> ADDED
import java.util.Spliterator

import annotation.tailrec


private[collection] object BinaryTreeStepper {
<<<<<<< OLD
  val emptyStack = new Array[AnyRef](0)
=======
  val emptyStack = new Array[AnyRef | Null](0)
>>>>>>> NEW
}


  * Subclasses should allow this class to do all the work of maintaining state; `next` should simply
  * reduce `maxLength` by one, and consume `myCurrent` and set it to `null` if `hasNext` is true.
  */
<<<<<<< OLD
private[collection] abstract class BinaryTreeStepperBase[A, T >: Null <: AnyRef, Sub >: Null, Semi <: Sub with BinaryTreeStepperBase[A, T, _, _]](
  protected var maxLength: Int, protected var myCurrent: T, protected var stack: Array[AnyRef], protected var index: Int,
  protected val left: T => T, protected val right: T => T
=======
private[collection] abstract class BinaryTreeStepperBase[A, T <: AnyRef, Sub, Semi <: Sub with BinaryTreeStepperBase[A, T, _, _]](
  protected var maxLength: Int, protected var myCurrent: T | Null, protected var stack: Array[AnyRef | Null], protected var index: Int,
  protected val left: T => T | Null, protected val right: T => T | Null
>>>>>>> NEW
)
extends EfficientSplit {
  /** Unrolls a subtree onto the stack starting from a particular node, returning
    *
    * Right now overwrites everything so could allow reuse, but isn't used for it.
    */
<<<<<<< OLD
  private[impl] final def initialize(root: T, size: Int): Unit =
=======
  private[impl] final def initialize(root: T | Null, size: Int): Unit =
>>>>>>> NEW
    if (root eq null) {
      maxLength = 0
      myCurrent = null
      myCurrent = detach(unroll(root))
    }

<<<<<<< OLD
  protected def semiclone(maxL: Int, myC: T, stk: Array[AnyRef], ix: Int): Semi
=======
  protected def semiclone(maxL: Int, myC: T | Null, stk: Array[AnyRef | Null], ix: Int): Semi
>>>>>>> NEW

  def characteristics: Int = Spliterator.ORDERED

    *
    * If the tree is empty or only has one element left, it returns `null` instead of splitting.
    */
<<<<<<< OLD
  def trySplit(): Sub =
=======
  def trySplit(): Sub | Null =
>>>>>>> NEW
    if (!hasStep || index < 0) null
    else {
      val root = stack(0).asInstanceOf[T]
<<<<<<< OLD
      val leftStack = 
=======
      val leftStack =
>>>>>>> NEW
        if (index > 0) java.util.Arrays.copyOfRange(stack, 1, index+1)
        else BinaryTreeStepper.emptyStack
      val leftIndex = index - 1
}


<<<<<<< OLD
private[collection] final class AnyBinaryTreeStepper[A, T >: Null <: AnyRef](
  _maxLength: Int, _myCurrent: T, _stack: Array[AnyRef], _index: Int, _left: T => T, _right: T => T, protected val extract: T => A
=======
private[collection] final class AnyBinaryTreeStepper[A, T <: AnyRef](
  _maxLength: Int, _myCurrent: T | Null, _stack: Array[AnyRef | Null], _index: Int, _left: T => T | Null, _right: T => T | Null, protected val extract: T => A
>>>>>>> NEW
)
extends BinaryTreeStepperBase[A, T, AnyStepper[A], AnyBinaryTreeStepper[A, T]](_maxLength, _myCurrent, _stack, _index, _left, _right)
with AnyStepper[A] {
  def nextStep(): A =
    if (hasStep) {
<<<<<<< OLD
      val ans = extract(myCurrent)
=======
      val ans = extract(myCurrent.nn)
>>>>>>> NEW
      myCurrent = null
      maxLength -= 1
      ans
    }
    else Stepper.throwNSEE()

<<<<<<< OLD
  def semiclone(maxL: Int, myC: T, stk: Array[AnyRef], ix: Int): AnyBinaryTreeStepper[A, T] =
=======
  def semiclone(maxL: Int, myC: T | Null, stk: Array[AnyRef | Null], ix: Int): AnyBinaryTreeStepper[A, T] =
>>>>>>> NEW
    new AnyBinaryTreeStepper[A, T](maxL, myC, stk, ix, left, right, extract)
}
private[collection] object AnyBinaryTreeStepper {
<<<<<<< OLD
  def from[A, T >: Null <: AnyRef](maxLength: Int, root: T, left: T => T, right: T => T, extract: T => A): AnyBinaryTreeStepper[A, T] = {
=======
  def from[A, T <: AnyRef](maxLength: Int, root: T | Null, left: T => T | Null, right: T => T | Null, extract: T => A): AnyBinaryTreeStepper[A, T] = {
>>>>>>> NEW
    val ans = new AnyBinaryTreeStepper(0, null, BinaryTreeStepper.emptyStack, -1, left, right, extract)
    ans.initialize(root, maxLength)
    ans
}


<<<<<<< OLD
private[collection] final class DoubleBinaryTreeStepper[T >: Null <: AnyRef](
  _maxLength: Int, _myCurrent: T, _stack: Array[AnyRef], _index: Int, _left: T => T, _right: T => T, protected val extract: T => Double
=======
private[collection] final class DoubleBinaryTreeStepper[T <: AnyRef](
  _maxLength: Int, _myCurrent: T | Null, _stack: Array[AnyRef | Null], _index: Int, _left: T => T | Null, _right: T => T | Null, protected val extract: T => Double
>>>>>>> NEW
)
extends BinaryTreeStepperBase[Double, T, DoubleStepper, DoubleBinaryTreeStepper[T]](_maxLength, _myCurrent, _stack, _index, _left, _right)
with DoubleStepper {
  def nextStep(): Double =
    if (hasStep) {
<<<<<<< OLD
      val ans = extract(myCurrent)
=======
      val ans = extract(myCurrent.nn)
>>>>>>> NEW
      myCurrent = null
      maxLength -= 1
      ans
    }
    else Stepper.throwNSEE()

<<<<<<< OLD
  def semiclone(maxL: Int, myC: T, stk: Array[AnyRef], ix: Int): DoubleBinaryTreeStepper[T] =
=======
  def semiclone(maxL: Int, myC: T | Null, stk: Array[AnyRef | Null], ix: Int): DoubleBinaryTreeStepper[T] =
>>>>>>> NEW
    new DoubleBinaryTreeStepper[T](maxL, myC, stk, ix, left, right, extract)
}
private [collection] object DoubleBinaryTreeStepper {
<<<<<<< OLD
  def from[T >: Null <: AnyRef](maxLength: Int, root: T, left: T => T, right: T => T, extract: T => Double): DoubleBinaryTreeStepper[T] = {
=======
  def from[T <: AnyRef](maxLength: Int, root: T | Null, left: T => T | Null, right: T => T | Null, extract: T => Double): DoubleBinaryTreeStepper[T] = {
>>>>>>> NEW
    val ans = new DoubleBinaryTreeStepper(0, null, BinaryTreeStepper.emptyStack, -1, left, right, extract)
    ans.initialize(root, maxLength)
    ans
}


<<<<<<< OLD
private[collection] final class IntBinaryTreeStepper[T >: Null <: AnyRef](
  _maxLength: Int, _myCurrent: T, _stack: Array[AnyRef], _index: Int, _left: T => T, _right: T => T, protected val extract: T => Int
=======
private[collection] final class IntBinaryTreeStepper[T <: AnyRef](
  _maxLength: Int, _myCurrent: T | Null, _stack: Array[AnyRef | Null], _index: Int, _left: T => T | Null, _right: T => T | Null, protected val extract: T => Int
>>>>>>> NEW
)
extends BinaryTreeStepperBase[Int, T, IntStepper, IntBinaryTreeStepper[T]](_maxLength, _myCurrent, _stack, _index, _left, _right)
with IntStepper {
  def nextStep(): Int =
    if (hasStep) {
<<<<<<< OLD
      val ans = extract(myCurrent)
=======
      val ans = extract(myCurrent.nn)
>>>>>>> NEW
      myCurrent = null
      maxLength -= 1
      ans
    }
    else Stepper.throwNSEE()

<<<<<<< OLD
  def semiclone(maxL: Int, myC: T, stk: Array[AnyRef], ix: Int): IntBinaryTreeStepper[T] =
=======
  def semiclone(maxL: Int, myC: T | Null, stk: Array[AnyRef | Null], ix: Int): IntBinaryTreeStepper[T] =
>>>>>>> NEW
    new IntBinaryTreeStepper[T](maxL, myC, stk, ix, left, right, extract)
}
private [collection] object IntBinaryTreeStepper {
<<<<<<< OLD
  def from[T >: Null <: AnyRef](maxLength: Int, root: T, left: T => T, right: T => T, extract: T => Int): IntBinaryTreeStepper[T] = {
=======
  def from[T <: AnyRef](maxLength: Int, root: T | Null, left: T => T | Null, right: T => T | Null, extract: T => Int): IntBinaryTreeStepper[T] = {
>>>>>>> NEW
    val ans = new IntBinaryTreeStepper(0, null, BinaryTreeStepper.emptyStack, -1, left, right, extract)
    ans.initialize(root, maxLength)
    ans



<<<<<<< OLD
private[collection] final class LongBinaryTreeStepper[T >: Null <: AnyRef](
  _maxLength: Int, _myCurrent: T, _stack: Array[AnyRef], _index: Int, _left: T => T, _right: T => T, protected val extract: T => Long
=======
private[collection] final class LongBinaryTreeStepper[T <: AnyRef](
  _maxLength: Int, _myCurrent: T | Null, _stack: Array[AnyRef | Null], _index: Int, _left: T => T | Null, _right: T => T | Null, protected val extract: T => Long
>>>>>>> NEW
)
extends BinaryTreeStepperBase[Long, T, LongStepper, LongBinaryTreeStepper[T]](_maxLength, _myCurrent, _stack, _index, _left, _right)
with LongStepper {
  def nextStep(): Long =
    if (hasStep) {
<<<<<<< OLD
      val ans = extract(myCurrent)
=======
      val ans = extract(myCurrent.nn)
>>>>>>> NEW
      myCurrent = null
      maxLength -= 1
      ans
    }
    else Stepper.throwNSEE()

<<<<<<< OLD
  def semiclone(maxL: Int, myC: T, stk: Array[AnyRef], ix: Int): LongBinaryTreeStepper[T] =
=======
  def semiclone(maxL: Int, myC: T | Null, stk: Array[AnyRef | Null], ix: Int): LongBinaryTreeStepper[T] =
>>>>>>> NEW
    new LongBinaryTreeStepper[T](maxL, myC, stk, ix, left, right, extract)
}
private [collection] object LongBinaryTreeStepper {
<<<<<<< OLD
  def from[T >: Null <: AnyRef](maxLength: Int, root: T, left: T => T, right: T => T, extract: T => Long): LongBinaryTreeStepper[T] = {
=======
  def from[T <: AnyRef](maxLength: Int, root: T | Null, left: T => T | Null, right: T => T | Null, extract: T => Long): LongBinaryTreeStepper[T] = {
>>>>>>> NEW
    val ans = new LongBinaryTreeStepper(0, null, BinaryTreeStepper.emptyStack, -1, left, right, extract)
    ans.initialize(root, maxLength)
    ans