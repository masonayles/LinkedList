import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import java.util.NoSuchElementException;
import java.util.Iterator;

public class LinkedListTester
{
    private static LinkedList<Integer> _basicList;

    private static void setUpBasicTest()
    {
        _basicList = new LinkedList<>();
        for (int i = 0; i < 22; i++)
        {
            _basicList.add(i);
        }
    }

    @Test
    public void test_LinkedList_ctor_valid_int()
    {
        // Arrange
        LinkedList<Integer> list;
        // Act
        list = new LinkedList<>();
        // Assert
        assertNotNull(list);
        assertThat(list, isA(LinkedList.class));
    }

    @Test
    public void test_LinkedList_ctor_valid_string()
    {
        // Arrange
        LinkedList<String> list;
        // Act
        list = new LinkedList<>();
        // Assert
        assertNotNull(list);
        assertThat(list, isA(LinkedList.class));
    }

    @Test
    public void test_LinkedList_ctorCapacity_valid_int()
    {
        // Arrange
        LinkedList<Integer> list;
        // Act
        list = new LinkedList<>();
        // Assert
        assertNotNull(list);
        assertThat(list, isA(LinkedList.class));
    }

    @Test
    public void test_LinkedList_ctorCapacity_valid_string()
    {
        // Arrange
        LinkedList<String> list;
        // Act
        list = new LinkedList<>();
        // Assert
        assertNotNull(list);
        assertThat(list, isA(LinkedList.class));
    }


    @Test
    public void test_LinkedList_ctorCapacity_zeroCapacity()
    {
        // Arrange
        LinkedList<String> list;
        // Act
        list = new LinkedList<>();
        // Assert
        assertNotNull(list);
        assertThat(list, isA(LinkedList.class));
    }





    @Test
    public void test_LinkedList_addIE_valid_noGrow()
    {
        // Arrange
        LinkedList<Integer> list;
        // Act
        list = new LinkedList<>();
        list.add(0, 7);
        // Assert
        assertTrue(7 == list.get(0));
    }

    @Test
    public void test_LinkedList_addIE_valid_grow()
    {
        // Arrange
        LinkedList<Integer> list;
        // Act
        list = new LinkedList<>();
        for (int i = 0; i < 5; i++)
        {
            list.add(i, i);
        }
        // Assert
        for (int i = 0; i < 5; i++)
        {
            assertTrue(list.get(i) == i);
        }
    }

    @Test
    public void test_LinkedList_addIE_belowZero()
    {
        // Arrange
        LinkedList<Integer> list = new LinkedList<>();
        // Assert
        assertThrows(IndexOutOfBoundsException.class,
                () -> { list.add(-1, 7); });
    }

    @Test
    public void test_LinkedList_addIE_indexTooLarge()
    {
        // Arrange
        LinkedList<Integer> list = new LinkedList<>();
        // Assert
        assertThrows(IndexOutOfBoundsException.class,
                () -> { list.add(1, 7); });
    }

    @Test
    public void test_LinkedList_addIE_valid_growFromZero()
    {
        // Arrange
        LinkedList<Integer> list = new LinkedList<>();

        // Act
        for (int i = 0; i <= 5; i++)
        {
            list.add(i, i);
        }

        // Assert
        for (int i = 0; i <= 5; i++)
        {
            assertTrue(list.get(i) == i);
        }
    }


    @Test
    public void test_LinkedList_addE_valid_noGrow()
    {
        // Arrange
        LinkedList<Integer> list = new LinkedList<>();
        int addMe = 7;
        // Act
        list.add(addMe);
        // Assert
        assertTrue(list.add(addMe));
    }

    @Test
    public void test_LinkedList_addE_valid_grow()
    {
        // Arrange
        LinkedList<Integer> list = new LinkedList<>();

        // Act
        for (int i = 0; i <= 5; i++)
        {
            list.add(i);
        }

        // Assert
        for (int i = 0; i <= 5; i++)
        {
            assertTrue(list.get(i) == i);
        }
    }


    @Test
    public void test_LinkedList_addE_valid_growFromZero()
    {
        // Arrange
        LinkedList<Integer> list = new LinkedList<>();

        // Act
        for (int i = 0; i <= 5; i++)
        {
            list.add(i);
        }

        // Assert
        for (int i = 0; i <= 5; i++)
        {
            assertTrue(list.get(i) == i);
        }
    }


