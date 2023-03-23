package vn.edu.rmit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Lee Gain - s3878170
 */

public class PuzzleTest {
  @Test
  public void returnValidFormat() {
    String expect = "Name: " + "p1" + ", Difficulty Level: " + 1 + ", Points: " + 1;
    Puzzle p1 = new Puzzle("p1", 1, 1);

    assertEquals(expect, p1.toString());
  }
}
