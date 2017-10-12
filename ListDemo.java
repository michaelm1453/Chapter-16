/**
   A program that demonstrates the LinkedList class
*/
public class ListDemo
{
   public static void main(String[] args){

	  //create LinkedList and add to it

      LinkedList staff = new LinkedList();
      ListIterator iterator = staff.listIterator();
      staff.addFirst("1");
      staff.addFirst("2");
      staff.addFirst("3");
      staff.addFirst("4");
      staff.addFirst("5");
      staff.addFirst("6");
      System.out.println(staff.contains("8)"));

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
