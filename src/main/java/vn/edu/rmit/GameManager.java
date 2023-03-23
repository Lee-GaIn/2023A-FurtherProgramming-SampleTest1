package vn.edu.rmit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.HashMap;

/**
 * @author Lee Gain - s3878170
 */

public class GameManager {
  private ArrayList<Crossword> crosswords = new ArrayList<Crossword>();
  private ArrayList<Sudoku> sudokus = new ArrayList<Sudoku>();
  private ArrayList<Trivia> trivias = new ArrayList<Trivia>();

  public void setHints(Puzzle p) throws Exception {
    Scanner sc = new Scanner(System.in);
    String[] hints = { "", "", "" };

    System.out.println("Please type hints. You can set it at most three."
        + "If you want to set it later, please leave it empty"
        + "Only Crossword and Trivia can have a list of hints");

    for (int i = 0; i < hints.length; i++) {
      System.out.printf("\nHint %d: ", i + 1);
      hints[i] = sc.nextLine();

    }

    if (p instanceof Crossword) {
      ((Crossword) p).setHints(hints);
    } else if (p instanceof Trivia) {
      ((Trivia) p).setHints(hints);
    }

    System.out.println("Result");

    if (p instanceof Crossword) {
      for (int i = 0; i < hints.length; i++) {
        System.out.printf("\nHint %d: %s", i + 1, ((Crossword) p).getHint());
      }

    } else if (p instanceof Trivia) {
      for (int i = 0; i < hints.length; i++) {
        System.out.printf("\nHint %d: %s", i + 1, ((Trivia) p).getHint());
      }

    }

  };

  public Puzzle scanHintPuzzleInfo() {
    Puzzle p;
    HashMap<String, String> res;

    res = this.scanSearchInfo();

    p = this.search(res.get("type"),
        res.get("name"));

    if (p == null) {
      System.out.println("No result");
    } else {
      System.out.println("\nResult- " + p);
    }

    return p;
  };

  public Puzzle scanPlayPuzzleInfo() {
    Puzzle p;
    HashMap<String, String> res;

    System.out.println("Please enter the puzzle info you want to play");

    res = this.scanSearchInfo();

    p = this.search(res.get("type"),
        res.get("name"));

    if (p == null) {
      System.out.println("No result");
    } else {
      System.out.println("\nResult- " + p);
    }

    return p;
  };

  public void playPuzzle(Puzzle myPuzzle) throws Exception {
    Scanner sc = new Scanner(System.in);
    boolean hasHints = false;
    String s = "None";

    if (myPuzzle instanceof Crossword ||
        myPuzzle instanceof Trivia) {
      hasHints = true;
    }

    do {
      System.out.println("Please type the status of the game: ");
      myPuzzle.updateState(sc.nextLine());
      System.out.println("Current Status : " + myPuzzle.getState());

      if (myPuzzle.isEndState()) {
        break;
      }

      if (hasHints) {
        System.out.println("Do you want to see a hint (Y/N)? ");
        String ans = sc.nextLine();
        if (ans.equals("Y") || ans.equals("y")) {
          if (myPuzzle instanceof Crossword) {
            s = ((Crossword) myPuzzle).getHint();
          } else if (myPuzzle instanceof Trivia) {
            s = ((Trivia) myPuzzle).getHint();
          }
          System.out.println("Hint : " + s);
        }

      }

    } while (true);

  };

  public HashMap<String, String> scanPuzzleInfo() {
    HashMap<String, String> res = new HashMap<String, String>();
    Scanner scanner = new Scanner(System.in);
    String type, name, diffLev, point;
    boolean isSameName = false;

    System.out.println("[Create a puzzle game]");

    System.out.println("Enter the puzzle game's type: ");
    type = scanner.nextLine();

    do {
      System.out.println("Enter the puzzle game name: ");
      name = scanner.nextLine();
      if (this.search(type, name) == null) {
        isSameName = false;
        break;
      }
      System.out.printf("\n[Error!] We are sorry. The game name '%s' is exist. Please use a different name.\n", name);
      isSameName = true;
    } while (isSameName);

    System.out.println("Enter the puzzle game's difficulty level: ");
    diffLev = scanner.nextLine();

    System.out.println("Enter the puzzle game's points: ");
    point = scanner.nextLine();

    res.put("name", name);
    res.put("type", type);
    res.put("diffLev", diffLev);
    res.put("point", point);

    System.out.println("\nInput - " +
        "name : " + name +
        ", type : " + type +
        ", diffLev : " + diffLev +
        ", point : " + point);

    return res;

  }

