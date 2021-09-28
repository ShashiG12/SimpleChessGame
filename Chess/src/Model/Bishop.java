package Model;

public class Bishop extends ChessPiece {

  private final String name = "Bishop";

  public String getName() {
    return name;
  }

  @Override
  public void move(Position position) {
    Position start = this.getPosition();

    //check for diagonal moves
    if ((Math.abs(start.getX() - position.getX()) > 0
        && (Math.abs(start.getY() - position.getY()) > 0))) {
      this.setPosition(position);
    } else {
      throw new IllegalArgumentException("Bishop can only move diagonally");
    }
  }

}
