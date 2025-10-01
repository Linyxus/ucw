
  /*private*/ type Entry = LinkedHashSet.Entry[A]

<<<<<<< OLD
  protected var firstEntry: Entry = null
=======
  @annotation.stableNull
  protected var firstEntry: Entry | Null = null
>>>>>>> NEW

<<<<<<< OLD
  protected var lastEntry: Entry = null
=======
  @annotation.stableNull
  protected var lastEntry: Entry | Null = null
>>>>>>> NEW

  /* Uses the same implementation as mutable.HashSet. The hashtable holds the following invariant:
   * - For each i between 0 and table.length, the bucket at table(i) only contains keys whose hash-index is i.
   * - Every bucket is sorted in ascendant hash order
   * - The sum of the lengths of all buckets is equal to contentSize.
   */
<<<<<<< OLD
  private[this] var table = new Array[Entry](tableSizeFor(LinkedHashSet.defaultinitialSize))
=======
  private[this] var table = new Array[Entry | Null](tableSizeFor(LinkedHashSet.defaultinitialSize))
>>>>>>> NEW

  private[this] var threshold: Int = newThreshold(table.length)

  private[this] var contentSize = 0

  override def last: A =
<<<<<<< OLD
    if (size > 0) lastEntry.key
=======
    if (size > 0) lastEntry.nn.key
>>>>>>> NEW
    else throw new NoSuchElementException("Cannot call .last on empty LinkedHashSet")

  override def lastOption: Option[A] =
<<<<<<< OLD
    if (size > 0) Some(lastEntry.key)
=======
    if (size > 0) Some(lastEntry.nn.key)
>>>>>>> NEW
    else None

  override def head: A =
<<<<<<< OLD
    if (size > 0) firstEntry.key
=======
    if (size > 0) firstEntry.nn.key
>>>>>>> NEW
    else throw new NoSuchElementException("Cannot call .head on empty LinkedHashSet")

  override def headOption: Option[A] =
<<<<<<< OLD
    if (size > 0) Some(firstEntry.key)
=======
    if (size > 0) Some(firstEntry.nn.key)
>>>>>>> NEW
    else None

  override def size: Int = contentSize
  override def remove(elem: A): Boolean = remove0(elem, computeHash(elem))

  private[this] abstract class LinkedHashSetIterator[T] extends AbstractIterator[T] {
<<<<<<< OLD
    private[this] var cur = firstEntry
=======
    private[this] var cur: Entry | Null = firstEntry
>>>>>>> NEW
    def extract(nd: Entry): T
    def hasNext: Boolean = cur ne null
    def next(): T =
<<<<<<< OLD
      if (hasNext) { val r = extract(cur); cur = cur.later; r }
=======
      if (hasNext) { val r = extract(cur.nn); cur = cur.nn.later; r }
>>>>>>> NEW
      else Iterator.empty.next()
  }

  }

  override def foreach[U](f: A => U): Unit = {
<<<<<<< OLD
    var cur = firstEntry
=======
    var cur: Entry | Null = firstEntry
>>>>>>> NEW
    while (cur ne null) {
      f(cur.key)
      cur = cur.later

  @`inline` private[this] def index(hash: Int) = hash & (table.length - 1)

<<<<<<< OLD
  @`inline` private[this] def findEntry(key: A): Entry = {
=======
  @`inline` private[this] def findEntry(key: A): Entry | Null = {
>>>>>>> NEW
    val hash = computeHash(key)
    table(index(hash)) match {
      case null => null
    val e = new Entry(key, hash)
    if (firstEntry eq null) firstEntry = e
    else {
<<<<<<< OLD
      lastEntry.later = e
=======
      lastEntry.nn.later = e
>>>>>>> NEW
      e.earlier = lastEntry
    }
    lastEntry = e
      case null =>
        table(idx) = createNewEntry(elem, hash)
      case old =>
<<<<<<< OLD
        var prev: Entry = null
        var n = old
=======
        var prev: Entry | Null = null
        var n: Entry | Null = old
>>>>>>> NEW
        while ((n ne null) && n.hash <= hash) {
          if (n.hash == hash && elem == n.key) return false
          prev = n
      case nd =>
        // find an element that matches
        var prev = nd
<<<<<<< OLD
        var next = nd.next
=======
        var next: Entry | Null = nd.next
>>>>>>> NEW
        while ((next ne null) && next.hash <= hash) {
          if (next.hash == hash && next.key == elem) {
            prev.next = next.next
      while (oldlen < newlen) {
        var i = 0
        while (i < oldlen) {
<<<<<<< OLD
          val old = table(i)
=======
          val old: Entry | Null = table(i)
>>>>>>> NEW
          if (old ne null) {
            preLow.next = null
            preHigh.next = null
            var lastLow = preLow
            var lastHigh = preHigh
<<<<<<< OLD
            var n = old
=======
            var n: Entry | Null = old
>>>>>>> NEW
            while (n ne null) {
              val next = n.next
              if ((n.hash & oldlen) == 0) { // keep low
  }

  @nowarn("""cat=deprecation&origin=scala\.collection\.Iterable\.stringPrefix""")
<<<<<<< OLD
  override protected[this] def stringPrefix = "LinkedHashSet"
=======
  override protected[this] def stringPrefix: String = "LinkedHashSet"
>>>>>>> NEW
}

/** $factoryInfo
  /** Class for the linked hash set entry, used internally.
   */
  private[mutable] final class Entry[A](val key: A, val hash: Int) {
<<<<<<< OLD
    var earlier: Entry[A] = null
    var later: Entry[A] = null
    var next: Entry[A] = null
=======
    @annotation.stableNull var earlier: Entry[A] | Null = null
    @annotation.stableNull var later: Entry[A] | Null = null
    @annotation.stableNull var next: Entry[A] | Null = null
>>>>>>> NEW

    @tailrec
<<<<<<< OLD
    final def findEntry(k: A, h: Int): Entry[A] =
=======
    final def findEntry(k: A, h: Int): Entry[A] | Null =
>>>>>>> NEW
      if (h == hash && k == key) this
      else if ((next eq null) || (hash > h)) null
      else next.findEntry(k, h)
  /** The default initial capacity for the hash table */
  private[collection] final def defaultinitialSize: Int = 16
}
<<<<<<< REMOVED

>>>>>>> REMOVED