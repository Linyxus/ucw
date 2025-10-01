  final override def collect[B](pf: PartialFunction[A, B]^): List[B] = {
    if (this eq Nil) Nil else {
      var rest = this
<<<<<<< OLD
      var h: ::[B] = null
=======
      var h: ::[B] | Null = null
>>>>>>> NEW
      var x: Any = null
      // Special case for first element
      while (h eq null) {

  final override def flatMap[B](f: A => IterableOnce[B]^): List[B] = {
    var rest = this
<<<<<<< OLD
    var h: ::[B] = null
    var t: ::[B] = null
=======
    var h: ::[B] | Null = null
    var t: ::[B] | Null = null
>>>>>>> NEW
    while (rest ne Nil) {
      val it = f(rest.head).iterator
      while (it.hasNext) {
    // Note to developers: there exists a duplication between this function and `reflect.internal.util.Collections#map2Conserve`.
    // If any successful optimization attempts or other changes are made, please rehash them there too.
    @tailrec
<<<<<<< OLD
    def loop(mappedHead: List[B], mappedLast: ::[B], unchanged: List[A], pending: List[A]): List[B] = {
=======
    def loop(mappedHead: List[B] | Null, mappedLast: ::[B] | Null, unchanged: List[A], pending: List[A]): List[B] = {
>>>>>>> NEW
      if (pending.isEmpty) {
        if (mappedHead eq null) unchanged
        else {
<<<<<<< OLD
          mappedLast.next = (unchanged: List[B])
=======
          mappedLast.nn.next = (unchanged: List[B])
>>>>>>> NEW
          mappedHead
        }
      }
          loop(mappedHead, mappedLast, unchanged, pending.tail)
        else {
          var xc = unchanged
<<<<<<< OLD
          var mappedHead1: List[B] = mappedHead
          var mappedLast1: ::[B] = mappedLast
=======
          var mappedHead1: List[B] | Null = mappedHead
          var mappedLast1: ::[B] | Null = mappedLast
>>>>>>> NEW
          while (xc ne pending) {
            val next = new ::[B](xc.head, Nil)
            if (mappedHead1 eq null) mappedHead1 = next