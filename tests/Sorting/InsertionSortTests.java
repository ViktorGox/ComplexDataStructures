package Sorting;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class InsertionSortTests {

    private <T> void compareArrayToArray(T[] expected, T[] actual) {
        for (int i = 0; i < actual.length; i++)
            assertEquals(expected[i], actual[i]);
    }

    @Test
    public void ArrayWithMultipleElements_InsertionSort_ReturnsSortedElements() {
        String[] letters = new String[] {"o","c","k","f","d","g","w","q","a"};
        InsertionSort<String> insertionSort = new InsertionSort<>();
        insertionSort.sort(letters);

        String[] expected = new String[] {"a","c","d","f","g","k","o","q","w"};

        compareArrayToArray(expected,letters);
    }
}
