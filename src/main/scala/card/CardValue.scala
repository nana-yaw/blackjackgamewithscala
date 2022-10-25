package card

sealed abstract class CardValue(val number: Int)
object CardValue {
  case object Two extends CardValue(2)
  case object Three extends CardValue(3)
  case object Four extends CardValue(4)
  case object Five extends CardValue(5)
  case object Six extends CardValue(6)
  case object Seven extends CardValue(7)
  case object Eight extends CardValue(8)
  case object Nine extends CardValue(9)
  case object Ten extends CardValue(10)
  case object Jack extends CardValue(10)
  case object Queen extends CardValue(10)
  case object King extends CardValue(10)
  case object Ace extends CardValue(11)
}
