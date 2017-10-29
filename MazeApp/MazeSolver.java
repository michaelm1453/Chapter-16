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
    private String path= "";


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





    /*
     * Returns either a string of the solution path as a list of coordinates [i,j]
     *      from the start to the exit or a message indicating no such path exists.
     *      If the maze isn't solved, a message is returned indicating such.
     *  @return if the solution path if such a path exists
     */
    public String getPath()
    {//check to see if the type is equal to 6 (on_path)
        if(!isSolved())
            return "The maze cannot be solved, sorry";
        else{
            //Goes through the whole maze and adds everything of type 6 to the path
            for(int row = 0; row < maze.getRows(); row ++){
                for(int col = 0; col < maze.getColumns(); col++){
                    if(mazeArray[row][col].getType() == 6)
                        path += "[" + row + "," + col + "]"; 
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
        if(this.isEmpty())//if the worklist is empty, stop.
            return null;
        Square next = this.next(); //gets the next square
        if(next == maze.getFinish())//if the next element in the worklist is the endpoint, stop
            return next;
        if(next != null){
            for(Square neighbor : maze.getNeighbors(next))//gets the next squares neighbors
            {
                 neighbor.goBack(next);//sets the previous square for neighbor equal to the original 'next' Square variable
                 if(neighbor.getType() == 3)
                     return next;//if the next square is the finish, stop
                 else{
                     neighbor.setType(4);//say that the neighbor is now on the worklist
                     add(neighbor);//add the neighbor to the worklist                  }
                
                }
            }
        
            if(next.getType() == 4)//if it's on the workpath, change it to explored
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
