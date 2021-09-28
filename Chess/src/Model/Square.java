package Model;

import java.awt.Color;

public class Square {

  private ChessPiece onTop = null;
  private final Color color;

  public Square(ChessPiece onTop, Color color) {
    this.onTop = onTop;
    this.color = color;
  }

  public void setOnTop(ChessPiece onTop) {
    this.onTop = onTop;
  }

  public ChessPiece getOnTop() {
    return this.onTop;
  }

  public Color getColor() {
    return color;
  }


}
