package LinkedList;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTests {

    private void compare(LinkedList<String> expected, ArrayList<String> actual) {
        for (int i = 0; i < expected.size(); i++)
            assertEquals(expected.get(i).getElement().toString(), actual.get(i).toString());
    }

    @Test
    public void addingAnElementShouldSucceed() {
        LinkedList<String> list = new LinkedList<String>();
        list.add("test1");
        assertEquals(1, list.size());
        assertEquals("test1", list.get(0).getElement());
    }

    @Test
    public void OneElement_CalledToString_ReceivesCorrectPreviousAndElementAndNext() {
        LinkedList<String> list = new LinkedList<String>();
        list.add("OneElement");
        assertEquals("Node { previous = null | element = OneElement | next = null}", list.toString());
    }

    @Test
    public void TwoElements_CalledToString_ReceivesCorrectPreviousAndElementAndNext() {
        LinkedList<String> list = new LinkedList<String>();
        list.add("OneElement");
        list.add("TwoElements");
        assertEquals("Node { previous = null | element = OneElement | next = TwoElements}\n" +
                "Node { previous = OneElement | element = TwoElements | next = null}", list.toString());
    }

    @Test
    public void FourElements_CalledToString_ReceivesCorrectPreviousAndElementAndNext() {
        LinkedList<String> list = new LinkedList<String>();
        list.add("OneElement");
        list.add("TwoElements");
        list.add("ThreeElements");
        list.add("FourElements");

        assertEquals("""
                        Node { previous = null | element = OneElement | next = TwoElements}
                        Node { previous = OneElement | element = TwoElements | next = ThreeElements}
                        Node { previous = TwoElements | element = ThreeElements | next = FourElements}
                        Node { previous = ThreeElements | element = FourElements | next = null}"""
                , list.toString());
    }

    @Test
    public void EmptyList_AddingElementWithGivenIndexAtIndex0_ListCorrectlyAddsElement() {
        LinkedList<String> list = new LinkedList<String>();
        list.add("ElementAtIndex0", 0);

        ArrayList<String> expectedList = new ArrayList<>();
        expectedList.add("ElementAtIndex0");

        compare(list,expectedList);
    }
}
