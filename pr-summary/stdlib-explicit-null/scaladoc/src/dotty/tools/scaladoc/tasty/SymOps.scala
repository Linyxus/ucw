class SymOpsWithLinkCache:
  import SymOps.*

<<<<<<< OLD
  private val externalLinkCache: scala.collection.mutable.Map[AbstractFile, Option[ExternalDocLink]] = MMap()
=======
  private val externalLinkCache: scala.collection.mutable.Map[AbstractFile | Null, Option[ExternalDocLink]] = MMap()
>>>>>>> NEW

  extension (using Quotes)(sym: reflect.Symbol)

              then externalLinkCache(csym.associatedFile)
              else {
                def calculatePath(file: AbstractFile): String = file.underlyingSource.filter(_ != file).fold("")(f => calculatePath(f) + "/") + file.path
<<<<<<< OLD
                val calculatedLink = Option(csym.associatedFile).map(f => calculatePath(f)).flatMap { path =>
=======
                val calculatedLink = Option.fromNullable(csym.associatedFile).map(f => calculatePath(f)).flatMap { path =>
>>>>>>> NEW
                  dctx.externalDocumentationLinks.find(_.originRegexes.exists(r => r.matches(path)))
                }
                externalLinkCache += (csym.associatedFile -> calculatedLink)