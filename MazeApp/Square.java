package MazeApp;

public class Square
{
	public static final int SPACE = 0;
	public static final int WALL = 1;
	public static final int START = 2;
	public static final int FINISH = 3;
	public static final int ON_WORK_LIST = 4;
	public static final int EXPLORED = 5;
	public static final int ON_PATH = 6;

	private int row = 0;
	private int col = 0;
	private int type = 0;
	private Square previous;

	//might want to use a switch for the toString()

	public Square(int row, int col, int type)
	{
		this.row = row;
		this.col = col;
		this.type = type;
	}

	//getters
	public int getRow() //gets the row
	{return row;}
	public int getColumn()//gets the column
	{return col;}
	public int getType()//gets the type
	{return type;}
	public void setType(int t) //sets the type 
	{type = t;}
	public void goBack(Square sq) //setter for the previous "Square"
	{previous = sq;}
	public Square getPrevious()//getter for the previous "Square"
	{return previous;}

	public String toString()
	{
		switch(type)
		{
			case 0: return "_"; //if empty space
			case 1: return "#";// if wall
			case 2: return "S"; //if start
			case 3: return "E";// if end
			case 4: return "o";//if on worklist
			case 5: return ".";//if explored
			case 6: return "x";//if on path
			default: return "_";

		}


	}


}