    @Test
    public void test_LinkedList_clear()
    {
        // Arrange
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i <= 5; i++)
        {
            list.add(i);
        }
        // Act
        list.clear();
        // Assert
        assertTrue(list.size() == 0);
    }

    @Test
    public void test_LinkedList_clear_onZeroSize()
    {
        // Arrange
        LinkedList<Integer> list = new LinkedList<>();
        // Act
        list.clear();
        // Assert
        assertTrue(list.size() == 0);
    }

    @Test
    public void test_LinkedList_get_valid_int()
    {
        // Arrange
        LinkedList<Integer> list = new LinkedList<>();
        int addMe = 7;
        // Act
        list.add(addMe);
        // Assert
        assertTrue(addMe == list.get(0));
        assertThat(list.get(0), isA(Integer.class));
    }

    @Test
    public void test_LinkedList_get_valid_nullObject()
    {
        // Arrange
        LinkedList<Object> list = new LinkedList<>();
        // Act
        list.add(null);
        // Assert
        assertNull(list.get(0));
    }

    @Test
    public void test_LinkedList_get_indexLessThanZero()
    {
        // Arrange
        LinkedList<Integer> list = new LinkedList<>();
        int addMe = 7;
        // Act
        list.add(addMe);
        // Assert
        assertThrows(IndexOutOfBoundsException.class,
                () -> { list.get(-1); });
    }

    @Test
    public void test_LinkedList_get_indexGreaterThanSize()
    {
        // Arrange
        LinkedList<Integer> list = new LinkedList<>();
        // Assert
        assertThrows(IndexOutOfBoundsException.class,
                () -> { list.get(0); });
    }

    @Test
    public void test_LinkedList_indexOf_simpleInt()
    {
        // Arrange
        LinkedList<Integer> list = new LinkedList<>();
        // Act
        for (int i = 0; i < 22; i++)
        {
            list.add(i);
        }
        // Assert
        for (int i = 0; i < 22; i++)
        {
            assertTrue(i == list.indexOf(i));
        }
    }

    @Test
    public void test_LinkedList_indexOf_String()
    {
        // Arrange
        LinkedList<String> list = new LinkedList<>();
        // Act
        list.add("Hello");
        // Assert
        assertEquals(0, list.indexOf("Hello"));
    }

    @Test
    public void test_LinkedList_indexOf_missingNull()
    {
        // Arrange
        LinkedList<String> list = new LinkedList<>();
        // Act
        // Assert
        assertTrue(-1 == list.indexOf(null));
    }

    @Test
    public void test_LinkedList_indexOf_findingNull()
    {
        // Arrange
        LinkedList<String> list = new LinkedList<>();
        // Act
        list.add(null);
        // Assert
        assertTrue(0 == list.indexOf(null));
    }

    @Test
    public void test_LinkedList_isEmpty_afterClear()
    {
        // Arrange
        setUpBasicTest();
        // Act
        _basicList.clear();
        // Assert
        assertTrue(_basicList.isEmpty());
    }

    @Test
    public void test_LinkedList_isEmpty_beforeClear()
    {
        // Arrange
        setUpBasicTest();
        // Assert
        assertFalse(_basicList.isEmpty());
    }

    @Test
    public void test_LinkedList_isEmpty_emptyList()
    {
        // Arrange
        LinkedList<Object> list = new LinkedList<>();
        // Assert
        assertTrue(list.isEmpty());
    }

    @Test
    public void test_LinkedList_isEmpty_removedList()
    {
        // Arrange
        setUpBasicTest();
        // Act
        int nElements = _basicList.size();
        for (int i = 0; i < nElements; i++)
        {
            _basicList.remove(0);
        }
        // Assert
        assertTrue(_basicList.isEmpty());
    }

    @Test
    public void test_LinkedList_remove_int()
    {
        // Arrange
        LinkedList<Integer> list = new LinkedList<>();
        // Act
        list.add(99);
        for (int i = 0; i < 22; i++)
        {
            list.add(i);
        }
        int bigSize = list.size();
        // Assert
        for (int i = 0; i < 22; i++)
        {
            assertFalse(i == list.get(i));
        }

        assertTrue(99 == list.remove(0));

        for (int i = 0; i < 22; i++)
        {
            assertTrue(i == list.get(i));
        }

        assertEquals(bigSize - 1, list.size());
    }

    @Test
    public void test_LinkedList_set_simple()
    {
        // Arrange
        LinkedList<Integer> list = new LinkedList<>();
        // Act
        list.add(7);
        // Assert
        assertTrue(7 ==  list.set(0, 99));
        assertTrue(99 ==  list.get(0));
    }

    @Test
    public void test_LinkedList_set_atEnd()
    {
        // Arrange
        setUpBasicTest();
        // Assert
        assertTrue(_basicList.get(_basicList.size() - 1) ==
                _basicList.set(_basicList.size() - 1, 99));
        assertTrue(99 ==  _basicList.get(_basicList.size() - 1));
    }

    @Test
    public void test_LinkedList_set_atBeginning()
    {
        // Arrange
        setUpBasicTest();
        // Assert
        assertTrue(0 == _basicList.set(0, 7));
        assertTrue(7 == _basicList.get(0));
    }

    @Test
    public void test_LinkedList_set_indexBelowZero()
    {
        // Arrange
        setUpBasicTest();
        // Assert
        assertThrows(IndexOutOfBoundsException.class,
                () -> { _basicList.set(-1, 7); });
    }

    @Test
    public void test_LinkedList_set_indexTooLarge()
    {
        // Arrange
        setUpBasicTest();
        // Assert
        assertThrows(IndexOutOfBoundsException.class,
                () -> { _basicList.set(_basicList.size(), 7); });
    }

    @Test
    public void test_LinkedList_size_ctorNoArg()
    {
        // Arrange
        LinkedList<Integer> list = new LinkedList<>();
        // Assert
        assertTrue(0 == list.size());
    }

    @Test
    public void test_LinkedList_size_ctorArgs()
    {
        // Arrange
        LinkedList<Integer> list = new LinkedList<>();
        // Assert
        assertTrue(0 == list.size());
    }

    @Test
    public void test_LinkedList_size_ctorArgsZero()
    {
        // Arrange
        LinkedList<Integer> list = new LinkedList<>();
        // Assert
        assertTrue(0 == list.size());
    }

    @Test
    public void test_LinkedList_removeIndexOutOfBounds() {
        // Arrange
        LinkedList<Integer> list = new LinkedList<>();

        // Act and Assert
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(0);  // Attempt to remove an element from an empty list
        });
    }

    @Test
    public void test_LinkedList_indexOfNullElement() {
        // Arrange
        LinkedList<String> list = new LinkedList<>();

        // Act
        list.add(null);

        // Assert
        assertEquals(0, list.indexOf(null));
    }

    @Test
    public void test_LinkedList_Iterable_forEachAfterRemove() {
        // Arrange
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        // Act: Removing the element at index 5
        list.remove(5);

        // Initialize a sum variable to calculate the sum of elements using forEach
        int sum = 0;

        // Use an Iterator to loop through the elements
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            sum += element;
        }

        // Assert: The sum should be the sum of elements 0 + 1 + 2 + 3 + 4 + 6 + 7 + 8 + 9
        assertEquals(40, sum);
    }

    @Test
    public void test_LinkedList_removeFromEmptyList() {
        // Arrange
        LinkedList<Integer> list = new LinkedList<>();

        // Act
        // Try to remove an element from an empty list

        // Assert
        assertEquals(0, list.size());
    }
    @Test
    public void test_LinkedList_add_correctSizeAfterAddRemoveAdd() {
        // Arrange
        LinkedList<Integer> list = new LinkedList<>();

        // Act: Adding elements
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        // Assert: The initial size should be 10
        assertEquals(10, list.size());

        // Act: Removing elements
        for (int i = 0; i < 5; i++) {
            list.remove(0);
        }

        // Assert: The size should be reduced after removal
        assertEquals(5, list.size());

        // Act: Adding more elements
        for (int i = 10; i < 15; i++) {
            list.add(i);
        }

        // Assert: The size should reflect all the added elements
        assertEquals(10, list.size());
    }

    @Test
    public void test_LinkedList_remove_maintainsSize() {
        // Arrange
        LinkedList<Integer> list = new LinkedList<>();

        // Act: Adding elements
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        // Assert: The initial size should be 10
        assertEquals(10, list.size());

        // Act: Removing elements
        for (int i = 0; i < 5; i++) {
            list.remove(0);
        }

        // Assert: The size should be reduced after removal
        assertEquals(5, list.size());

        // Act: Removing more elements
        for (int i = 0; i < 5; i++) {
            list.remove(0);
        }

        // Assert: The size should reflect all the removals
        assertEquals(0, list.size());
    }

    @Test
    public void test_LinkedList_size_append()
    {
        // Arrange
        LinkedList<Integer> list = new LinkedList<>();
        // Act
        list.add(7);
        // Assert
        assertTrue(1 == list.size());
    }

    @Test
    public void test_LinkedList_size_insert()
    {
        // Arrange
        LinkedList<Integer> list = new LinkedList<>();
        // Act
        list.add(0, 7);
        list.add(0, 7);
        // Assert
        assertTrue(2 == list.size());
    }

    @Test
    public void test_LinkedList_size_clear()
    {
        // Arrange
        LinkedList<Integer> list = new LinkedList<>();
        // Act
        list.clear();
        // Assert
        assertTrue(0 == list.size());
    }

    @Test
    public void test_LinkedList_size_remove()
    {
        // Arrange
        LinkedList<Integer> list = new LinkedList<>();
        // Act
        list.add(7);
        list.remove(0);
        // Assert
        assertTrue(0 == list.size());
    }

    @Test
    public void test_LinkedList_size_set()
    {
        // Arrange
        LinkedList<Integer> list = new LinkedList<>();
        // Act
        list.add(7);
        list.set(0, 99);
        // Assert
        assertTrue(1 == list.size());
    }
}

// Continue adapting and renaming your test cases for other methods.


