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
        stack = new MyStack<>();
    }
    public boolean isEmpty()
    {
        if(stack.size() == 0)
            return true;
        return false;
    }
    public void add(Square sq)
    {
        stack.push(sq);
    }
    public Square next()
    {
        return stack.pop();
    }
    public Square remove()
    {
        return stack.pop();
    }
    
    
    public static void main(String[] args) throws FileNotFoundException
    {
        MazeSolverStack test = new MazeSolverStack(m);
        test.solve();
        System.out.println(test.getPath());
    }
}