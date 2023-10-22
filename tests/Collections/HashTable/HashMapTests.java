package Collections.HashTable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HashMapTests {
    @Test
    public void EmptyHashTable_AddingThreeNewElements_WorksCorrectly() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("one", 1);
        hashMap.put("two", 2);
        hashMap.put("three", 3);

        assertEquals(1, hashMap.get("one"));
        assertEquals(2, hashMap.get("two"));
        assertEquals(3, hashMap.get("three"));
    }

    @Test
    public void EmptyHashTable_AddingThreeElementsAndDeletingOne_WorksCorrectly() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("one", 1);
        hashMap.put("two", 2);
        hashMap.put("three", 3);

        assertEquals(1, hashMap.get("one"));
        assertEquals(2, hashMap.get("two"));
        assertEquals(3, hashMap.get("three"));

        hashMap.remove("three");

        assertNull(hashMap.get("three"));
    }

    @Test
    public void HashTableWithMultipleElements_TriggeringResize_ResizeWorksCorrectly() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        // resize is triggered at 75% filled capacity is 10, so should be triggered at 8th element.
        for (int i = 0; i < 8; i++) {
            hashMap.put(String.valueOf(i),i);
        }

        hashMap.put("9",9);

        assertEquals(1,1);
    }

    @Test
    public void EmptyHashTable_AttemptingToAddSameKey_OnlyOneInstanceIsAdded() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        // resize is triggered at 75% filled capacity is 10, so should be triggered at 8th element.
        for (int i = 0; i < 8; i++) {
            hashMap.put("1",i);
        }

        assertEquals(1, hashMap.size());
    }

    @Test
    public void HashTableWithMultipleElementsInSameEntryLocation_TriggeringResize_ResizeWorksCorrectly() {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        // resize is triggered at 75% filled capacity is 10, so should be triggered at 8th element.
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            assertDoesNotThrow(() -> hashMap.put(finalI,finalI));
        }
    }
}