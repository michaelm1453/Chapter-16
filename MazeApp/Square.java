public class Square
{
	public static final int SPACE = 0;
	public static final int WALL = 1;
	public static final int START = 2;
	public static final int FINISH = 3;

	private int row = 0;
	private int col = 0;
	private int type = 0;
	private State state;

	//might want to use a switch for the toString()
	public enum State
	{
		UNEXPLORED, // '_'
		ON_WORK_LIST, // 'o'
		EXPLORED, // '.'
		ON_PATH // 'x'

	};

	public Square(int row, int col, int type)
	{
		this.row = row;
		this.col = col;
		this.type = type;
	}

	//getters
	public int getRow()
	{return row;}
	public int getColumn()
	{return column();}
	public int getType()
	{return type;}

	public String toString()
	{
		switch(type)
		{
			case 0: return "_";

			case 1: return "#";
			case

		}

	}


}