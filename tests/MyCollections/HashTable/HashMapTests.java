package MyCollections.HashTable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HashMapTests {
    @Test
    public void EmptyHashTable_AddingThreeNewElements_WorksCorrectly() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("one", 1);
        hashMap.put("two", 2);
        hashMap.put("three", 3);
        // doesn't crash
        hashMap.put(null,null);

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

        // doesn't crash
        assertNull(hashMap.get(null));

        hashMap.remove("three");

        // doesn't crash
        assertNull(hashMap.remove(null));

        assertNull(hashMap.get("three"));
        hashMap.remove("two");
        hashMap.remove("one");
        assertTrue(hashMap.isEmpty());
    }

    @Test
    public void EmptyHashTable_AttemptingToAddSameKey_OnlyOneInstanceIsAdded() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("1",1);
        hashMap.put("1",5);

        assertEquals(1, hashMap.get("1"));
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

    @Test
    public void hashTableWithSomeElements_Contains_ReturnsExistingValueOrNullIfNotPresent() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("one", 1);
        hashMap.put("two", 2);
        hashMap.put("three", 3);

        assertTrue(hashMap.contains("one"));
        assertFalse(hashMap.contains("six"));
        assertFalse(hashMap.contains(null));
    }

    @Test
    public void hashTable_TryAddElementToHitSameKey_ValueIsAddedAtTheEndCorrectly() {
        HashMap<Integer, DummyClass> hashMap = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            hashMap.put(i, new DummyClass("1"));
        }
    }

    public static class DummyClass {
        protected String value;
        public DummyClass(String value) {
            this.value = value;
        }
    }
}