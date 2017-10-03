public class StackDemo
{
   public static void main(String[] args)
   {
      LinkedListStack s = new LinkedListStack();
      //.push()
      s.push("Tom");
      s.push("Diana");
      s.push("Harry");
      while(!s.empty())
      {
		  System.out.println(s.pop());
	  }


	  //while !empty .pop()

   }
}
