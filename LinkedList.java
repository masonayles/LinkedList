/**
 * Class LinkedList<E> is a doubly linked list of LinkedListNode
 * Such a node contains a reference to some object of type E.
 * @param <E>
 */
public class LinkedList<E> implements Iterable
{

   /**
    * Constructs an empty list
    */
   public LinkedList()
   {

   }

   /**
    * Inserts the specified element at the specified position in this list.
    * Shifts the element currently at that position (if any) and any
    * subsequent elements to the right (adds one to their indices).
    * @param index Param index is the index at which the specified element is to be inserted.
    * @param element Param element is the element that is to be inserted.
    */
   public void add(int index, E element)
   {

   }

   /**
    * This method appends the specified element to the end of this list.
    * @param element element is the specified element that is to be appeneded to this list.
    * @return returns true
    */
   public boolean add(E element)
   {

   }

   /**
    * Removes all the elements from this list. The list will be empty after this call returns.
    */
   public void clear()
   {

   }

   /**
    * This is returning the element at the specified position in this list.
    * @param index index is the specified index of the element to return.
    * @return returns the element at the specified position in this list.
    */
   public E get(int index)
   {

   }

   /**
    * Returns the index of the first occurrance of the specified element in this list,
    * or -1 if this list does not contain the element. More formally, returns the
    * lowest index i or -1 if there is no such index.
    * @param element element is the specified element to search for.
    * @return
    */
   public int indexOf(E element)
   {

   }

   /**
    * returns true if this list contains no elements.
    * @return returns true if this list contains no elements.
    */
   public boolean isEmpty()
   {

   }

   /**
    * Removes the element at the specified position inthis list.
    * Shifts any subsequent elements to the left. Returns the element
    * that was removed from the list.
    * @param index index is the index of the element to be removed.
    * @return returning the element previously at the specified position.
    * @Throws throws index out of bounds exception
    */
   public E remove(int index)
   {

   }

   /**
    * Replaces the element at the specified position in this list
    * with the specified element.
    * @param index index is the index of the element to replace.
    * @param element element to be stored at the specified position.
    * @return returning the element previously at the specified position.
    */
   public E set(int index, E element)
   {

   }

   /**
    * Returns the number of elements in this list.
    * @return returns the number of elements in this list.
    */
   public int size()
   {

   }

   /**
    *
    * @return
    */
   public Iterator<E> iterator()
   {

   }

   /**
    * Returns an iterator over the elements in this deque in reverse sequential order.
    * the elements will be returned in order from last to first.
    * @return Return the elements from tail to head.
    */
   public Iterator<E> reverseIterator()
   {

   }

   /**
    *
    */
   public class LinkedListNode
   {

      /**
       *
       */
      public LinkedListNode()
      {

      }

      /**
       *
       * @param value
       */
      public LinkedListNode(E value)
      {

      }

      /**
       *
       * @param value
       * @param prev
       * @param next
       */
      public void LinkedlistNode(E value, LinkedListNode prev, LinkedListNode next)
      {

      }

      /**
       *
       * @return
       */
      public E getValue()
      {

      }

      /**
       *
       * @return
       */
      public LinkedListNode getPrevious()
      {

      }

      /**
       *
       * @return
       */
      public LinkedListNode getNext()
      {

      }

      /**
       *
       * @param value
       */
      public void setValue(E value)
      {

      }

      /**
       *
       * @param prev
       */
      public void setPrevious(LinkedListNode prev)
      {

      }

      /**
       *
       * @param next
       */
      public void setNext(LinkedListNode next)
      {

      }
   }

   /**
    *
    */
   public class LinkedListIterator implements Iterator<E> // Do i need <E>?
   {

      /**
       *
       * @param reverse
       */
      public LinkedListIterator(boolean reverse)
      {

      }

      /**
       *
       * @return
       */
      public boolean hasNext()
      {

      }

      /**
       *
       * @return
       */
      public E next()
      {

      }
   }
}

