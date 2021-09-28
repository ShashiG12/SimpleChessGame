package Model;

public class Knight extends ChessPiece {

  private final String name = "Knight";

  public String getName() {
    return name;
  }

  @Override
  public void move(Position position) {
    Position start = this.getPosition();

    //check for valid move
    if (((Math.abs(start.getX() - position.getX()) == 2)
        && (Math.abs(start.getY() - position.getY()) == 1))
    || (Math.abs(start.getY() - position.getY()) == 2
        && (Math.abs(start.getX() - position.getX()) == 1))) {
      this.setPosition(position);
    } else {
      throw new IllegalArgumentException("Knight can only move in an L shape");
    }
  }

}
