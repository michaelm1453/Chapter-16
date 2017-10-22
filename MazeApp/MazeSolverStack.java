package MazeApp; 

public class MazeSolverStack extends MazeSolver
{
    Maze m = new Maze();
    MyStack<Square> stack = new MyStack<>();
    public MazeSolverStack()
    {
        super(m);
    }
    public void MakeEmpty()
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
        MazeSolverStack test = new MazeSolverStack();
        test.solve();
        System.out.println(test.path());
    }
}