import java.util.ArrayList;
import java.util.List;

public abstract class PlayerAdvanceFactory {

     private List<Players> players_list=new ArrayList<Players>();

    public List<Players>  getPlayers(int no_of_players)
    {
        List<Players> players_list=DeclareShapes(no_of_players);

        return players_list;
    }

    public abstract List<Players> DeclareShapes(int players);

}


class No_of_players extends PlayerAdvanceFactory
{
    private List<Players> players_list=new ArrayList<Players>();

    @Override
    public List<Players> DeclareShapes(int no_of_players) {

        if(no_of_players==1)
        {
            PlayingPiece p1=new PieceX();
            Players player1=new Players("Subh",p1);
            players_list.add(player1);


        }
        else if(no_of_players==2)
        {
            PlayingPiece p1=new PieceX();
            Players player1=new Players("Subh",p1);


            PlayingPiece p2=new Piece0();
            Players player2=new Players("Max",p2);

            players_list.add(player1);
            players_list.add(player2);

        }
        else if(no_of_players==3)
        {

            PlayingPiece p1=new PieceX();
            Players player1=new Players("Subh",p1);


            PlayingPiece p2=new Piece0();
            Players player2=new Players("Max",p2);

            PlayingPiece p3=new PieceK();
            Players player3=new Players("Sam",p3);

            players_list.add(player1);
            players_list.add(player2);
            players_list.add(player3);




        }
        return players_list;


    }
}
