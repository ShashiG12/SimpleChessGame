package Model;

public class King extends ChessPiece{

  private final String name = "King";

  public String getName() {
    return name;
  }

  @Override
  public void move(Position position) {
    Position start = this.getPosition();

    //check that king only moves one square in any direction
    if (Math.abs(start.getX() - position.getX()) == 1
    || Math.abs(start.getY() - position.getY()) == 1) {
      this.setPosition(position);
    } else {
      throw new IllegalArgumentException("King can only move one square in any direction");
    }
  }
}
