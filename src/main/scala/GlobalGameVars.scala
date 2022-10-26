import card.{CardSuit, CardValue, Clubs, Diamonds, Hearts, Spades}
import player.Player

import scala.collection.mutable.ListBuffer

package object GameBoard {
  val allDiamonds: ListBuffer[Diamonds] = ListBuffer(
    Diamonds(CardValue.Two),
    Diamonds(CardValue.Three),
    Diamonds(CardValue.Four),
    Diamonds(CardValue.Five),
    Diamonds(CardValue.Six),
    Diamonds(CardValue.Seven),
    Diamonds(CardValue.Eight),
    Diamonds(CardValue.Nine),
    Diamonds(CardValue.Ten),
    Diamonds(CardValue.Jack),
    Diamonds(CardValue.Queen),
    Diamonds(CardValue.King),
    Diamonds(CardValue.Ace)
  )

  val allClubs: ListBuffer[Clubs] = ListBuffer(
    Clubs(CardValue.Two),
    Clubs(CardValue.Three),
    Clubs(CardValue.Four),
    Clubs(CardValue.Five),
    Clubs(CardValue.Six),
    Clubs(CardValue.Seven),
    Clubs(CardValue.Eight),
    Clubs(CardValue.Nine),
    Clubs(CardValue.Ten),
    Clubs(CardValue.Jack),
    Clubs(CardValue.Queen),
    Clubs(CardValue.King),
    Clubs(CardValue.Ace)
  )

  val allHearts: ListBuffer[Hearts] = ListBuffer(
    Hearts(CardValue.Two),
    Hearts(CardValue.Three),
    Hearts(CardValue.Four),
    Hearts(CardValue.Five),
    Hearts(CardValue.Six),
    Hearts(CardValue.Seven),
    Hearts(CardValue.Eight),
    Hearts(CardValue.Nine),
    Hearts(CardValue.Ten),
    Hearts(CardValue.Jack),
    Hearts(CardValue.Queen),
    Hearts(CardValue.King),
    Hearts(CardValue.Ace)
  )

  val allSpades: ListBuffer[Spades] = ListBuffer(
    Spades(CardValue.Two),
    Spades(CardValue.Three),
    Spades(CardValue.Four),
    Spades(CardValue.Five),
    Spades(CardValue.Six),
    Spades(CardValue.Seven),
    Spades(CardValue.Eight),
    Spades(CardValue.Nine),
    Spades(CardValue.Ten),
    Spades(CardValue.Jack),
    Spades(CardValue.Queen),
    Spades(CardValue.King),
    Spades(CardValue.Ace)
  )

  val deck: ListBuffer[CardSuit] = ListBuffer(allHearts, allSpades, allClubs, allDiamonds).flatten

  val numberOfPlayers: ListBuffer[Player] = ListBuffer.empty[Player]
}
