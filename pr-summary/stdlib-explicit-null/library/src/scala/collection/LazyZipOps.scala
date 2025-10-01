      def iterator: AbstractIterator[(El1, El2)]^{this, p} = new AbstractIterator[(El1, El2)] {
        private[this] val elems1 = coll1.iterator
        private[this] val elems2 = coll2.iterator
<<<<<<< OLD
        private[this] var _current: (El1, El2) = _
=======
        private[this] var _current: (El1, El2) | Null = _
>>>>>>> NEW
        private def current = {
          while ((_current eq null) && elems1.hasNext && elems2.hasNext) {
            val e1 = elems1.next()
        private[this] val elems1 = coll1.iterator
        private[this] val elems2 = coll2.iterator
        private[this] val elems3 = coll3.iterator
<<<<<<< OLD
        private[this] var _current: (El1, El2, El3) = _
=======
        private[this] var _current: (El1, El2, El3) | Null = _
>>>>>>> NEW
        private def current = {
          while ((_current eq null) && elems1.hasNext && elems2.hasNext && elems3.hasNext) {
            val e1 = elems1.next()
        private[this] val elems2 = coll2.iterator
        private[this] val elems3 = coll3.iterator
        private[this] val elems4 = coll4.iterator
<<<<<<< OLD
        private[this] var _current: (El1, El2, El3, El4) = _
=======
        private[this] var _current: (El1, El2, El3, El4) | Null = _
>>>>>>> NEW
        private def current = {
          while ((_current eq null) && elems1.hasNext && elems2.hasNext && elems3.hasNext && elems4.hasNext) {
            val e1 = elems1.next()