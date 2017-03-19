package todd.jazzQuintet

case class Message(from: Option[Instrument], to: Instrument, message: String)

class MessageHandler(musician: Musician, out: java.io.ByteArrayOutputStream = null) {

  lazy val bandstand = musician.bandstand
  
//  def requestSupply(message: Message) {
//    val supply = hippyCircle.getStonerById(message.to).supply.toString.toLowerCase
//    log(message.from + " requested " + supply + " from " + message.to)
//    sendMessage(to = message.from, "takeSupply")
//  }
//
//  def sendMessage(to: String, message: String) = {
//    hippyCircle.getStonerById(to) ! Message(from = stoner.stonerId, to, message)
//  }

  def log(msg: String) = {
    if (out == null) {
      println(Thread.currentThread().getName() + ": " + msg)
    } else {
      out.write(msg.getBytes)
      out.write('\n')
    }
  }
}