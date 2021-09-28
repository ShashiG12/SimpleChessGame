package Model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Board {

  private Square[][] board = new Square[8][8];
  private List<ChessPiece> dead = new ArrayList<ChessPiece>();
  private boolean isGameOver;

  public void initializeBoard() {
    //add initial squares with colors
    //iterates over all squares
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (i % 2 == j % 2) {
          board[i][j] = new Square(null, new Color(0, 0, 0));
        } else {
          board[i][j] = new Square(null, new Color(255, 255, 255));
        }
      }
    }

    //add initial pieces with correct colors
    //iterates only over the first 2 and last 2 rows
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (i == 0 || i == 1) {
          board[i][j].setOnTop(createPiece(new Position(i, j), new Color(0, 0, 0)));
        }
        if (i == board.length - 1 || i == board.length - 2) {
          board[i][j].setOnTop(createPiece(new Position(i, j), new Color(255, 255, 255)));
        }
      }
    }


  }

  private ChessPiece createPiece(Position position, Color color) {
    if (position.getX() == 1 || position.getX() == board.length - 2) {
      return initializePiece(new Pawn(), position, color);
    }
    else {
      if (position.getY() == 0) {
        return initializePiece(new Rook(), position, color);
      }
      if (position.getY() == 1) {
        return initializePiece(new Knight(), position, color);
      }
      if (position.getY() == 2) {
        return initializePiece(new Bishop(), position, color);
      }
      if (position.getY() == 3) {
        return initializePiece(new King(), position, color);
      }
      if (position.getY() == 4) {
        return initializePiece(new Queen(), position, color);
      }
      if (position.getY() == 5) {
        return initializePiece(new Bishop(), position, color);
      }
      if (position.getY() == 6) {
        return initializePiece(new Knight(), position, color);
      }
      if (position.getY() == 7) {
        return initializePiece(new Rook(), position, color);
      }
    }
    return null;
  }

  private ChessPiece initializePiece(ChessPiece piece, Position position, Color color) {
    piece.setPosition(position);
    piece.setColor(color);
    return piece;
  }

  public Square[][] getBoard() {
    return this.board;
  }

  public boolean isGameOver() {
    return isGameOver;
  }

  public void move(Position p1, Position p2) {
//    Square currentSquare = this.board[p1.getX()][p1.getY()];
//    Square endSquare = this.board[p2.getX()][p2.getY()];
    ChessPiece currentPiece = this.board[p1.getX()][p1.getY()].getOnTop();
    ChessPiece endPiece = this.board[p2.getX()][p2.getY()].getOnTop();

    if (this.board[p1.getX()][p1.getY()].getOnTop() == null) {
      throw new IllegalArgumentException("No chess piece at specified location");
    }

    if (this.board[p2.getX()][p2.getY()].getOnTop() != null) {
      if (this.board[p1.getX()][p1.getY()].getOnTop().getColor().equals(
          this.board[p2.getX()][p2.getY()].getOnTop().getColor())) {
        throw new IllegalArgumentException("Chess piece of same color at end location");
      }
    }

    this.board[p1.getX()][p1.getY()].getOnTop().move(p2);
    this.board[p2.getX()][p2.getY()].setOnTop(currentPiece);
    this.board[p1.getX()][p1.getY()].setOnTop(null);
    if (endPiece != null) {
      dead.add(endPiece);
    }

  }

  public List<ChessPiece> getDead() {
    return dead;
  }
}
