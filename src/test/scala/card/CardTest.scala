package card

import munit.FunSuite

class CardTest extends FunSuite {
  test("Total number of each card type should be 13") {
    assertEquals(GameBoard.allDiamonds.size, 13)
    assertEquals(GameBoard.allClubs.size, 13)
    assertEquals(GameBoard.allSpades.size, 13)
    assertEquals(GameBoard.allHearts.size, 13)
  }
}
