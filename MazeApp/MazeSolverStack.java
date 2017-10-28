package MazeApp; 
import java.io.FileNotFoundException;
public class MazeSolverStack extends MazeSolver
{
    static Maze m = new Maze();
    public static MyStack<Square> stack = new MyStack<>();
    
    public MazeSolverStack(Maze maze) throws FileNotFoundException
    {
        super(maze);
    }
    public void makeEmpty()
    {
        stack = new MyStack<>(); //creates a new stack to clear it
    }
    public boolean isEmpty()
    {
        if(stack.size() == 0)
            return true;
        return false;
    }
    public void add(Square sq)
    {
        stack.push(sq);//adds to the worklist
    }
    public Square next()
    {
        return stack.pop(); //removes from the worklist
    }
    public Square remove()
    {
        return stack.pop();//removes from the worklist
    }
}
