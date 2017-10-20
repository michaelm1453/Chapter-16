package MazeApp; 

public class MazeSolverStack extends MazeSolver
{
    Maze m = new Maze();
    public MazeSolverStack()
    {
        super(m);
    }
    public void MakeEmpty()
    {
        stack.clear();
    }
    public void add(Square sq)
    {
        
    }
}