package todd.jazzQuintet

sealed abstract class Instrument(val soloOrder: Int)
sealed trait Messageable

case object Trumpet extends Instrument(1) with Messageable
case object Saxophone extends Instrument(2) with Messageable
case object Piano extends Instrument(3) with Messageable
case object Bass extends Instrument(4) with Messageable
case object Drums extends Instrument(5) with Messageable

case object AllMusicians extends Messageable
