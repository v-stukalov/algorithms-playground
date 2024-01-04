import java.util.Arrays;

class SortedArraySquares {

//    public static int[] makeSquares(int[] arr) {
//        int n = arr.length;
//        int[] squares = new int[n];
//        int i = 0;
//        while (i < n && arr[i] < 0) {
//            i++;
//        }
//        //[-2, -1, 0, 2, 3]
//        int k = 0;
//        if (i == 0) {
//            while (i < n) {
//                squares[k++] = arr[i] * arr[i];
//                i++;
//            }
//        } else if (i == n - 1) {
//            while (i >= 0) {
//                squares[k++] = arr[i] * arr[i];
//                i--;
//            }
//        } else {
//            int j = i;
//            i--;
//            while (i >= 0 && j < n) {
//                if (-1 * arr[i] < arr[j]) {
//                    squares[k] = arr[i] * arr[i];
//                    i--;
//                } else {
//                    squares[k] = arr[j] * arr[j];
//                    j++;
//                }
//                k++;
//            }
//            while (i >= 0) {
//                squares[k++] = arr[i] * arr[i];
//                i--;
//            }
//            while (j < n) {
//                squares[k++] = arr[j] * arr[j];
//                j++;
//            }
//        }
//        return squares;
//    }

    public static int[] makeSquares(int[] arr) {
        int n = arr.length;
        int[] squares = new int[n];
        int hi = n - 1;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int sq_left = arr[left] * arr[left];
            int sq_right = arr[right] * arr[right];
            if (sq_left > sq_right) {
                squares[hi--] = sq_left;
                left++;
            } else {
                squares[hi--] = sq_right;
                right--;
            }
        }
        return squares;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-4, -3, -2, -1};//{0, 1, 2, 3, 4};//{-2, -1, 0, 2, 3};
        System.out.println(Arrays.toString(makeSquares(arr)));
    }
}