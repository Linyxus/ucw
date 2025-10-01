
  private[collection] type Entry = LinkedHashMap.LinkedEntry[K, V]

<<<<<<< OLD
  private[collection] def _firstEntry: Entry = firstEntry
=======
  private[collection] def _firstEntry: Entry | Null = firstEntry
>>>>>>> NEW

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

  /* Uses the same implementation as mutable.HashMap. The hashtable holds the following invariant:
   * - For each i between 0 and table.length, the bucket at table(i) only contains keys whose hash-index is i.
   * - Every bucket is sorted in ascendant hash order
   * - The sum of the lengths of all buckets is equal to contentSize.
   */
<<<<<<< OLD
  private[this] var table = new Array[Entry](tableSizeFor(LinkedHashMap.defaultinitialSize))
=======
  private[this] var table = new Array[Entry | Null](tableSizeFor(LinkedHashMap.defaultinitialSize))
>>>>>>> NEW

  private[this] var threshold: Int = newThreshold(table.length)

  private[this] var contentSize = 0

  override def last: (K, V) =
<<<<<<< OLD
    if (size > 0) (lastEntry.key, lastEntry.value)
=======
    if (size > 0) (lastEntry.nn.key, lastEntry.nn.value)
>>>>>>> NEW
    else throw new NoSuchElementException("Cannot call .last on empty LinkedHashMap")

  override def lastOption: Option[(K, V)] =
<<<<<<< OLD
    if (size > 0) Some((lastEntry.key, lastEntry.value))
=======
    if (size > 0) Some((lastEntry.nn.key, lastEntry.nn.value))
>>>>>>> NEW
    else None

  override def head: (K, V) =
<<<<<<< OLD
    if (size > 0) (firstEntry.key, firstEntry.value)
=======
    if (size > 0) (firstEntry.nn.key, firstEntry.nn.value)
>>>>>>> NEW
    else throw new NoSuchElementException("Cannot call .head on empty LinkedHashMap")

  override def headOption: Option[(K, V)] =
<<<<<<< OLD
    if (size > 0) Some((firstEntry.key, firstEntry.value))
=======
    if (size > 0) Some((firstEntry.nn.key, firstEntry.nn.value))
>>>>>>> NEW
    else None

  override def size = contentSize
    }
  }

<<<<<<< OLD
  private[this] def removeEntry0(elem: K): Entry = removeEntry0(elem, computeHash(elem))
=======
  private[this] def removeEntry0(elem: K): Entry | Null = removeEntry0(elem, computeHash(elem))
>>>>>>> NEW

  /** Removes a key from this map if it exists
   *
   * @param hash the **improved** hashcode of `element` (see computeHash)
   * @return the node that contained element if it was present, otherwise null
   */
