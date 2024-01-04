package warmup;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class MyHashMap<K, V> {

    private int CAPACITY = 10;
    private MyMapBucket[] bucket;
    private int size = 0;

    public class MyKeyValueEntry<K, V> {
        private K key;
        private V value;

        public MyKeyValueEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        // getters & setters

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        // hashCode & equals

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            MyKeyValueEntry<?, ?> that = (MyKeyValueEntry<?, ?>) o;

            if (!Objects.equals(key, that.key)) return false;
            return Objects.equals(value, that.value);
        }

        @Override
        public int hashCode() {
            int result = key != null ? key.hashCode() : 0;
            result = 31 * result + (value != null ? value.hashCode() : 0);
            return result;
        }
    }

    class MyMapBucket {
        private List<MyKeyValueEntry> entries;

        public MyMapBucket() {
            if (entries == null) {
                entries = new LinkedList<>();
            }
        }

        public List<MyKeyValueEntry> getEntries() {
            return entries;
        }

        public void addEntry(MyKeyValueEntry entry) {
            this.entries.add(entry);
        }

        public void removeEntry(MyKeyValueEntry entry) {
            this.entries.remove(entry);
        }
    }

    public MyHashMap() {
//        this.bucket = new MyMapBucket[CAPACITY];
    }

    private int getHash(K key) {
        return (key.hashCode() & 0xfffffff) % CAPACITY;
    }

    private MyKeyValueEntry getEntry(K key) {
        int hash = getHash(key);
        for (int i = 0; i < bucket[hash].getEntries().size(); i++) {
            MyKeyValueEntry myKeyValueEntry = bucket[hash].getEntries().get(i);

            if (myKeyValueEntry.getKey().equals(key)) {
                return myKeyValueEntry;
            }
        }
        return null;
    }

    public void put(K key, V value) {
        if (containsKey(key)) {
            MyKeyValueEntry entry = getEntry(key);
            entry.setValue(value);
        } else {
            int hash = getHash(key);
            if (bucket[hash] == null) {
                bucket[hash] = new MyMapBucket();
            }
            bucket[hash].addEntry(new MyKeyValueEntry<>(key, value));
            size++;
        }
    }

    public V get(K key) {
        return containsKey(key) ? (V) getEntry(key).getValue() : null;
    }

    public boolean containsKey(K key) {
        int hash = getHash(key);
        return !(Objects.isNull(bucket[hash]) || Objects.isNull(getEntry(key)));
    }

    public void delete(K key) {
        if (containsKey(key)) {
            int hash = getHash(key);
            bucket[hash].removeEntry(getEntry(key));
            size--;
        }
    }

    public int size() {
        return size;
    }
}

