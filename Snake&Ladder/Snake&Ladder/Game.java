import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    int size_of_board;
    int no_of_dice;
    List<Players> players_list=new ArrayList<>();
    Map<Integer,Snake> Snakes=new HashMap<>();
    Map<Integer,Ladder> Ladders=new HashMap<>();
    Map<String,Integer> playerPeice=new HashMap<>();
    Board b;
    Dice dice = new Dice(no_of_dice);
    Game(int size_of_board,int no_of_dice,List<Players> players_list,Map<Integer,Snake> Snakes,Map<Integer,Ladder> Ladders)
    {
        this.size_of_board=size_of_board;
        this.no_of_dice=no_of_dice;
        this.players_list=players_list;
        this.Snakes=Snakes;
        this.Ladders=Ladders;
        dice = new Dice(no_of_dice);
    }
    void intializeBoard()
    {
        b=new Board(size_of_board,Snakes,Ladders);

    }
    Players getPlayerName()
    {
        Players player_turn=players_list.get(0);
        players_list.remove(0);
        players_list.add(player_turn);
        return player_turn;
    }
    int demoGame()
    {
        Players player_turn=getPlayerName();

        int current_roll=dice.roll();
        //System.out.println("We got the Dice Roll value as "+current_roll);
        int curr_pos=playerPeice.get(player_turn.Name);
        int next_pos=b.CheckforNextPos(current_roll,curr_pos);
        System.out.println(player_turn.Name + " rolled "+current_roll+" and moved from "+curr_pos+" to "+next_pos);
        if(next_pos>size_of_board*size_of_board)
        {
            System.out.println("We have the Winner = "+ player_turn.Name );
            return 1;
        }

        playerPeice.put(player_turn.Name,next_pos);
        return 0;









    }

    void StartGame() {
        for(Players player:players_list)
        {
            System.out.println(player.Name);
            playerPeice.put(player.Name,1);

        }
        int run_game=0;
        while(run_game==0)
        {
            run_game=demoGame();

        }





    }



}
