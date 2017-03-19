package todd.jazzQuintet

import java.util.Date
import scala.util.Random

class Musician(songs: Seq[String]) {
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
  def apply(songs: Seq[String]) = new Musician(songs)
}