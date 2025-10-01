private[immutable] final class VectorMapBuilder[K, V] extends mutable.Builder[(K, V), VectorMap[K, V]] {
  private[this] val vectorBuilder = new VectorBuilder[K]
  private[this] val mapBuilder = new MapBuilderImpl[K, (Int, V)]
<<<<<<< OLD
  private[this] var aliased: VectorMap[K, V] = _
=======
  @annotation.stableNull
  private[this] var aliased: VectorMap[K, V] | Null = null
>>>>>>> NEW

  override def clear(): Unit = {
    vectorBuilder.clear()