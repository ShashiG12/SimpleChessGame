package Model;

public class Queen extends ChessPiece {

  private final String name = "Queen";

  public String getName() {
    return name;
  }

  @Override
  public void move(Position position) {
    this.setPosition(position);
  }

}
