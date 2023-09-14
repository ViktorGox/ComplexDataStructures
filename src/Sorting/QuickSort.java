package Sorting;
//TODO: https://chat.openai.com/share/08b07dd7-6c6f-482a-bc95-4fbad9b539fe last part
public class QuickSort<T extends Comparable<T>> implements ISortMethod<T> {

    @Override
    public void sort(T[] unsorted) {
        quickSort(unsorted, 0, unsorted.length - 1);
    }

    private void quickSort(T[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    private int partition(T[] arr, int low, int high) {
        T pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) <= 0) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    private void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
