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
        queue.clear(); //clears the queue
    }
    public boolean isEmpty()
    {
        if(queue.size() == 0)
            return true;
        return false;
    }
    public void add(Square sq)
    {
        queue.enqueue(sq);//adds to the worklist
    }
    public Square remove()
    {
        return queue.dequeue(); //also removes from the worklist, there are two to staisfy the abstract class
    }
    public Square next()
    {
        return queue.dequeue(); //removes from the worklist
    }
    
}
