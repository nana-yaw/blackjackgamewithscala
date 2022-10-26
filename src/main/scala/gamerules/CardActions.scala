package gamerules

import GameBoard.deck
import card.CardSuit
import gamerules.CardActions.shuffleCard
import player.Player

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer
import scala.util.Random

object CardActions {

  def shuffleCard(deck: ListBuffer[CardSuit]): ListBuffer[CardSuit] = Random.shuffle(deck)

  def getCachedDeck: ListBuffer[CardSuit] = shuffleCard(deck)

  @tailrec
  def dealCardToPlayer(cachedDeck: ListBuffer[CardSuit], player:Player, numberOfCardsToDeal: Int): Any = {
    if(player.totalCardsWithPlayer.size > numberOfCardsToDeal || numberOfCardsToDeal == 0) player
    else {
      player.totalCardsWithPlayer.append(cachedDeck.head)
      cachedDeck.remove(0)
      dealCardToPlayer(cachedDeck, player, numberOfCardsToDeal - 1)
    }
  }
}
