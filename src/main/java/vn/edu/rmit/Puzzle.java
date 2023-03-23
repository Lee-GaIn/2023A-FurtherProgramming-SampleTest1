package vn.edu.rmit;

import java.util.Comparator;

/**
 * @author Lee Gain - s3878170
 */

public class Puzzle {
  protected String name;
  protected int diffLev;
  protected int points;
  protected String state;

  // Usage of comparator
  public static Comparator<Puzzle> PuzzleNameComparator = new Comparator<Puzzle>() {
    public int compare(Puzzle p1, Puzzle p2) {
      return p1.name.compareTo(p2.name);
    }
  };

  public static Comparator<Puzzle> PuzzleDiffLevComparator = new Comparator<Puzzle>() {
    public int compare(Puzzle p1, Puzzle p2) {
      return p1.diffLev - p2.diffLev;
    }
  };

  public static Comparator<Puzzle> PuzzlePointComparator = new Comparator<Puzzle>() {
    public int compare(Puzzle p1, Puzzle p2) {
      return p1.points - p2.points;
    }
  };

  public Puzzle(String name, int diffLev, int points) {
    this.name = name;
    this.diffLev = diffLev;
    this.points = points;
  }

  public String getName() {
    return name;
  }

  public int getDiffLev() {
    return diffLev;
  }

  public int getPoints() {
    return points;
  }

  public String getState() {
    return state;
  }

  public void display() {
    // display a game board
  };

  public void updateState(String action) {
    // update the current state of a game with a given user action
  };

  public boolean isEndState() {
    // if the game is finished or not
    return state.equals("end");
  };

  @Override
  public String toString() {
    return "Name: " + name + ", Difficulty Level: " + diffLev + ", Points: " + points;
  }

};
