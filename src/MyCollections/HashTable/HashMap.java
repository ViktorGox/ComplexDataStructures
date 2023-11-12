package MyCollections.HashTable;

import MyCollections.IArray;

public class HashMap<K, V> implements IArray, IHashMap<K, V> {
    private static final int INITIAL_CAPACITY = 10;
    private Entry<K, V>[] entryTable;
    private double resizeCountRequirement;
    private int internalEntriesCount;
    private int entryCount;

    public HashMap() {
        entryTable = new Entry[INITIAL_CAPACITY];
        recalculateResizeCountRequirement(INITIAL_CAPACITY);
    }

    public void put(K key, V value) {
        if (key == null || value == null) {
            return;
        }
        if (get(key) != null) {
            return;
        }
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
        internalEntriesCount++;
        entryCount++;

        if (internalEntriesCount > resizeCountRequirement) {
            resize();
        }
    }

    @Override
    public boolean contains(K key) {
        if(key == null) {
            return false;
        }
        V result = get(key);
        return result != null;
    }

    public V get(K key) {
        if(key == null) {
            return null;
        }
        Entry<K, V> entry = getEntry(key);
        return (entry == null) ? null : entry.value;
    }

    private Entry<K, V> getEntry(K key) {
        if(key == null) {
            return null;
        }
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

    @Override
    public V remove(K key) {
        if(key == null) {
            return null;
        }
        Entry<K, V> entryToDelete = getEntry(key);
        assert entryToDelete != null;
        entryToDelete.isDeleted = true;
        entryCount--;
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

        internalEntriesCount = 0;
        entryCount = 0;
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

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return entryCount;
    }
}