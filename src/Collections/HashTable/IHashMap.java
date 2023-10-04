package Collections.HashTable;

public interface IHashMap<K, V> {
    void put(K key, V value);
    boolean contains(K key);
    V get(K key);
    V remove(K key);
}
