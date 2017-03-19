package todd.jazzQuintet

import java.util.Date
import scala.util.Random

class Musician(songs: Seq[String]) {
  private val random = new Random(new Date().getTime)
  
  def songSuggestion = songs(random.nextInt(songs.size))
  def knows(song: String) = songs.contains(song)
}

object Musician {
  def apply(songs: Seq[String]) = new Musician(songs)
}