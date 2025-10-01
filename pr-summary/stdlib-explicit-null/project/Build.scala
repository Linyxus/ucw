      "-deprecation",
      "-unchecked",
      //"-Wconf:cat=deprecation&msg=Unsafe:s",    // example usage
<<<<<<< OLD
      "-Werror",
=======
      // "-Werror",
>>>>>>> NEW
      //"-Wunused:all",
      //"-rewrite", // requires -Werror:false since no rewrites are applied with errors
      "-encoding", "UTF8",
      // NOTE: The only difference here is that we drop `-Werror` and semanticDB for now
      Compile / scalacOptions := Seq("-deprecation", "-feature", "-unchecked", "-encoding", "UTF8", "-language:implicitConversions"),
      Compile / scalacOptions += "-Yno-stdlib-patches",
<<<<<<< OLD
      Compile / scalacOptions ++= Seq(
=======
      Compile / scalacOptions += "-Yexplicit-nulls",
      (Compile / scalacOptions) ++= Seq(
>>>>>>> NEW
        // Needed so that the library sources are visible when `dotty.tools.dotc.core.Definitions#init` is called
        "-sourcepath", (Compile / sourceDirectories).value.map(_.getCanonicalPath).distinct.mkString(File.pathSeparator),
      ),
      // NOTE: The only difference here is that we drop `-Werror` and semanticDB for now
      Compile / scalacOptions :=  Seq("-deprecation", "-feature", "-unchecked", "-encoding", "UTF8", "-language:implicitConversions"),
      Compile / scalacOptions += "-Yno-stdlib-patches",
<<<<<<< ADDED
      Compile / scalacOptions += "-Yexplicit-nulls",
>>>>>>> ADDED
      Compile / scalacOptions ++= Seq(
        // Needed so that the library sources are visible when `dotty.tools.dotc.core.Definitions#init` is called
        "-sourcepath", (Compile / sourceDirectories).value.map(_.getCanonicalPath).distinct.mkString(File.pathSeparator),
      // NOTE: The only difference here is that we drop `-Werror` and semanticDB for now
      Compile / scalacOptions :=  Seq("-deprecation", "-feature", "-unchecked", "-encoding", "UTF8", "-language:implicitConversions", "-nowarn"),
      Compile / scalacOptions += "-Yno-stdlib-patches",
<<<<<<< ADDED
      Compile / scalacOptions += "-Yexplicit-nulls",
>>>>>>> ADDED
      Compile / scalacOptions += "-scalajs",
      // Packaging configuration of the stdlib
      Compile / packageBin / publishArtifact := true,
      // NOTE: The only difference here is that we drop `-Werror` and semanticDB for now
      Compile / scalacOptions := Seq("-deprecation", "-feature", "-unchecked", "-encoding", "UTF8", "-language:implicitConversions"),
      // TODO: Enable these flags when the new stdlib is explicitelly null checked
<<<<<<< OLD
      //Compile / scalacOptions ++= Seq("-Yexplicit-nulls", "-Wsafe-init"),
=======
      Compile / scalacOptions ++= Seq("-Yexplicit-nulls", "-Wsafe-init"),
>>>>>>> NEW
      // Make sure that the produced artifacts have the minimum JVM version in the bytecode
      Compile / javacOptions  ++= Seq("--release", Versions.minimumJVMVersion),
      Compile / scalacOptions ++= Seq("--java-output-version", Versions.minimumJVMVersion),
      // NOTE: The only difference here is that we drop `-Werror` and semanticDB for now
      Compile / scalacOptions := Seq("-deprecation", "-feature", "-unchecked", "-encoding", "UTF8", "-language:implicitConversions"),
      // TODO: Enable these flags when the new stdlib is explicitelly null checked
<<<<<<< OLD
      //Compile / scalacOptions ++= Seq("-Yexplicit-nulls", "-Wsafe-init"),
=======
      Compile / scalacOptions ++= Seq("-Yexplicit-nulls", "-Wsafe-init"),
>>>>>>> NEW
      // Make sure that the produced artifacts have the minimum JVM version in the bytecode
      Compile / javacOptions  ++= Seq("--release", Versions.minimumJVMVersion),
      Compile / scalacOptions ++= Seq("--java-output-version", Versions.minimumJVMVersion),
      Compile / scalacOptions := Seq("-deprecation", "-feature", "-unchecked", "-encoding", "UTF8", "-language:implicitConversions"),
      Compile / scalacOptions += "-experimental",
      // TODO: Enable these flags when the new stdlib is explicitelly null checked
<<<<<<< OLD
      //Compile / scalacOptions ++= Seq("-Yexplicit-nulls", "-Wsafe-init"),
=======
      Compile / scalacOptions ++= Seq("-Yexplicit-nulls", "-Wsafe-init"),
>>>>>>> NEW
      // Make sure that the produced artifacts have the minimum JVM version in the bytecode
      Compile / javacOptions  ++= Seq("--release", Versions.minimumJVMVersion),
      Compile / scalacOptions ++= Seq("--java-output-version", Versions.minimumJVMVersion),