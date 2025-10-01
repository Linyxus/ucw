
    def p_size0 = size0
    def p_size0_=(s: Int) = size0 = s
<<<<<<< OLD
    def p_array = array
=======
    def p_array: Array[AnyRef | Null] = array.asInstanceOf[Array[AnyRef | Null]]
>>>>>>> NEW
    def p_ensureSize(n: Int) = super.ensureSize(n)
    def p_ensureAdditionalSize(n: Int) = super.ensureSize(size0 + n)
    def p_swap(a: Int, b: Int): Unit = {

  def result() = this

<<<<<<< OLD
  private def toA(x: AnyRef): A = x.asInstanceOf[A]
  protected def fixUp(as: Array[AnyRef], m: Int): Unit = {
=======
  private def toA(x: AnyRef | Null): A = x.asInstanceOf[A]
  protected def fixUp(as: Array[AnyRef | Null], m: Int): Unit = {
>>>>>>> NEW
    var k: Int = m
    // use `ord` directly to avoid allocating `OrderingOps`
    while (k > 1 && ord.lt(toA(as(k / 2)), toA(as(k)))) {
    }
  }

<<<<<<< OLD
  protected def fixDown(as: Array[AnyRef], m: Int, n: Int): Boolean = {
=======
  protected def fixDown(as: Array[AnyRef | Null], m: Int, n: Int): Boolean = {
>>>>>>> NEW
    // returns true if any swaps were done (used in heapify)
    var k: Int = m
    while (n >= 2 * k) {