<<<<<<< OLD
  private[this] def removeEntry0(elem: K, hash: Int): Entry = {
=======
  private[this] def removeEntry0(elem: K, hash: Int): Entry | Null = {
>>>>>>> NEW
    val idx = index(hash)
    table(idx) match {
      case null => null

  @`inline` private[this] def index(hash: Int) = hash & (table.length - 1)

<<<<<<< OLD
  @`inline` private[this] def findEntry(key: K): Entry = {
=======
  @`inline` private[this] def findEntry(key: K): Entry | Null = {
>>>>>>> NEW
    val hash = computeHash(key)
    table(index(hash)) match {
      case null => null
  }

  private[this] abstract class LinkedHashMapIterator[T] extends AbstractIterator[T] {
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

      val hash = computeHash(key)
      val indexedHash = index(hash)

<<<<<<< OLD
      var foundEntry: Entry = null
      var previousEntry: Entry = null
=======
      var foundEntry: Entry | Null = null
      var previousEntry: Entry | Null = null
>>>>>>> NEW
      table(indexedHash) match {
        case null =>
        case nd =>
          @tailrec
<<<<<<< OLD
          def findEntry(prev: Entry, nd: Entry, k: K, h: Int): Unit = {
=======
          def findEntry(prev: Entry | Null, nd: Entry, k: K, h: Int): Unit = {
>>>>>>> NEW
            if (h == nd.hash && k == nd.key) {
              previousEntry = prev
              foundEntry = nd
            }
            else if ((nd.next eq null) || (nd.hash > h)) ()
<<<<<<< OLD
            else findEntry(nd, nd.next, k, h)
=======
            else findEntry(nd, nd.next.nn, k, h)
>>>>>>> NEW
          }

          findEntry(null, nd, key, hash)
        case (None, None) => // do nothing

        case (Some(_), None) =>
<<<<<<< OLD
          if (previousEntry != null) previousEntry.next = foundEntry.next
          else table(indexedHash) = foundEntry.next
          deleteEntry(foundEntry)
=======
          if (previousEntry != null) previousEntry.nn.next = foundEntry.nn.next
          else table(indexedHash) = foundEntry.nn.next
          deleteEntry(foundEntry.nn)
>>>>>>> NEW
          contentSize -= 1

        case (None, Some(value)) =>
            } else indexedHash
          put0(key, value, getOld = false, hash, newIndexedHash)

<<<<<<< OLD
        case (Some(_), Some(newValue)) => foundEntry.value = newValue
=======
        case (Some(_), Some(newValue)) => foundEntry.nn.value = newValue
>>>>>>> NEW
      }
      nextValue
    }
    val e = new Entry(key, hash, value)
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
  /** Delete the entry from the LinkedHashMap, set the `earlier` and `later` pointers correctly */
  private[this] def deleteEntry(e: Entry): Unit = {
    if (e.earlier eq null) firstEntry = e.later
<<<<<<< OLD
    else e.earlier.later = e.later
=======
    else e.earlier.nn.later = e.later
>>>>>>> NEW
    if (e.later eq null) lastEntry = e.earlier
<<<<<<< OLD
    else e.later.earlier = e.earlier
=======
    else e.later.nn.earlier = e.earlier
>>>>>>> NEW
    e.earlier = null
    e.later = null
    e.next = null
  }

<<<<<<< OLD
  private[this] def put0(key: K, value: V, getOld: Boolean): Some[V] = {
=======
  private[this] def put0(key: K, value: V, getOld: Boolean): Some[V] | Null = {
>>>>>>> NEW
    if (contentSize + 1 >= threshold) growTable(table.length * 2)
    val hash = computeHash(key)
    val idx = index(hash)
    put0(key, value, getOld, hash, idx)
  }

<<<<<<< OLD
  private[this] def put0(key: K, value: V, getOld: Boolean, hash: Int, idx: Int): Some[V] = {
=======
  private[this] def put0(key: K, value: V, getOld: Boolean, hash: Int, idx: Int): Some[V] | Null = {
>>>>>>> NEW
    table(idx) match {
      case null =>
        table(idx) = createNewEntry(key, hash, value)
      case old =>
<<<<<<< OLD
        var prev: Entry = null
        var n = old
=======
        var prev: Entry | Null = null
        var n: Entry | Null = old
>>>>>>> NEW
        while ((n ne null) && n.hash <= hash) {
          if (n.hash == hash && key == n.key) {
            val old = n.value
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
  /** Class for the linked hash map entry, used internally.
    */
  private[mutable] final class LinkedEntry[K, V](val key: K, val hash: Int, var value: V) {
<<<<<<< OLD
    var earlier: LinkedEntry[K, V] = null
    var later: LinkedEntry[K, V] = null
    var next: LinkedEntry[K, V] = null
=======
    var earlier: LinkedEntry[K, V] | Null = null
    var later: LinkedEntry[K, V] | Null = null
    var next: LinkedEntry[K, V] | Null = null
>>>>>>> NEW

    @tailrec
<<<<<<< OLD
    final def findEntry(k: K, h: Int): LinkedEntry[K, V] =
=======
    final def findEntry(k: K, h: Int): LinkedEntry[K, V] | Null =
>>>>>>> NEW
      if (h == hash && k == key) this
      else if ((next eq null) || (hash > h)) null
<<<<<<< OLD
      else next.findEntry(k, h)
=======
      else next.nn.findEntry(k, h)
>>>>>>> NEW
  }

  /** The default load factor for the hash table */