package vn.edu.rmit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Lee Gain - s3878170
 */

public class CrosswordTest {
  @Test
  public void setGameState() {
    Crossword c1 = new Crossword("c1", 1, 1);
    c1.updateState("action1");
    assertEquals("action1", c1.getState());
  }

  @Test
  public void setGameStateEnd() {
    Crossword c1 = new Crossword("c1", 1, 1);
    c1.updateState("end");
    assertEquals(true, c1.isEndState());
  }

  @Test
  public void setNoHints() throws Exception {
    Crossword c1 = new Crossword("c1", 1, 1);
    String[] hints = {};
    c1.setHints(hints);

    Exception exception = assertThrows(Exception.class, () -> {
      c1.getHint();
    });

    String expectedMessage = "[Error] Hints have not set yet.";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));

  }

  @Test
  public void setLessThanThreeHints() throws Exception {
    int NUM_OF_EXAMPLES = 5;
    String[] actual = new String[NUM_OF_EXAMPLES];
    String[] expected = { "h1", "h1", "h1", "h1", "h1" };

    Crossword c1 = new Crossword("c1", 1, 1);
    String[] hints = { "h1" };

    c1.setHints(hints);

    for (int i = 0; i < NUM_OF_EXAMPLES; i++) {
      actual[i] = c1.getHint();
    }

    assertArrayEquals(expected, actual);
  }

  @Test
  public void setThreeHints() throws Exception {
    int NUM_OF_EXAMPLES = 5;
    String[] actual = new String[NUM_OF_EXAMPLES];
    String[] expected = { "h1", "h2", "h3", "h1", "h2" };

    Crossword c1 = new Crossword("c1", 1, 1);
    String[] hints = { "h1", "h2", "h3" };

    c1.setHints(hints);

    for (int i = 0; i < NUM_OF_EXAMPLES; i++) {
      actual[i] = c1.getHint();
    }

    assertArrayEquals(expected, actual);
  }

  @Test
  public void setMoreThanThreeHints() {
    Crossword c1 = new Crossword("c1", 1, 1);
    String[] hints = { "h1", "h2", "h3", "h4" };
    Exception exception = assertThrows(Exception.class, () -> {
      c1.setHints(hints);
    });

    String expectedMessage = "You can only set three hints at most.";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test
  public void getEmptyHints() throws Exception {
    Crossword c1 = new Crossword("c1", 1, 1);
    String[] hints = {};
    c1.setHints(hints);
    Exception exception = assertThrows(Exception.class, () -> {
      c1.getHint();
    });

    String expectedMessage = "[Error] Hints have not set yet.";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test
  public void getHintsLessThanThree() throws Exception {
    int NUM_OF_EXAMPLES = 5;
    String[] actual = new String[NUM_OF_EXAMPLES];
    String[] expected = { "h1", "h1", "h1", "h1", "h1" };

    Crossword c1 = new Crossword("c1", 1, 1);
    String[] hints = { "h1" };

    c1.setHints(hints);

    for (int i = 0; i < NUM_OF_EXAMPLES; i++) {
      actual[i] = c1.getHint();
    }

    assertArrayEquals(expected, actual);

  }

  @Test
  public void getHintsThree() throws Exception {
    int NUM_OF_EXAMPLES = 5;
    String[] actual = new String[NUM_OF_EXAMPLES];
    String[] expected = { "h1", "h2", "h3", "h1", "h2" };

    Crossword c1 = new Crossword("c1", 1, 1);
    String[] hints = { "h1", "h2", "h3" };

    c1.setHints(hints);

    for (int i = 0; i < NUM_OF_EXAMPLES; i++) {
      actual[i] = c1.getHint();
    }

    assertArrayEquals(expected, actual);
  }

  @Test
  public void getHintsMoreThanThree() {
    Crossword c1 = new Crossword("c1", 1, 1);
    String[] hints = { "h1", "h2", "h3", "h4" };
    Exception exception = assertThrows(Exception.class, () -> {
      c1.setHints(hints);
    });

    String expectedMessage = "You can only set three hints at most.";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));

  }
}
