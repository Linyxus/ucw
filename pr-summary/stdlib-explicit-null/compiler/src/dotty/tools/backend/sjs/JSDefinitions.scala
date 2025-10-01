    @threadUnsafe lazy val EnumerationClass = requiredClass("scala.Enumeration")
      @threadUnsafe lazy val Enumeration_Value_NoArg = EnumerationClass.requiredValue(nmeValue)
      @threadUnsafe lazy val Enumeration_Value_IntArg = EnumerationClass.requiredMethod(nmeValue, List(defn.IntType))
<<<<<<< OLD
      @threadUnsafe lazy val Enumeration_Value_StringArg = EnumerationClass.requiredMethod(nmeValue, List(defn.StringType))
      @threadUnsafe lazy val Enumeration_Value_IntStringArg = EnumerationClass.requiredMethod(nmeValue, List(defn.IntType, defn.StringType))
=======
      @threadUnsafe lazy val Enumeration_Value_StringArg = EnumerationClass.requiredMethod(nmeValue, List(OrNull(defn.StringType)))
      @threadUnsafe lazy val Enumeration_Value_IntStringArg = EnumerationClass.requiredMethod(nmeValue, List(defn.IntType, OrNull(defn.StringType)))
>>>>>>> NEW
      @threadUnsafe lazy val Enumeration_nextName = EnumerationClass.requiredMethod(termName("nextName"))

    @threadUnsafe lazy val EnumerationValClass = EnumerationClass.requiredClass("Val")
      @threadUnsafe lazy val Enumeration_Val_NoArg = EnumerationValClass.requiredMethod(nme.CONSTRUCTOR, Nil)
      @threadUnsafe lazy val Enumeration_Val_IntArg = EnumerationValClass.requiredMethod(nme.CONSTRUCTOR, List(defn.IntType))
<<<<<<< OLD
      @threadUnsafe lazy val Enumeration_Val_StringArg = EnumerationValClass.requiredMethod(nme.CONSTRUCTOR, List(defn.StringType))
      @threadUnsafe lazy val Enumeration_Val_IntStringArg = EnumerationValClass.requiredMethod(nme.CONSTRUCTOR, List(defn.IntType, defn.StringType))
=======
      @threadUnsafe lazy val Enumeration_Val_StringArg = EnumerationValClass.requiredMethod(nme.CONSTRUCTOR, List(OrNull(defn.StringType)))
      @threadUnsafe lazy val Enumeration_Val_IntStringArg = EnumerationValClass.requiredMethod(nme.CONSTRUCTOR, List(defn.IntType, OrNull(defn.StringType)))
>>>>>>> NEW

    def isValueMethod(sym: Symbol)(using Context): Boolean =
      sym.name == nmeValue && sym.owner == EnumerationClass