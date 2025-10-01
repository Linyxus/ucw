  }

  /** See the [[MurmurHash3.caseClassHash(x:Product,caseClassName:String)]] overload */
<<<<<<< OLD
  final def caseClassHash(x: Product, seed: Int, caseClassName: String): Int = {
=======
  final def caseClassHash(x: Product, seed: Int, caseClassName: String | Null): Int = {
>>>>>>> NEW
    val arr = x.productArity
    val aye = (if (caseClassName != null) caseClassName else x.productPrefix).hashCode
    if (arr == 0) aye
   * val res2: Int = -668012062
   * }}}
   */
<<<<<<< OLD
  def caseClassHash(x: Product, caseClassName: String = null): Int = caseClassHash(x, productSeed, caseClassName)
=======
  def caseClassHash(x: Product, caseClassName: String | Null = null): Int = caseClassHash(x, productSeed, caseClassName)
>>>>>>> NEW

  private[scala] def arraySeqHash[@specialized T](a: Array[T]): Int = arrayHash(a, seqSeed)
  private[scala] def tuple2Hash(x: Any, y: Any): Int = tuple2Hash(x.##, y.##, productSeed)