
  class BufferedLineIterator extends AbstractIterator[String] with Iterator[String] {
    private[this] val lineReader = decachedReader
<<<<<<< OLD
    var nextLine: String = null
=======
    var nextLine: String | Null = null
>>>>>>> NEW

    override def hasNext = {
      if (nextLine == null)
    override def next(): String = {
      val result = {
        if (nextLine == null) lineReader.readLine
<<<<<<< OLD
        else try nextLine finally nextLine = null
=======
        else try nextLine.nn finally nextLine = null
>>>>>>> NEW
      }
      if (result == null) Iterator.empty.next()
<<<<<<< OLD
      else result
=======
      else result.nn
>>>>>>> NEW
    }
  }
