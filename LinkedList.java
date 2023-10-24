import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Class LinkedList<E> is a doubly linked list of LinkedListNode
 * Such a node contains a reference to some object of type E.
 * @param <E>
 */
public class LinkedList<E> implements Iterable<E>
{
   private LinkedListNode head;
   private LinkedListNode tail;
   private int size;
   private long modcount;

   /**
    * Constructs an empty list
    */
   public LinkedList()
   {
      head = null;
      tail = null;
      size = 0;
      modcount = 0;
   }

   /**
    * Inserts the specified element at the specified position in this list.
    * Shifts the element currently at that position (if any) and any
    * subsequent elements to the right (adds one to their indices).
    * @param index Param index is the index at which the specified element is to be inserted.
    * @param element Param element is the element that is to be inserted.
    * @throws IndexOutOfBoundsException Throws IndexOutOfBoundException if index is out of bounds
    */
   public void add(int index, E element)
   {
      if (index < 0 || index > size)
      {
         throw new IndexOutOfBoundsException("Invalid Index");
      }
      // Appending to the end of the list if the condition is true.
      if (index == size)
      {
         addLast(element);
      }
      // If the condition above is false we need to insert the element at a specified position.
      else
      {
         LinkedListNode currentNode = head;
         // linear searching the list to find the node at specified index.
         for (int i = 0; i < index; i++)
         {
            currentNode = currentNode.getNext();
         }
         // Making a new node.
         LinkedListNode newNode = new LinkedListNode(element, currentNode.getPrevious(), currentNode);

         // Updating the previous node to point to the new node.
         if (currentNode.getNext() != null)
         {
            currentNode.getPrevious().setNext(newNode);
         }
         else
         {
            head = newNode;
         }
         // Updating the current node to point to the new node.
         currentNode.setPrevious(newNode);
         size++;
      }
   }

   /**
    * This method appends the specified element to the end of this list.
    * @param element element is the specified element that is to be appeneded to this list.
    * @return returns true
    */
   public boolean add(E element)
   {
      addLast(element);
      return true;
   }

   /**
    * Removes all the elements from this list. The list will be empty after this call returns.
    */
   public void clear()
   {
      head = null;
      tail = null;
      size = 0;
      modcount ++; // TODO: do I increment modcount in clear?
   }

   /**
    * This is returning the element at the specified position in this list.
    * @param index index is the specified index of the element to return.
    * @return returns the element at the specified position in this list.
    */
   public E get(int index)
   {
      if (index < 0 || index >= size)
      {
         throw new IndexOutOfBoundsException("Index out of bounds");
      }
      // Reference to the head which is used to linear search through the list.
      LinkedListNode currentNode = head;

      // Linear searching through the list to find the node at specified location.
      for (int i = 0; i < index; i++)
      {
         currentNode = currentNode.getNext();
      }
      return currentNode.getValue();
   }

   /**
    * Returns the index of the first occurrence of the specified element in this list,
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
      return size == 0;
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
      if (index > 0 || index >= size)
      {
         throw new IndexOutOfBoundsException("Index out of bounds");
      }
      LinkedListNode currentNode = head;
      // Linear searching through the list to find the node at the specified index.
      for (int i = 0; i < index; i++)
      {
         currentNode = currentNode.getNext();
      }
      // Storing the value to be replaced
      E removedElement = currentNode.getValue();
      // Updating the value of the node at the specified index with new element.
      currentNode.setValue(element);
      return removedElement;
   }

   /**
    * Returns the number of elements in this list.
    * @return returns the number of elements in this list.
    */
   public int size()
   {
      return size;
   }

   /**
    *
    * @return
    */
   public Iterator<E> iterator()
   {
      return new LinkedListIterator(false);
   }

   /**
    * Returns an iterator over the elements in this deque in reverse sequential order.
    * the elements will be returned in order from last to first.
    * @return Return the elements from tail to head.
    */
   public Iterator<E> reverseIterator()
   {
      return new LinkedListIterator(true);
   }

   /**
    * Helper method that is used for simplicity and exception handling within
    * the add methods.
    * @param element Element to be added first.
    */
   private void addFirst(E element)
   {
      if (isEmpty())
      {
         // If the list is empty, create a new node with the provided element
         // and make it both the head and the tail of the list.
         head = new LinkedListNode(element);
         tail = head;
      }
      else
      {
         // If the list is not empty, create a new node with the provided element,
         // and set its "next" reference to the current head.
         LinkedListNode newNode = new LinkedListNode(element, null, head);
         // Update the previous reference of the current head to point to the new node.
         head.setPrevious(newNode);
         // Update the head of the list to be the new node.
         head = newNode;
      }
      size++;
   }

   /**
    * Helper method that is used for simplicity and exception handling within
    * the add methods.
    * @param element Element to be added.
    */
   private void addLast(E element)
   {
      if (isEmpty())
      {
         head = new LinkedListNode(element);
         tail = head;
      }
      else
      {
         LinkedListNode newNode = new LinkedListNode(element, tail, null);
         tail.setNext(newNode);
         tail = newNode;
      }
      size++;
   }

   /**
    * Helper method used when removing element. Specifically the first node.
    * @return Returning the element to be removed.
    */
   private E removeFirst()
   {
      if (head == null)
      {
         throw new NoSuchElementException("List is empty");
      }
      // Getting the value of the first element.
      E elementRemoved = head.getValue();

      if (head == tail)
      {
         // If theirs only one element, set both the head and tail
         // to null making the lit empty
         head = null;
         tail = null;
      }
      // Updating the head to be the next element.
      else
      {
         head = head.getNext();
         head.setPrevious(null);
      }
      size--;
      return elementRemoved;
   }

   /**
    * Helper method used when removing element. Specifically the last node.
    * @return Returning the element to be removed.
    */
   private E removeLast()
   {
      if (tail == null)
      {
         throw new NoSuchElementException("List is empty");
      }
      E elementRemoved = tail.getValue();

      if (head == tail)
      {
         head = null;
         tail = null;
      }
      else
      {
         tail = tail.getPrevious();
         tail.setNext(null);
      }
      size--;
      return elementRemoved;
   }

   /**
    *
    */
   public class LinkedListNode
   {
      private E _value;
      private LinkedListNode _previous;
      private LinkedListNode _next;

      /**
       *
       */
      public LinkedListNode()
      {
         this(null);
      }

      /**
       *
       * @param value
       */
      public LinkedListNode(E value)
      {
         this(value, null, null);
      }

      /**
       *
       * @param value
       * @param prev
       * @param next
       */
      public LinkedListNode(E value, LinkedListNode prev, LinkedListNode next)
      {
         _value =  value;
         _previous = prev;
         _next = next;
      }

      /**
       *
       * @return
       */
      public E getValue()
      {
         return _value;
      }

      /**
       *
       * @return
       */
      public LinkedListNode getPrevious()
      {
         return _previous;
      }

      /**
       *
       * @return
       */
      public LinkedListNode getNext()
      {
         return _next;
      }

      /**
       *
       * @param value
       */
      public void setValue(E value)
      {
         this._value = value;
      }

      /**
       *
       * @param prev
       */
      public void setPrevious(LinkedListNode prev)
      {
         this._previous = prev;
      }

      /**
       *
       * @param next
       */
      public void setNext(LinkedListNode next)
      {
         this._next = next;
      }
   }

   /**
    *
    */
   public class LinkedListIterator implements Iterator<E>
   {
      private LinkedListNode _cursor;
      private boolean _reverse;

      /**
       *
       * @param reverse
       */
      public LinkedListIterator(boolean reverse)
      {
         this._reverse = reverse;
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

