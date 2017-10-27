package MazeApp;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Abstract class MazeSolver - write a description of the class here
 *
 * @author gcschmit
 * @version 2 June 2017
 */
public abstract class MazeSolver
{
    // instance variables - replace the example below with your own
    protected Maze maze;
    boolean foundExit;
    protected MyStack<Square> stack;
    private Square[][] mazeArray;


    /**
     * Constructor
     *
     *  @param maze the maze to solve
     */
    MazeSolver(Maze maze)
    {
        this.maze = maze;
        this.foundExit = false;
        this.makeEmpty();
        this.add(maze.getStart());
        this.mazeArray = maze.MazeArray();
    
    }

    /**
     * Create an empty worklist
     *
     */
    public abstract void makeEmpty();

    /**
     * Returns true if the worklist is empty
     *
     *  @return true if the worklist is empty
     */
    public abstract boolean isEmpty();

    /**
     * Adds the specified square to the worklist
     *
     *  @param the square to add to the worklist
     */
    public abstract void add( Square sq );

    /**
     * Returns the next item from the worklist
     *
     *  @return the next item from the worklist
     */
    public abstract Square next();

    /**
     * Returns true if either: A path from the start to the exit has been found; OR
     *      You determine there is no such path (worklist is now empty)
     *
     *  @return if the maze is solved
     */
    public boolean isSolved()
    {
        if(maze.getFinish().getPrevious() == null) 
            return false;
        else
        {
            Square pathBuilder = maze.getFinish().getPrevious();
            while(pathBuilder.getType() != 2 &&pathBuilder.getType() != 1)
            {
                pathBuilder.setType(6);
                pathBuilder = pathBuilder.getPrevious();
            }
            return true;
        }

    }
    public abstract Square remove();





    /*/**
     * Returns either a string of the solution path as a list of coordinates [i,j]
     *      from the start to the exit or a message indicating no such path exists.
     *      If the maze isn't solved, a message is returned indicating such.
     *  @return if the solution path if such a path exists
     */
    public String getPath()
    {//check to see if the type is equal to 6 (on_path)
        String path = "";
        if(!isSolved())
            return "The maze cannot be solved, sorry";
        else{
            for(int i = 0; i < maze.getFinish().getRow(); i ++){
                for(int j = 0; j < maze.getFinish().getColumn(); i++){
                    if(maze.maze[i][j].getType() == 6)
                        path += "[" + i + "," + j + "]";
                }
            }
            return path;
        }
    }

    /**
     * Perform one iteration of the algorithm above (i.e., steps 1 through 5) and
     *      return the Square that was just explored (and null if no such Square exists).
     *
     *  @return the Square that was just explored (and null if no such Square exists)
     */
    public Square step()
    {
        if(this.isEmpty())
            return null;
        Square next = this.next(); //gets the next square
        if(next == maze.getFinish())
            return next;
        if(next != null){
            for(Square neighbor : maze.getNeighbors(next))//gets the next squares neighbors
            {
                if(neighbor.getType() < 4 && neighbor.getType() != 2){ //makes sure it isn't the start or on the worklist
                    neighbor.goBack(next);
                    if(neighbor.getType() == 3)
                        return next;
                    else{
                        neighbor.setType(4);
                        add(neighbor);
                    }
                
                }
            }
        
            if(next.getType() >2)
                next.setType(5);
        }
        return next;
    }
    
     
        
    

    /**
     * Repeatedly calls step() until you get to the exit square or the worklist is empty.
     *
     */
    public void solve()
    {
        while(isSolved() != true)
        {
            this.step();
            if(this.isEmpty() && maze.getFinish().getPrevious() == null)
                break;
        }
        
        System.out.println(this.getPath());
    }

}
