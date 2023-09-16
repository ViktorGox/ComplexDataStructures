package Collections.HashTable;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class HashTableTests {
    @Test
    public void EmptyHashTable_AddingThreeNewElements_WorksCorrectly() {
        HashTable<String, Integer> hashTable = new HashTable<>();
        hashTable.put("one", 1);
        hashTable.put("two", 2);
        hashTable.put("three", 3);

        assertEquals(1,hashTable.get("one"));
        assertEquals(2,hashTable.get("two"));
        assertEquals(3,hashTable.get("three"));
    }

    @Test
    public void EmptyHashTable_AddingThreeElementsAndDeletingOne_WorksCorrectly() {
        HashTable<String, Integer> hashTable = new HashTable<>();
        hashTable.put("one", 1);
        hashTable.put("two", 2);
        hashTable.put("three", 3);

        assertEquals(1,hashTable.get("one"));
        assertEquals(2,hashTable.get("two"));
        assertEquals(3,hashTable.get("three"));

        hashTable.delete("three");

        assertNull(hashTable.get("three"));
    }
}
