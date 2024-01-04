import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TripletSumToZero {

    private static int removeDuplicates(int[] arr) {
        int n = arr.length;
        int next = 1;
        int i = 0;
        while (i < n) {
            if (arr[next - 1] != arr[i]) {
                arr[next] = arr[i];
                next++;
            }
            i++;
        }
        return next;
    }

    private static List<List<Integer>> findPairs(int[] arr, int left, int right, int target) {
        List<List<Integer>> pairs = new ArrayList<>();
        int i = left + 1;
        int j = right;
        while (i <= j) {
            int sum = arr[i] + arr[j];
            if (sum == target) {
                pairs.add(Arrays.asList(arr[i], arr[j]));
                i++;
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return pairs;
    }

    public static List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();
        int n = arr.length;
        if (n < 3)
            return triplets;
        Arrays.sort(arr);
        int m = removeDuplicates(arr);
        for (int i = 0; i <= m; i++) {
            List<List<Integer>> pairs = findPairs(arr, i, m, -1 * arr[i]);
            if (pairs.size() > 0) {
                for (List<Integer> pair : pairs) {
                    List<Integer> triplet = new ArrayList<>(pair);
                    triplet.add(arr[i]);
                    triplets.add(triplet);
                }
            }
        }
        return triplets;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-3, 0, 1, 2, -1, 1, -2};
        System.out.println(searchTriplets(arr)); // [[-3, 1, 2], [-2, 1, 1], [-2, 0, 2], [-1, 0, 1]]
    }
}