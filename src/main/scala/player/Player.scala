package player

import card.CardSuit

import scala.collection.mutable.ListBuffer

case class Player(name: String) {
  var totalCardsWithPlayer: ListBuffer[CardSuit] = ListBuffer.empty[CardSuit]
}
