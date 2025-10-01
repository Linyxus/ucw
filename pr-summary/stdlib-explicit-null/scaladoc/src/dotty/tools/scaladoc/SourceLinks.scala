        if unsupported.nonEmpty then Left(s"Unsupported patterns from scaladoc format are used: ${unsupported.mkString(" ")}")
        else Right(TemplateSourceLink(supported.foldLeft(string)((template, pattern) =>
          template.replace(pattern, SupportedScalaDocPatternReplacements(pattern)))))
<<<<<<< OLD
      case KnownProvider(name, organization, repo, rawRevision, rawSubPath) =>
        val subPath = Option(rawSubPath).fold("")("/" + _.drop(1))
        val pathRev = Option(rawRevision).map(_.drop(1)).orElse(revision)
=======
      case KnownProvider(name: String, organization: String, repo: String, rawRevision, rawSubPath) =>
        val subPath = Option.fromNullable(rawSubPath).fold("")("/" + _.drop(1))
        val pathRev = Option.fromNullable(rawRevision).map(_.drop(1)).orElse(revision)
>>>>>>> NEW

        def withRevision(template: String => SourceLink) =
          pathRev.fold(Left(s"No revision provided"))(r => Right(template(r)))