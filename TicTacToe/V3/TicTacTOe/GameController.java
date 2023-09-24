import java.util.Stack;

public class GameController {
    Commands command;
    private Stack<Commands> Undo_Stack=new Stack<>();
    private Stack<Commands> Redo_Stack=new Stack<>();
    public void setCommand(Commands command)
    {
        this.command=command;
    }
    public void MakeMove()
    {
        command.execute();
        Undo_Stack.add(command);
    }
    public void undo()
    {
        System.out.println("---------- We are Undoing some of the operations -------------");
        if(Undo_Stack.size()>0)
        {
            //We could have also used the array List but that would be difficult to maintain with the indexes
            Commands command=Undo_Stack.pop();
            Redo_Stack.add(command);
            command.undo();
        }
    }
    public void redo()
    {
        command.redo();
    }
}
