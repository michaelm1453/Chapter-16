import java.util.NoSuchElementException;

/**
   An implementation of a stack as a sequence of nodes.
*/
public class LinkedListStack
{
   private Node top;

   /**
      Constructs an empty stack.
   */
   public LinkedListStack()
   {
      top = null;
   }

   /**
      Adds an element to the top of the stack.
      @param element the element to add
   */
   public void push (Object element){
	   Node newNode = new Node();
	   newNode.data = element; // reference to new data in stack
	   newNode.next = top; //Points to the previous top of the stack
	   top = newNode; //Sets the top as what was just passed in



   }






   /**
      Removes the element from the top of the stack.
      @return the removed element
   */
   public Object pop(){
	   if(top == null){
		   throw new NoSuchElementException();}

	   Object temp = top.data; //gets the first data
	   top = top.next; //move to the next node

	   return temp;
   }








   /**
      Checks whether this stack is empty.
      @return true if the stack is empty
   */
   public boolean empty()
   {
	   return top == null;
   }



   class Node
   {
      public Object data;
      public Node next;
   }
}
