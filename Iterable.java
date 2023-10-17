import java.util.Iterator;

/**
 * Implementing this interface allows an object to be the target of the
 * enhanced for statement.
 * @param <T> elements of type T.
 */
public interface Iterable<T>
{
   /**
    * Returns an iterator over elements of type T.
    * @return returns all elements of type T.
    */
   Iterator<T> iterator();
}
