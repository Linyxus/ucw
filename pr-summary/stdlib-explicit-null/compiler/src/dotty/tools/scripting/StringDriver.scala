          try
            val classpath = s"${ctx.settings.classpath.value}${pathsep}${sys.props("java.class.path")}"
            val classpathEntries: Seq[Path] = ClassPath.expandPath(classpath, expandStar=true).map { Paths.get(_) }
<<<<<<< OLD
            sys.props("java.class.path") = classpathEntries.map(_.toString).mkString(pathsep)
=======
            sys.props("java.class.path") = classpathEntries.map(_.toString).mkString(pathsep.nn)
>>>>>>> NEW
            detectMainClassAndMethod(outDir, classpathEntries, scalaSource) match
              case Right((mainClass, mainMethod)) =>
                mainMethod.invoke(null, Array.empty[String])