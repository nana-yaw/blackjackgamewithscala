package gamerules

import card.CardValue.{Ace, Jack, Queen, Seven, Six}
import card.{Clubs, Diamonds, Hearts, Spades}
import gamerules.CardPlayStrategy.{getSumCardValues, isGoBust, isHit, isStick}
import munit.FunSuite
import player.Player

class CardPlayStrategyTest extends FunSuite {
  val yaw: Player = Player("Yaw")

  override def afterEach(context: AfterEach): Unit = yaw.totalCardsWithPlayer.clear()

  test("Yaw has zero cards") {
    assertEquals(yaw.totalCardsWithPlayer.size, 0)
  }

  test("when total card value is less than 17 then they hit") {
    yaw.totalCardsWithPlayer += Hearts(Seven)
    yaw.totalCardsWithPlayer += Clubs(Six)
    assertEquals(isHit(yaw), true)
  }

  test("when total card value is greater or equal to 17 then they stick") {
    yaw.totalCardsWithPlayer += Spades(Queen)
    yaw.totalCardsWithPlayer += Diamonds(Jack)
    assertEquals(getSumCardValues(yaw), 20)
    assertEquals(isStick(yaw), true)
  }

  test("when total card value is greater than 21 then they go burst") {
    yaw.totalCardsWithPlayer += Spades(Ace)
    yaw.totalCardsWithPlayer += Diamonds(Ace)
    assertEquals(isGoBust(yaw), true)
  }
}
