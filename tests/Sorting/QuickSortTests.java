package Sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuickSortTests {
    private <T> void compareArrayToArray(T[] expected, T[] actual) {
        for (int i = 0; i < actual.length; i++)
            assertEquals(expected[i], actual[i]);
    }

    @Test
    public void ArrayWithMultipleElements_QuickSort_ReturnsSortedElements() {
        String[] letters = new String[] {"o","c","k","f","d","g","w","q","a"};
        QuickSort<String> quickSort = new QuickSort<>();
        quickSort.sort(letters);

        String[] expected = new String[] {"a","c","d","f","g","k","o","q","w"};

        compareArrayToArray(expected,letters);
    }
}
