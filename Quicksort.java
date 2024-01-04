import java.util.Arrays;

public class Quicksort {
    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private static int partition(int[] nums, int left, int right, int pivot) {
        while (left <= right) {
            while (nums[left] < pivot) {
                left++;
            }
            while (nums[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private static void quicksort(int[] nums, int left, int right) {
        if (left >= right) return;
        int pivot = nums[left + (right - left) / 2];
        int index = partition(nums, left, right, pivot);
        quicksort(nums, left, index - 1);
        quicksort(nums, index, right);
    }

    public static void sort(int[] nums) {
        quicksort(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int n = 500;
        int[] nums = new int[n];
        for (int i = n - 1, j = 0; i >= 0; i--, j++) {
            nums[j] = i;
        }
        System.out.println(Arrays.toString(nums));
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
