import java.util.HashMap;
import java.util.Map;

public class Board {


    int dimensions;
    Map<Integer,Snake> Snakes;
    Map<Integer,Ladder> Ladders;
    Map<Integer,BoardEnity> cell=new HashMap<>();
    Board(int size,Map<Integer,Snake> Snakes,Map<Integer,Ladder> Ladders)
    {
        this.dimensions=size*size;
        this.Snakes=Snakes;
        this.Ladders=Ladders;

    }
    int CheckforNextPos(int current_pos,int roll_value)
    {
        int next_pos=current_pos+roll_value;
        if(next_pos==dimensions)
            return dimensions+1;
        if(next_pos>dimensions)
        {
            return current_pos;
        }
        if(Snakes.containsKey(next_pos))
        {
            Snake s= Snakes.get(next_pos);
            return s.end_pos;
        }
        if(Ladders.containsKey(next_pos))
        {
            Ladder L= Ladders.get(next_pos);
            return L.end_pos;
        }
        return next_pos;
    }



}
