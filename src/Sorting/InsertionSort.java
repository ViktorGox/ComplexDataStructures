package Sorting;

public class InsertionSort<T extends Comparable<T>> implements ISortMethod<T> {
    @Override
    public void sort(T[] unsorted) {
        insertionSort(unsorted);
    }

    public static <T extends Comparable<T>> void insertionSort(T[] unsorted) {
        int n = unsorted.length;
        for (int i = 1; i < n; i++) {
            T key = unsorted[i];
            int j = i - 1;
            while (j >= 0 && unsorted[j].compareTo(key) > 0) {
                unsorted[j + 1] = unsorted[j];
                j--;
            }
            unsorted[j + 1] = key;
        }
    }
}