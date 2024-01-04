import java.util.*;

public class TopologicalSort {
    public static List<Integer> topologicalSort(int v, int[][] e) {
        List<Integer> sorted = new ArrayList<>();
        if (v <= 1) return sorted;
        Map<Integer, Integer> ingress = new HashMap<>();
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int i = 0; i < e.length; i++) {
            ingress.put(i, 0);
            g.put(i, new ArrayList<>());
        }
        for (int i = 0; i < e.length; i++) {
            int parent = e[i][0];
            int child = e[i][1];
            ingress.put(child, ingress.get(child) + 1);
            g.get(parent).add(child);
        }
        Queue<Integer> sources = new LinkedList<>(); // vertices w/o incoming edges
        for (Map.Entry<Integer, Integer> entry : ingress.entrySet()) {
            if (entry.getValue() == 0) {
                sources.add(entry.getKey());
            }
        }
        while (!sources.isEmpty()) {
            int vertex = sources.poll();
            sorted.add(vertex);
            List<Integer> children = g.get(vertex);
            for (int child : children) {
                ingress.put(child, ingress.get(child) - 1);
                if (ingress.get(child) == 0) {
                    sources.add(child);
                }
            }
        }
        if (sorted.size() != v) {
            return new ArrayList<>();
        }
        return sorted;
    }

    public static void main(String[] args) {
        int v = 5;
        int[][] e = new int[][]{{0, 1}, {0, 2}, {2, 3}, {1, 3}, {3, 4}};
        System.out.println(topologicalSort(v, e));
    }
}
