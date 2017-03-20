package todd.jazzQuintet
import org.scalatest._
import akka.actor.ActorDSL
import akka.actor.ActorSystem

class MusicianActorTest extends FunSpec with ShouldMatchers {
  
  it("") {
    val out = new java.io.ByteArrayOutputStream
    val songs = Seq(
        "A Night in Tunesia",
        "Well You Needn't",
        "Blue Trane"
    )
    
    implicit val system = ActorSystem("demo")
    val bassist = ActorDSL.actor(new MusicianActor("Ralphe Armstrong", Bass, songs, out))
    bassist ! "hello"
  }
  
}