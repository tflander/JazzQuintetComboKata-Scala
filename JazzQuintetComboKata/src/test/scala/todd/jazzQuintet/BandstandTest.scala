package todd.jazzQuintet
import org.scalatest._

class BandstandTest extends FunSpec with ShouldMatchers {
  
  def quintet = it
  def jazzCats = new Bandstand(Seq(
      Musician("Paul Chambers", Bass, null),
      Musician("John Coletrane", Saxophone, null),
      Musician("Bill Evans", Piano, null),
      Musician("Miles Davis", Trumpet, null),
      Musician("Jimmy Cobb", Drums, null)
  ))
  
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
  
  // TODO: exception tests for too many, too few, and wrong instrument mix
  
}