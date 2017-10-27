package MazeApp;


public class MazeSolverQueue extends MazeSolver
{
    static Maze m = new Maze();
    private MyQueue<Square> queue = new MyQueue();
    
    public MazeSolverQueue(Maze maze)
    {
        super(maze);
        //maze.loadMaze();
    }
    public void makeEmpty()
    {
        queue.clear();
    }
    public boolean isEmpty()
    {
        if(queue.size() == 0)
            return true;
        return false;
    }
    public void add(Square sq)
    {
        queue.enqueue(sq);
    }
    public Square remove()
    {
        return queue.dequeue();
    }
    public Square next()
    {
        return queue.dequeue();
    }
    
}
