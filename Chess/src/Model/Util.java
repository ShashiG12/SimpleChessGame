package Model;

import java.awt.Color;

public class Util {

  public String squareToString(Square square) {
    if (square.getOnTop() == null) {
//      if (square.getColor().equals(new Color(0, 0, 0))) {
//        return " ";
//      }
//      else {
//        return "  ";
//      }
      return "   ";
    }
    else {
      return this.pieceToString(square.getOnTop(), square.getOnTop().getColor()) + " ";
    }
  }

  public String pieceToString(ChessPiece piece, Color color) {
    if (color.equals(new Color(255, 255, 255))) {
      switch (piece.getName()) {
        case "Pawn":
          return "♙";
        case "Rook":
          return "♖";
        case "Knight":
          return "♘";
        case "Bishop":
          return "♗";
        case "Queen":
          return "♕";
        case "King":
          return "♔";
      }
    } else {
      switch (piece.getName()) {
        case "Pawn":
          return "♟";
        case "Rook":
          return "♜";
        case "Knight":
          return "♞";
        case "Bishop":
          return "♝";
        case "Queen":
          return "♛";
        case "King":
          return "♚";
      }
    }
    return "";
  }

}
