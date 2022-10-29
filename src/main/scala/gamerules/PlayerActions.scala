package gamerules

import card.CardSuit
import player.Player
import scala.collection.mutable.ListBuffer

object PlayerActions {
  def playHitDealAction(cachedDeck: ListBuffer[CardSuit], player: Player): Unit = {
    player.totalCardsWithPlayer += cachedDeck.head
    cachedDeck.remove(0)
    println("Player hit")
  }

  def playStickDealAction(availablePlayers: ListBuffer[Player], player: Player): Unit = {
    availablePlayers -= player
    availablePlayers += player
    println("Player stick")
  }

  def playGoBurstDealAction(availablePlayers: ListBuffer[Player], player: Player): Unit = {
    availablePlayers -= player
    println("Player go burst")
  }
}
