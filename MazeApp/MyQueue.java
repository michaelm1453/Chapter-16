package MazeApp;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MyQueue<T> implements QueueADT<T>
{
    public ArrayList<T> myQueue;
    public MyQueue()
    {
        myQueue = new ArrayList<T>();     
    }
    public void enqueue(T item){//adds to the end ArrayList automatically adds to the end
        myQueue.add(item);

    }

    public T dequeue() throws NoSuchElementException
    {
        
        if(myQueue.size() != 0)
        {
           return this.myQueue.remove(0);
        }
        else 
            throw new NoSuchElementException();
        
    }

    public T front() throws NoSuchElementException
    {
        if(myQueue.size() != 0)
           return this.myQueue.get(0);
        else 
            throw new NoSuchElementException();
            
    }

    public int size()
    {
        return myQueue.size();
    }

    public boolean isEmpty()
    {
        if(size() == 0)
            return true;
        return false;
    }

    public void clear()
    {
        myQueue.clear();
    }
    
    class Node
    {
        private Object data;
        private Node newNode;
    }



}
