import Model.Board;
import View.BoardView;
import View.SimpleBoardView;
import org.junit.Test;

public class ViewTest {

  @Test
  public void chessViewTest() {
    Board example = new Board();
    example.initializeBoard();
    BoardView view = new SimpleBoardView(example);
    view.boardToString();
  }

}
