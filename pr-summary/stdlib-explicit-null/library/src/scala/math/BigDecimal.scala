  private final val deci2binary = 3.3219280948873626  // Ratio of log(10) to log(2)
  private[this] val minCached = -512
  private[this] val maxCached = 512
<<<<<<< OLD
  val defaultMathContext = MathContext.DECIMAL128
=======
  val defaultMathContext: MathContext = MathContext.DECIMAL128
>>>>>>> NEW

  /** Cache only for defaultMathContext using BigDecimals in a small range. */
  private[this] lazy val cache = new Array[BigDecimal](maxCached - minCached + 1)
  implicit def double2bigDecimal(d: Double): BigDecimal = decimal(d)

  /** Implicit conversion from `java.math.BigDecimal` to `scala.BigDecimal`. */
<<<<<<< OLD
  implicit def javaBigDecimal2bigDecimal(x: BigDec): BigDecimal = if (x == null) null else apply(x)
=======
  implicit def javaBigDecimal2bigDecimal(x: BigDec | Null): BigDecimal | Null = if (x == null) null else apply(x)
>>>>>>> NEW
}

/**