  public HashMap<String, String> scanSearchInfo() {
    HashMap<String, String> res = new HashMap<String, String>();
    Scanner scanner = new Scanner(System.in);
    String type, name;

    System.out.println("Enter the puzzle game's type: ");
    type = scanner.nextLine();

    System.out.println("Enter the puzzle game's name: ");
    name = scanner.nextLine();

    res.put("name", name);
    res.put("type", type);

    System.out.println("\nInput - " +
        "name : " + name +
        ", type : " + type);

    return res;

  }

  public HashMap<String, String> scanDisplayInfo() {
    HashMap<String, String> res = new HashMap<String, String>();
    Scanner scanner = new Scanner(System.in);
    String sortField, ascending;

    System.out.println("Enter the sort field: ");
    sortField = scanner.nextLine();

    System.out.println("Do you want to sort a list of games in ascending order?(Y/N): ");
    ascending = scanner.nextLine();

    res.put("sortField", sortField);
    res.put("ascending", ascending);

    System.out.println("\nInput - " +
        "Sort field : " + res.get(sortField) +
        ", Ascending order : " + res.get(ascending));

    return res;

  }

  public Puzzle createPuzzle(String name, int diffLev, int point, String type) {
    Puzzle p = null;
    switch (type.toLowerCase()) {
      case "crossword":
        p = new Crossword(name, diffLev, point);
        crosswords.add((Crossword) p);
        break;
      case "sudoku":
        p = new Sudoku(name, diffLev, point);
        sudokus.add((Sudoku) p);
        break;
      case "trivia":
        p = new Trivia(name, diffLev, point);
        trivias.add((Trivia) p);
        break;
      default:
        // code block
    }

    System.out.println("\nResult - " + p);

    return p;
  };

  public void printMainMenu() {
    System.out.println("====================================="
        + "\n1.Create a game"
        + "\n2.Search a game by name."
        + "\n3.Display all games on the system."
        + "\n4.Play a puzzle."
        + "\n5.Set hints"
        + "\n6.Exit."
        + "\n====================================="
        + "\nPlease enter an option above(1, 2, 3 or 4): ");
  };

  public Puzzle search(String type, String name) {
    Puzzle p = null;
    switch (type.toUpperCase()) {
      case "CROSSWORD":
        for (Puzzle crossword : crosswords) {
          if (crossword.getName().equals(name)) {
            p = crossword;
            break;
          }
        }
        break;
      case "SUDOKU":
        for (Puzzle sudoku : sudokus) {
          if (sudoku.getName().equals(name)) {
            p = sudoku;
            break;
          }
        }
        break;
      case "TRIVIA":
        for (Puzzle trivia : trivias) {
          if (trivia.getName().equals(name)) {
            p = trivia;
            break;
          }
        }
        break;
    }
    return p;
  };

  public Puzzle[] allGames(String sortField) {
    return allGames(sortField, true);
  };

  public Puzzle[] allGames(String sortField, boolean ascending) {
    // The sortField parameter is either: "NAME", "DIFFICULTY", or "POINT"
    ArrayList<Puzzle> allPuzzles = new ArrayList<Puzzle>();
    allPuzzles.addAll(crosswords);
    allPuzzles.addAll(sudokus);
    allPuzzles.addAll(trivias);

    // sort
    switch (sortField.toUpperCase()) {
      case "NAME":
        Collections.sort(allPuzzles,
            Puzzle.PuzzleNameComparator);
        break;
      case "DIFFICULTY":
        Collections.sort(allPuzzles,
            Puzzle.PuzzleDiffLevComparator);
        break;
      case "POINT":
        Collections.sort(allPuzzles,
            Puzzle.PuzzlePointComparator);
        break;
      default:
        return null;
    }

    if (!ascending) {
      Collections.reverse(allPuzzles);
    }

    Puzzle[] ans = new Puzzle[allPuzzles.size()];
    ans = allPuzzles.toArray(ans);
    return ans;
  };

  public static void displayList(Puzzle[] puzzles) {
    System.out.println("Result - \n=====================================");
    for (Puzzle p : puzzles) {
      System.out.println(p);
    }
    System.out.println("=====================================");
  };
};
