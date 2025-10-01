          if e1.isInstanceOf[WildcardType] || e2.isInstanceOf[WildcardType] then WildcardType
          else erasedGlb(e1, e2)
      case OrType(tp1, tp2) =>
<<<<<<< OLD
        if isSymbol && sourceLanguage.isScala2 && ctx.settings.scalajs.value then
=======
        val e1 = this(tp1)
        val e2 = this(tp2)
        val result = if e1.isInstanceOf[WildcardType] || e2.isInstanceOf[WildcardType]
          then WildcardType
          else TypeComparer.orType(e1, e2, isErased = true)
        def isNullStripped =
          tp2.isNullType && e1.derivesFrom(defn.ObjectClass)
          || tp1.isNullType && e2.derivesFrom(defn.ObjectClass)
        if isSymbol && sourceLanguage.isScala2 && ctx.settings.scalajs.value && !isNullStripped then
>>>>>>> NEW
          // In Scala2Unpickler we unpickle Scala.js pseudo-unions as if they were
          // real unions, but we must still erase them as Scala 2 would to emit
          // the correct signatures in SJSIR.
          // impact on overriding relationships so it's best to leave them
          // alone (and this doesn't impact the SJSIR we generate).
          JSDefinitions.jsdefn.PseudoUnionType
<<<<<<< OLD
        else
          val e1 = this(tp1)
          val e2 = this(tp2)
          if e1.isInstanceOf[WildcardType] || e2.isInstanceOf[WildcardType] then WildcardType
          else TypeComparer.orType(e1, e2, isErased = true)
=======
        else result
>>>>>>> NEW
      case tp: MethodType =>
        def paramErasure(tpToErase: Type) =
          erasureFn(sourceLanguage, semiEraseVCs, isConstructor, isSymbol, inSigName = false)(tpToErase)