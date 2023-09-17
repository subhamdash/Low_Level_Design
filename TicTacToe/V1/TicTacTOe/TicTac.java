import java.lang.reflect.Array;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Boards
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
class PlayingPiece
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

class Players
{
    String Name;
    int id;
    public PlayingPiece piece;
    Players(String name,PlayingPiece piece)
    {
        Name=name;
        this.piece=piece;

    }




}

public class TicTac {
    public static void main(String[] args) {

        List<Players> players_list=new ArrayList<Players>();

        PlayingPiece p1=new PieceX();
        Players player1=new Players("Subh",p1);

        PlayingPiece p2=new Piece0();
        Players player2=new Players("Max",p2);

        players_list.add(player1);
        players_list.add(player2);


        Boards board=new Boards(3);
        boolean is_game_on=true;
        int row, column;
        Scanner sc = new Scanner(System.in);
        String ans=null;
        while(is_game_on) {
            Players player_turn=players_list.get(0);
            players_list.remove(0);
            //players_list.add(player_turn);
            System.out.println("Insert the indexes for " +
                    player_turn.Name);


            row = sc.nextInt();
            column = sc.nextInt();
            boolean isPeiceAdded=board.addPiece(row, column, player_turn.piece);
            if(!isPeiceAdded)
            {
                System.out.println("Trying to insert in Wrong postion");
                players_list.add(0,player_turn);
            }
            else
            {
                System.out.println("The values are added for " + player_turn.Name);
                players_list.add(player_turn);
            }
            boolean temp_win=board.IsWinner(row, column, player_turn.piece);
            if(temp_win) {
                is_game_on = false;
                System.out.println("Winner is  " + player_turn.Name);
            }
            if(board.CheckForEmpty())
            {
                if(is_game_on) ans="Tie";



            }
            board.PrintBoard();

        }
        if(ans!=null)
        System.out.println("The final Verdict of game is " + ans);


    }


}
