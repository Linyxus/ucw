    }

    private def manage[A](op: Manager => A): A = {
<<<<<<< OLD
      var toThrow: Throwable = null
=======
      var toThrow: Throwable | Null = null
>>>>>>> NEW
      try {
        op(this)
      } catch {
      } finally {
        closed = true
        var rs = resources
<<<<<<< OLD
        resources = null // allow GC, in case something is holding a reference to `this`
        while (rs.nonEmpty) {
=======
        resources = null.asInstanceOf[List[Resource[_]]] // allow GC, in case something is holding a reference to `this`
        while (rs != null && rs.nonEmpty) {
>>>>>>> NEW
          val resource = rs.head
          rs = rs.tail
          try resource.release()
  def resource[R, A](resource: R)(body: R => A)(implicit releasable: Releasable[R]): A = {
    if (resource == null) throw new NullPointerException("null resource")

<<<<<<< OLD
    var toThrow: Throwable = null
=======
    var toThrow: Throwable | Null = null
>>>>>>> NEW
    try {
      body(resource)
    } catch {