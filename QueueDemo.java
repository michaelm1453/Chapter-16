public class QueueDemo
{
   public static void main(String[] args)
   {
      CircularArrayQueue q = new CircularArrayQueue();

      q.add("a");
      q.add("b");
      q.add("c");
      q.add("d");

      while (!q.empty())
      {
         q.remove();
      }
   }
}
