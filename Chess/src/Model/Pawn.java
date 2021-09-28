package Model;

import java.awt.Color;

public class Pawn extends ChessPiece {

  private final String name = "Pawn";

  public String getName() {
    return name;
  }

  @Override
  public void move(Position position) {
    Position start = this.getPosition();

    //check for diagonal moves
    if (this.getColor().equals(new Color(0,0,0))
    && start.getX() - position.getX() != -1) {
      throw new IllegalArgumentException("Pawns can only move forward one square");
    } else if (this.getColor().equals(new Color(255,255,255))
        && start.getX() - position.getX() != 1) {
      throw new IllegalArgumentException("Pawns can only move forward one square");
    }
    else {
      this.setPosition(position);
    }
  }

}
