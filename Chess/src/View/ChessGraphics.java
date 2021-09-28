package View;

import Model.Board;
import Model.ChessPiece;
import Model.Util;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ChessGraphics extends JPanel {

  private Board board;

  public ChessGraphics(Board board) {
    this.board = board;
  }

  public void paintComponent(Graphics g) {

    int fontSize = 40;

    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;

    Util util = new Util();


    for (int i = 0; i < this.board.getBoard().length; i++) {
      for (int j = 0; j < this.board.getBoard()[0].length; j++) {
        g2d.setPaint(this.board.getBoard()[i][j].getColor());
        g2d.fillRect(i * 40, j * 40, 40, 40);
      }
    }

    for (int i = 0; i < this.board.getBoard().length; i++) {
      for (int j = 0; j < this.board.getBoard()[0].length; j++) {
        if (this.board.getBoard()[i][j].getColor().equals(Color.BLACK)) {
          g2d.setPaint(Color.WHITE);
        } else {
          g2d.setPaint(Color.BLACK);
        }
        g2d.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
        g2d.drawString(util.squareToString(this.board.getBoard()[j][i]), i * 40, j * 40 + 40);
      }
    }

    //show dead pieces
    for (int i = 0; i < this.board.getDead().size(); i++) {
      ChessPiece current = this.board.getDead().get(i);
      g2d.drawString(util.pieceToString(current, current.getColor()), 400, i * 40 + 40);
    }


  }


}
