  private def wrapImportedSection(snippetLines: Seq[SnippetLine]): Seq[SnippetLine] =
    val mRes = cutBetweenSymbols(importedStartSymbol, importedEndSymbol, snippetLines) {
      case (begin, mid, end) =>
<<<<<<< OLD
        val name = importedRegex.findFirstMatchIn(mid.head.content).fold("")(_.group(1))
=======
        val name = importedRegex.findFirstMatchIn(mid.head.content).fold("")(_.group(1)).nn
>>>>>>> NEW
        begin ++ mid.drop(1).dropRight(1).map(_.withClass("hideable").withClass("include").withAttribute("name", name)) ++ wrapImportedSection(end)
    }
    mRes.getOrElse(snippetLines)