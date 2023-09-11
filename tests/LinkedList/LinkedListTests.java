package LinkedList;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTests {
    private <T> void compare(LinkedList<T> expected, ArrayList<T> actual) {
        for (int i = 0; i < expected.size(); i++)
            assertEquals(expected.get(i).getData(), actual.get(i));
    }

    //region add(T element)
    @Test
    public void EmptyArray_AddingOneElement_ElementIsAddedSuccessfully() {
        LinkedList<String> list = new LinkedList<String>();
        list.add("test1");

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("test1");

        compare(list,arrayList);
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

        compare(list, arrayList);
    }

    @Test
    public void EmptyList_AddingNullElement_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            LinkedList<String> list = new LinkedList<String>();
            list.add(null);
        });
    }
    //endregion

    //region add(T element, int index)
    @Test
    public void EmptyList_AddingOneElementWithGivenIndexAtIndex0_ListCorrectlyAddsElement() {
        LinkedList<String> list = new LinkedList<String>();
        list.add("ElementAtIndex0",0);
        ArrayList<String> expectedList = new ArrayList<>();
        expectedList.add(0,"ElementAtIndex0");

        compare(list,expectedList);
    }

    @Test
    public void EmptyList_AddingTwoElementsWithGivenIndexAtIndex0_ListCorrectlyAddsElement() {
        LinkedList<String> list = new LinkedList<String>();
        list.add("ElementAtIndex0",0);
        list.add("ElementAtIndex1",0);
        ArrayList<String> expectedList = new ArrayList<>();
        expectedList.add(0,"ElementAtIndex0");
        expectedList.add(0,"ElementAtIndex1");

        compare(list,expectedList);
    }

    @Test
    public void EmptyList_AddingTwoElementsWithGivenIndexAtIndex0And1_ListCorrectlyAddsElement() {
        LinkedList<String> list = new LinkedList<String>();
        list.add("ElementAtIndex0",0);
        list.add("ElementAtIndex1",1);
        ArrayList<String> expectedList = new ArrayList<>();
        expectedList.add(0,"ElementAtIndex0");
        expectedList.add(1,"ElementAtIndex1");

        compare(list,expectedList);
    }

//    @Test
//    public void EmptyList_AddingMutlipleElements_ListCorrectlyAddsElement() {
//        LinkedList<String> list = new LinkedList<String>();
//        list.add("ElementAtIndex0",0);
//        list.add("ElementAtIndex1",1);
//        ArrayList<String> expectedList = new ArrayList<>();
//        expectedList.add(0,"ElementAtIndex0");
//        expectedList.add(1,"ElementAtIndex1");
//
//        compare(list,expectedList);
//    }

    @Test
    public void EmptyList_AddingOneElementsWithOutOfBoundsIndex_ThrowsException() {
        assertThrows(ArrayIndexOutOfBoundsException.class, ()-> {
            LinkedList<String> list = new LinkedList<String>();
            list.add("ElementAtIndex0",1);
        });
    }

    @Test
    public void EmptyArray_AddingNullElement_ThrowsException() {
        assertThrows(IllegalArgumentException.class, ()-> {
            LinkedList<String> list = new LinkedList<String>();
            list.add(null,0);
        });
    }

    //endregion

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

        compare(list,expectedList);
    }

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
}
