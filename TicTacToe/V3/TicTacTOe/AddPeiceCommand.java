public class AddPeiceCommand implements Commands {
    Boards boards;
    Game game;
    PlayingPiece playingPiece;
    int row,col;
    AddPeiceCommand(Game game,Boards boards,int row,int col)
    {
        this.game=game;
        this.boards=boards;
        this.row=row;
        this.col=col;
    }
    @Override
    public void execute()
    {
        game.getMoves(row,col);

    }

    @Override
    public void undo() {
        game.removeMoves(row,col);


    }

    @Override
    public void redo() {

    }
}
