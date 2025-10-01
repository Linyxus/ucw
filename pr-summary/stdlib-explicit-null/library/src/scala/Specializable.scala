  trait SpecializedGroup

  // Smuggle a list of types by way of a tuple upon which Group is parameterized.
<<<<<<< OLD
  class Group[T >: Null](value: T) extends SpecializedGroup
=======
  class Group[T](value: T) extends SpecializedGroup
>>>>>>> NEW

<<<<<<< OLD
  final val Primitives:  Group[(Byte, Short, Int, Long, Char, Float, Double, Boolean, Unit)] = null
  final val Everything:  Group[(Byte, Short, Int, Long, Char, Float, Double, Boolean, Unit, AnyRef)] = null
  final val Bits32AndUp: Group[(Int, Long, Float, Double)] = null
  final val Integral:    Group[(Byte, Short, Int, Long, Char)] = null
  final val AllNumeric:  Group[(Byte, Short, Int, Long, Char, Float, Double)] = null
  final val BestOfBreed: Group[(Int, Double, Boolean, Unit, AnyRef)] = null
  final val Unit:        Group[Tuple1[Unit]] = null
=======
  final val Primitives:  Group[(Byte, Short, Int, Long, Char, Float, Double, Boolean, Unit)] = null.asInstanceOf[Group[(Byte, Short, Int, Long, Char, Float, Double, Boolean, Unit)]]
  final val Everything:  Group[(Byte, Short, Int, Long, Char, Float, Double, Boolean, Unit, AnyRef)] = null.asInstanceOf[Group[(Byte, Short, Int, Long, Char, Float, Double, Boolean, Unit, AnyRef)]]
  final val Bits32AndUp: Group[(Int, Long, Float, Double)] = null.asInstanceOf[Group[(Int, Long, Float, Double)]]
  final val Integral:    Group[(Byte, Short, Int, Long, Char)] = null.asInstanceOf[Group[(Byte, Short, Int, Long, Char)]]
  final val AllNumeric:  Group[(Byte, Short, Int, Long, Char, Float, Double)] = null.asInstanceOf[Group[(Byte, Short, Int, Long, Char, Float, Double)]]
  final val BestOfBreed: Group[(Int, Double, Boolean, Unit, AnyRef)] = null.asInstanceOf[Group[(Int, Double, Boolean, Unit, AnyRef)]]
  final val Unit:        Group[Tuple1[Unit]] = null.asInstanceOf[Group[Tuple1[Unit]]]
>>>>>>> NEW

<<<<<<< OLD
  final val Arg:         Group[(Int, Long, Float, Double)] = null
  final val Args:        Group[(Int, Long, Double)] = null
  final val Return:      Group[(Int, Long, Float, Double, Boolean, Unit)] = null
=======
  final val Arg:         Group[(Int, Long, Float, Double)] = null.asInstanceOf[Group[(Int, Long, Float, Double)]]
  final val Args:        Group[(Int, Long, Double)] = null.asInstanceOf[Group[(Int, Long, Double)]]
  final val Return:      Group[(Int, Long, Float, Double, Boolean, Unit)] = null.asInstanceOf[Group[(Int, Long, Float, Double, Boolean, Unit)]]
>>>>>>> NEW
}