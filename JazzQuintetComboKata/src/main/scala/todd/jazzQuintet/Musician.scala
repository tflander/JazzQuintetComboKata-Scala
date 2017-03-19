package todd.jazzQuintet

class Musician(songs: Seq[String]) {
  def randomSong = songs.head
}

object Musician {
  def apply(songs: Seq[String]) = new Musician(songs)
}