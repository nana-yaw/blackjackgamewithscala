package card

case class Hearts(value: CardValue) extends CardSuit {
  override def cardValue: CardValue = value
}

case class Spades(value: CardValue) extends CardSuit {
  override def cardValue: CardValue = value
}

case class Clubs(value: CardValue) extends CardSuit {
  override def cardValue: CardValue = value
}

case class Diamonds(value: CardValue) extends CardSuit {
  override def cardValue: CardValue = value
}