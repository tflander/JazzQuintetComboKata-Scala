package todd.jazzQuintet

import java.util.Date
import scala.util.Random

class Musician(val name: String, val instrument: Instrument, songs: Seq[String]) {
  private val random = new Random(new Date().getTime)
  
  var bandstand: Bandstand = _

  lazy val nextSoloist: Option[Musician] = {
    val musicians = bandstand.musicians
    val bandSize = musicians.size
    val me = musicians.indexOf(this)
    me + 1 match {
      case `bandSize` => None
      case nextCat => Some(musicians(me + 1))
    }
  }
  
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

