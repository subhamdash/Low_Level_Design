public class RemovePeiceCommand implements Commands {
    Boards boards;
    PlayingPiece playingPiece;
    int row,col;
    RemovePeiceCommand(Boards boards,int row,int col)
    {
        this.boards=boards;
        this.row=row;
        this.col=col;
    }
    public void execute()
    {

    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }

}
