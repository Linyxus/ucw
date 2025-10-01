    cache
  }

<<<<<<< OLD
  def find(receiver: Class[_]): Method = get.find(receiver)
=======
  def find(receiver: Class[_]): Method | Null = get.find(receiver)
>>>>>>> NEW

  def add(receiver: Class[_], m: Method): Method = {
    cache = new SoftReference(get.add(receiver, m))