import java.math.BigInteger;
import java.util.Arrays;

import static java.lang.System.*;

public class MaxProductOfThree {
    public int solution(int[] nums) {
        int N = nums.length;
        Arrays.sort(nums);
        int last = nums[N - 3] * nums[N - 2] * nums[N - 1];
        int first = nums[0] * nums[1] * nums[N - 1];
        return Math.max(last, first);
    }
//    public int solution(int[] nums) {
//        int N = nums.length;
//        BigInteger max = BigInteger.valueOf(Integer.MIN_VALUE);
//        BigInteger[][] memo = new BigInteger[N][N - 1];
//        int c = 1;
//        for (int i = 0; i < N - 2; i++) {
//            for (int j = i + 1; j < N - 1; j++) {
//                BigInteger ij = memo[i][j];
//                if (ij == null) {
//                    ij = BigInteger.valueOf(nums[i]).multiply(BigInteger.valueOf(nums[j]));
//                    memo[i][j] = ij;
//                }
//                for (int k = j + 1; k < N; k++) {
//                    BigInteger ijk = ij.multiply(BigInteger.valueOf(nums[k]));
//                    max = ijk.compareTo(max) == 1 ? ijk : max;
//                    out.print(c++ + ": ");
//                    out.print(nums[i] + ", " + nums[j] + ", " + nums[k]);
//                    out.print(" (" + max + ")");
//                    out.println();
//                }
//            }
//        }
//        return max.intValue();
//    }

    public static void main(String[] args) {
        MaxProductOfThree maxProductOfThree = new MaxProductOfThree();
        int[] nums = new int[]{-3, 1, 2, -2, 5, 6};
        out.print(maxProductOfThree.solution(nums));
    }

    private static void print(int[][] nums) {
        for (int[] n : nums) {
            print(n);
        }
    }

    private static void print(int[] nums) {
        out.print("[ ");
        for (int n : nums) {
            out.print(n + " ");
        }
        out.print("]");
        out.println();
    }
}
