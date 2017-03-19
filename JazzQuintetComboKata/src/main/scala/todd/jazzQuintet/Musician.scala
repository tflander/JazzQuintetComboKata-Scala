package todd.jazzQuintet

import java.util.Date
import scala.util.Random

class Musician(val name: String, val instrument: Instrument, songs: Seq[String]) {
  private val random = new Random(new Date().getTime)
  
  def songSuggestion = songs(random.nextInt(songs.size))
  
  def suggestSongIfNoOneElseDoes = {
    val delay = random.nextInt(200) + 100
    Thread.sleep(delay)
    
    // TODO: check for a song suggestion from someone else
    //       if someone else suggests, then return None
    
    Some(songSuggestion)
  }
  
  def knows(song: String) = songs.contains(song)
}

object Musician {
  def apply(name: String, instrument: Instrument, songs: Seq[String]) = new Musician(name, instrument, songs)
}

