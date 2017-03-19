package todd.jazzQuintet
import org.scalatest._

class MusicianTest extends FunSpec with ShouldMatchers {
  
  val songs = Seq(
      "song a",
      "song b",
      "song c"
  )
  
  val bassist = Musician(songs)
  
  describe("song suggestion tests") {
    it("suggests a random song") {
      songs should contain (bassist.randomSong)
    }
    
    it("eventually suggests every song") {
      val suggestedSongs = (for (a <- 1 to 100) yield bassist.randomSong)
        .toSet
      suggestedSongs should be(songs.toSet)
    }
  }
}