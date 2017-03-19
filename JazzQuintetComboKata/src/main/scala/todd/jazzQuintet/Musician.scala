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
  
    require(message.to == instrument, "invalid message:to.  Got " + message.to + ", expected " + instrument)

    val hitJointPattern = "hitJoint(\\d+)".r

    message.message match {
//      case "requestSupply" => stonerMessageHander.requestSupply(message)
//      case "takeSupply" => stonerMessageHander.takeSupply(message)
//      case hitJointPattern(tokes) => stonerMessageHander.hitJoint(tokes.toInt, message)
//      case "yourTurnToRoll" => stonerMessageHander.yourTurnToRoll(message)
//      case "roll" => stonerMessageHander.roll(message)
      case unknownMessage => {
        println("ignoring message " + unknownMessage + " from: " + message.from + " to: " + message.to)
      }
    }
  }


}

class MusicianActor(name: String, instrument: Instrument, songs: Seq[String], out: java.io.ByteArrayOutputStream = null) extends Musician(name, instrument, songs, out) with Actor {
  def receive: Actor.Receive = {
    ???
  }  
}


object Musician {
  
  implicit val system = ActorSystem("demo")

//  def apply(name: String, instrument: Instrument, songs: Seq[String]) = ActorDSL.actor(new MusicianActor(name, instrument, songs))
  def apply(name: String, instrument: Instrument, songs: Seq[String]) = new Musician(name, instrument, songs)
}

