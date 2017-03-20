package todd.jazzQuintet
import org.scalatest._
import akka.actor.ActorDSL
import akka.actor.ActorSystem

class MusicianActorTest extends FunSpec with ShouldMatchers {
  
    val out = new java.io.ByteArrayOutputStream
    val songs = Seq(
        "A Night in Tunesia",
        "Well You Needn't",
        "Blue Trane"
    )
    
  it("") {
    
    implicit val system = ActorSystem("MusicianActorTest")
    val bassist = ActorDSL.actor(new MusicianActor("Ralphe Armstrong", Bass, songs, out))
    bassist ! Message(to = Some(AllMusicians), from = None, message = "Let's Jam")
  }
  
}