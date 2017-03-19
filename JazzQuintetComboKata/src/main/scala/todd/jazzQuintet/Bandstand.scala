package todd.jazzQuintet

class Bandstand(musiciansIn: Seq[Musician]) {
  validateIsProperQuintet
  val musicians = musiciansIn.sortBy { _.instrument.soloOrder }
  
  def validateIsProperQuintet = {
    require(musiciansIn.size == 5, "Bandstand must be a quintet of 5 musicians.  Found " + musiciansIn.size)
    require(musiciansIn.map (_.instrument).toSet.size == 5)
  }
}

