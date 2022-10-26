package gamerules

import player.Player

object CardPlayStrategy {
  def getSumCardValues(player: Player): Int = player.totalCardsWithPlayer.map(value => value.cardValue.number).sum

  def isHit(player: Player): Boolean = getSumCardValues(player) < 17

  def isStick(player: Player): Boolean = getSumCardValues(player) >= 17

  def isGoBust(player: Player): Boolean = getSumCardValues(player) > 21
}
