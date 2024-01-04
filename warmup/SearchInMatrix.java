package warmup;

public class SearchInMatrix {
    static int binary_search(int[][] nums, int target, int left, int right) {
        int total = nums.length * nums.length + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int row = row(mid, total);
            int col = col(mid, total);
            if (nums[row][col] == target) {
                return mid;
            }
            if (nums[row][col] > target) {
                return binary_search(nums, target, 0, mid - 1);
            }
            if (nums[row][col] < target) {
                return binary_search(nums, target, mid, total);
            }
        }
        return -1;
    }

    static int row(int mid, int total) {
        return total / mid;
    }

    static int col(int mid, int total) {
        return total % mid;
    }

    public static IntPair search_in_matrix(int[][] matrix, int value) {
        int total = matrix.length * matrix.length + 1;
        int mid = binary_search(matrix, value, 0, total);
        return new IntPair(row(mid, total), col(mid, total));
    }

    public static class IntPair {
        int x;
        int y;

        IntPair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        int k=0;
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                matrix[i][j] = k++;
            }
        }
        IntPair pair = search_in_matrix(matrix, 5);
        System.out.println(pair.x + ", " + pair.y);
    }
}
