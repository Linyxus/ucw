   *  The implementation of `exitValue` interrupts `inputThread`
   *  and then waits until all I/O threads die before returning.
   */
<<<<<<< OLD
  private[process] class SimpleProcess(p: JProcess, inputThread: Thread, outputThreads: List[Thread]) extends Process {
=======
  private[process] class SimpleProcess(p: JProcess, inputThread: Thread | Null, outputThreads: List[Thread]) extends Process {
>>>>>>> NEW
    override def isAlive() = p.isAlive()
    override def exitValue() = {
      try p.waitFor()                   // wait for the process to terminate