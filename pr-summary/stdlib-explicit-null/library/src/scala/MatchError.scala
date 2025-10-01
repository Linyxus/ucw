  /** There's no reason we need to call toString eagerly,
   *  so defer it until getMessage is called or object is serialized
   */
<<<<<<< OLD
  private[this] lazy val objString = {
=======
  private[this] lazy val objString: String = {
>>>>>>> NEW
    def ofClass = "of class " + obj.getClass.getName
    if (obj == null) "null"
    else
    this
  }

<<<<<<< OLD
  override def getMessage() = objString
=======
  override def getMessage(): String = objString
>>>>>>> NEW
}