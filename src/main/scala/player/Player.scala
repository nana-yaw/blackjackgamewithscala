package player

import card.CardSuit

import scala.collection.mutable.ListBuffer

case class Player(name: String) {
  var currentStrategy: String = "DEFAULT"
  var totalCardsWithPlayer: ListBuffer[CardSuit] = ListBuffer.empty[CardSuit]
  var currentScore: Int = 0
  var currentPosition: Int = 0
}
