package todd.jazzQuintet

import java.util.Date
import scala.util.Random

class Musician(songs: Seq[String]) {
  private val random = new Random(new Date().getTime)
  def randomSong = songs(random.nextInt(songs.size))
}

object Musician {
  def apply(songs: Seq[String]) = new Musician(songs)
}