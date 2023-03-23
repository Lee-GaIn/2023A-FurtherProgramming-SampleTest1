package vn.edu.rmit;

/**
 * @author Lee Gain - s3878170
 */

public class Trivia extends Puzzle {
  private String[] hints;
  private int numOfCalls = 0;

  public Trivia(String name, int diffLev, int points) {
    super(name, diffLev, points);
  }

  @Override
  public void display() {
    System.out.printf("CROSSWORD - %s - %d - %d", this.name, this.diffLev, this.points);
  };

  @Override
  public void updateState(String action) {
    // update the current state of a game with a given user action
    state = action;
    System.out.printf("TRIVIA - %s", action);
  };

  public void setHints(String[] hints) throws Exception {
    if (hints.length > 3) {
      throw new Exception("[Error] You can only set three hints at most.");
    }
    this.hints = hints;
  };

  public String getHint() throws Exception {
    if (hints.length <= 0) {
      throw new Exception("[Error] Hints have not set yet.");
    }

    int idx = numOfCalls % hints.length;
    numOfCalls++;
    return hints[idx];
  }
}
