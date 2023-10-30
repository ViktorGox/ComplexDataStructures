package MyCollections.Heap;

import MyCollections.IArray;

import java.lang.reflect.Array;
import java.util.Arrays;

// TODO: https://chat.openai.com/share/695ffb81-d43d-409e-be1a-b56506e84cbc for the log with size
public class MinHeap<T extends Comparable<T>> implements IHeap<T>, IArray {

    private T[] array;
    private final Class<T> classT;

    public MinHeap(Class<T> classT) {
        if(classT == null) throw new IllegalArgumentException("classT cannot be null!");
        this.classT = classT;
        array = (T[]) Array.newInstance(classT, 1); // Not using resize because at first it's not initialised, so it throws nullException
    }

    @Override
    public void push(T value) {
        if(value == null) throw new IllegalArgumentException("Null values are not accepted!");
        int size = sizeResize(true);
        array[size] = value;
    }

    @Override
    public T peek() {
        buildHeap();
        if(array[0] == null) return null;
        return array[0];
    }

    @Override
    public T pop() {
        buildHeap();
        T top = array[0];
        if(array[0] == null) return null;
        int lastIndex = size() - 1;
        array[0] = array[lastIndex];
        array[lastIndex] = null;
        tryDownScale();
        return top;
    }

    @Override
    public void buildHeap() {
        for (int i = lastParent(); i >= 0; i--) {
            flipRecursive(i);
        }
    }

    private void flipRecursive(int start) {
        if (array[start] == null) return;
        int leftI = leftOf(start);
        int rightI = rightOf(start);

        int toCheck;

        if (leftI >= array.length) return;

        if (array[leftI] == null && array[rightI] == null)
            return;
        if (array[rightI] == null) {
            toCheck = leftI;
        } else {
            toCheck = (array[leftI].compareTo(array[rightI])) > 0 ? rightI : leftI;
        }

        if (array[toCheck].compareTo(array[start]) < 0) {
            T higherE = array[start];
            T lowerE = array[toCheck];
            array[start] = lowerE;
            array[toCheck] = higherE;
            flipRecursive(toCheck);
        }
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return sizeResize(false);
    }

    // Separated because when building heap with all elements filled, it will resize it, which makes no sense to do so. I would have to down
    // scale it right after. So I separated them to make it just not even try to scale up.
    private int sizeResize(boolean callResize) {
        int index; // Starts from the last layer instead of iterating every layer
        for (index = getSizeUpToLayer(getLayers() - 2); index < array.length; index++) {
            if (array[index] != null) continue;
            return index;
        }
        if (callResize) {
            resize(calculateNewSize());
        }
        return index;
    }

    private int calculateNewSize() {
        return getSizeUpToLayer(getLayers());
    }

    private int getSizeUpToLayer(int layers) {
        int totalSize = 0;
        for (int i = 0; i < layers + 1; i++) {// +1 for the new layer
            totalSize += (int) Math.pow(2, i);
        }
        return totalSize;
    }

    private int getLayers() {
        return (int) (Math.log(array.length) / Math.log(2)) + 1;
    }

    private void resize(int size) {
        if (size <= 0) throw new IllegalArgumentException("Size should never be <= 0!");
        T[] oldArray = Arrays.copyOf(array, array.length);
        array = (T[]) Array.newInstance(classT, size);
        System.arraycopy(oldArray, 0, array, 0, Math.min(oldArray.length, array.length));
    }

    private void tryDownScale() {
        int half = (int) Math.floor((double) array.length / 2.0);
        if (array[half - 1] == null) {
            resize(half); // -1 for the last element, that we just checked is null. No need to keep it.
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    private int leftOf(int index) {
        return 2 * index + 1;
    }

    private int rightOf(int index) {
        return 2 * index + 2;
    }

    private int lastParent() {
        return (int) Math.floor((double) size() / 2 - 1);
    }
}
