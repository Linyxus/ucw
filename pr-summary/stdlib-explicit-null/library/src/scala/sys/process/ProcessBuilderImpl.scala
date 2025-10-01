      val process = p.start() // start the external process

      // spawn threads that process the input, output, and error streams using the functions defined in `io`
<<<<<<< OLD
      val inThread =
=======
      val inThread: Thread | Null =
>>>>>>> NEW
        if (inherit || (writeInput eq BasicIO.connectNoOp)) null
        else Spawn("Simple-input", daemon = true)(writeInput(process.getOutputStream))
      val outThread = Spawn("Simple-output", daemonizeThreads)(processOutput(process.getInputStream()))