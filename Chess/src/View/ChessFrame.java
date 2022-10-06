package View;

import Model.Board;
import Model.Position;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ChessFrame extends JFrame implements ActionListener{

  ChessGraphics cgraphics;
  Board board;
  private int count = 0;
  private Position firstClick;

  public ChessFrame(Board board) {
    this.board = board;
    this.setSize(500, 500);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.cgraphics = new ChessGraphics(board);
    this.add(cgraphics);
    this.setVisible(true);
    this.initializeButtons();
  }

  //adds a button for every square on the chess board
  private void initializeButtons() {
    for (int i = 0; i < this.board.getBoard().length; i++) {
      for (int j = 0; j < this.board.getBoard()[0].length; j++) {
        JButton button = new JButton();
        button.addActionListener(this);
        button.setBounds(i * 40, j * 40, 40, 40);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        this.add(button);
      }
    }
  }

  //processes button click
  public void actionPerformed(ActionEvent ae) {
    count++;
    JButton button = (JButton) ae.getSource();
    int x = button.getX() / 40;
    int y = button.getY() / 40;
    if (count == 1) {
      this.firstClick = new Position(y, x);
      cgraphics.getGraphics().setColor(Color.YELLOW);
      cgraphics.getGraphics().fillRect(x * 40, y * 40, 40, 40);
    }
    if (count == 2) {
      try {
        board.move(firstClick, new Position(y, x));
        cgraphics.repaint();
      }
      catch (IllegalArgumentException e) {
        cgraphics.getGraphics().drawString(e.getMessage(), 50, 400);
      }
      count = 0;
    }


  }


}
