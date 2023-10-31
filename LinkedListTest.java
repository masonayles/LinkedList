import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

    public static void main(String[] args) {
        LinkedListTest testClass = new LinkedListTest();
        testClass.testGetOutOfBounds();
        testClass.testIsEmpty();
        testClass.testRemove();
        testClass.testRemoveOutOfBounds();
        testClass.testRemoveFirst();
        testClass.testRemoveLast();
        testClass.testRemoveFirstEmptyList();
        testClass.testRemoveLastEmptyList();
        testClass.testSet();
        testClass.testSetOutOfBounds();
        testClass.testSize();
        testClass.testAddNegativeIndex();
        testClass.testRemoveNegativeIndex();
        testClass.testRemoveDuringIteration();
        testClass.testIteratorAfterRemoval();
        testClass.testAddAtIndex();
        testClass.testLinkedListReverseIteratorLargeList();
        testClass.testLinkedListAddAtIndexZero();
    }

    private LinkedList<String> list;

    public LinkedListTest() {
        list = new LinkedList<>();
    }

    public void testGetOutOfBounds() {
        list.add("A");
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
    }



    public void testIsEmpty() {
        assertTrue(list.isEmpty());

        list.add("A");
        assertFalse(list.isEmpty());
    }

    public void testRemove() {
        list.add("A");
        list.add("B");
        String removed = list.remove(0);

        assertEquals("A", removed);
        assertEquals(1, list.size());
        assertEquals("B", list.get(0));
    }

    public void testRemoveOutOfBounds() {
        list.add("A");
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(1));
    }

    public void testRemoveFirst() {
        list.add("A");
        list.add("B");
        String removed = list.remove(0);

        assertEquals("A", removed);
        assertEquals(1, list.size());
        assertEquals("B", list.get(0));
    }

    public void testRemoveLast() {
        list.add("A");
        list.add("B");
        String removed = list.remove(1);

        assertEquals("B", removed);
        assertEquals(1, list.size());
        assertEquals("A", list.get(0));
    }

    public void testRemoveFirstEmptyList() {
        LinkedList<String> emptyList = new LinkedList<>();
        assertThrows(NoSuchElementException.class, () -> emptyList.remove(0));
    }

    public void testRemoveLastEmptyList() {
        LinkedList<String> emptyList = new LinkedList<>();
        assertThrows(NoSuchElementException.class, () -> emptyList.remove(emptyList.size() - 1));
    }

    public void testSet() {
        list.add("A");
        list.add("B");
        String previous = list.set(1, "X");

        assertEquals("B", previous);
        assertEquals("A", list.get(0));
        assertEquals("X", list.get(1));
    }

    public void testSetOutOfBounds() {
        list.add("A");
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(1, "X"));
    }

    public void testSize() {
        assertEquals(0, list.size());

        list.add("A");
        list.add("B");
        assertEquals(2, list.size());
    }

    public void testAddNegativeIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(-1, "X"));
    }

    public void testRemoveNegativeIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
    }

    public void testRemoveDuringIteration() {
        list.add("A");
        list.add("B");
        Iterator<String> iterator = list.iterator();
        iterator.next();
        list.remove(0);
        assertThrows(ConcurrentModificationException.class, () -> iterator.next());
    }

    public void testIteratorAfterRemoval() {
        list.add("A");
        Iterator<String> iterator = list.iterator();
        list.remove(0);
        assertFalse(iterator.hasNext());
    }

    public void testAddAtIndex() {
        list.add("A");
        list.add("B");
        list.add("C");
        list.add(1, "X");

        assertEquals("A", list.get(0));
        assertEquals("X", list.get(1));
        assertEquals("B", list.get(2));
        assertEquals("C", list.get(3));
        assertEquals(4, list.size());
    }

    public void testLinkedListReverseIteratorLargeList() {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        Iterator<Integer> iterator = list.reverseIterator();

        for (int i = 99; i >= 90; i--) {
            assertTrue(iterator.hasNext());
            assertEquals(Optional.of(i), iterator.next());
        }
    }

    public void testLinkedListAddAtIndexZero() {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("C");

        list.add(1, "B");

        assertEquals(3, list.size());
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
    }
}
