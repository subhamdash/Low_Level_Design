import java.lang.reflect.Array;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;





public class TicTac {
    public static void main(String[] args) {



        //Let's Decide the size of the board.
        Scanner sc = new Scanner(System.in);
        int size_of_board;


        //We are asking user to input the size of the board
        System.out.println("Please enter the size of the board");
        size_of_board = sc.nextInt();
        Boards board=new Boards(size_of_board);

        int no_of_players;
        System.out.println("Enter the number of Players");
        no_of_players = sc.nextInt();


        // Here we can have two players or single players or we extend it to have three players so we are
        //using factory to get the List of the Object so that we can use this
        List<Players> players_list;
//        PlayerFactory playerFactory=new PlayerFactory();
//        players_list=playerFactory.getPlayers(no_of_players);
//        We have commented out the Normal Factory and We are using the Advance Factory , The benifit is we can extend the
//        The Advance Factory More easily.
        PlayerAdvanceFactory pf=new No_of_players();
        players_list=pf.getPlayers(no_of_players);
        Game game=new Game(players_list,board);


        int is_game_on=1;
        int row, column;

        String ans=null;
        while(is_game_on==1) {

            System.out.println("Insert the indexes for " + game.GetPlayerName());
            row = sc.nextInt();
            column = sc.nextInt();
            is_game_on = game.getMoves(row, column);
        }
        System.out.println(is_game_on);
        if(is_game_on==0)
            System.out.println("Winner is  " + game.GetPlayerName());
        else
            System.out.println("Tie");




    }


}
