package todd.jazzQuintet

abstract class Instrument(val soloOrder: Int)
case object Trumpet extends Instrument(1)
case object Saxophone extends Instrument(2)
case object Piano extends Instrument(3)
case object Bass extends Instrument(4)
case object Drums extends Instrument(5)