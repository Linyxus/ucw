        }
      }
      evaluated = true
<<<<<<< OLD
      underlying = null
=======
      underlying = nullForGC[SomeSeqOps[A]] // allow GC of unneeded reference
>>>>>>> NEW
      res
    }

    private[this] def elems: SomeSeqOps[A]^{this} = {
<<<<<<< OLD
      val orig: SomeSeqOps[A]^{this} = underlying
      if (evaluated) _sorted else orig
=======
      if (evaluated) _sorted else underlying
>>>>>>> NEW
    }

    def apply(i: Int): A = _sorted.apply(i)