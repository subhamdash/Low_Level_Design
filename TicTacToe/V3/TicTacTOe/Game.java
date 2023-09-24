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
    Players getPlayerName()
    {
        Players player_turn=players_list.get(0);
        players_list.remove(0);
        return player_turn;
    }
    void CheckPlayerMove(boolean isValid,Players player_turn)
    {
        if(isValid)
        {
            System.out.println("The operatation is made for " + player_turn.Name);
            players_list.add(player_turn);
        }

        else
        {
            System.out.println("Trying to perform operation in Wrong postion");
            players_list.add(0,player_turn);

        }
    }

    public int getMoves(int row,int column)
    {

            Players player_turn=getPlayerName();
            boolean isPeiceAdded=board.addPiece(row, column, player_turn.piece);
            CheckPlayerMove(isPeiceAdded,player_turn);

            boolean temp_win=board.IsWinner(row, column, player_turn.piece);
            if(temp_win) {
                return 0;
            }
            if(board.CheckForEmpty())
            {
                return -1;

            }
            board.PrintBoard();
        return 1;


    }


    void removeMoves(int row,int column)
    {
        int last_palyer_index=players_list.size()-1;
        Players player_turn=players_list.get(last_palyer_index);
        players_list.add(0,player_turn);
        boolean canPeiceRemoved=board.removePiece(row, column, player_turn.piece);
        CheckPlayerMove(canPeiceRemoved,player_turn);
        board.PrintBoard();

    }
    public String GetPlayerName()
    {
        return players_list.get(0).Name;
    }

}
