package Collections.HashTable;

// TODO: partly chat gpt generated https://chat.openai.com/share/103bd1d9-fc0e-439e-962c-7f3b580a3410
public class HashTable<K,V> {
    private static final int INITIAL_CAPACITY = 10;
    private Entry<K, V>[] table;

    private int entries;

    public HashTable() {
        table = new Entry[INITIAL_CAPACITY];
    }

    public void put(K key, V value) {
        int index = hash(key) % table.length;
        if (table[index] == null) {
            table[index] = new Entry<>(key, value);
        } else {
            Entry<K, V> current = table[index];
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Entry<>(key, value);
        }
    }

    public V get(K key) {
        int index = hash(key) % table.length;
        Entry<K, V> entry = table[index];
        while (entry != null) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
            entry = entry.next;
        }
        return null;  // Key not found
    }

    private int hash(K key) {
        // Use the built-in hashCode method of the key object
        return key.hashCode();
    }
}