  // when `_head ne Uninitialized`
  //   - `null` if this is an empty lazy list
  //   - `tail: LazyListIterable[A]` otherwise
<<<<<<< OLD
  private[this] var _tail: AnyRef^{this} /* () => LazyListIterable[A] | MidEvaluation.type | LazyListIterable[A] */ =
=======
  private[this] var _tail: AnyRef^{this} | Null /* () => LazyListIterable[A] | MidEvaluation.type | LazyListIterable[A] | Null */ =
>>>>>>> NEW
    if (lazyState eq EmptyMarker) null else lazyState

  private def rawHead: Any = _head
<<<<<<< OLD
  private def rawTail: AnyRef^{this} = _tail
=======
  private def rawTail: AnyRef^{this} | Null = _tail
>>>>>>> NEW

  @inline private def isEvaluated: Boolean = _head.asInstanceOf[AnyRef] ne Uninitialized

    // DO NOT REFERENCE `ll` ANYWHERE ELSE, OR IT WILL LEAK THE HEAD
    var restRef: LazyListIterable[A]^{ll} = ll                          // val restRef = new ObjectRef(ll)
    newLL {
<<<<<<< OLD
      var it: Iterator[B]^{f} = null
=======
      var it: Iterator[B]^{f} | Null = null
>>>>>>> NEW
      var itHasNext = false
      var rest: LazyListIterable[A]^{ll} = restRef           // var rest = restRef.elem
      while (!itHasNext && !rest.isEmpty) {
        }
      }
      if (itHasNext) {
<<<<<<< OLD
        val head = it.next()
=======
        val head = it.nn.next()
>>>>>>> NEW
        rest     = rest.tail
        restRef  = rest                       // restRef.elem = rest
<<<<<<< OLD
        eagerCons(head, newLL(eagerHeadPrependIterator(it)(flatMapImpl(rest, f))))
=======
        eagerCons(head, newLL(eagerHeadPrependIterator(it.nn)(flatMapImpl(rest, f))))
>>>>>>> NEW
      } else Empty
    }
  }