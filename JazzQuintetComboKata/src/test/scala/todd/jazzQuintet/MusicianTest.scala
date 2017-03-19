package todd.jazzQuintet
import org.scalatest._

class MusicianTest extends FunSpec with ShouldMatchers {
  
  val songs = Seq(
      "song a",
      "song b"
  )
  
  it("suggests random songs") {
    val bassist = Musician(songs)
    songs should contain (bassist.randomSong)
  }
  
  
}