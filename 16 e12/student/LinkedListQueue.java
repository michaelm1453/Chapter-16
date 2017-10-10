/**
   Implement a queue as a sequence of nodes.
*/
public class LinkedListQueue
{
   private Node head;
   private Node tail;

   /**
      Constructs an empty queue.
   */
   public LinkedListQueue()
   {
      head=null;
      tail=null;
   }

   /**
      Checks whether this queue is empty.
      @return true if this queue is empty
   */
   public boolean empty()
   {
      return head==null;
   }

   /**
      Adds an element to the tail of this queue.
      @param newElement the element to add
   */
   public void add(Object newElement)
   {
	  Object temp = new Object();

      head.data=newElement;
      /*
      Node temp = newElement;
      if(head == null){
		  head.data = newElement;
	  }
	  else{
		  tail.next = null;
	  }
	  tail.data = newElement;
      */
   }

   /**
      Removes an element from the head of this queue.
      @return the removed element
   */
   public Object remove()
   {
	   /*
	   if(head ==null)
	   		return null;
	   */
      Object temp = head;
      head = head.next;
      return temp;
   }

   class Node
   {
      public Object data;
      public Node next;
   }
}