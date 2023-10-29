import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class LinkedListTest {
    public static void main(String[] args) {
        testAdd();
        testAddAt();
        testRemove();
        testClear();
        testGet();
        testIndexOf();
        testIsEmpty();
        testSet();
        testReverseIterator();
        testEdgeCases();
    }

    public static void testAdd() {
        LinkedList<Integer> list = new LinkedList<>();

        // Test add and size
        assert list.isEmpty();
        list.add(1);
        assert list.size() == 1;
        list.add(2);
        assert list.size() == 2;
    }

    public static void testAddAt() {
        LinkedList<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(3);

        // Test add at specific index
        list.add(1, 2); // Insert 2 at index 1
        assert list.get(1) == 2;
        assert list.size() == 3;

        list.add(0, 0); // Insert 0 at the beginning
        assert list.get(0) == 0;
        assert list.size() == 4;

        list.add(4, 4); // Insert 4 at the end
        assert list.get(4) == 4;
        assert list.size() == 5;
    }

    public static void testRemove() {
        LinkedList<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        // Test remove
        int removed = list.remove(1); // Remove the element at index 1 (which is 2)
        assert removed == 2;
        assert list.size() == 2;
        assert list.get(1) == 3;

        removed = list.remove(0); // Remove the first element (which is 1)
        assert removed == 1;
        assert list.size() == 1;
        assert list.get(0) == 3;
    }

    public static void testClear() {
        LinkedList<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);

        // Test clear
        list.clear();
        assert list.isEmpty();
        assert list.size() == 0;
    }

    public static void testGet() {
        LinkedList<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);

        // Test get
        assert list.get(0) == 1;
        assert list.get(1) == 2;
    }

    public static void testIndexOf() {
        LinkedList<String> list = new LinkedList<>();

        list.add("apple");
        list.add("banana");
        list.add("cherry");

        // Test indexOf
        assert list.indexOf("banana") == 1;
        assert list.indexOf("kiwi") == -1;
    }

    public static void testIsEmpty() {
        LinkedList<Integer> list = new LinkedList<>();

        // Test isEmpty
        assert list.isEmpty();
        list.add(1);
        assert !list.isEmpty();
    }

    public static void testSet() {
        LinkedList<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);

        // Test set
        int replaced = list.set(0, 3); // Replace the element at index 0 (which is 1) with 3
        assert replaced == 1;
        assert list.get(0) == 3;
    }



    public static void testReverseIterator() {
        LinkedList<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        // Test reverse iteration
        int sum = 0;
        Iterator<Integer> reverseIterator = list.reverseIterator();
        while (reverseIterator.hasNext()) {
            sum += reverseIterator.next();
        }
        assert sum == 6;
    }

    public static void testEdgeCases() {
        LinkedList<Integer> list = new LinkedList<>();

        // Test edge cases

        // Test get on an empty list
        try {
            list.get(0);
            assert false; // Should not reach here
        } catch (IndexOutOfBoundsException e) {
            assert true;
        }

        // Test add at out-of-bounds index
        try {
            list.add(2, 5);
            assert false; // Should not reach here
        } catch (IndexOutOfBoundsException e) {
            assert true;
        }

        // Test set on an empty list
        try {
            list.set(0, 5);
            assert false; // Should not reach here
        } catch (IndexOutOfBoundsException e) {
            assert true;
        }

        // Test set at out-of-bounds index
        try {
            list.add(1, 10);
            assert false; // Should not reach here
        } catch (IndexOutOfBoundsException e) {
            assert true;
        }

        // Test remove on an empty list
        try {
            list.remove(0);
            assert false; // Should not reach here
        } catch (IndexOutOfBoundsException e) {
            assert true;
        }

        // Test remove at out-of-bounds index
        try {
            list.add(1, 10);
            list.remove(2);
            assert false; // Should not reach here
        } catch (IndexOutOfBoundsException e) {
            assert true;
        }

        // Test iterator concurrent modification
        try {
            Iterator<Integer> iterator = list.iterator();
            list.add(5);
            iterator.next();
            assert false; // Should not reach here
        } catch (ConcurrentModificationException e) {
            assert true;
        }
    }
}

