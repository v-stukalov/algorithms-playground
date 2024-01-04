public class Experiment2 {
    private static int find(int[] nums, int n) {
        return find(nums, 0, nums.length - 1, n);
    }

    private static int find(int[] nums, int start, int end, int n) {
        int k = start + (end - start) / 2;
        if (nums[k] == n)
            return k;
        else if (nums[k] < n)
            return find(nums, k + 1, nums.length - 1, n);
        else
            return find(nums, 0, k, n);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 7, 8, 9, 11, 13, 15, 22};
        int index = find(nums, 4);
        System.out.println(index);
    }
}
