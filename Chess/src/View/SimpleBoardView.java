package View;

import Model.Board;
import Model.Square;
import Model.Util;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFrame;

public class SimpleBoardView implements BoardView{

  private Board board;
  private final ArrayList<String> letters = new ArrayList<>(
      Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H"));

  public SimpleBoardView(Board board) {
    this.board = board;
  }

  public void boardToString() {
    Util util = new Util();

    System.out.print("  ");

    for (String letter : this.letters) {
      System.out.print(letter + "  ");
    }

    System.out.println();

    for (int i = 0; i < this.board.getBoard().length; i++) {
      System.out.print((8 - i) + " ");
      for (int j = 0; j < this.board.getBoard()[0].length; j++) {
        System.out.print(util.squareToString(this.board.getBoard()[i][j]));
      }
      System.out.println();
    }
  }

  public ArrayList<String> getLetters() {
    return letters;
  }

}
