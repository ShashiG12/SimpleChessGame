package Model;

import java.awt.Color;

public abstract class ChessPiece {

  private Position position;
  private Color color;

  public abstract void move(Position position);

  public Position getPosition() {
    return position;
  }

  public void setPosition(Position position) {
    this.position = position;
  }

  public Color getColor() {
    return this.color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  public abstract String getName();

}
