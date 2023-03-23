package vn.edu.rmit;

/**
 * @author Lee Gain - s3878170
 */

public class Sudoku extends Puzzle {

  public Sudoku(String name, int diffLev, int points) {
    super(name, diffLev, points);
  }

  @Override
  public void display() {
    System.out.printf("TRIVIA - %s - %d - %d", this.name, this.diffLev, this.points);
  };

  @Override
  public void updateState(String action) {
    // update the current state of a game with a given user action
    state = action;
    System.out.printf("SUDOKU - %s", action);
  };

}
