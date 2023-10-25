package Collections.Heap;

import org.junit.jupiter.api.Test;

public class MinHeapTests {

    @Test
    public void some() {
        MinHeap<Integer> heap = new MinHeap<>(Integer.class);
        for (int i = 0; i < 16; i++) {
            heap.push(i);
        }
        System.out.println();
        heap.pop();
        System.out.println(heap);
    }
}
