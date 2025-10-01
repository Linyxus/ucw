    // * over-allocating -- the resulting array will be exactly the right size
    // * multiple resizing allocations -- the array is allocated one time, not log(n) times.
    var i = nwords - 1
<<<<<<< OLD
    var newArray: Array[Long] = null
=======
    var newArray: Array[Long] | Null = null
>>>>>>> NEW
    while (i >= 0) {
      val w = BitSetOps.computeWordForFilter(pred, isFlipped, word(i), i)
      if (w != 0L) {