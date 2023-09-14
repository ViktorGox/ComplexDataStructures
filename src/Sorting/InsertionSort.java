package Sorting;

// chat gpt generated https://chat.openai.com/share/eff0f3b4-ba07-4f85-b14c-f3e9990a2748
// TODO: hi! So im trying to use insert sort on a custom T variable but im not sure how can I do that? I'd guess i need to use comparable interface somehow but im not sure how to actually do it. Got any ideas?

// also this https://chat.openai.com/share/08b07dd7-6c6f-482a-bc95-4fbad9b539fe
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