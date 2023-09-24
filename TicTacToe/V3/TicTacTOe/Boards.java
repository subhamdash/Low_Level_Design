public class Boards
{
    int size;
    PlayingPiece board[][];
    Boards(int size)
    {
        this.size=size;
        board=new PlayingPiece[size][size];

    }
    boolean addPiece(int row,int column, PlayingPiece PP)
    {
        if(board[row][column]!=null || row>size || column>size)
            return false;
        board[row][column]=PP;
        return true;


    }

    boolean removePiece(int row,int column, PlayingPiece PP)
    {
        if(board[row][column]==null || row>size || column>size)
            return false;
        board[row][column]=null;
        return true;


    }
    boolean IsWinner(int row,int column,PlayingPiece PP)
    {
        boolean row_wise=true,column_wise=true,diagnol_left=true,diagnol_right=true;
        for(int i=0;i<size;i++)
        {
            if(board[i][column]==null || board[i][column].Piece !=PP.Piece) row_wise= false;
            if(board[row][i]==null || board[row][i].Piece !=PP.Piece) column_wise= false;
        }
        for(int i=0,j=0;i<size;i++,j++)
        {
            if(board[i][j]==null || board[i][j].Piece !=PP.Piece) diagnol_left= false;
        }

        for(int i=0,j=size-1;i<size;i++,j--)
        {
            if(board[i][j]==null || board[i][j].Piece !=PP.Piece) diagnol_right= false;
        }
        return row_wise|| column_wise || diagnol_left ||diagnol_right;
    }
    void PrintBoard()
    {
        System.out.println("----------");
        for(int i=0;i<size;i++)
        {System.out.print("| ");
            for(int j=0;j<size;j++)
            {
                if(board[i][j]!=null)
                    System.out.print(board[i][j].Piece);
                else
                    System.out.print(" ");

                System.out.print(" | ");


            }
            System.out.println();


        }
        System.out.println("----------");
    }


    boolean CheckForEmpty()
    {
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                if(board[i][j]==null) return false;
            }
        }
        return true;

    }

}