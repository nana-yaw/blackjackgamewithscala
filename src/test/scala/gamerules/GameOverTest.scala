package gamerules

import card.CardValue.{Ace, Jack}
import card.{Diamonds, Spades}
import gamerules.GameOver.{isAllPlayerStick, isAnyPlayerScoreTwentyOne, isLastPlayerLeftWithNoBurst}
import munit.FunSuite
import player.Player
import scala.collection.mutable.ListBuffer

class GameOverTest extends FunSuite {
  val yaw = Player("Yaw")
  val kojo = Player("Kojo")
  val ama = Player("Ama")
  var playersInGame: ListBuffer[Player] = ListBuffer(yaw, kojo, ama)

  override def afterEach(context: AfterEach): Unit = {
    playersInGame.foreach(Player => Player.currentStrategy = "DEFAULT")
    playersInGame.foreach(Player => Player.totalCardsWithPlayer.clear())
    playersInGame = ListBuffer(yaw, kojo, ama)
  }

  test("when all players stick in a round") {
    playersInGame.foreach(Player => Player.currentStrategy = "STICK")
    assertEquals(isAllPlayerStick(playersInGame), true)
  }

  test("when any player hits 21 exactly") {
    playersInGame.last.totalCardsWithPlayer += (Spades(Jack),  Diamonds(Ace))
    assertEquals(isAnyPlayerScoreTwentyOne(playersInGame), true)
  }

  test("when there is only one player left in the game because all others have gone bust") {
    yaw.currentStrategy = "BURST"
    yaw.currentStrategy = "STICK"
    ama.currentStrategy = "BURST"
    assertEquals(isLastPlayerLeftWithNoBurst(playersInGame), true)
  }
}
