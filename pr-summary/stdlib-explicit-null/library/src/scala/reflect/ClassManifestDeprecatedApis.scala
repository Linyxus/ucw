    def loop(left: Set[jClass[_]], seen: Set[jClass[_]]): Boolean = {
      left.nonEmpty && {
        val next = left.head
<<<<<<< OLD
        val supers = next.getInterfaces.toSet ++ Option(next.getSuperclass)
=======
        val supers = next.getInterfaces.nn.toSet ++ Option(next.getSuperclass)
>>>>>>> NEW
        supers(sup) || {
          val xs = left ++ supers filterNot seen
          loop(xs - next, seen + next)

  protected def argString =
    if (typeArguments.nonEmpty) typeArguments.mkString("[", ", ", "]")
<<<<<<< OLD
    else if (runtimeClass.isArray) "["+ClassManifest.fromClass(runtimeClass.getComponentType)+"]"
=======
    else if (runtimeClass.isArray) "["+ClassManifest.fromClass(runtimeClass.getComponentType.nn)+"]"
>>>>>>> NEW
    else ""
}
