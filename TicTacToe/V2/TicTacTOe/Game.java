import java.util.List;

public class Game {
    private List<Players> players_list;
    private Boards board;
    private boolean is_game_on;
    String ans=null;
    Game(List<Players> players_list,Boards board)
    {
        this.players_list=players_list;
        this.board=board;
        is_game_on=true;

    }
    public int getMoves(int row,int column)
    {

            Players player_turn=players_list.get(0);
            players_list.remove(0);
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
                return 0;

                //System.out.println("Winner is  " + player_turn.Name);
            }
            if(board.CheckForEmpty())
            {

                return -1;

            }
            board.PrintBoard();



        return 1;


    }
    public String GetPlayerName()
    {
        return players_list.get(0).Name;
    }

}
