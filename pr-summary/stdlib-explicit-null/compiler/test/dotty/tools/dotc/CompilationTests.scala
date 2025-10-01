    ).checkCompile()

  // Explicit nulls tests
<<<<<<< REMOVED
  @Ignore
>>>>>>> REMOVED
  @Test def explicitNullsNeg: Unit = {
    implicit val testGroup: TestGroup = TestGroup("explicitNullsNeg")
    aggregateTests(
      compileFilesInDir("tests/explicit-nulls/unsafe-common", explicitNullsOptions `and` "-Yno-flexible-types", FileFilter.exclude(TestSources.negExplicitNullsScala2LibraryTastyExcludelisted)),
    ).checkExpectedErrors()

<<<<<<< OLD
    locally {
      val unsafeFile = compileFile("tests/explicit-nulls/flexible-unpickle/neg/Unsafe_1.scala", explicitNullsOptions without "-Yexplicit-nulls")
      val flexibleFile = compileFile("tests/explicit-nulls/flexible-unpickle/neg/Flexible_2.scala",
          explicitNullsOptions.and("-Yflexify-tasty").withClasspath(defaultOutputDir + testGroup + "/Unsafe_1/neg/Unsafe_1"))
=======
    // locally {
    //   val unsafeFile = compileFile("tests/explicit-nulls/flexible-unpickle/neg/Unsafe_1.scala", explicitNullsOptions without "-Yexplicit-nulls")
    //   val flexibleFile = compileFile("tests/explicit-nulls/flexible-unpickle/neg/Flexible_2.scala",
    //       explicitNullsOptions.and("-Yflexify-tasty").withClasspath(defaultOutputDir + testGroup + "/Unsafe_1/neg/Unsafe_1"))
>>>>>>> NEW

<<<<<<< OLD
      flexibleFile.keepOutput.checkExpectedErrors()
=======
    //   unsafeFile.keepOutput.checkCompile()
    //   flexibleFile.keepOutput.checkExpectedErrors()
>>>>>>> NEW

<<<<<<< OLD
      List(unsafeFile, flexibleFile).foreach(_.delete())
    }
=======
    //   List(unsafeFile, flexibleFile).foreach(_.delete())
    // }
>>>>>>> NEW
  }

<<<<<<< REMOVED
  @Ignore
>>>>>>> REMOVED
  @Test def explicitNullsPos: Unit = {
    implicit val testGroup: TestGroup = TestGroup("explicitNullsPos")
    aggregateTests(
      compileFilesInDir("tests/explicit-nulls/unsafe-common", explicitNullsOptions `and` "-language:unsafeNulls" `and` "-Yno-flexible-types"),
    ).checkCompile()

<<<<<<< OLD
    locally {
      val tests = List(
        compileFile("tests/explicit-nulls/flexible-unpickle/pos/Unsafe_1.scala", explicitNullsOptions `without` "-Yexplicit-nulls"),
        compileFile("tests/explicit-nulls/flexible-unpickle/pos/Flexible_2.scala",
        explicitNullsOptions.and("-Yflexify-tasty").withClasspath(defaultOutputDir + testGroup + "/Unsafe_1/pos/Unsafe_1")),
      ).map(_.keepOutput.checkCompile())
=======
    // locally {
    //   val tests = List(
    //     compileFile("tests/explicit-nulls/flexible-unpickle/pos/Unsafe_1.scala", explicitNullsOptions without "-Yexplicit-nulls"),
    //     compileFile("tests/explicit-nulls/flexible-unpickle/pos/Flexible_2.scala",
    //     explicitNullsOptions.and("-Yflexify-tasty").withClasspath(defaultOutputDir + testGroup + "/Unsafe_1/pos/Unsafe_1")),
    //   ).map(_.keepOutput.checkCompile())
>>>>>>> NEW

<<<<<<< OLD
      tests.foreach(_.delete())
    }
=======
    //   tests.foreach(_.delete())
    // }
>>>>>>> NEW
  }

<<<<<<< REMOVED
  @Ignore
>>>>>>> REMOVED
  @Test def explicitNullsWarn: Unit = {
    implicit val testGroup: TestGroup = TestGroup("explicitNullsWarn")
    compileFilesInDir("tests/explicit-nulls/warn", explicitNullsOptions)
  }.checkWarnings()

<<<<<<< REMOVED
  @Ignore
>>>>>>> REMOVED
  @Test def explicitNullsRun: Unit = {
    implicit val testGroup: TestGroup = TestGroup("explicitNullsRun")
    compileFilesInDir("tests/explicit-nulls/run", explicitNullsOptions)