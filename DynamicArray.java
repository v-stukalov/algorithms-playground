public class DynamicArray<T> {
    private T data[];
    private int size;
    private int capacity;

    public DynamicArray() {
        this(16);
    }

    public DynamicArray(int c) {
        capacity = c;
        data = (T[]) new Object[capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(T item) {
        insert(size, item);
    }

    public void set(int index, T item) {
        data[index] = item;
    }

    public T get(int index) {
        return data[index];
    }

    private void resize(int c) {
        T d[] = (T[]) new Object[c];
        for (int i = 0; i < size; i++) {
            d[i] = data[i];
        }
        data = d;
        capacity = c;
    }

    public void insert(int index, T item) {
        if (size == capacity) {
            resize(2 * capacity);
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = item;
        size++;
    }

    public boolean contains(T item) {
        for (T t : data) {
            if (item.equals(item)) {
                return true;
            }
        }
        return false;
    }

    public void delete(int index) {
        if (size == .25 * capacity) {
            resize(capacity / 2);
        }
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    public static void main(String[] args) {
        DynamicArray<String> arr = new DynamicArray<>(2);
        arr.add("a");
        arr.add("b");
        arr.add("d");
        arr.insert(2, "c");
        System.out.println(arr.contains("d"));
        arr.delete(0);
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }
}
