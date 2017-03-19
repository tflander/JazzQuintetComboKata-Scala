package todd.jazzQuintet
import org.scalatest._

class MusicianTest extends FunSpec with ShouldMatchers {
  
  val songs = Seq(
      "song a",
      "song b",
      "song c"
  )
  
  val bassist = Musician(songs)
  
  def theMusician = it
  
  describe("song suggestion tests") {
    theMusician("suggests a random song") {
      songs should contain (bassist songSuggestion)
    }
    
    theMusician("eventually suggests every song") {
      val suggestedSongs = (for (a <- 1 to 100) yield bassist songSuggestion)
        .toSet
      suggestedSongs should be(songs.toSet)
    }
    
    theMusician("agrees to play a song he knows") {
      bassist knows "song b" should be(true)
    }
    
    theMusician("does not agree to play a song he doesnt know") {
      bassist knows "smoke on the water" should be(false)
    }
  }
}