package todd.jazzQuintet
import org.scalatest._

class BandstandTest extends FunSpec with ShouldMatchers {
  
  def quintet = it
  def jazzCats = new Bandstand()
  
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
  
}