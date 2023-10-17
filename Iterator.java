public interface Iterator<E>
{
   /**
    * Returns true if the iteration has more elements.
    * @return returns true if the iteration has more elements.
    */
   boolean hasNext();

   /**
    * Returning the next element in the iteration.
    * @return Returns the next element in the iteration.
    */
   E next();
}
