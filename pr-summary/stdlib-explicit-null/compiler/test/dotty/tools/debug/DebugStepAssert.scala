      given location: CheckFileLocation = CheckFileLocation(checkFile, allLines.size - lines.size + 1)
      lines match
        case Nil => acc.reverse
<<<<<<< OLD
        case break(className , lineStr) :: tail =>
=======
        case break(className: String, lineStr: String) :: tail =>
>>>>>>> NEW
          val breakpointLine = lineStr.toInt
          val step = DebugStepAssert(Break(className, breakpointLine), checkClassAndLine(className, breakpointLine))
          loop(tail, step :: acc)
<<<<<<< OLD
        case step(pattern) :: tail =>
=======
        case step(pattern: String) :: tail =>
>>>>>>> NEW
          val step = DebugStepAssert(Step, checkLineOrMethod(pattern))
          loop(tail, step :: acc)
<<<<<<< OLD
        case next(pattern) :: tail =>
=======
        case next(pattern: String) :: tail =>
>>>>>>> NEW
          val step = DebugStepAssert(Next, checkLineOrMethod(pattern))
          loop(tail, step :: acc)
<<<<<<< OLD
        case eval(expr) :: tail0 =>
=======
        case eval(expr: String) :: tail0 =>
>>>>>>> NEW
          val (assertion, tail1) = parseEvalAssertion(tail0)
          val step = DebugStepAssert(Eval(expr), assertion)
          loop(tail1, step :: acc)
      lines match
        case Nil => throw new Exception(s"Missing result or error")
        case trailing() :: tail => parseEvalAssertion(tail)
<<<<<<< OLD
        case result(expected) :: tail => (checkResult(expected), tail)
        case error(expected) :: tail => (checkError(Seq(expected)), tail)
=======
        case result(expected: String) :: tail => (checkResult(expected), tail)
        case error(expected: String) :: tail => (checkError(Seq(expected)), tail)
>>>>>>> NEW
        case multiLineError() :: tail0 =>
          val (expected, tail1) = tail0.span(_.startsWith("  "))
          (checkError(expected.map(_.stripPrefix("  "))), tail1)