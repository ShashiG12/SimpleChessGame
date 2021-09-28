package Model;

public class Rook extends ChessPiece {

  private final String name = "Rook";

  public String getName() {
    return name;
  }

  @Override
  public void move(Position position) {
    Position start = this.getPosition();

    //check for horizontal or vertical moves
    if ((Math.abs(start.getX() - position.getX()) > 0
        && !(Math.abs(start.getY() - position.getY()) > 0))
        || !(Math.abs(start.getX() - position.getX()) > 0)
        && (Math.abs(start.getY() - position.getY()) > 0)) {
      this.setPosition(position);
    } else {
      throw new IllegalArgumentException("Rook must be moved vertically or horizontally");
    }
  }

}
