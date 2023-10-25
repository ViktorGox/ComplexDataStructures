package Collections.Heap;

import Collections.IArray;

import java.lang.reflect.Array;
import java.util.Arrays;

// TODO: https://chat.openai.com/share/695ffb81-d43d-409e-be1a-b56506e84cbc for the log with size
public class MinHeap<T extends Comparable<T>> implements IHeap<T>, IArray {

    private T[] array;
    private final Class<T> classT;

    public MinHeap(Class<T> classT) {
        this.classT = classT;
        array = (T[]) Array.newInstance(classT, 3); // Not using resize because at first it's not initialised, so it throws nullException
    }

    @Override
    public void push(T value) {
        int size = size();
        array[size] = value;
    }

    @Override
    public T peek() {
        return array[0];
    }

    @Override
    public T pop() {
        buildHeap();
        T top = array[0];
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

        if (array[leftI] == null && array[rightI] == null)
            return;
        if (array[leftI] == null) {
            toCheck = rightI;
        } else if (array[rightI] == null) {
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
        int index;
        for (index = 0; index < array.length; index++) { // Wanted to make this not count from 0, but from the last layer, but didn't work out :/
            if (array[index] != null) continue;
            return index;
        }
        resize(calculateNewSize());
        return index;
    }

    private int calculateNewSize() {
        int layers = getLayers();
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
        int half = (int) Math.ceil((double) array.length / 2.0);
        if (array[half] == null) {
            resize(half - 1); // -1 for the last element, that we just checked is null. No need to keep it.
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
