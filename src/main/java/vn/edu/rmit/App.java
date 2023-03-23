package vn.edu.rmit;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Lee Gain - s3878170
 */
public final class App {
    public static void main(String[] args) {
        GameManager gm = new GameManager();
        Scanner scanner = new Scanner(System.in);
        Puzzle p = null;
        HashMap<String, String> res;
        Boolean isExit = false;

        do {
            gm.printMainMenu();
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    // create a game
                    res = gm.scanPuzzleInfo();
                    p = gm.createPuzzle(res.get("name"),
                            Integer.parseInt(res.get("diffLev")),
                            Integer.parseInt(res.get("point")),
                            res.get("type"));
                    System.out.println("\nResult- " + p);

                    break;

                case 2:
                    // search a game by name
                    res = gm.scanSearchInfo();
                    p = gm.search(res.get("type"),
                            res.get("name"));

                    if (p == null) {
                        System.out.println("No result");
                    } else {
                        System.out.println("\nResult- " + p);
                    }
                    break;

                case 3:
                    // display all games on the system
                    Puzzle[] puzzles;
                    res = gm.scanDisplayInfo();

                    if (res.get("ascending").equals("Y") ||
                            res.get("ascending").equals("y")) {
                        puzzles = gm.allGames(res.get("sortField"),
                                true);
                    } else {
                        puzzles = gm.allGames(res.get("sortField"),
                                false);
                    }

                    GameManager.displayList(puzzles);
                    break;

                case 4:
                    try {
                        p = gm.scanPlayPuzzleInfo();
                        gm.playPuzzle(p);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    try {
                        p = gm.scanHintPuzzleInfo();
                        gm.setHints(p);
                        break;
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }

                case 6:
                    isExit = true;
                    break;

                default:
                    break;
            }

        } while (!isExit);

    }

}
