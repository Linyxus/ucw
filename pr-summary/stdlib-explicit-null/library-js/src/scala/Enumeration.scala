  private val vmap: mutable.Map[Int, Value] = new mutable.HashMap

  /** The cache listing all values of this enumeration. */
<<<<<<< OLD
  @transient private var vset: ValueSet = null
=======
  @transient private var vset: ValueSet | Null = null
>>>>>>> NEW
  @transient @volatile private var vsetDefined = false

  /** The mapping from the integer used to identify values to their
      vset = (ValueSet.newBuilder ++= vmap.values).result()
      vsetDefined = true
    }
<<<<<<< OLD
    vset
=======
    vset.nn
>>>>>>> NEW
  }

  /** The integer to use to identify the next created value. */
  /** The string to use to name the next created value. */
  protected var nextName: Iterator[String] = _

<<<<<<< OLD
  private def nextNameOrNull =
=======
  private def nextNameOrNull: String | Null =
>>>>>>> NEW
    if (nextName != null && nextName.hasNext) nextName.next() else null

  /** The highest integer amongst those used to identify values in this
   *  @param name A human-readable name for that value.
   *  @return  Fresh value called `name`.
   */
<<<<<<< OLD
  protected final def Value(name: String): Value = Value(nextId, name)
=======
  protected final def Value(name: String | Null): Value = Value(nextId, name)
>>>>>>> NEW

  /** Creates a fresh value, part of this enumeration, called `name`
   *  and identified by the integer `i`.
   * @param name A human-readable name for that value.
   * @return     Fresh value with the provided identifier `i` and name `name`.
   */
<<<<<<< OLD
  protected final def Value(i: Int, name: String): Value = new Val(i, name)
=======
  protected final def Value(i: Int, name: String | Null): Value = new Val(i, name)
>>>>>>> NEW

  /** The type of the enumerated values. */
  @SerialVersionUID(7091335633555234129L)
   *  identification behaviour.
   */
  @SerialVersionUID(0 - 3501153230598116017L)
<<<<<<< OLD
  protected class Val(i: Int, name: String) extends Value with Serializable {
=======
  protected class Val(i: Int, name: String | Null) extends Value with Serializable {
>>>>>>> NEW
    def this(i: Int)       = this(i, nextNameOrNull)
<<<<<<< OLD
    def this(name: String) = this(nextId, name)
=======
    def this(name: String | Null) = this(nextId, name)
>>>>>>> NEW
    def this()             = this(nextId)

    assert(!vmap.isDefinedAt(i), "Duplicate id: " + i)