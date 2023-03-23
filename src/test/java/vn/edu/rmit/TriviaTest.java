package vn.edu.rmit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Lee Gain - s3878170
 */

public class TriviaTest {
  @Test
  public void setGameState() {
    Trivia t1 = new Trivia("t1", 1, 1);
    t1.updateState("action1");
    assertEquals("action1", t1.getState());
  }

  @Test
  public void setGameStateEnd() {
    Trivia t1 = new Trivia("t1", 1, 1);
    t1.updateState("end");
    assertEquals(true, t1.isEndState());
  }

  @Test
  public void setNoHints() throws Exception {
    Trivia t1 = new Trivia("t1", 1, 1);
    String[] hints = {};
    t1.setHints(hints);

    Exception exception = assertThrows(Exception.class, () -> {
      t1.getHint();
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

    Trivia t1 = new Trivia("t1", 1, 1);
    String[] hints = { "h1" };

    t1.setHints(hints);

    for (int i = 0; i < NUM_OF_EXAMPLES; i++) {
      actual[i] = t1.getHint();
    }

    assertArrayEquals(expected, actual);
  }

  @Test
  public void setThreeHints() throws Exception {
    int NUM_OF_EXAMPLES = 5;
    String[] actual = new String[NUM_OF_EXAMPLES];
    String[] expected = { "h1", "h2", "h3", "h1", "h2" };

    Trivia t1 = new Trivia("t1", 1, 1);
    String[] hints = { "h1", "h2", "h3" };

    t1.setHints(hints);

    for (int i = 0; i < NUM_OF_EXAMPLES; i++) {
      actual[i] = t1.getHint();
    }

    assertArrayEquals(expected, actual);
  }

  @Test
  public void setMoreThanThreeHints() {
    Trivia t1 = new Trivia("t1", 1, 1);
    String[] hints = { "h1", "h2", "h3", "h4" };
    Exception exception = assertThrows(Exception.class, () -> {
      t1.setHints(hints);
    });

    String expectedMessage = "You can only set three hints at most.";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test
  public void getEmptyHints() throws Exception {
    Trivia t1 = new Trivia("t1", 1, 1);
    String[] hints = {};
    t1.setHints(hints);
    Exception exception = assertThrows(Exception.class, () -> {
      t1.getHint();
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

    Trivia t1 = new Trivia("t1", 1, 1);
    String[] hints = { "h1" };

    t1.setHints(hints);

    for (int i = 0; i < NUM_OF_EXAMPLES; i++) {
      actual[i] = t1.getHint();
    }

    assertArrayEquals(expected, actual);

  }

  @Test
  public void getHintsThree() throws Exception {
    int NUM_OF_EXAMPLES = 5;
    String[] actual = new String[NUM_OF_EXAMPLES];
    String[] expected = { "h1", "h2", "h3", "h1", "h2" };

    Trivia t1 = new Trivia("t1", 1, 1);
    String[] hints = { "h1", "h2", "h3" };

    t1.setHints(hints);

    for (int i = 0; i < NUM_OF_EXAMPLES; i++) {
      actual[i] = t1.getHint();
    }

    assertArrayEquals(expected, actual);
  }

  @Test
  public void getHintsMoreThanThree() {
    Trivia t1 = new Trivia("t1", 1, 1);
    String[] hints = { "h1", "h2", "h3", "h4" };
    Exception exception = assertThrows(Exception.class, () -> {
      t1.setHints(hints);
    });

    String expectedMessage = "You can only set three hints at most.";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));

  }
}
