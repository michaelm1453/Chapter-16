package MazeApp;

//package MazeApp;

//package MazeApp;
import java.io.*;
import java.util.Scanner;
import javax.swing.JFileChooser;
import java.util.ArrayList;

public class Maze
{
    private File file1 = null;
    public static Square[][] maze; private Square start; private Square end;
    private Square[][] backup = null;
    private int row = 0; private int col = 0; private int type = 0;
    public boolean loadMaze(String fileName)
    {
        try{
            Scanner f = new Scanner(new File(fileName));
            row = Integer.parseInt(f.next());
            col = Integer.parseInt(f.next());
            maze = new Square[row][col];
            while(f.hasNext())
            {
                for(int i = 0; i < row; i ++){
                    for(int j = 0; j < col; j ++){
                        String s = f.next();
                        type = Integer.parseInt(s);
                        maze[i][j] = new Square(i, j, type);
                        backup[i][j] = new Square(i, j, type);
                        if(type == 2)
                            start = maze[i][j];
                        if(type == 3)
                            end = maze[i][j];
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
            myString += "\n";
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
        for(int x = 0; x < row; x ++)
            for(int y = 0; y < col; y ++)
                maze[x][y] = backup[x][y];

    }

    public ArrayList<Square> getNeighbors(Square sq)
    {
        ArrayList<Square> neighbors = new ArrayList<Square>();
        if(sq != null && sq.getRow()-1 >= 0)//checks if the direction above it is valid
            if(maze[sq.getRow()-1][sq.getColumn()].getType() == 0 || maze[sq.getRow()-1][sq.getColumn()].getType() == 3)
                neighbors.add(maze[sq.getRow()-1][sq.getColumn()]);
        if(sq.getColumn()+1 < col)
            if(maze[sq.getRow()][sq.getColumn()+1].getType() == 0 || maze[sq.getRow()][sq.getColumn()+1].getType() == 3)
                neighbors.add(maze[sq.getRow()][sq.getColumn()+1]);
        if(sq.getRow()+1 < row)
            if(maze[sq.getRow()+1][sq.getColumn()].getType() == 0 || maze[sq.getRow()+1][sq.getColumn()].getType() == 3)
                neighbors.add(maze[sq.getRow()+1][sq.getColumn()]);
        if(sq.getColumn() - 1 >= 0)
            if(maze[sq.getRow()][sq.getColumn()-1].getType() == 0 || maze[sq.getRow()][sq.getColumn()-1].getType() == 3)
                neighbors.add(maze[sq.getRow()][sq.getColumn()-1]);
        return neighbors;
    }
    
    public Square[][] MazeArray()
    {
        return maze;
    }


}
