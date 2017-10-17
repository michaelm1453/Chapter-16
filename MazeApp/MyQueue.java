import java.util.ArrayList;

public class MyQueue<T> implements QueueADT<T>
{
	ArrayList<T> myQueue = new ArrayList<>();
	public void enqueue(T item){
		myQueue.addLast(item);

	}

}