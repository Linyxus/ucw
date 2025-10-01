  object LocalSymbol:

    def unapply(symbolInfo: SymbolInformation): Option[Int] = symbolInfo.symbol match
<<<<<<< OLD
      case locals(ints) =>
=======
      case locals(ints: String) =>
>>>>>>> NEW
        val bi = BigInt(ints)
        if bi.isValidInt then
          Some(bi.toInt)