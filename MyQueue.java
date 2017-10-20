package MazeApp;

import java.util.ArrayList;
import java.util.NoSuchElementException;

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
        return this.myQueue.remove(0);
    }

    public T front() throws NoSuchElementException
    {
        return this.myQueue.get(0);
    }

    public int size()
    {
        return x;
    }

    public boolean isEmpty()
    {
        if(x != 0)
            return true;
        return false;
    }

    public void clear()
    {
        this.myQueue = new ArrayList<T>();

    }



}
