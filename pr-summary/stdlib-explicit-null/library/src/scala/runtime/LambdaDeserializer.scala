  }

  def deserializeLambdaOrNull(lookup: MethodHandles.Lookup, cache: java.util.Map[String, MethodHandle],
<<<<<<< OLD
                              targetMethodMap: java.util.Map[String, MethodHandle], serialized: SerializedLambda): AnyRef = {
=======
                              targetMethodMap: java.util.Map[String, MethodHandle], serialized: SerializedLambda): AnyRef | Null = {
>>>>>>> NEW
    assert(targetMethodMap != null)
    def slashDot(name: String) = name.replaceAll("/", ".")
    val loader = lookup.lookupClass().getClassLoader
    val implClass = loader.loadClass(slashDot(serialized.getImplClass))
    val key = LambdaDeserialize.nameAndDescriptorKey(serialized.getImplMethodName, serialized.getImplMethodSignature)

<<<<<<< OLD
    def makeCallSite: CallSite = {
=======
    def makeCallSite: CallSite | Null = {
>>>>>>> NEW
      import serialized._
      def parseDescriptor(s: String) =
        MethodType.fromMethodDescriptorString(s, loader)