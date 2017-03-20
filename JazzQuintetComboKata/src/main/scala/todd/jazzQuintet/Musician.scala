package todd.jazzQuintet

import java.util.Date
import scala.util.Random
import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.ActorDSL

class Musician(val name: String, val instrument: Instrument, songs: Seq[String], out: java.io.ByteArrayOutputStream = null) {
  private val random = new Random(new Date().getTime)
  
  var bandstand: Bandstand = _
  
  // TODO: TDD
  val messageHandler = new MessageHandler(this, out)

  lazy val nextSoloist: Option[Musician] = {
    val musicians = bandstand.musicians
    val bandSize = musicians.size
    val me = musicians.indexOf(this)
    me + 1 match {
      case `bandSize` => None
      case nextCat => Some(musicians(me + 1))
    }
  }
  
  def songSuggestion = songs(random.nextInt(songs.size))
  
  def suggestSongIfNoOneElseDoes = {
    val delay = random.nextInt(200) + 100
    Thread.sleep(delay)
    
    // TODO: check for a song suggestion from someone else
    //       if someone else suggests, then return None
    
    Some(songSuggestion)
  }
  
  def knows(song: String) = songs.contains(song)
  
  def soloLengthInPhrases = {
    val relativeLength = random.nextInt(3)
    relativeLength match {
      case 2 => 4
      case notMax => notMax + 1 
    }
  }
  
def processMessage(message: Message) = {
  
    require(message.to != None, "This message was not intented to be routed")
    val recipient = message.to.get  
    require(recipient == AllMusicians || recipient.asInstanceOf[Instrument] == instrument, "invalid message:to.  Got " + recipient + ", expected " + instrument)

    message.message match {
      case "callSong" => messageHandler.callSong(message)
      case unknownMessage => {
        println("ignoring message " + unknownMessage + " from: " + message.from + " to: " + message.to)
      }
    }
  }

}

class MusicianActor(name: String, instrument: Instrument, songs: Seq[String], out: java.io.ByteArrayOutputStream = null) extends Musician(name, instrument, songs, out) with Actor {
  def receive: Actor.Receive = {
    case msg: Message => {
      println ("msg = [" + msg.message + "] From " + msg.from + " in thread " + Thread.currentThread.getName)
      msg.message match {
        case "Let's Jam" => println("Jam message")
      }
    }
    case anything => println("received [" + anything +"] of type " + anything.getClass.getName + " in thread " + Thread.currentThread.getName)
  }  
}


object Musician {
  def apply(name: String, instrument: Instrument, songs: Seq[String]) = new Musician(name, instrument, songs)
}

