package Collections.HashTable;

public class Entry<K, V> {
    protected K key;
    protected V value;
    protected Entry<K, V> next;

    protected boolean isDeleted;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }
}