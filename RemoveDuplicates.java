import java.util.Arrays;

/**
 * Given an array of sorted numbers, separate all duplicates from it in-place.
 * You should not use any extra space; move all duplicates at the end of the array and after moving return
 * the length of the subarray that has no duplicate in it.
 */
class RemoveDuplicates {
//    public static int remove(int[] arr) {
//        int next = 1; // index of the next non-duplicate element
//        for (int i = 0; i < arr.length; i++) { //2 2 1
//            if (arr[next - 1] != arr[i]) {
//                arr[next] = arr[i];
//                next++;
//            }
//        }
//        return next;
//    }

    private static int remove(int[] arr) {
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

    public static void main(String[] args) {
        int[] arr = new int[]{2, 2, 3, 4, 4, 5};
        System.out.println("before: " + Arrays.toString(arr));
        System.out.println("length: " + remove(arr));
        System.out.println("after: " + Arrays.toString(arr));
    }
}