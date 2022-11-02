package gamerules

import gamerules.CardPlayStrategy.getSumCardValues
import player.Player

import scala.collection.mutable.ListBuffer

object GameOver {
  def isAllPlayerStick(allPlayers: ListBuffer[Player]): Boolean = allPlayers.forall(Player => Player.currentStrategy == "STICK")

  def isAnyPlayerScoreTwentyOne(allPlayers: ListBuffer[Player]): Boolean = allPlayers.exists(Player => getSumCardValues(Player) == 21)

  def isLastPlayerLeftWithNoBurst(allPlayers: ListBuffer[Player]): Boolean = allPlayers.exists(Player => Player.currentStrategy == "HIT") ||
    allPlayers.exists(Player => Player.currentStrategy == "STICK")
}
