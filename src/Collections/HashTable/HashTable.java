package Collections.HashTable;

// TODO: partly chat gpt generated https://chat.openai.com/share/103bd1d9-fc0e-439e-962c-7f3b580a3410
public class HashTable<K, V> {
    private static final int INITIAL_CAPACITY = 10;
    private Entry<K, V>[] entryTable;
    private double resizeCountRequirement;
    private int entriesCount;

    public HashTable() {
        entryTable = new Entry[INITIAL_CAPACITY];
        recalculateResizeCountRequirement(INITIAL_CAPACITY);
    }

    public void put(K key, V value) {
        if(get(key) != null) return;
        int index = hash(key) % entryTable.length;
        if (entryTable[index] == null) {
            entryTable[index] = new Entry<>(key, value);
        } else {
            Entry<K, V> current = entryTable[index];
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Entry<>(key, value);
        }
        entriesCount++;

        if (entriesCount > resizeCountRequirement) {
            resize();
        }
    }

    public V get(K key) {
        Entry<K, V> entry = getEntry(key);
        return (entry == null) ? null : entry.value;
    }

    private Entry<K, V> getEntry(K key) {
        int index = hash(key) % entryTable.length;
        Entry<K, V> entry = entryTable[index];
        while (entry != null) {
            if (entry.key.equals(key) && !entry.isDeleted) {
                return entry;
            }
            entry = entry.next;
        }
        return null;
    }

    public V delete(K key) {
        Entry<K, V> entryToDelete = getEntry(key);
        assert entryToDelete != null;
        entryToDelete.isDeleted = true;
        return entryToDelete.value;
    }

    /**
     * upon reaching 75% filled capacity, 50% of the current size is added, to make the new array with 50% filled capacity.
     * 75% of 250 = 187.5 ; 250 + 50% = 375 ; 50% of 350 = 187.5 ;
     */
    private void resize() {
        Entry<K, V>[] oldEntries = entryTable;

        int newSize = oldEntries.length + (oldEntries.length / 2);
        entryTable = new Entry[newSize];

        entriesCount = 0;
        recalculateResizeCountRequirement(newSize);
        for (Entry<K, V> entry : oldEntries) {
            if (entry == null) continue;

            Entry<K, V> current = entry;
            while (current.next != null) {
                put(current.key, current.value);
                current = current.next;


            }
            put(current.key, current.value);
        }
    }

    private int hash(K key) {
        return key.hashCode();
    }

    private void recalculateResizeCountRequirement(int size) {
        resizeCountRequirement = size * 0.75;
    }

    public int size() {
        return entriesCount;
    }
}