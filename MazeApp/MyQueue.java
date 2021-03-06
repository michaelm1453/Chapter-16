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
    public void enqueue(T item){//adds to the end; ArrayList automatically adds to the end
        myQueue.add(item);

    }

    public T dequeue() throws NoSuchElementException
    {
        if(!this.isEmpty()) //removes the first element as long as such an element exists
        {
           return this.myQueue.remove(0);
        }
        else 
            throw new NoSuchElementException();
        
    }

    public T front() throws NoSuchElementException
    {
        if(!isEmpty()) //gets the first element, as long as such an element exists
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
        if(this.size() == 0)
            return true;
        return false;
    }

    public void clear()
    {
        myQueue.clear();
    }
    
    //class Node
    //{
      //  private Object data;
        //private Node newNode;
    //}



}
