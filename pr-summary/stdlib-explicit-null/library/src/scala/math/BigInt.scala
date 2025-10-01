
  /** Implicit conversion from `java.math.BigInteger` to `scala.BigInt`.
   */
<<<<<<< OLD
  implicit def javaBigInteger2bigInt(x: BigInteger): BigInt = if (x eq null) null else apply(x)
=======
  implicit def javaBigInteger2bigInt(x: BigInteger | Null): BigInt | Null = if (x eq null) null else apply(x)
>>>>>>> NEW

  // this method is adapted from Google Guava's version at
  //   https://github.com/google/guava/blob/master/guava/src/com/google/common/math/LongMath.java
 *
 * It wraps `java.math.BigInteger`, with optimization for small values that can be encoded in a `Long`.
 */
<<<<<<< OLD
final class BigInt private (private var _bigInteger: BigInteger, private val _long: Long)
  extends ScalaNumber
=======
final class BigInt private (
  @annotation.stableNull private var _bigInteger: BigInteger | Null,
  private val _long: Long
) extends ScalaNumber
>>>>>>> NEW
    with ScalaNumericConversions
    with Serializable
    with Ordered[BigInt]
   */
  def compare(that: BigInt): Int =
    if (this.longEncoding) {
<<<<<<< OLD
      if (that.longEncoding) java.lang.Long.compare(this._long, that._long) else -that._bigInteger.signum()
=======
      if (that.longEncoding) java.lang.Long.compare(this._long, that._long) else -that._bigInteger.nn.signum()
>>>>>>> NEW
    } else {
<<<<<<< OLD
      if (that.longEncoding) _bigInteger.signum() else this._bigInteger.compareTo(that._bigInteger)
=======
      if (that.longEncoding) _bigInteger.nn.signum() else this._bigInteger.nn.compareTo(that._bigInteger)
>>>>>>> NEW
    }

  /** Addition of BigInts
      if (that.longEncoding) {
        if (that._long == 0) return this.abs
        // if (that._long == Long.MinValue) return this gcd (-that)
<<<<<<< OLD
        val red = (this._bigInteger mod BigInteger.valueOf(that._long.abs)).longValue()
=======
        val red = (this._bigInteger.nn mod BigInteger.valueOf(that._long.abs)).longValue()
>>>>>>> NEW
        if (red == 0) return that.abs
        BigInt(BigInt.longGcd(that._long.abs, red))
      } else BigInt(this.bigInteger.gcd(that.bigInteger))
   *   +1 if it is greater than 0,
   *   0  if it is equal to 0.
   */
<<<<<<< OLD
  def signum: Int = if (longEncoding) java.lang.Long.signum(_long) else _bigInteger.signum()
=======
  def signum: Int = if (longEncoding) java.lang.Long.signum(_long) else _bigInteger.nn.signum()
>>>>>>> NEW

  /** Returns the sign of this BigInt;
   *   -1 if it is less than 0,
    if (longEncoding) {
      if (_long < 0) 64 - java.lang.Long.numberOfLeadingZeros(-(_long + 1)) // takes care of Long.MinValue
      else 64 - java.lang.Long.numberOfLeadingZeros(_long)
<<<<<<< OLD
    } else _bigInteger.bitLength()
=======
    } else _bigInteger.nn.bitLength()
>>>>>>> NEW

  /** Returns the number of bits in the two's complement representation of this BigInt
   *  that differ from its sign bit.
   *  overall magnitude of the BigInt value as well as return a result with
   *  the opposite sign.
   */
<<<<<<< OLD
  def longValue: Long = if (longEncoding) _long else _bigInteger.longValue
=======
  def longValue: Long = if (longEncoding) _long else _bigInteger.nn.longValue
>>>>>>> NEW

  /** Converts this `BigInt` to a `float`.
   *  If this `BigInt` has too great a magnitude to represent as a float,