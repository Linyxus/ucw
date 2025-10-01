    def at(g: SpecGroup): Int = descriptor.start(g.ordinal)
    def end(g: SpecGroup): Int = descriptor.end(g.ordinal)
    def offset(g: SpecGroup, i: Int = 0): Int = at(g) + i
<<<<<<< OLD
    def group(g: SpecGroup): Option[String] = Option(descriptor.group(g.ordinal))
=======
    def group(g: SpecGroup): Option[String] =
      // Unable to use @experimental fromNullable now
      Option(descriptor.group(g.ordinal)).asInstanceOf[Option[String]]
>>>>>>> NEW
    def stringOf(g: SpecGroup): String = group(g).getOrElse("")
    def intOf(g: SpecGroup): Option[Int] = group(g).map(_.toInt)
