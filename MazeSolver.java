  
public abstract class MazeSolver
{
    Maze test;
    abstract void MakeEmpty();
    abstract boolean isEmpty();
    abstract void add(Square sq);
    abstract Square next();
    
    public MazeSolver(Maze maze)
    {
        test = maze;        
    }
    
    public boolean isSolved()
    {
        
    }
    
    public String getPath()
    {
        
    }
    
    public Square step()
    {
        
    }
 
    public void solve()
    {
        this.step();
    }
    
    
}