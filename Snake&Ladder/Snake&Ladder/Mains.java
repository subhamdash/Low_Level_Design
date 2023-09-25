import java.util.*;

public class Mains {
    public static void main(String[] args) {
        int size_of_board;
        int row_of_board;
        int no_of_snakes;
        int no_of_ladders;
        int no_of_players;
        int no_of_dice;
        Scanner sc=new Scanner(System.in);

// -----------------------Board Part ---------------------------------//

        System.out.println("Please Enter the Size of the Board");
        size_of_board=10; //sc.nextInt();
//        System.out.println("Please Enter the Row size of the Board");
//        row_of_board=sc.nextInt();

// -----------------------Players Part ---------------------------------//

//        System.out.println("Enter the number of players");
//        no_of_ladders= sc.nextInt();

        Players p1=new Players("Subh",1);
        Players p2=new Players("Max",2);
        List<Players> players_list=new ArrayList<>();
        players_list.add(p1);
        players_list.add(p2);

// -----------------------Snakes Part ---------------------------------//
        Map<Integer,Snake> Snakes=new HashMap<>();
        System.out.println("SSSSSnakes number Please");
        no_of_snakes= 3;// sc.nextInt();
        System.out.println("Enter Head of Snake and Tail of Snake");
        int snake_pos[][]=new int[3][2];
        snake_pos[0][0]=99;snake_pos[0][1]=12;
        snake_pos[1][0]=70;snake_pos[1][1]=22;
        snake_pos[2][0]=50;snake_pos[2][1]=5;

        for(int i=0;i<no_of_snakes;i++)
        {
            //int start=sc.nextInt();
            //int end=sc.nextInt();
            int start=snake_pos[i][0];
            int end=snake_pos[i][1];
            Snake ss=new Snake(start,end);
            Snakes.put(start,ss);
        }

// -----------------------Ladder Part ---------------------------------//

        int ladder_pos[][]=new int[4][2];
        ladder_pos[0][0]=10;ladder_pos[0][1]=25;
        ladder_pos[1][0]=20;ladder_pos[1][1]=49;
        ladder_pos[2][0]=34;ladder_pos[2][1]=77;
        ladder_pos[2][0]=45;ladder_pos[2][1]=89;

        Map<Integer,Ladder> Ladders=new HashMap<>();
        System.out.println("Ladders that will be there");
        no_of_ladders=4;//sc.nextInt();
        System.out.println("Enter Begining  of Ladder and End of Ladder Please");
        for(int i=0;i<no_of_ladders;i++)
        {
            //int start=sc.nextInt();
            //int end=sc.nextInt();
            int start=ladder_pos[i][0];
            int end=ladder_pos[i][1];
            Ladder lad=new Ladder(start,end);
            Ladders.put(start,lad);
        }
// -----------------------Dice Part ---------------------------------//

        System.out.println("Number of DIce");
        no_of_dice= 1;//sc.nextInt();

// -----------------------Will send all the Details to the game ---------------------------------//

        Game game=new Game(size_of_board,no_of_dice,players_list,Snakes,Ladders);
        game.intializeBoard();
        game.StartGame();



        Dice d=new Dice(no_of_dice);

        System.out.println(d.roll());
        System.out.println(d.roll());
        System.out.println(d.roll());
        System.out.println(d.roll());








    }
}
