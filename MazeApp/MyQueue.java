package MazeApp;

import java.util.ArrayList;
import java.NoSuchElementException

public class MyQueue<T> implements QueueADT<T>
{
	ArrayList<T> myQueue = new ArrayList<>();
	int x = 0;
	public void enqueue(T item){//adds to the end ArrayList automatically adds to the end
		myQueue.add(item);
		x++;

	}

	public T dequeue() throws NoSuchElementException
	{
		x--;
		return elements.remove(0);
	}

	public T front() throws NoSuchElementException
	{
		return elements.get(0);
	}

	public int size()
	{
		return x;
	}

	public boolean empty()
	{
		if(x != 0)
			return true;
		return false;
	}

	public void clear()
	{
		for(int z = 0; z < x; z++)
			this.myQueue[z] = null;
	}



}
