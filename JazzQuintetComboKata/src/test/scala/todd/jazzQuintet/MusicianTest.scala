package todd.jazzQuintet
import org.scalatest._
import java.util.Date

class MusicianTest extends FunSpec with ShouldMatchers {
  
  val songs = Seq(
      "song a",
      "song b",
      "song c"
  )
  
  val bassist = Musician("Ron Carter", Bass, songs)
  
  def musician = it

  describe("general musician tests") {
    musician("plays an instrument") {
      bassist.instrument should be (Bass)
    }
    
    musician("has a name") {
      bassist.name should be("Ron Carter")
    }
  }
  
  describe("song suggestion tests") {
    
    musician("recalls a random song") {
      songs should contain (bassist songSuggestion)
    }
    
    musician("eventually suggests every song") {
      val suggestedSongs = (for (a <- 1 to 100) yield bassist songSuggestion)
        .toSet
      suggestedSongs should be(songs.toSet)
    }
    
    musician("agrees to play a song he knows") {
      bassist knows "song b" should be(true)
    }
    
    musician("does not agree to play a song he doesnt know") {
      bassist knows "smoke on the water" should be(false)
    }
    
    musician ("waits patiently before suggesting a song") {
      val start = new Date().getTime
      val suggestionOrNot = bassist suggestSongIfNoOneElseDoes
      val elapsed = new Date().getTime - start
      elapsed should (be > 100L and be < 300L)
      songs should contain (suggestionOrNot.get)
    }
    
    // TODO: need test for another musician speaking up before giving a suggestion.
    
    // TODO: think about race conditions
  }
  
  describe("Soloing tests") {
    
    musician("decides how long to solo") {
      bassist.soloLengthInPhrases should (be (1)).or(be (2)).or(be (4))
    }
    
    musician("eventually plays solos of every length") {
      val soloLengths = (for (a <- 1 to 100) yield bassist soloLengthInPhrases)
        .toSet
      soloLengths should be(Set(1, 2, 4))
    }
    
  }
  
  describe("Messaging tests") {
    
    musician("accepts his messages") {
      val message = Message(to = Some(Bass), from = None, message = "foo")
      bassist.processMessage(message)
    }
        
    musician("accepts broadcast messages") {
      val message = Message(to = Some(AllMusicians), from = None, message = "foo")
      bassist.processMessage(message)      
    }
    
    musician("does not get messages intended for others") {
      val message = Message(to = Some(Trumpet), from = None, message = "foo")
      intercept[IllegalArgumentException] {
        bassist.processMessage(message)
      }
    }
    
    musician("does not get messages intended for no one") {
      val message = Message(to = None, from = None, message = "foo")
      intercept[IllegalArgumentException] {
        bassist.processMessage(message)
      }
    }
    
  }

}