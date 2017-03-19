package todd.jazzQuintet
import org.scalatest._

class BandstandTest extends FunSpec with ShouldMatchers {
  
  def quintet = it
  val jazzCats = new Bandstand(Seq(
      Musician("Paul Chambers", Bass, null),
      Musician("John Coletrane", Saxophone, null),
      Musician("Bill Evans", Piano, null),
      Musician("Miles Davis", Trumpet, null),
      Musician("Jimmy Cobb", Drums, null)
  ))
  
  for (cat <- jazzCats.musicians) {
    cat.bandstand = jazzCats
  }
  
  describe("Quintent band member tests") {
  
    quintet("has the expected five musicians") {
      val instrumentSoloOrder = jazzCats.musicians.map { cat => cat.instrument }; 
      instrumentSoloOrder should be (Seq(
        Trumpet,
        Saxophone,
        Piano,
        Bass,
        Drums
      ))
    }
  
    quintet("has named musicians") {
      val instrumentSoloOrder = jazzCats.musicians.map { cat => cat.name }; 
      instrumentSoloOrder should be (Seq(
        "Miles Davis",
        "John Coletrane",
        "Bill Evans",
        "Paul Chambers",
        "Jimmy Cobb"
      ))
    }
    
    quintet("is not a trio") {
        intercept[IllegalArgumentException] {
          val trio = new Bandstand(Seq(
          Musician("Paul Chambers", Bass, null),
          Musician("John Coletrane", Saxophone, null),
          Musician("Jimmy Cobb", Drums, null)
          ))
        }
    }
    
    quintet("has the proper mix of instruments") {
        intercept[IllegalArgumentException] {
          val saxBand = new Bandstand(Seq(
              Musician("Paul Chambers", Bass, null),
              Musician("John Coletrane", Saxophone, null),
              Musician("Bill Evans", Piano, null),
              Musician("Wayne Shorter", Saxophone, null),
              Musician("Jimmy Cobb", Drums, null)
          ))
        }
    }
    
  } 
  describe("Next soloist tests") {
    
    def nextSoloist = it
    val miles = jazzCats.musicians(0)
    val john = jazzCats.musicians(1)
    val bill = jazzCats.musicians(2)
    val paul = jazzCats.musicians(3)
    val jimmy = jazzCats.musicians(4)
    
    nextSoloist("after Trumpet is Saxophone") {
      miles.nextSoloist.get.instrument should be(Saxophone)
    }
    
    nextSoloist("after Saxophone is Piano") {
      john.nextSoloist.get.instrument should be(Piano)
    }
    
    nextSoloist("after Piano is Bass") {
      bill.nextSoloist.get.instrument should be(Bass)
    }
    
    nextSoloist("after Bass is Drums") {
      paul.nextSoloist.get.instrument should be(Drums)
    }
    
    nextSoloist("Drummer is the last soloist") {
      jimmy.nextSoloist should be(None)
    }
  }
  
}