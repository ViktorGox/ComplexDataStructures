package LinkedList;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTests {
    private <T> void compareLinkedListToArrayList(LinkedList<T> expected, ArrayList<T> actual) {
        for (int i = 0; i < actual.size(); i++)
            assertEquals(expected.get(i), actual.get(i));
    }

    private <T> void compareArrayToArray(T[] expected, T[] actual) {
        for (int i = 0; i < actual.length; i++)
            assertEquals(expected[i], actual[i]);
    }

    //region add(T data)
    @Test
    public void EmptyArray_AddingOneElement_ElementIsAddedSuccessfully() {
        LinkedList<String> list = new LinkedList<String>();
        list.add("test1");

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("test1");

        compareLinkedListToArrayList(list, arrayList);
    }

    @Test
    public void EmptyArray_AddingFourElement_ElementIsAddedSuccessfully() {
        LinkedList<String> list = new LinkedList<String>();
        list.add("e1");
        list.add("e2");
        list.add("e3");
        list.add("e4");

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("e1");
        arrayList.add("e2");
        arrayList.add("e3");
        arrayList.add("e4");

        compareLinkedListToArrayList(list, arrayList);
    }

    @Test
    public void EmptyList_AddingNullElement_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            LinkedList<String> list = new LinkedList<String>();
            list.add(null);
        });
    }

    @Test
    public void EmptyList_AddingElementsWithoutGivenIndex_ListCorrectlyAddsElement() {
        LinkedList<String> list = new LinkedList<String>();
        list.add("ElementAtIndex0");
        list.add("ElementAtIndex1");
        list.add("ElementAtIndex2");

        ArrayList<String> expectedList = new ArrayList<>();
        expectedList.add("ElementAtIndex0");
        expectedList.add("ElementAtIndex1");
        expectedList.add("ElementAtIndex2");

        compareLinkedListToArrayList(list, expectedList);
    }

    //endregion

    //region add(T data, int index)
    @Test
    public void EmptyList_AddingOneElementWithGivenIndexAtIndex0_ListCorrectlyAddsElement() {
        LinkedList<String> list = new LinkedList<String>();
        list.add("ElementAtIndex0", 0);
        ArrayList<String> expectedList = new ArrayList<>();
        expectedList.add(0, "ElementAtIndex0");

        compareLinkedListToArrayList(list, expectedList);
    }

    @Test
    public void EmptyList_AddingTwoElementsWithGivenIndexAtIndex0_ListCorrectlyAddsElement() {
        LinkedList<String> list = new LinkedList<String>();
        list.add("ElementAtIndex0", 0);
        list.add("ElementAtIndex1", 0);
        ArrayList<String> expectedList = new ArrayList<>();
        expectedList.add(0, "ElementAtIndex0");
        expectedList.add(0, "ElementAtIndex1");

        compareLinkedListToArrayList(list, expectedList);
    }

    @Test
    public void EmptyList_AddingElementAtTheSizeIndex_ListCorrectlyAddsElement() {
        LinkedList<String> list = new LinkedList<String>();
        list.add("ElementAtIndex0", 0);
        list.add("ElementAtIndex1", 1);
        ArrayList<String> expectedList = new ArrayList<>();
        expectedList.add(0, "ElementAtIndex0");
        expectedList.add(1, "ElementAtIndex1");

        compareLinkedListToArrayList(list, expectedList);
    }

    @Test
    public void EmptyList_AddingElementsInMiddle_ListCorrectlyAddsElement() {
        LinkedList<String> list = new LinkedList<String>();
        list.add("ElementAtIndex0", 0);
        list.add("ElementAtIndex1", 1);
        list.add("ElementAtIndex2", 1);
        list.add("ElementAtIndex3", 1);
        list.add("ElementAtIndex4", 1);

        ArrayList<String> expectedList = new ArrayList<>();
        expectedList.add(0, "ElementAtIndex0");
        expectedList.add(1, "ElementAtIndex1");
        expectedList.add(1, "ElementAtIndex2");
        expectedList.add(1, "ElementAtIndex3");
        expectedList.add(1, "ElementAtIndex4");

        compareLinkedListToArrayList(list, expectedList);
    }

    @Test
    public void EmptyList_AddingOneElementsWithOutOfBoundsIndex_ThrowsException() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            LinkedList<String> list = new LinkedList<String>();
            list.add("ElementAtIndex0", 1);
        });
    }

    @Test
    public void EmptyArray_AddingNullElement_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            LinkedList<String> list = new LinkedList<String>();
            list.add(null, 0);
        });
    }

    @Test
    public void EmptyArray_AddingElementWithIndexBelow0_ThrowsException() {
        LinkedList<String> list = new LinkedList<String>();
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.add("data", -1));
    }

    //endregion

    //region get(int index) (getNodeOf(int index))

    @Test
    public void ListWithOneElement_GetIndexAt0_GivesItemAt0() {
        LinkedList<String> list = new LinkedList<String>();
        list.add("data");
        assertEquals("data", list.get(0));
    }

    @Test
    public void ListWithTwoElements_GetIndexAt0_GivesItemAt0() {
        LinkedList<String> list = new LinkedList<String>();
        list.add("data");
        list.add("data1");
        assertEquals("data", list.get(0));
    }

    @Test
    public void ListWithFourElements_GetIndexAtEnd_GivesCorrectItem() {
        LinkedList<String> list = new LinkedList<String>();
        list.add("data");
        list.add("data1");
        list.add("data2");
        list.add("data3");
        assertEquals("data3", list.get(3));
    }

    @Test
    public void ListWithFourElements_GetIndexInMiddle_GivesCorrectItem() {
        LinkedList<String> list = new LinkedList<String>();
        list.add("data");
        list.add("data1");
        list.add("data2");
        list.add("data3");
        assertEquals("data2", list.get(2));
    }

    @Test
    public void ListWithFourElements_GetIndexOutsideOfSize_ThrowsException() {
        LinkedList<String> list = new LinkedList<String>();
        list.add("data");
        list.add("data1");
        list.add("data2");
        list.add("data3");
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.get(5));
    }

    @Test
    public void ListWithFourElements_GetIndexBelow0_ThrowsException() {
        LinkedList<String> list = new LinkedList<String>();
        list.add("data");
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.get(-1));
    }

    @Test
    public void EmptyList_GetIndexAt0_ThrowsException() {
        LinkedList<String> list = new LinkedList<String>();
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.get(0));
    }

    @Test
    public void ListWithOneElement_GetItemAtCorrectIndexBut_ThrowsException() {
        LinkedList<String> list = new LinkedList<String>();
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.get(0));
    }


    //endregion

    //region indexOf(T data)

    @Test
    public void ListWith4Elements_IndexOfElementAtIndex0_GivesCorrectData() {
        LinkedList<String> list = new LinkedList<String>();
        list.add("data");
        list.add("data1");
        list.add("data2");
        list.add("data3");
        assertEquals(0, list.indexOf("data"));
    }

    @Test
    public void ListWith4Elements_IndexOfElementAtIndexSize_GivesCorrectData() {
        LinkedList<String> list = new LinkedList<String>();
        list.add("data");
        list.add("data1");
        list.add("data2");
        list.add("data3");
        assertEquals(3, list.indexOf("data3"));
    }

    @Test
    public void ListWith4Elements_IndexOfElementAtIndex2_GivesCorrectData() {
        LinkedList<String> list = new LinkedList<String>();
        list.add("data");
        list.add("data1");
        list.add("data2");
        list.add("data3");
        assertEquals(2, list.indexOf("data2"));
    }

    @Test
    public void EmptyList_IndexOfElement_ReturnsMinus1() {
        LinkedList<String> list = new LinkedList<String>();
        assertEquals(-1, list.indexOf("data2"));
    }

    @Test
    public void ListWith1Element_IndexOfElementNull_ThrowsException() {
        LinkedList<String> list = new LinkedList<String>();
        list.add("e");
        assertThrows(IllegalArgumentException.class, () -> list.indexOf(null));
    }

    @Test
    public void EmptyList_IndexOfElementThatDoesNotExist_ReturnsMinus1() {
        LinkedList<String> list = new LinkedList<String>();
        list.add("1");
        assertEquals(-1, list.indexOf("data2"));
    }

    //endregion

    //region contains(T data)

    @Test
    public void ListWith2Elements_ContainsWithDataItHas_ReturnsTrue() {
        LinkedList<String> list = new LinkedList<String>();
        list.add("data");
        list.add("data2");
        assertTrue(list.contains("data"));
    }

    @Test
    public void ListWith2Elements_ContainsWithDataItDoesNotHave_ReturnsFalse() {
        LinkedList<String> list = new LinkedList<String>();
        list.add("data");
        list.add("data2");
        assertFalse(list.contains("data3"));
    }

    @Test
    public void ListWith2Elements_ContainsWithGivenNull_ReturnsFalse() {
        LinkedList<String> list = new LinkedList<String>();
        list.add("data");
        list.add("data2");
        assertFalse(list.contains(null));
    }

    //endregion

    //region set(int index, T data)

    @Test
    public void ListWithOneElement_SettingDataToNewValue_ChangedCorrectly() {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("data");

        ArrayList<String> list = new ArrayList<>();
        list.add("data");

        compareLinkedListToArrayList(linkedList, list);
        linkedList.set(0, "data1");
        list.set(0, "data1");

        compareLinkedListToArrayList(linkedList, list);
    }

    @Test
    public void ListWithOneElement_SettingDataToNull_NothingHappens() {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("data");

        ArrayList<String> list = new ArrayList<>();
        list.add("data");

        compareLinkedListToArrayList(linkedList, list);

        linkedList.set(0, null);

        compareLinkedListToArrayList(linkedList, list);
    }

    @Test
    public void ListWithOneElement_SettingDataToIndexMinusOne_ThrowsException() {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("data");

        ArrayList<String> list = new ArrayList<>();
        list.add("data");

        compareLinkedListToArrayList(linkedList, list);

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> linkedList.set(-1, "newData"));
    }

    @Test
    public void ListWithOneElement_SettingDataToIndex0_WorksCorrectly() {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("data");

        ArrayList<String> list = new ArrayList<>();
        list.add("data");

        compareLinkedListToArrayList(linkedList, list);

        assertDoesNotThrow(() -> linkedList.set(0, "newData"));

        list.set(0, "newData");

        compareLinkedListToArrayList(linkedList, list);
    }

    @Test
    public void ListWithThreeElement_SettingDataToIndexEqualToSize_WorksCorrectly() {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("data");
        linkedList.add("data1");
        linkedList.add("data2");

        ArrayList<String> list = new ArrayList<>();
        list.add("data");
        list.add("data1");
        list.add("data2");

        compareLinkedListToArrayList(linkedList, list);

        assertDoesNotThrow(() -> linkedList.set(2, "newData"));

        list.set(2, "newData");

        compareLinkedListToArrayList(linkedList, list);
    }

    @Test
    public void ListWithThreeElement_SettingDataToIndexEqualToMiddle_WorksCorrectly() {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("data");
        linkedList.add("data1");
        linkedList.add("data2");

        ArrayList<String> list = new ArrayList<>();
        list.add("data");
        list.add("data1");
        list.add("data2");

        compareLinkedListToArrayList(linkedList, list);

        assertDoesNotThrow(() -> linkedList.set(1, "newData"));

        list.set(1, "newData");

        compareLinkedListToArrayList(linkedList, list);

    }

    //endregion

    //region remove(T data) && remove(int index)

    @Test
    public void ListWithFourElements_RemovingElementAtMiddleIndex_ElementIsRemovedCorrectly() {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("data1");
        linkedList.add("data2");
        linkedList.add("data3");
        linkedList.add("data4");

        ArrayList<String> list = new ArrayList<>();
        list.add("data1");
        list.add("data2");
        list.add("data3");
        list.add("data4");

        compareLinkedListToArrayList(linkedList, list);

        linkedList.remove("data2");
        list.remove("data2");

        compareLinkedListToArrayList(linkedList, list);
    }

    @Test
    public void ListWithOneElement_RemovingElementAtIndex0_MakesListEmpty() {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("data1");

        linkedList.remove("data1");
        assertTrue(linkedList.isEmpty());
    }

    @Test
    public void ListWithTwoElements_RemovingElementAtIndex0_ElementIsCorrectlyRemoved() {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("data1");
        linkedList.add("data2");

        ArrayList<String> list = new ArrayList<>();
        list.add("data1");
        list.add("data2");

        compareLinkedListToArrayList(linkedList, list);

        linkedList.remove("data1");
        list.remove("data1");

        compareLinkedListToArrayList(linkedList, list);
    }

    @Test
    public void ListWithThreeElements_RemovingElementAtIndexSize_CorrectlyRemovesElement() {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("data1");
        linkedList.add("data2");
        linkedList.add("data3");

        ArrayList<String> list = new ArrayList<>();
        list.add("data1");
        list.add("data2");
        list.add("data3");

        compareLinkedListToArrayList(linkedList, list);

        linkedList.remove("data3");
        list.remove("data3");

        compareLinkedListToArrayList(linkedList, list);

    }

    @Test
    public void ListWithOneElement_RemovingElementThatDoesntExist_ReturnsNull() {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("data1");

        assertNull(linkedList.remove("data5"));
    }

    //endregion

    //region clear() size() getHead()

    @Test
    public void ListWithThreeElements_ClearingTheList_MakesTheListEmpty() {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("data1");
        linkedList.add("data2");
        linkedList.add("data3");

        linkedList.clear();
        assertTrue(linkedList.isEmpty());
    }

    @Test
    public void EmptyList_AddingMultipleElementsAndRemovingMultiple_GivesCorrectSize() {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("data1");
        linkedList.add("data2");
        linkedList.add("data3");

        assertEquals(3, linkedList.size());

        linkedList.remove("data1");

        assertEquals(2, linkedList.size());

        linkedList.remove(1);

        assertEquals(1, linkedList.size());

        linkedList.add("data4", 0);

        assertEquals(2, linkedList.size());

        linkedList.set(0, "SomeNewData");

        assertEquals(2, linkedList.size());
    }

    @Test
    public void EmptyList_GetHead_GivesCorrectElement() {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("data1");

        String headData = linkedList.get(0);

        assertEquals(headData, linkedList.getHead());
    }
    //endregion

    //region convertToArray()

    @Test
    public void ListWithMultipleElements_CovertToArray_ConvertedCorrectly() {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("data1");
        linkedList.add("data2");
        linkedList.add("data3");
        linkedList.add("data4");
        linkedList.add("data5");

        String[] linkedListConverted = new String[linkedList.size()];
        linkedListConverted = linkedList.convertToArray(linkedListConverted);

        String[] array = new String[]{"data1", "data2", "data3", "data4", "data5"};


        compareArrayToArray(array, linkedListConverted);
    }

    @Test
    public void EmptyList_ConvertedToArray_ThrowsException() {
        LinkedList<String> linkedList = new LinkedList<String>();

        assertThrows(IllegalStateException.class, () -> {
            String[] linkedListConverted = new String[linkedList.size()];
            linkedList.convertToArray(linkedListConverted);
        });
    }

    @Test
    public void ListWithElements_ConvertedToArrayWithDifferentSize_ThrowsException() {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("data1");
        linkedList.add("data2");

        assertThrows(IllegalArgumentException.class, () -> {
            String[] linkedListConverted = new String[linkedList.size() + 2];
            linkedList.convertToArray(linkedListConverted);
        });
    }

    //endregion

    //region convertFromArray(E[] existingArray)

    @Test
    public void NativeArrayWithMultipleElements_ConvertFromArrayToLinkedList_ConvertsCorrectly() {
        String[] array = new String[]{"a", "b", "c", "d", "e", "f"};

        assertDoesNotThrow(() -> {
            LinkedList<String> linkedList = LinkedList.convertFromArray(array);
        });

        LinkedList<String> linkedList = LinkedList.convertFromArray(array);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        arrayList.add("d");
        arrayList.add("e");
        arrayList.add("f");

        compareLinkedListToArrayList(linkedList, arrayList);
    }

    @Test
    public void NativeArrayWithZeroElements_ConvertFromArrayToLinkedList_ThrowsException() {
        String[] array = new String[0];

        assertThrows(IllegalStateException.class, () -> {
            LinkedList<String> linkedList = LinkedList.convertFromArray(array);
        });
    }

    //endregion

    //region sort()

    //endregion

    //region toString()
    @Test
    public void OneElement_CalledToString_ReceivesCorrectPreviousAndElementAndNext() {
        LinkedList<String> list = new LinkedList<String>();
        list.add("OneElement");
        assertEquals("Node { previous = null | data = OneElement | next = null}", list.toString());
    }

    @Test
    public void TwoElements_CalledToString_ReceivesCorrectPreviousAndElementAndNext() {
        LinkedList<String> list = new LinkedList<String>();
        list.add("OneElement");
        list.add("TwoElements");
        assertEquals("Node { previous = null | data = OneElement | next = TwoElements}\n" +
                "Node { previous = OneElement | data = TwoElements | next = null}", list.toString());
    }

    @Test
    public void FourElements_CalledToString_ReceivesCorrectPreviousAndElementAndNext() {
        LinkedList<String> list = new LinkedList<String>();
        list.add("OneElement");
        list.add("TwoElements");
        list.add("ThreeElements");
        list.add("FourElements");

        assertEquals("""
                        Node { previous = null | data = OneElement | next = TwoElements}
                        Node { previous = OneElement | data = TwoElements | next = ThreeElements}
                        Node { previous = TwoElements | data = ThreeElements | next = FourElements}
                        Node { previous = ThreeElements | data = FourElements | next = null}"""
                , list.toString());
    }

    //endregion
}