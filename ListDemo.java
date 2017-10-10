/**
   A program that demonstrates the LinkedList class
*/
public class ListDemo
{
   public static void main(String[] args){

	  //create LinkedList and add to it

      LinkedList staff = new LinkedList();
      ListIterator iterator = staff.listIterator();
      staff.addFirst("wheeee");
      staff.addFirst("Liz is useless");
      staff.addFirst("Liz is very useless");
      staff.addFirst("Liz is really useless");
      staff.addFirst("Liz is extremely useless");
      staff.addFirst("Liz is more useless than you thought was humanly possible");

      System.out.println(staff.size());


/*      // | in the comments indicates the iterator position
      staff.addFirst("G");
      staff.addFirst("H");
      staff.addFirst("J");
      staff.addFirst("K");
      //KJHG
      staff.removeFirst();
      //JHG


      // Add more elements after second element
      iterator.next();
      iterator.next();
      iterator.add("After Second");
      //JH After Second G


      // Remove last traversed element
      iterator = staff.listIterator();
      //iterator.remove();
      iterator.next();
      iterator.remove();
      //H After Second G



      // Print all elements

      iterator = staff.listIterator();
      while (iterator.hasNext())
      {
         System.out.print(iterator.next() + " ");
      }
      System.out.println();*/
   }
}
