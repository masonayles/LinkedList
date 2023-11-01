import org.junit.jupiter.api.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {
    @Test
    public void testIteratorHasNext() {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        Iterator<String> iterator = list.iterator();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testIteratorNext() {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        Iterator<String> iterator = list.iterator();

        assertEquals("A", iterator.next());
        assertEquals("B", iterator.next());
    }

    @Test
    public void testIteratorNextWithConcurrentModification() {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        Iterator<String> iterator = list.iterator();
        list.add("C"); // Modifying the list

        assertThrows(ConcurrentModificationException.class, iterator::next);
    }

    @Test
    public void testIteratorNextOnEmptyList() {
        LinkedList<String> list = new LinkedList<>();
        Iterator<String> iterator = list.iterator();

        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    public void testReverseIterator() {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        Iterator<String> reverseIterator = list.reverseIterator();

        assertEquals("B", reverseIterator.next());
        assertEquals("A", reverseIterator.next());
    }

    @Test
    public void testReverseIteratorWithConcurrentModification() {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        Iterator<String> reverseIterator = list.reverseIterator();
        list.add("C"); // Modifying the list

        assertThrows(ConcurrentModificationException.class, reverseIterator::next);
    }

    @Test
    public void testReverseIteratorOnEmptyList() {
        LinkedList<String> list = new LinkedList<>();
        Iterator<String> reverseIterator = list.reverseIterator();

        assertThrows(NoSuchElementException.class, reverseIterator::next);
    }
}
