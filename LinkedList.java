import java.util.NoSuchElementException;

/**
   A linked list is a sequence of nodes with efficient
   element insertion and removal. This class
   contains a subset of the methods of the standard
   java.util.LinkedList class.
*/
public class LinkedList
{
	private Node first;


   /**
      Constructs an empty linked list.
   */
   public LinkedList()
   {
	   first = null;
   }




   /**
      Returns the first element in the linked list.
      @return the first element in the linked list
   */
   public Object getFirst()
   {
	   if(first == null){
	   		throw new NoSuchElementException();}
	   return first.data;
   }

   /**
      Removes the first element in the linked list.
      @return the removed element
   */
   public Object removeFirst()
   {
	   if(first == null){
		   throw new NoSuchElementException();}
	   Object obj = first.data; //so you can return
	   first = first.next; //change first reference to the next Node
	   return obj;
   }





   /**
      Adds an element to the front of the linked list.
      @param element the element to add
   */
   public void addFirst(Object obj)
   {
	   Node newNode = new Node();
	   newNode.data = obj; //makes it an alias
	   newNode.next = first; //alias to next node
	   first = newNode;
   }





   /**
      Returns an iterator for iterating through this list.
      @return an iterator for iterating through this list
   */
   public LinkedListIterator listIterator()
   {
	   return new LinkedListIterator(); //create Iterator class and returns it
   }





   //Class Node
   class Node
   {
	   public Object data;
	   public Node next;
   }


   class LinkedListIterator //implements ListIterator
   {
	  //private data
	  private Node position; // keeps track of where we are
	  private Node previous;
	  private boolean isAfterNext; //basics flag for when next is called



      /**
         Constructs an iterator that points to the front
         of the linked list.
      */
      public LinkedListIterator()
      {
		  //You're welcome Liz
		  position = null;
		  previous = null;
		  isAfterNext = false;
	  }


      /**
         Moves the iterator past the next element.
         @return the traversed element
      */
      public Object next()
      {
		  if(!hasNext()){
		  	throw new NoSuchElementException();}

		  previous = position; //remember for remove
		  isAfterNext = true;

		  if(posiion = null) //if | is at the start, before the first node
		  {position = first;
		  }

		  else
		  {
			  position = position.next;
		  }
		  return position.data;
  	  }




      /**
         Tests if there is an element after the iterator position.
         @return true if there is an element after the iterator position
      */
      public boolean hasNext()
      {

	  }


      /**
         Adds an element before the iterator position
         and moves the iterator past the inserted element.
         @param element the element to add
      */






      /**
         Removes the last traversed element. This method may
         only be called after a call to the next() method.
      */







      /**
         Sets the last traversed element to a different value.
         @param element the element to set
      */




   }//LinkedListIterator
}//LinkedList
