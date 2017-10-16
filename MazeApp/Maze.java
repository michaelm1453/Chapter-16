//package MazeApp;
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
			int count = 0;
            File file = picker.getSelectedFile();
            backup = picker.getSelectedFile();
            Scanner f = new Scanner(file);
            row = Integer.parseInt(f.next());
            col = Integer.parseInt(f.next());
            maze = new Square[row][col];
            while(f.hasNext())
            {
                for(int i = 0; i < row; i ++){
                    for(int j = 0; j < col; j ++){
                        String s = f.next();
                        count ++;
                        type = Integer.parseInt(s);
                        maze[i][j] = new Square(i, j, type);
                    }
                }
            }
            System.out.println(count);

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
				myString += maze[i][j].toString();
            }
            myString += "\n";
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
