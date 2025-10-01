   *  @param  s     The string to match
   *  @return       The matches
   */
<<<<<<< OLD
  def unapplySeq(s: CharSequence): Option[List[String]] = {
=======
  def unapplySeq(s: CharSequence): Option[List[String | Null]] = {
>>>>>>> NEW
    val m = pattern.matcher(s)
    if (runMatcher(m)) Some(List.tabulate(m.groupCount) { i => m.group(i + 1) })
    else None
   *  Otherwise, this Regex is applied to the previously matched input,
   *  and the result of that match is used.
   */
<<<<<<< OLD
  def unapplySeq(m: Match): Option[List[String]] =
=======
  def unapplySeq(m: Match): Option[List[String | Null]] =
>>>>>>> NEW
    if (m.matched == null) None
    else if (m.matcher.pattern == this.pattern) Regex.extractGroupsFromMatch(m)
<<<<<<< OLD
    else unapplySeq(m.matched)
=======
    else unapplySeq(m.matched.nn)
>>>>>>> NEW

  //  @see UnanchoredRegex
  protected def runMatcher(m: Matcher): Boolean = m.matches()
    def end(i: Int): Int

    /** The matched string, or `null` if nothing was matched. */
<<<<<<< OLD
    def matched: String =
=======
    def matched: String | Null =
>>>>>>> NEW
      if (start >= 0) source.subSequence(start, end).toString
      else null

    /** The matched string in group `i`,
     *  or `null` if nothing was matched.
     */
<<<<<<< OLD
    def group(i: Int): String =
=======
    def group(i: Int): String | Null =
>>>>>>> NEW
      if (start(i) >= 0) source.subSequence(start(i), end(i)).toString
      else null

    /** All capturing groups, i.e., not including group(0). */
<<<<<<< OLD
    def subgroups: List[String] = (1 to groupCount).toList map group
=======
    def subgroups: List[String | Null] = (1 to groupCount).toList map group
>>>>>>> NEW

    /** The char sequence before first character of match,
     *  or `null` if nothing was matched.
     */
<<<<<<< OLD
    def before: CharSequence =
=======
    def before: CharSequence | Null =
>>>>>>> NEW
      if (start >= 0) source.subSequence(0, start)
      else null

    /** The char sequence before first character of match in group `i`,
     *  or `null` if nothing was matched for that group.
     */
<<<<<<< OLD
    def before(i: Int): CharSequence =
=======
    def before(i: Int): CharSequence | Null =
>>>>>>> NEW
      if (start(i) >= 0) source.subSequence(0, start(i))
      else null

    /** Returns char sequence after last character of match,
     *  or `null` if nothing was matched.
     */
<<<<<<< OLD
    def after: CharSequence =
=======
    def after: CharSequence | Null =
>>>>>>> NEW
      if (end >= 0) source.subSequence(end, source.length)
      else null

    /** The char sequence after last character of match in group `i`,
     *  or `null` if nothing was matched for that group.
     */
<<<<<<< OLD
    def after(i: Int): CharSequence =
=======
    def after(i: Int): CharSequence | Null =
>>>>>>> NEW
      if (end(i) >= 0) source.subSequence(end(i), source.length)
      else null

     *  @return   The requested group
     *  @throws   IllegalArgumentException if the requested group name is not defined
     */
<<<<<<< OLD
    def group(id: String): String = (
=======
    def group(id: String): String | Null = (
>>>>>>> NEW
      if (groupNamesNowarn.isEmpty)
        matcher group id
      else
    )

    /** The matched string; equivalent to `matched.toString`. */
<<<<<<< OLD
    override def toString: String = matched
=======
    override def toString: String = matched.nn
>>>>>>> NEW
  }

  /** Provides information about a successful match. */
   *
   */
  object Match {
<<<<<<< OLD
    def unapply(m: Match): Some[String] = Some(m.matched)
=======
    def unapply(m: Match): Some[String] = Some(m.matched.nn)
>>>>>>> NEW
  }

  /** An extractor object that yields the groups in the match. Using this extractor
   *  }}}
   */
  object Groups {
<<<<<<< OLD
    def unapplySeq(m: Match): Option[Seq[String]] = {
=======
    def unapplySeq(m: Match): Option[Seq[String | Null]] = {
>>>>>>> NEW
      if (m.groupCount > 0) extractGroupsFromMatch(m) else None
    }
  }

<<<<<<< OLD
  @inline private def extractGroupsFromMatch(m: Match): Option[List[String]] =
=======
  @inline private def extractGroupsFromMatch(m: Match): Option[List[String | Null]] =
>>>>>>> NEW
     Some(List.tabulate(m.groupCount) { i => m.group(i + 1) })

  /** A class to step through a sequence of regex matches.
    }

    // Appends the input prefix and the replacement text.
<<<<<<< OLD
    def replace(replacement: String) = matcher.appendReplacement(sb, replacement)
=======
    def replace(replacement: String): Matcher = matcher.appendReplacement(sb, replacement)
>>>>>>> NEW
  }

  /** Quotes strings to be used literally in regex patterns.