 *  @tparam A     type of the elements contained in this hash table.
 */
// Not used in the standard library, but used in scala-parallel-collections
<<<<<<< OLD
private[collection] trait HashTable[A, B, Entry >: Null <: HashEntry[A, Entry]] extends HashTable.HashUtils[A] {
=======
private[collection] trait HashTable[A, B, Entry <: HashEntry[A, Entry]] extends HashTable.HashUtils[A] {
>>>>>>> NEW
  // Replacing Entry type parameter by abstract type member here allows to not expose to public
  // implementation-specific entry classes such as `DefaultEntry` or `LinkedEntry`.
  // However, I'm afraid it's too late now for such breaking change.

  /** The actual hash table.
   */
<<<<<<< OLD
  protected[collection] var table: Array[HashEntry[A, Entry]] = new Array(initialCapacity)
=======
  protected[collection] var table: Array[HashEntry[A, Entry] | Null] = new Array(initialCapacity)
>>>>>>> NEW

  /** The number of mappings contained in this hash table.
   */

  /** The array keeping track of the number of elements in 32 element blocks.
   */
<<<<<<< OLD
  protected var sizemap: Array[Int] = null
=======
  @annotation.stableNull
  protected var sizemap: Array[Int] | Null = null
>>>>>>> NEW

  protected var seedvalue: Int = tableSizeSeed


  /** Find entry with given key in table, null if not found.
   */
<<<<<<< OLD
  final def findEntry(key: A): Entry =
=======
  final def findEntry(key: A): Entry | Null =
>>>>>>> NEW
    findEntry0(key, index(elemHashCode(key)))

<<<<<<< OLD
  protected[collection] final def findEntry0(key: A, h: Int): Entry = {
    var e = table(h).asInstanceOf[Entry]
=======
  protected[collection] final def findEntry0(key: A, h: Int): Entry | Null = {
    var e = table(h).asInstanceOf[Entry | Null]
>>>>>>> NEW
    while (e != null && !elemEquals(e.key, key)) e = e.next
    e
  }
  }

  protected[collection] final def addEntry0(e: Entry, h: Int): Unit = {
<<<<<<< OLD
    e.next = table(h).asInstanceOf[Entry]
=======
    e.next = table(h).asInstanceOf[Entry | Null]
>>>>>>> NEW
    table(h) = e
    tableSize = tableSize + 1
    nnSizeMapAdd(h)
   *  Returns entry found in table or null.
   *  New entries are created by calling `createNewEntry` method.
   */
<<<<<<< OLD
  def findOrAddEntry(key: A, value: B): Entry = {
=======
  def findOrAddEntry(key: A, value: B): Entry | Null = {
>>>>>>> NEW
    val h = index(elemHashCode(key))
    val e = findEntry0(key, h)
    if (e ne null) e else { addEntry0(createNewEntry(key, value), h); null }

  /** Remove entry from table if present.
   */
<<<<<<< OLD
  final def removeEntry(key: A) : Entry = {
=======
  final def removeEntry(key: A) : Entry | Null = {
>>>>>>> NEW
    removeEntry0(key, index(elemHashCode(key)))
  }
  /** Remove entry from table if present.
   */
<<<<<<< OLD
  private[collection] final def removeEntry0(key: A, h: Int) : Entry = {
    var e = table(h).asInstanceOf[Entry]
=======
  private[collection] final def removeEntry0(key: A, h: Int) : Entry | Null = {
    var e = table(h).asInstanceOf[Entry | Null]
>>>>>>> NEW
    if (e != null) {
      if (elemEquals(e.key, key)) {
        table(h) = e.next
    def hasNext = es != null
    def next() = {
      val res = es
<<<<<<< OLD
      es = es.next
=======
      es = es.nn.next
>>>>>>> NEW
      while (es == null && idx > 0) {
        idx = idx - 1
        es = iterTable(idx)
      while (e != null) {
        val h = index(elemHashCode(e.key))
        val e1 = e.next
<<<<<<< OLD
        e.next = table(h).asInstanceOf[Entry]
=======
        e.next = table(h).asInstanceOf[Entry | Null]
>>>>>>> NEW
        table(h) = e
        e = e1
        nnSizeMapAdd(h)
        }
        tableidx += 1
      }
<<<<<<< OLD
      sizemap(bucketidx) = currbucketsize
=======
      sizemap.nn(bucketidx) = currbucketsize
>>>>>>> NEW
      tableuntil += sizeMapBucketSize
      bucketidx += 1
    }
  }

  private[collection] def printSizeMap() = {
<<<<<<< OLD
    println(sizemap.to(collection.immutable.List))
=======
    println(sizemap.nn.to(collection.immutable.List))
>>>>>>> NEW
  }

  protected final def sizeMapDisable() = sizemap = null
  */
private[collection] trait HashEntry[A, E <: HashEntry[A, E]] {
  val key: A
<<<<<<< OLD
  var next: E = _
=======
  var next: E | Null = _
>>>>>>> NEW
}