
  def parse[T](args: Seq[String], projectRoot: Path = Paths.get("").toAbsolutePath())(using parser: ArgParser[T]): ParsingResult[T] = {
    val parsed = args.map {
<<<<<<< OLD
      case PathExtractor(path, arg) => parser.parse(arg).map(elem => Entry(Some(Paths.get(path)), elem))
=======
      case PathExtractor(path: String, arg: String) => parser.parse(arg).map(elem => Entry(Some(Paths.get(path)), elem))
>>>>>>> NEW
      case arg => parser.parse(arg).map(elem => Entry(None, elem))
    }
    val errors = parsed.collect {