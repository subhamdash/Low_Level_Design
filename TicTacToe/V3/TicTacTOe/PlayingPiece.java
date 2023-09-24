public class PlayingPiece
{
    String Piece;
    PlayingPiece(String Piece)
    {
        this.Piece= Piece;
    }

}

class PieceX extends PlayingPiece
{
    PieceX()
    {
        super("X");
    }

}

class Piece0 extends PlayingPiece
{
    Piece0()
    {
        super("0");
    }

}


class PieceK extends PlayingPiece
{
    PieceK()
    {
        super("K");
    }

}