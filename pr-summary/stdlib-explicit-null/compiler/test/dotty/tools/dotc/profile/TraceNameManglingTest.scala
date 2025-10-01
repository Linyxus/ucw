  }

  @Test def escapeBackslashes(): Unit = {
<<<<<<< OLD
    val isWindows = sys.props("os.name").toLowerCase(Locale.ROOT).nn.contains("windows")
=======
    val isWindows = sys.props("os.name").nn.toLowerCase(Locale.ROOT).nn.contains("windows")
>>>>>>> NEW
    // It is not possible to create a file with backslash in name on Windows
    val filename = if isWindows then "test.scala" else "\\.scala"
    checkTraceEvents(