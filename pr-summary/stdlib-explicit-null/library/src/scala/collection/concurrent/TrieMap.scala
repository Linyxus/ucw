import scala.util.Try
import scala.util.hashing.Hashing

<<<<<<< OLD
private[collection] final class INode[K, V](bn: MainNode[K, V], g: Gen, equiv: Equiv[K]) extends INodeBase[K, V](g) {
=======
private[collection] final class INode[K, V](bn: MainNode[K, V] | Null, g: Gen, equiv: Equiv[K]) extends INodeBase[K, V](g) {
>>>>>>> NEW
  import INodeBase._

  WRITE(bn)

  def this(g: Gen, equiv: Equiv[K]) = this(null, g, equiv)

<<<<<<< OLD
  def WRITE(nval: MainNode[K, V]) = INodeBase.updater.set(this, nval)
=======
  def WRITE(nval: MainNode[K, V] | Null) = INodeBase.updater.set(this, nval)
>>>>>>> NEW

  def CAS(old: MainNode[K, V], n: MainNode[K, V]) = INodeBase.updater.compareAndSet(this, old, n)

<<<<<<< OLD
  def gcasRead(ct: TrieMap[K, V]): MainNode[K, V] = GCAS_READ(ct)
=======
  def gcasRead(ct: TrieMap[K, V]): MainNode[K, V] | Null = GCAS_READ(ct)
>>>>>>> NEW

<<<<<<< OLD
  def GCAS_READ(ct: TrieMap[K, V]): MainNode[K, V] = {
=======
  def GCAS_READ(ct: TrieMap[K, V]): MainNode[K, V] | Null = {
>>>>>>> NEW
    val m = /*READ*/mainnode
<<<<<<< OLD
    val prevval = /*READ*/m.prev
=======
    val prevval: MainNode[K, V] | Null = /*READ*/m.prev
>>>>>>> NEW
    if (prevval eq null) m
    else GCAS_Complete(m, ct)
  }

<<<<<<< OLD
  @tailrec private def GCAS_Complete(m: MainNode[K, V], ct: TrieMap[K, V]): MainNode[K, V] = if (m eq null) null else {
=======
  @tailrec private def GCAS_Complete(m: MainNode[K, V] | Null, ct: TrieMap[K, V]): MainNode[K, V] | Null = if (m eq null) null else {
>>>>>>> NEW
    // complete the GCAS
<<<<<<< OLD
    val prev = /*READ*/m.prev
=======
    val prev: MainNode[K, V] | Null = /*READ*/m.prev
>>>>>>> NEW
    val ctr = ct.readRoot(abort = true)

    prev match {
          else GCAS_Complete(m, ct)
        } else {
          // try to abort
<<<<<<< OLD
          m.CAS_PREV(prev, new FailedNode(prev))
=======
          // we know `vn eq prev` and `prev ne null`
          m.CAS_PREV(prev, new FailedNode(vn))
>>>>>>> NEW
          GCAS_Complete(/*READ*/mainnode, ct)
        }
    }
    *
    *  @return        true if successful, false otherwise
    */
<<<<<<< OLD
  @tailrec def rec_insert(k: K, v: V, hc: Int, lev: Int, parent: INode[K, V], startgen: Gen, ct: TrieMap[K, V]): Boolean = {
=======
  @tailrec def rec_insert(k: K, v: V, hc: Int, lev: Int, parent: INode[K, V] | Null, startgen: Gen, ct: TrieMap[K, V]): Boolean = {
>>>>>>> NEW
    val m = GCAS_READ(ct) // use -Yinline!

    m match {
          GCAS(cn, ncnode, ct)
        }
      case tn: TNode[K, V] =>
<<<<<<< OLD
        clean(parent, ct, lev - 5)
=======
        clean(parent.nn, ct, lev - 5)
>>>>>>> NEW
        false
      case ln: LNode[K, V] => // 3) an l-node
        val nn = ln.inserted(k, v)
    *
    *  @return     null if unsuccessful, Option[V] otherwise (indicating previous value bound to the key)
    */
<<<<<<< OLD
  @tailrec def rec_insertif(k: K, v: V, hc: Int, cond: AnyRef, fullEquals: Boolean, lev: Int, parent: INode[K, V], startgen: Gen, ct: TrieMap[K, V]): Option[V] = {
=======
  @tailrec def rec_insertif(k: K, v: V, hc: Int, cond: AnyRef, fullEquals: Boolean, lev: Int, parent: INode[K, V] | Null, startgen: Gen, ct: TrieMap[K, V]): Option[V] | Null = {
>>>>>>> NEW
    val m = GCAS_READ(ct)  // use -Yinline!

    m match {
          case otherv => None
        }
      case sn: TNode[K, V] =>
<<<<<<< OLD
        clean(parent, ct, lev - 5)
=======
        clean(parent.nn, ct, lev - 5)
>>>>>>> NEW
        null
      case ln: LNode[K, V] => // 3) an l-node
        def insertln() = {
    *  @return          NO_SUCH_ELEMENT_SENTINEL if no value has been found, RESTART if the operation wasn't successful,
    *                   or any other value otherwise
    */
<<<<<<< OLD
  @tailrec def rec_lookup(k: K, hc: Int, lev: Int, parent: INode[K, V], startgen: Gen, ct: TrieMap[K, V]): AnyRef = {
=======
  @tailrec def rec_lookup(k: K, hc: Int, lev: Int, parent: INode[K, V] | Null, startgen: Gen, ct: TrieMap[K, V]): AnyRef = {
>>>>>>> NEW
    val m = GCAS_READ(ct) // use -Yinline!

    m match {
        }
      case tn: TNode[_, _] => // 3) non-live node
        def cleanReadOnly(tn: TNode[K, V]) = if (ct.nonReadOnly) {
<<<<<<< OLD
          clean(parent, ct, lev - 5)
=======
          clean(parent.nn, ct, lev - 5)
>>>>>>> NEW
          RESTART
        } else {
          if (tn.hc == hc && tn.k == k) tn.v.asInstanceOf[AnyRef]
    removalPolicy: Int,
    hc: Int,
    lev: Int,
<<<<<<< OLD
    parent: INode[K, V],
=======
    parent: INode[K, V] | Null,
>>>>>>> NEW
    startgen: Gen,
<<<<<<< OLD
    ct: TrieMap[K, V]): Option[V] = {
=======
    ct: TrieMap[K, V]): Option[V] | Null = {
>>>>>>> NEW

    GCAS_READ(ct) match {
      case cn: CNode[K, V] =>

          if (res == None || (res eq null)) res
          else {
<<<<<<< OLD
            @tailrec def cleanParent(nonlive: AnyRef): Unit = {
              val cn = parent.GCAS_READ(ct)
=======
            @tailrec def cleanParent(nonlive: AnyRef | Null): Unit = {
              val cn = parent.nn.GCAS_READ(ct)
>>>>>>> NEW
              cn match {
                case cn: CNode[K, V] =>
                  val idx = (hc >>> (lev - 5)) & 0x1f
                    if (sub eq this) (nonlive: @uc) match {
                      case tn: TNode[K, V] @uc =>
                        val ncn = cn.updatedAt(pos, tn.copyUntombed, gen).toContracted(lev - 5)
<<<<<<< OLD
                        if (!parent.GCAS(cn, ncn, ct))
=======
                        if (!parent.nn.GCAS(cn, ncn, ct))
>>>>>>> NEW
                          if (ct.readRoot().gen == startgen) cleanParent(nonlive)
                    }
                  }
          }
        }
      case tn: TNode[K, V] =>
<<<<<<< OLD
        clean(parent, ct, lev - 5)
=======
        clean(parent.nn, ct, lev - 5)
>>>>>>> NEW
        null
      case ln: LNode[K, V] =>
        if (removalPolicy == RemovalPolicy.Always) {
  def isNullInode(ct: TrieMap[K, V]) = GCAS_READ(ct) eq null

  def cachedSize(ct: TrieMap[K, V]): Int =
<<<<<<< OLD
    GCAS_READ(ct).cachedSize(ct)
=======
    GCAS_READ(ct).nn.cachedSize(ct)
>>>>>>> NEW

  def knownSize(ct: TrieMap[K, V]): Int =
<<<<<<< OLD
    GCAS_READ(ct).knownSize()
=======
    GCAS_READ(ct).nn.knownSize()
>>>>>>> NEW

  /* this is a quiescent method! */
<<<<<<< OLD
  def string(lev: Int) = "%sINode -> %s".format("  " * lev, mainnode match {
=======
  def string(lev: Int): String = "%sINode -> %s".format("  " * lev, mainnode match {
>>>>>>> NEW
    case null => "<null>"
    case tn: TNode[_, _] => "TNode(%s, %s, %d, !)".format(tn.k, tn.v, tn.hc)
    case cn: CNode[_, _] => cn.string(lev)

  def knownSize: Int = throw new UnsupportedOperationException

<<<<<<< OLD
  override def toString = "FailedNode(%s)".format(p)
=======
  override def toString: String = "FailedNode(%s)".format(p)
>>>>>>> NEW
}


  def copyTombed = new TNode(k, v, hc)
  def copyUntombed = new SNode(k, v, hc)
  def kvPair = (k, v)
<<<<<<< OLD
  def string(lev: Int) = ("  " * lev) + "SNode(%s, %s, %x)".format(k, v, hc)
=======
  def string(lev: Int): String = ("  " * lev) + "SNode(%s, %s, %x)".format(k, v, hc)
>>>>>>> NEW
}

// Tomb Node, used to ensure proper ordering during removals
  def kvPair = (k, v)
  def cachedSize(ct: AnyRef): Int = 1
  def knownSize: Int = 1
<<<<<<< OLD
  def string(lev: Int) = ("  " * lev) + "TNode(%s, %s, %x, !)".format(k, v, hc)
=======
  def string(lev: Int): String = ("  " * lev) + "TNode(%s, %s, %x, !)".format(k, v, hc)
>>>>>>> NEW
}

// List Node, leaf node that handles hash collisions

  def knownSize: Int = -1 // shouldn't ever be empty, and the size of a list is not known

<<<<<<< OLD
  def string(lev: Int) = (" " * lev) + "LNode(%s)".format(entries.mkString(", "))
=======
  def string(lev: Int): String = (" " * lev) + "LNode(%s)".format(entries.mkString(", "))
>>>>>>> NEW

}

}


<<<<<<< OLD
private[concurrent] case class RDCSS_Descriptor[K, V](old: INode[K, V], expectedmain: MainNode[K, V], nv: INode[K, V]) {
=======
private[concurrent] case class RDCSS_Descriptor[K, V](old: INode[K, V], expectedmain: MainNode[K, V] | Null, nv: INode[K, V]) {
>>>>>>> NEW
  @volatile var committed = false
}

  *  For details, see: [[http://lampwww.epfl.ch/~prokopec/ctries-snapshot.pdf]]
  */
@SerialVersionUID(-5212455458703321708L)
<<<<<<< OLD
final class TrieMap[K, V] private (r: AnyRef, rtupd: AtomicReferenceFieldUpdater[TrieMap[K, V], AnyRef], hashf: Hashing[K], ef: Equiv[K])
=======
final class TrieMap[K, V] private (r: AnyRef, rtupd: AtomicReferenceFieldUpdater[TrieMap[K, V], AnyRef] | Null, hashf: Hashing[K], ef: Equiv[K])
>>>>>>> NEW
  extends scala.collection.mutable.AbstractMap[K, V]
    with scala.collection.concurrent.Map[K, V]
    with scala.collection.mutable.MapOps[K, V, TrieMap, TrieMap[K, V]]
  private[this] var hashingobj = if (hashf.isInstanceOf[Hashing.Default[_]]) new TrieMap.MangledHashing[K] else hashf
  private[this] var equalityobj = ef
  @transient
<<<<<<< OLD
  private[this] var rootupdater = rtupd
=======
  private[this] var rootupdater: AtomicReferenceFieldUpdater[TrieMap[K, V], AnyRef] | Null = rtupd
>>>>>>> NEW
  def hashing = hashingobj
  def equality = equalityobj
  @volatile private var root = r
    }
  }

<<<<<<< OLD
  private def CAS_ROOT(ov: AnyRef, nv: AnyRef) = rootupdater.compareAndSet(this, ov, nv)
=======
  private def CAS_ROOT(ov: AnyRef, nv: AnyRef) = rootupdater.nn.compareAndSet(this, ov, nv)
>>>>>>> NEW

  private[collection] def readRoot(abort: Boolean = false): INode[K, V] = RDCSS_READ_ROOT(abort)

    }
  }

<<<<<<< OLD
  private def RDCSS_ROOT(ov: INode[K, V], expectedmain: MainNode[K, V], nv: INode[K, V]): Boolean = {
=======
  private def RDCSS_ROOT(ov: INode[K, V], expectedmain: MainNode[K, V] | Null, nv: INode[K, V]): Boolean = {
>>>>>>> NEW
    val desc = RDCSS_Descriptor(ov, expectedmain, nv)
    if (CAS_ROOT(ov, desc)) {
      RDCSS_Complete(abort = false)
  }


<<<<<<< OLD
  def string = RDCSS_READ_ROOT().string(0)
=======
  def string: String = RDCSS_READ_ROOT().string(0)
>>>>>>> NEW

  /* public methods */

  private val stack = new Array[Array[BasicNode]](7)
  private val stackpos = new Array[Int](7)
  private var depth = -1
<<<<<<< OLD
  private var subiter: Iterator[(K, V)] = null
  private var current: KVNode[K, V] = null
=======
  @annotation.stableNull private var subiter: Iterator[(K, V)] | Null = null
  @annotation.stableNull private var current: KVNode[K, V] | Null = null
>>>>>>> NEW

  if (mustInit) initialize()

  def hasNext = (current ne null) || (subiter ne null)

<<<<<<< OLD
  def next() = if (hasNext) {
    var r: (K, V) = null
=======
  def next(): (K, V) = {
>>>>>>> NEW
    if (subiter ne null) {
<<<<<<< OLD
      r = subiter.next()
=======
      val r = subiter.next()
>>>>>>> NEW
      checkSubiter()
<<<<<<< OLD
    } else {
      r = current.kvPair
=======
      r
    } else if (current ne null) {
      val r = current.kvPair
>>>>>>> NEW
      advance()
<<<<<<< OLD
    }
    r
  } else Iterator.empty.next()
=======
      r
    } else Iterator.empty.next()
  }
>>>>>>> NEW

  private def readin(in: INode[K, V]) = in.gcasRead(ct) match {
    case cn: CNode[K, V] =>
    case mainNode => throw new MatchError(mainNode)
  }

<<<<<<< OLD
  private def checkSubiter() = if (!subiter.hasNext) {
=======
  private def checkSubiter() = if (!subiter.nn.hasNext) {
>>>>>>> NEW
    subiter = null
    advance()
  }