    def tryStart(state: ParserState, matchedBlockParser: MatchedBlockParser): BlockStart = {
      val nextNonSpace = state.getNextNonSpaceIndex
      val line = state.getLine
<<<<<<< REMOVED
      var matcher: Matcher = null
>>>>>>> REMOVED
      if state.getIndent < 4 then {
        val trySequence = line.subSequence(nextNonSpace, line.length)
<<<<<<< OLD
        matcher = OPENING_FENCE.matcher(trySequence)
=======
        val matcher = OPENING_FENCE.matcher(trySequence)
>>>>>>> NEW
        if matcher.find then {
          val fenceLength = matcher.group(0).length
          val blockParser =
    val nextNonSpace = state.getNextNonSpaceIndex
    var newIndex = state.getIndex
    val line = state.getLine
<<<<<<< REMOVED
    var matcher: Matcher = null
>>>>>>> REMOVED
    val matches =
      state.getIndent <= 3
      && nextNonSpace < line.length

    if matches then {
      val trySequence = line.subSequence(nextNonSpace, line.length)
<<<<<<< OLD
      matcher = WikiCodeBlockParser.CLOSING_FENCE.matcher(trySequence)
=======
      val matcher = WikiCodeBlockParser.CLOSING_FENCE.matcher(trySequence)
>>>>>>> NEW
      if matcher.find then {
        val foundFenceLength = matcher.group(0).length
        if (foundFenceLength >= fenceLength) { // closing fence - we're at end of line, so we can finalize now
    }
    else block.setContent(content)
    block.setCharsFromContent
<<<<<<< OLD
    content = null
=======
    content = null.asInstanceOf[BlockContent] // release for GC
>>>>>>> NEW
  }
}
