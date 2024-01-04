public class MinPQ<T extends Comparable> {
    private T[] pq;
    private int n;

    public MinPQ(int capacity) {
        pq = (T[]) new Comparable[capacity + 1];
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void insert(T key) {
        pq[++n] = key;
        swim(n);
    }

    public T delMax() {
        T max = pq[1];
        exch(1, n--);
        sink(1);
        pq[n + 1] = null;
        return max;
    }

    private boolean greater(int i, int j) {
        return pq[i].compareTo(pq[j]) > 0;
    }

    private void exch(int i, int j) {
        T swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    private void swim(int k) {
        while (k > 1 && greater(k / 2, k)) {
            exch(k, k / 2);
            k /= 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && greater(j, j + 1)) {
                j++;
            }
            if (!greater(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    public static void main(String[] args) {
        MinPQ<String> pq = new MinPQ(26);
        for (String s : "HEAPSORTEXAMPLE".split("")) {
            pq.insert(s);
        }
        while (!pq.isEmpty()) {
            System.out.println(pq.delMax());
        }
    }
}