import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;

/**
 * Class LinkedList<E> is a doubly linked list of LinkedListNode
 * Such a node contains a reference to some object of type E.
 * @param <E>
 */
public class LinkedList<E> implements Iterable<E>
{
   private LinkedListNode _head;
   private LinkedListNode _tail;
   private int _size;
   private long _modcount;

   /**
    * Constructs an empty list
    */
   public LinkedList()
   {
      _head = null;
      _tail = null;
      _size = 0;
      _modcount = 0;
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
      if (index < 0 || index > _size)
      {
         throw new IndexOutOfBoundsException("Invalid Index");
      }
      // Appending to the end of the list if the condition is true.
      if (index == _size)
      {
         addLast(element);
      }
      // If the condition above is false we need to insert the element at a specified position.
      else if (index ==0)
      {
         addFirst(element);
      }
      else
      {
         LinkedListNode currentNode = _head;
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
            _head = newNode;
         }
         // Updating the current node to point to the new node.
         currentNode.setPrevious(newNode);
         _size++;
         _modcount++;
      }
   }

   /**
    * This method appends the specified element to the end of this list.
    * @param element element is the specified element that is to be appended to this list.
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
      LinkedListNode currentNode = _head;

      while (currentNode != null) {
         LinkedListNode nextNode = currentNode.getNext();
         currentNode.setNext(null);
         currentNode.setPrevious(null);
         currentNode = nextNode;
      }
      _head = null;
      _tail = null;
      _size = 0;
      _modcount ++; // TODO: do I increment modcount in clear?
   }

   /**
    * This is returning the element at the specified position in this list.
    * @param index index is the specified index of the element to return.
    * @return returns the element at the specified position in this list.
    */
   public E get(int index) {
      if (index < 0 || index >= _size) {
         throw new IndexOutOfBoundsException("Index out of bounds");
      }

      if (index == _size - 1) {
         // Special case: Get the last element (index == _size - 1)
         return _tail.getValue();
      }

      LinkedListNode currentNode = _head;

      // Linear searching through the list to find the node at the specified index.
      for (int i = 0; i < index; i++) {
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
      int index = 0;
      LinkedListNode current = _head;

      //Linear searching through the whole list
      while (current != null) {
         if ((element == null && current.getValue() == null) || (element != null && element.equals(current.getValue()))) {
            return index;
         }
         current = current.getNext();
         index++;
      }
      return -1;
   }

   /**
    * returns true if this list contains no elements.
    * @return returns true if this list contains no elements.
    */
   public boolean isEmpty()
   {
      return _size == 0;
   }

   /**
    * Removes the element at the specified position in this list.
    * Shifts any subsequent elements to the left. Returns the element
    * that was removed from the list.
    * @param index index is the index of the element to be removed.
    * @return returning the element previously at the specified position.
    * @Throws throws index out of bounds exception
    */
   public E remove(int index)
   {
      if (index < 0 || index >= _size)
      {
         throw new IndexOutOfBoundsException("Index out of bounds");
      }
      // If index = 0 call my remove first method and same for last
      if (index == 0)
      {
         return removeFirst();
      }
      else if (index == _size - 1)
      {
         return removeLast();
      }
      else
      {
         // If the index is not found in the first or last this is how I
         // find the node at the specified index.
         LinkedListNode currentNode = _head;
         for(int i = 0; i < index; i++)
         {
            currentNode = currentNode.getNext();
         }
         // Updates the reverence for previous and next.
         LinkedListNode previous = currentNode.getPrevious();
         LinkedListNode next = currentNode.getNext();
         previous.setNext(next);
         next.setPrevious(previous);
         _size--;
         _modcount++;
         // Returning the element that was removed.
         return currentNode.getValue();
      }
   }

   public E set(int index, E element) {
      if (index < 0 || index >= _size) {
         throw new IndexOutOfBoundsException("Index out of bounds");
      }

      if (index == _size - 1) {
         // Special case: Set the last element (index == _size - 1)
         if (_size == 1) {
            // If theres only one element in the list, update both head and tail.
            E removedElement = _head.getValue();
            _head.setValue(element);
            _tail.setValue(element);
            return removedElement;
         } else {
            // If theres more than one element, update the tail.
            E removedElement = _tail.getValue();
            _tail.setValue(element);
            return removedElement;
         }
      }

      LinkedListNode currentNode = _head;

      // Linear searching through the list to find the node at the specified index.
      for (int i = 0; i < index; i++) {
         currentNode = currentNode.getNext();
      }

      // Storing the value to be replaced
      E removedElement = currentNode.getValue();
      // Updating the value of the node at the specified index with the new element.
      currentNode.setValue(element);
      return removedElement;
   }


   /**
    * Returns the number of elements in this list.
    * @return returns the number of elements in this list.
    */
   public int size()
   {
      return _size;
   }

   /**
    * Method that returns a new LinkedListIterator.
    * @return Returns a new LinkedListIterator.
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
         _head = new LinkedListNode(element);
         _tail = _head;
      }
      else
      {
         // If the list is not empty, create a new node with the provided element,
         // and set its "next" reference to the current head.
         LinkedListNode newNode = new LinkedListNode(element, null, _head);
         // Update the previous reference of the current head to point to the new node.
         _head.setPrevious(newNode);
         // Update the head of the list to be the new node.
         _head = newNode;
      }
      _size++;
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
         _head = new LinkedListNode(element);
         _tail = _head;
      }
      else
      {
         LinkedListNode newNode = new LinkedListNode(element, _tail, null);
         _tail.setNext(newNode);
         _tail = newNode;
      }
      _size++;
   }

   /**
    * Helper method used when removing element. Specifically the first node.
    * @return Returning the element to be removed.
    */
   private E removeFirst()
   {
      if (_head == null)
      {
         throw new NoSuchElementException("List is empty");
      }
      // Getting the value of the first element.
      E elementRemoved = _head.getValue();

      if (_head == _tail)
      {
         // If theirs only one element, set both the head and tail
         // to null making the lit empty
         _head = null;
         _tail = null;
      }
      // Updating the head to be the next element.
      else
      {
         _head = _head.getNext();
         if (_head != null)
         {
            _head.setPrevious(null);
         }
      }
      _size--;
      return elementRemoved;
   }

   /**
    * Helper method used when removing element. Specifically the last node.
    * @return Returning the element to be removed.
    */
   private E removeLast()
   {
      if (_tail == null)
      {
         throw new NoSuchElementException("List is empty");
      }
      E elementRemoved = _tail.getValue();

      if (_head == _tail)
      {
         _head = null;
         _tail = null;
      }
      else
      {
         _tail = _tail.getPrevious();
         _tail.setNext(null);
      }
      _size--;
      return elementRemoved;
   }

   /**
    * Class LinkedListNode is used for initializing each individual node.
    * and assigning it a previous, next, and its value.
    */
   public class LinkedListNode
   {
      private E _value;
      private LinkedListNode _previous;
      private LinkedListNode _next;

      /**
       * Constructor LinkedListNode used to a null value.
       */
      public LinkedListNode()
      {
         this(null);
      }

      /**
       * Constructor LinkedListNode is used to assign a value given to each node.
       * @param value Value is the value given to be stored.
       */
      public LinkedListNode(E value)
      {
         this(value, null, null);
      }

      /**
       * Constructor LinkedlistNode is used to initialize the value, previous
       * and next for each node.
       * @param value Value is being assigned to _value.
       * @param prev Prev is being assigned to _prev.
       * @param next Next is being assigned to _next.
       */
      public LinkedListNode(E value, LinkedListNode prev, LinkedListNode next)
      {
         _value =  value;
         _previous = prev;
         _next = next;
      }

      /**
       * getValue method returns the _value of node.
       * @return Returning value of the node.
       */
      public E getValue()
      {
         return _value;
      }

      /**
       * getPrevious returns previous node.
       * @return Returns previous node.
       */
      public LinkedListNode getPrevious()
      {
         return _previous;
      }

      /**
       * getNext returns the next value in the list.
       * @return returns next node.
       */
      public LinkedListNode getNext()
      {
         return _next;
      }

      /**
       * setValue is assigning _value to value.
       * @param value Value is the given value for the node.
       */
      public void setValue(E value)
      {
         this._value = value;
      }

      /**
       * setPrevious is assigning _previous to prev.
       * @param prev Prev is the setting _previous to prev.
       */
      public void setPrevious(LinkedListNode prev)
      {
         this._previous = prev;
      }

      /**
       * setNext method is assigning the next LinkedListNode to next.
       * @param next _next is being set to next
       */
      public void setNext(LinkedListNode next)
      {
         this._next = next;
      }
   }

   /**
    * Inner class that implements Iterator interface, and it uses the LinkedListNode
    * and new variable cursor to keep track of where the iterator is through hasNext
    * method.
    */
   public class LinkedListIterator implements Iterator<E>
   {
      private LinkedListNode _cursor;
      private boolean _reverse;
      private long _expectedModCount;

      /**
       *
       * @param reverse
       */
      public LinkedListIterator(boolean reverse)
      {
         this._reverse = reverse;
         // Get the current mod count.
         this._expectedModCount = _modcount;

         if (reverse)
         {
            _cursor = _tail;
         }
         else
         {
            _cursor = _head;
         }
      }

      /**
       * hasNext method checks for a concurrent modification exception throughout the iteration.
       * and throws an error if the list has been modified during the iteraton.
       * @return Returning _cursor != null.
       */
      public boolean hasNext()
      {
         if (_expectedModCount != _modcount)
         {
         throw new ConcurrentModificationException("List has been modified");
         }
         return _cursor != null;
      }

      /**
       * next() is a method that checks for concurrent modification exceptions
       * and throws an error if the list was modified through the iteration.
       * @return
       */
      public E next()
      {
         if (_expectedModCount != _modcount)
         {
            throw new ConcurrentModificationException("List has been modified");
         }
         if (!hasNext())
         {
            throw new NoSuchElementException();
         }
         E element = _cursor.getValue();

         if (_reverse)
         {
            _cursor = _cursor.getPrevious();
         }
         else
         {
            _cursor = _cursor.getNext();
         }

         if (_expectedModCount != _modcount)
         {
            throw new ConcurrentModificationException("List has been modified");
         }
         return element;
      }
   }
}

