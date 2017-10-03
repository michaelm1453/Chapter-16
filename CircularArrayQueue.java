import java.util.NoSuchElementException;

/**
   An implementation of a queue as a circular array.
*/
public class CircularArrayQueue
{
   private Object[] elements;
   private int currentSize;
   private int head; private int tail;
   //private data



   /**
      Constructs an empty queue.
   */
   public CircularArrayQueue(){
	   final int INITIAL_SIZE = 10;
	   elements= new Object[INITIAL_SIZE];
	   currentSize = 0;
	   head = 0;
	   tail = 0;
   }






   /**
      Checks whether this queue is empty.
      @return true if this queue is empty
   */
   public boolean empty()
   {
	   return currentSize == 0;
   }




   /**
      Adds an element to the tail of this queue.
      @param newElement the element to add
   */
   public void add(Object element)
   {
	   growIfNecessary();
	   currentSize ++;
	   //tail
	   elements[tail] = element;
	   tail = (tail + 1 ) % elements.length;
	   //nothing to do with head
   }





   /**
      Removes an element from the head of this queue.
      @return the removed element
   */
   public Object remove()
   {
	   if(currentSize == 0)
	   		throw new NoSuchElementException();

	   Object removed = elements[head]; //got element to be removed/returned
	   //adjust the position of the head
	   head = (head +1) % elements.length; //moves the head of the array
	   //curent size?
	   currentSize --;

	   return removed;

   }





   /**
      Grows the element array if the current size equals the capacity.
   */
   private void growIfNecessary()
   {
	   Object[] newElements = new Object[0];
	  	if(currentSize == elements.length)
    	{newElements = new Object[2 * currentSize];}

		for(int i = 0; i < elements.length; i++){
			newElements[i] = elements[i];
		}
		elements = newElements;//makes an alias
		head = 0;
		tail = currentSize;
   }





}//CircularArrayQueue
