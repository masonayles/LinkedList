import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class LinkedListTest {

    private LinkedList<String> list;

    @Before
    public void setUp() {
        list = new LinkedList<>();
    }

    @Test
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

    @Test
    public void testAddAtIndexOutOfBounds() {
        list.add("A");
        list.add("B");

        assertThrows(IndexOutOfBoundsException.class, () -> list.add(3, "X"));
    }

    @Test
    public void testAddLast() {
        list.add("A");
        list.add("B");

        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals(2, list.size());
    }


    @Test
    public void testClear() {
        list.add("A");
        list.add("B");
        list.clear();

        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    public void testGet() {
        list.add("A");
        list.add("B");

        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
    }

    @Test
    public void testGetOutOfBounds() {
        list.add("A");

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
    }

    @Test
    public void testIndexOf() {
        list.add("A");
        list.add("B");

        assertEquals(0, list.indexOf("A"));
        assertEquals(1, list.indexOf("B"));
        assertEquals(-1, list.indexOf("C"));
    }

    @Test
    public void testIsEmpty() {
        assertTrue(list.isEmpty());

        list.add("A");
        assertFalse(list.isEmpty());
    }

    @Test
    public void testRemove() {
        list.add("A");
        list.add("B");
        String removed = list.remove(0);

        assertEquals("A", removed);
        assertEquals(1, list.size());
        assertEquals("B", list.get(0));
    }

    @Test
    public void testRemoveOutOfBounds() {
        list.add("A");

        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(1));
    }

    @Test
    public void testRemoveFirst() {
        list.add("A");
        list.add("B");
        String removed = list.remove(0);

        assertEquals("A", removed);
        assertEquals(1, list.size());
        assertEquals("B", list.get(0));
    }

    @Test
    public void testRemoveLast() {
        list.add("A");
        list.add("B");
        String removed = list.remove(1);

        assertEquals("B", removed);
        assertEquals(1, list.size());
        assertEquals("A", list.get(0));
    }

    @Test
    public void testRemoveFirstEmptyList() {
        LinkedList<String> emptyList = new LinkedList<>();
        assertThrows(NoSuchElementException.class, () -> emptyList.remove(0));
    }

    @Test
    public void testRemoveLastEmptyList() {
        LinkedList<String> emptyList = new LinkedList<>();
        assertThrows(NoSuchElementException.class, () -> emptyList.remove(emptyList.size() - 1));
    }




    @Test
    public void testSet() {
        list.add("A");
        list.add("B");
        String previous = list.set(1, "X");

        assertEquals("B", previous);
        assertEquals("A", list.get(0));
        assertEquals("X", list.get(1));
    }

    @Test
    public void testSetOutOfBounds() {
        list.add("A");

        assertThrows(IndexOutOfBoundsException.class, () -> list.set(1, "X"));
    }

    @Test
    public void testSize() {
        assertEquals(0, list.size());

        list.add("A");
        list.add("B");
        assertEquals(2, list.size());
    }



    // Add more test methods for error scenarios, if needed.

}
