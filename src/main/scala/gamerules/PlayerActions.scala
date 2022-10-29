package gamerules

import card.CardSuit
import player.Player
import scala.collection.mutable.ListBuffer

object PlayerActions {
  def playHitDealAction(cachedDeck: ListBuffer[CardSuit], player: Player): Unit = {
    player.totalCardsWithPlayer += cachedDeck.head
    cachedDeck.remove(0)
    player.currentStrategy = "HIT"
    println("Player hit")
  }

  def playStickDealAction(availablePlayers: ListBuffer[Player], player: Player): Unit = {
    availablePlayers -= player
    availablePlayers += player
    player.currentStrategy = "STICK"
    println("Player stick")
  }

  def playGoBurstDealAction(availablePlayers: ListBuffer[Player], player: Player): Unit = {
    availablePlayers -= player
    player.currentStrategy = "BURST"
    println("Player go burst")
  }
}
