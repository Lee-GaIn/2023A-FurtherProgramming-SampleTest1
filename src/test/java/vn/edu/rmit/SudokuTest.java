package vn.edu.rmit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Lee Gain - s3878170
 */

public class SudokuTest {
  @Test
  public void setGameState() {
    Sudoku s1 = new Sudoku("s1", 1, 1);
    s1.updateState("action1");
    assertEquals("action1", s1.getState());
  }

  @Test
  public void setGameStateEnd() {
    Sudoku s1 = new Sudoku("s1", 1, 1);
    s1.updateState("end");
    assertEquals(true, s1.isEndState());
  }
}
