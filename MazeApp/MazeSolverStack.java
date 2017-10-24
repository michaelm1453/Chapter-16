package MazeApp; 

public class MazeSolverStack extends MazeSolver
{
    static Maze m = new Maze(); 
    MyStack<Square> stack = new MyStack<>();
    public MazeSolverStack(Maze maze)
    {
        super(maze);
    }
    public void makeEmpty()
    {
        stack.clear();
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
        return stack.top();
    }
    
    
    public static void main(String[] args)
    {
        MazeSolverStack test = new MazeSolverStack(m);
        test.solve();
        System.out.println(test.getPath());
    }
}