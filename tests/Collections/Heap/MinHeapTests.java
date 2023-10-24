package Collections.Heap;

import org.junit.jupiter.api.Test;

public class MinHeapTests {

    @Test
    public void some() {
        MinHeap<Integer> heap = new MinHeap<>(Integer.class);
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
        System.out.println(heap.size());
        heap.pop();
        System.out.println(heap.size());
    }
}
