package gamerules

import GameBoard.deck
import gamerules.CardActions.{dealCardToPlayer, getCachedDeck, shuffleCard}
import munit.FunSuite
import player.Player

import scala.collection.mutable.ListBuffer

class CardActionsTest extends FunSuite {
    test(" deck should have same size after shuffle") {
        val intialDeckSize = deck.size
        val currentDeckSize = shuffleCard(deck).size
        assertEquals(currentDeckSize, intialDeckSize)
    }

    test("deal only 2 cards to players at game start") {
      // given
      val playersInGame = ListBuffer(Player("Yaw"), Player("Kojo"), Player("Ama"))
      val sizeOfCardsToDeal = 2
      val currentDeck = getCachedDeck
      // when
      playersInGame.foreach(Player => dealCardToPlayer(currentDeck, Player, sizeOfCardsToDeal))
      // then
      playersInGame.foreach(Player => assertEquals(Player.totalCardsWithPlayer.size, 2))
    }
}
