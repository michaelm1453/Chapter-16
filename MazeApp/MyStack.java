package MazeApp;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Implementation of a stack
 *
 * @author
 * @version 1
 */
public class MyStack<T> implements StackADT<T>
{
    private ArrayList<T> stack;
    int Size = 0;


    /**
     * Constructor
     *
     */
    public MyStack()
    {
        this.stack = new ArrayList<T>();
    }


    /**
     * Add an item onto the stack
     * @param item the data item to add (of type T)
     */

     public void push(T element)
     {
         Size++;
         this.stack.add(0, element);
         
     }






    /**
     * Remove the top item from the stack
     * @return the top item in the stack
     * @throws NoSuchElementException if the stack is empty
     */
    public T pop() throws NoSuchElementException
    {
        Size --;
        if(this.isEmpty())
            throw new NoSuchElementException();
        return this.stack.remove(0);


    }

    /**
     * Display the top item from the stack without removing it
     * @return the top item in the stack
     * @throws NoSuchElementException if the stack is empty
     */
    public T top() throws NoSuchElementException
    {
        return this.stack.get(0);

    }

    /**
     * Find how many items are in the stack
     * @return the number of items in the stack
     */

     public int size()
     {
         return Size;
     }





    /**
     * Determine if the stack is empty
     * @return true if the size is 0, false otherwise
     */
     public boolean isEmpty()
     {
         if(Size == 0)
            return true;

         return false;
     }





    /**
     * Clear out the data structure
     */
    public void clear()
    {
        this.stack.clear();
    }

    public String toString()
    {
        String str = "[";
        for(int x = 0; x < Size; x ++)
            str += this.stack.get(x) + ",";

        str += "]";

        return str;
    }
}
