
  lazy val snippetChecker = dctx.snippetChecker

<<<<<<< OLD
  val qctx: repr.qctx.type = if repr == null then null else repr.qctx // TODO why we do need null?
=======
  val qctx: repr.qctx.type = if repr == null then null.asInstanceOf[repr.qctx.type] else repr.qctx // TODO why we do need null?
>>>>>>> NEW
  val owner: qctx.reflect.Symbol =
    if repr == null then null.asInstanceOf[qctx.reflect.Symbol] else repr.sym
  private given qctx.type = qctx