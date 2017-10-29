package MazeApp;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Maze
{
    private File file1 = null;
    public static Square[][] maze; private Square start; private Square end;
    private int row = 0; private int col = 0; private int type = 0;
    private String fileName = "";
    
    /*
    @param String fileName - file path of the maze file
    Takes a file and converts it into a maze, setting the start and end points. 
    @return true (if you can load the maze)
    @return false (if you cannot load the maze)
    */
    public boolean loadMaze(String fileName)
    {
        try{
            Scanner f = new Scanner(new File(fileName));
            this.fileName = fileName; //sets fileName equal to what was passed through, will be used for reset() later
            row = Integer.parseInt(f.next()); 
            col = Integer.parseInt(f.next()); //gets the first two characters, which are the row and column
            maze = new Square[row][col]; //creates an array of Square objects
            while(f.hasNext())
            {
                for(int i = 0; i < row; i ++){
                    for(int j = 0; j < col; j ++){
                        String s = f.next();
                        type = Integer.parseInt(s); //gets whether the Square is a wall, empty space, start, or end.
                        maze[i][j] = new Square(i, j, type); //sets the index at the array to a new square
                        if(type == 2)
                            start = maze[i][j]; //sets the 'start' Square equal to whatever has the type 2
                        if(type == 3)
                            end = maze[i][j]; //sets the 'end' Square equal to whatever has the type 3 
                    }
                }
            }
            

            return true;
        }
        catch (FileNotFoundException e){
            return false;
        }   

    }

    public String toString()
    {
        String myString = "";
        for(int i = 0; i < row; i ++){
            for(int j = 0; j <col; j++)
            {
                myString += maze[i][j].toString();
            }
            myString += "\n"; //after it goes through a row, start a new line
        }
        return myString;
    }

    public Square getStart()
    {
        return start;
    }
    public Square getFinish()
    {
        return end;
    }

    public void reset()
    {
        loadMaze(fileName); //reloads the maze
    }

    public ArrayList<Square> getNeighbors(Square sq)
    {
        //Only adds empty spaces and the finish part the neighbor array list.
        //Does not add the start point (it is automatically added to the worklist, we do not want to add it again)
        //Does not add anything that is explored, on path, or on worklist because we have already tested them
        ArrayList<Square> neighbors = new ArrayList<Square>();
        if(sq != null && sq.getRow()-1 >= 0)//checks if the direction above it is valid (not out of bounds)
            if(maze[sq.getRow()-1][sq.getColumn()].getType() == 0 || maze[sq.getRow()-1][sq.getColumn()].getType() == 3)//checks if it is either an empty space or the end
                neighbors.add(maze[sq.getRow()-1][sq.getColumn()]);//adds the element above it in the maze to the ArrayList
        if(sq.getColumn()+1 < col)//checks to the right
            if(maze[sq.getRow()][sq.getColumn()+1].getType() == 0 || maze[sq.getRow()][sq.getColumn()+1].getType() == 3)
                neighbors.add(maze[sq.getRow()][sq.getColumn()+1]);
        if(sq.getRow()+1 < row)//checks below
            if(maze[sq.getRow()+1][sq.getColumn()].getType() == 0 || maze[sq.getRow()+1][sq.getColumn()].getType() == 3)
                neighbors.add(maze[sq.getRow()+1][sq.getColumn()]);
        if(sq.getColumn() - 1 >= 0)//checks to the left
            if(maze[sq.getRow()][sq.getColumn()-1].getType() == 0 || maze[sq.getRow()][sq.getColumn()-1].getType() == 3)
                neighbors.add(maze[sq.getRow()][sq.getColumn()-1]);
        return neighbors;
    }
    
    /*
    *Getter for the MazeArray
    */
    public Square[][] MazeArray()
    {
        return maze;
    }
    public int getRows()
    {return row;}
    public int getColumns()
    {return col;}


}
