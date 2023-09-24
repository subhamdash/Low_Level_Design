import java.lang.reflect.Array;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class TicTac {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int size_of_board;

        System.out.println("Please enter the size of the board");
        size_of_board = 3;//sc.nextInt();
        Boards board=new Boards(size_of_board);

        int no_of_players;
        System.out.println("Enter the number of Players");
        no_of_players = 2;//sc.nextInt();



        List<Players> players_list;
        PlayerAdvanceFactory pf=new No_of_players();
        players_list=pf.getPlayers(no_of_players);
        Game game=new Game(players_list,board);


        int is_game_on=1;
        int row, column;

        String ans=null;

        GameController GC= new GameController();

        while(is_game_on==1) {
            String Options;
            System.out.println("Type M to make Move or U to Undo");
            Options= sc.next();
            System.out.println("Your Option is "+Options);

            if(Options.equals("M")) {
                System.out.println("Insert the indexes for " + game.GetPlayerName());
                row = sc.nextInt();
                column = sc.nextInt();
                //is_game_on = game.getMoves(row, column);
                Commands AddPeice = new AddPeiceCommand(game, board, row, column);
                GC.setCommand(AddPeice);
                GC.MakeMove();
            }
            else {
                GC.undo();
            }

        }


        System.out.println(is_game_on);
        if(is_game_on==0)
            System.out.println("Winner is  " + game.GetPlayerName());
        else
            System.out.println("Tie");




    }


}
