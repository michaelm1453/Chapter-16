package MazeApp;
import java.util.ArrayList;

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
        this.add(this.maze.getStart() );
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
        if(this.next().equals(maze.getFinish()))
            return true;
        return false;
    }





    /**
     * Returns either a string of the solution path as a list of coordinates [i,j]
     *      from the start to the exit or a message indicating no such path exists.
     *      If the maze isn't solved, a message is returned indicating such.
     *
     *  @return if the solution path if such a path exists
     */
    public String getPath()
    {//check to see if the type is equal to 6 (on_path)
         String path = "";
        if(this.isSolved() == false)
            return "The maze cannot be solved, sorry";
        for(int i = 0; i < maze.getFinish().getRow(); i ++){
            for(int j = 0; j < maze.getFinish().getColumn(); i++){
                path += "[" + i + "," + j + "]";
            }
        }
        return path;
    }

    /**
     * Perform one iteration of the algorithm above (i.e., steps 1 through 5) and
     *      return the Square that was just explored (and null if no such Square exists).
     *
     *  @return the Square that was just explored (and null if no such Square exists)
     */
    /**
     * Is the worklist empty? If so, the exit is unreachable; terminate the algorithm.
     * Otherwise, grab the "next" location to explore from the worklist.
     * Does the location correspond to the exit square? If so, the finish was reachable; terminate the algorithm and output the path you found.
     * Otherwise, it is a reachable non-finish location that we haven't explored yet. So, explore it as follows:
     * compute all the adjacent up, right, down, left locations that are inside the maze and aren't walls, and
     * add them to the worklist for later exploration provided they have not previously been added to the worklist.
     * Also, record the fact that you've explored this location so you won't ever have to explore it again.
     * Note that a location is considered "explored" once its neighbors have been put on the worklist.
     * The neighbors themselves are not "explored" until they are removed from the worklist and checked for their neighbors
     */
    public Square step()
    {
        // check if the maze cannot be solved
        if( this.isEmpty() )
            return null; //maybe just return null the whole time?
            //remember to make sure that getNeighbors ONLY adds non walls.
        for(Square square : maze.getNeighbors(this.next()))
        {
            if(square.getType() == 3)
                return null;
            if(maze.getNeighbors(square).size() > 0){
                this.add(square);
                square.setType(4);
            }
            else
                square.setType(5);
                
            //also test to see if the square is already in the worklist?
            //make sure you change the type of the square to either "on worklist" or "explored" or "on path"
            
        }
        return null;


        
    }

    /**
     * Repeatedly calls step() until you get to the exit square or the worklist is empty.
     *
     */
    public void solve()
    {
        while(!this.isEmpty())
            this.step();
    }

}
