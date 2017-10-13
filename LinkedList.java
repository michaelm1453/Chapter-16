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
	private static int size = 0;




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

   private static int size(Node start)
   {
	   if(start == null)
	   		return size;
	   if(start.next!= null){
	   		start = start.next;
		    size ++;
		    size(start);
	   	}

	   	return size +1;


   }

   public int size()
   {
	   return size(first);
   }

   public boolean contains(Object obj)
   {
	    Node temp = first;
	    if(temp.data.equals(obj))
	   		return true;
	   	if(temp.next.data != null)
	   		return contains(temp.next.data);


	   	return false;

   }





   /*public int size() {
	   return this.first==null ? 0 : sizeHelper(this.first);


   }
   private int sizeHelper(Node a) {
	   if (a.next!=null) {
		   return 1+sizeHelper(a.next);
	   }
	   return 1;
   }*/ //KEEP BECAUSE IT'S beautiful





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


   class LinkedListIterator implements ListIterator
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

		  if(position == null) //if | is at the start, before the first node
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
		  if(position == null){ //are we at the beginning
			  return first != null;
		  }
		  else { //if current is not knull, is the next node equal to knull
			  return position.next != null;
		  }

	  }


      /**
         Adds an element before the iterator position
         and moves the iterator past the inserted element.
         @param element the element to add
      */
      public void add(Object element){
		  if(position == null){//nothing in the list yet
			  addFirst(element);
			  position = first; //first node
		  }
		  else{
			  Node newNode = new Node();
			  newNode.data = element; //alias/reference
			  newNode.next = position.next; //what is next
			  position.next = newNode; //Iterator knows wha the next is now
			  position = newNode; //current position is the newNode, little conflict if remove() is called
		  }
		  isAfterNext = false;


	  }






      /**
         Removes the last traversed element. This method may
         only be called after a call to the next() method.
      */
      public void remove()
      {
		  if(!isAfterNext) //flag false
		  	  throw new IllegalStateException();
		  if(position == first)
		  {
			  removeFirst(); //call the premade method
		  }
		  else{
			  previous.next = position.next; //moving the reference
		  }
		  //current position in the iterator is previous
		  position = previous;
		  isAfterNext = false;

	  }







      /**
         Sets the last traversed element to a different value.
         @param element the element to set
      */
      public void set(Object element){
		  if(!isAfterNext)
		  	throw new IllegalStateException();

		  position.data = element;
	  }




   }//LinkedListIterator
}//LinkedList
