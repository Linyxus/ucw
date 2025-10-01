
  // these variables allow configuring the Codec object, and then
  // all decoders and encoders retrieved from it will use these settings.
<<<<<<< OLD
  private[this] var _onMalformedInput: Action         = null
  private[this] var _onUnmappableCharacter: Action    = null
  private[this] var _encodingReplacement: Array[Byte] = null
  private[this] var _decodingReplacement: String      = null
=======
  private[this] var _onMalformedInput: Action | Null         = null
  private[this] var _onUnmappableCharacter: Action | Null    = null
  private[this] var _encodingReplacement: Array[Byte] | Null = null
  private[this] var _decodingReplacement: String | Null      = null
>>>>>>> NEW
  private[this] var _onCodingException: Handler       = e => throw e

  /** The name of the Codec. */
<<<<<<< OLD
  override def toString = name
=======
  override def toString: String = name
>>>>>>> NEW

  // these methods can be chained to configure the variables above
  def onMalformedInput(newAction: Action): this.type              = { _onMalformedInput = newAction ; this }
  def encodingReplaceWith(newReplacement: Array[Byte]): this.type = { _encodingReplacement = newReplacement ; this }
  def onCodingException(handler: Handler): this.type              = { _onCodingException = handler ; this }

<<<<<<< OLD
  def name = charSet.name
=======
  def name: String = charSet.name
>>>>>>> NEW
  def encoder: CharsetEncoder = {
    val enc = charSet.newEncoder()
    if (_onMalformedInput ne null) enc onMalformedInput _onMalformedInput