package MazeApp;
import java.io.*;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class Maze
{
    private File file1 = null;
    private Square[][] maze;
    private File backup = null;
    private int row = 0; private int col = 0; private int type = 0;
    public boolean loadMaze() throws FileNotFoundException
    {
        JFileChooser picker = new JFileChooser();
        if(picker.showOpenDialog(null) == JFileChooser.APPROVE_OPTION )
        {
            File file = picker.getSelectedFile();
            backup = picker.getSelectedFile();
            Scanner f = new Scanner(file);
            row = Integer.parseInt(f.next());
            col = Integer.parseInt(f.next());
            while(f.hasNext())
            {
                for(int i = 0; i < row; i ++){
                    for(int j = 0; j < col; j ++){
                        String s = f.next();
                        switch(s){
                            case "_": type = 0; break;
                            case "x": type = 1; break;
                            case "S": type = 2; break;
                            case "E": type = 3; break;
                            default: break;
                        }
                        maze[i][j] = new Square(i, j, type); 
                    }
                }
            }
                     
            return true;
        }
        return false;
        
    }

    public String toString()
    {
        String myString = "";
        for(int i = 0; i < row; i ++){
            for(int j = 0; j <col; j++)
            {
                if(j == col - 1)
                    myString += "/n" +maze[i][j].toString();
                else
                    myString += maze[i][j].toString();
                
            }
        }
        return myString;
    }
    
    public static void main(String[] args) throws FileNotFoundException
    {
        Maze m = new Maze();
        m.loadMaze();
        System.out.println(m.toString());
    }
    
}
