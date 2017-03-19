package todd.jazzQuintet

class Bandstand(musiciansIn: Seq[Musician]) {
  require(musiciansIn.size == 5, "Bandstand must be a quintet of 5 musicians.  Found " + musiciansIn.size)
  val musicians = musiciansIn.sortBy { _.instrument.soloOrder }
}