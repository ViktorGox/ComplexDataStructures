package MyCollections.Heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MinHeapTests {

    @Test
    public void EmptyMinHeap_AddingSomeElements_WorksCorrectly() {
        MinHeap<Integer> heap = new MinHeap<>(Integer.class);
        assertTrue(heap.isEmpty());

        for (int i = 0; i < 16; i++) {
            heap.push(i);
        }
        assertFalse(heap.isEmpty());
        assertEquals(0, heap.peek());
        assertEquals(16, heap.size());
    }

    @Test
    public void MinHeapWithSomeElement_Popping_AlwaysReturnsSmallest() {
        MinHeap<Integer> heap = new MinHeap<>(Integer.class);
        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());
        for (int i = 0; i < 16; i++) {
            heap.push(i);
        }
        assertFalse(heap.isEmpty());
        assertEquals(0, heap.peek());
        assertEquals(16, heap.size());
        int initialSize = heap.size();
        for (int i = 0; i < initialSize; i++) {
            assertEquals(i, heap.pop());
        }
        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());
        assertNull(heap.pop());
        assertNull(heap.peek());
    }

    @Test
    public void MinheapWith15Elements_BuildingHeapIncludingLeftAndRightAsFirst_PerformedCorrectly() {
        MinHeap<Integer> heap = new MinHeap<>(Integer.class);
        assertTrue(heap.isEmpty());
        heap.push(92);
        heap.push(47);
        heap.push(21);
        heap.push(20);
        heap.push(12);
        heap.push(45);
        heap.push(63);
        heap.push(61);
        heap.push(17);
        heap.push(55);
        heap.push(37);
        heap.push(25);
        heap.push(64);
        heap.push(83);
        heap.push(73);
        assertFalse(heap.isEmpty());
        assertEquals(15, heap.size());
        assertEquals(12, heap.peek());
    }

    @Test
    public void MakingMinHeapWithTClassNull_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
                new MinHeap<Integer>(null)
        );
    }
}
