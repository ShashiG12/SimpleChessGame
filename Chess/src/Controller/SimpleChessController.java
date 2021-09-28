package Controller;

import Model.Board;
import Model.Position;
import View.BoardView;
import View.ChessFrame;
import View.SimpleBoardView;
import java.util.Locale;
import java.util.Scanner;
import javax.swing.JFrame;

public class SimpleChessController {

  private Board board;

  public SimpleChessController(Board board) {
    this.board = board;
  }

  public void playTextGame() {
    Scanner sc = new Scanner(System.in);

    this.board.initializeBoard();
    BoardView view = new SimpleBoardView(this.board);
    view.boardToString();

    while (!this.board.isGameOver()) {
      System.out.print("Enter move: ");
      int x1 = sc.nextInt() - 1;
      int y1 = sc.nextInt() - 1;
      int x2 = sc.nextInt() - 1;
      int y2 = sc.nextInt() - 1;

      try {
        this.board.move(new Position(y1, x1), new Position(y2, x2));
      }
      catch(IllegalArgumentException e) {
        System.out.println(e.getMessage() + ". Try again!");
      }

      view.boardToString();
    }

  }

  public void playGUIGame() {

    this.board.initializeBoard();
    ChessFrame cf = new ChessFrame(this.board);


  }


}
