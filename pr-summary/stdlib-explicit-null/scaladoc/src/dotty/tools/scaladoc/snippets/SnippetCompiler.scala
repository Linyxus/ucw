
  private def newRun(using ctx: Context): Run = scala3Compiler.newRun

<<<<<<< OLD
  private def nullableMessage(msgOrNull: String): String =
=======
  private def nullableMessage(msgOrNull: String | Null): String =
>>>>>>> NEW
    if (msgOrNull == null) "" else msgOrNull

  private def createReportMessage(wrappedSnippet: WrappedSnippet, arg: SnippetCompilerArg, diagnostics: Seq[Diagnostic], sourceFile: SourceFile): Seq[SnippetCompilerMessage] = {