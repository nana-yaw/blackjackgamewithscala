package gamerules

import gamerules.CardPlayStrategy.getSumCardValues
import player.Player

import scala.collection.mutable.ListBuffer

object GameOver {
  def isAllPlayerStick(allPlayers: ListBuffer[Player]): Boolean = allPlayers.forall(Player => Player.currentStrategy == "STICK")

  def isPlayerScoreTwentyOne(player: Player): Boolean = getSumCardValues(player) == 21

  def isLastPlayerLeft(player: Player): Boolean = player.currentStrategy == "HIT" || player.currentStrategy == "STICK"
}
