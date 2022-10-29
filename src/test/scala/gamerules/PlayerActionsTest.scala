package gamerules

import card.{CardSuit, Clubs, Diamonds, Hearts, Spades}
import card.CardValue.{Ace, Eight, Jack, King, Seven, Six}
import gamerules.CardActions.dealCardToPlayer
import gamerules.CardPlayStrategy.{isGoBust, isHit, isStick}
import gamerules.PlayerActions.{playGoBurstDealAction, playHitDealAction, playStickDealAction}
import munit.FunSuite
import player.Player
import scala.collection.mutable.ListBuffer

class PlayerActionsTest extends FunSuite {
  var currentDeck: ListBuffer[CardSuit] = ListBuffer(
    Hearts(Six),
    Clubs(Seven),
    Diamonds(Seven),
    Spades(Jack),
    Hearts(Ace),
    Diamonds(Ace),
    Clubs(Eight),
    Spades(King)
  )
  val yaw = Player("Yaw")
  val kojo = Player("Kojo")
  val ama = Player("Ama")
  var playersInGame: ListBuffer[Player] = ListBuffer(yaw, kojo, ama)

  override def beforeEach(context: BeforeEach): Unit = playersInGame.foreach(Player => dealCardToPlayer(currentDeck, Player, 2))

  override def afterEach(context: AfterEach): Unit = {
    playersInGame.foreach(Player => Player.totalCardsWithPlayer.clear())
    currentDeck = ListBuffer(
      Hearts(Six),
      Clubs(Seven),
      Diamonds(Seven),
      Spades(Jack),
      Hearts(Ace),
      Diamonds(Ace),
      Clubs(Eight),
      Spades(King)
    )
    playersInGame = ListBuffer(yaw, kojo, ama)
  }

  test("when the player's total is less than 17, they hit") {
    if(isHit(yaw)){
      playHitDealAction(currentDeck, yaw)
      assertEquals(yaw.totalCardsWithPlayer.size, 3)
    }
  }

  test("when the player's total is 17 or greater, they stick") {
    if(isStick(kojo)){
      playStickDealAction(playersInGame, kojo)
      assertEquals(playersInGame.size, 3)
      assertEquals(playersInGame.last.name == kojo.name, true)
      assertEquals(kojo.totalCardsWithPlayer.size, 2)
    }
  }

  test("when the player's total is greater than 21, they go burst") {
    if(isGoBust(ama)){
      playGoBurstDealAction(playersInGame, ama)
      assertEquals(ama.totalCardsWithPlayer.size, 2)
      assertEquals(playersInGame.size, 2)
      assertEquals(playersInGame.last.name == ama.name, false)
    }
  }
}
