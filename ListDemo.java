/**
   A program that demonstrates the LinkedList class
*/
public class ListDemo
{
   public static void main(String[] args)

	  //create LinkedList and add to it

      LinkedList staff = new LinkedList();


      // | in the comments indicates the iterator position


      // Add more elements after second element



      // Remove last traversed element



      // Print all elements

      iterator = staff.listIterator();
      while (iterator.hasNext())
      {
         System.out.print(iterator.next() + " ");
      }
      System.out.println();
   }
}
