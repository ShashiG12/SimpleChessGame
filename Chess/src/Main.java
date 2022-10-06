import Controller.SimpleChessController;
import Model.Board;
import View.BoardView;
import View.ChessFrame;
import View.SimpleBoardView;
import java.awt.Graphics;
import java.util.Locale;
import java.util.Scanner;
import javax.swing.JFrame;

public class Main {

  private static void processInput(String input) {
    Scanner sc = new Scanner(System.in);

    switch (input.toLowerCase(Locale.ROOT)) {
      case "t":
        Board example = new Board();
        example.initializeBoard();
        SimpleChessController controller = new SimpleChessController(example);
        controller.playTextGame();
        break;
      case "g":
        Board example1 = new Board();
        example1.initializeBoard();
        SimpleChessController controller1 = new SimpleChessController(example1);
        controller1.playGUIGame();
        break;
      default:
        System.out.print("Unrecognized input, try again: ");
        String input2 = sc.nextLine();
        processInput(input2);
    }

  }

  public static void main(String[] args) {
//    Scanner sc = new Scanner(System.in);
//    System.out.print("Type t for console and g for GUI: ");
//    String input = sc.nextLine();
//
//    processInput(input);

    Board example1 = new Board();
    example1.initializeBoard();
    SimpleChessController controller1 = new SimpleChessController(example1);
    controller1.playGUIGame();

  }

}
