package warmup;

import java.util.Arrays;

public class Permutation {
    //[0..9]
    //0 - all pairs0
    //1 - all pairs1
    //..
    //9 - all pairs9

    //all pairs0 - all triplets0
    //all pairs1 - all triplets1
    //..
    //all pairs9 - all triplets9

    //all triplets0 - all quadruples0
    //all triplets1 - all quadruples1
    //...
    //all triplets9 - all quadruples9

    //987[6,5,4,3,2,1,9]
    public static boolean[] flags(int base) {
        boolean[] flags = new boolean[10];
        for (int i = 0; i < 3; i++) {
            flags[base % 10] = true;
            base /= 10;
        }
        return flags;
    }

    public static boolean[] flags(int[] base) {
        boolean[] flags = new boolean[10];
        for (int i = 0; i < base.length; i++) {
            flags[base[i]] = true;
        }
        return flags;
    }

    public static int[] perm(int base, int len) {
        boolean[] flags = flags(base);

        int sz = 10 - len;
        int[] perm = new int[sz];
        int base10 = base * 10;
        int j = 0;

        for (int i = 0; i < flags.length; i++) {
            if (!flags[i]) {
                perm[j++] = base10 + i;
                if (j > sz) {
                    break;
                }
            }
        }

        return perm;
    }

//    public static int[] perm(String s) {
//        int len = s.length();
//        int[] in = new int[3];
//
//        int base = Integer.parseInt(s);
//        for (int i = 0; i < 3; i++) {
//            in[base % 10] = true;
//            base /= 10;
//        }
//        boolean[] flags = flags(base);
//
//        int sz = 10 - len;
//        int[] perm = new int[sz];
//        int base10 = base * 10;
//
//        int j = 0;
//        for (int i = 0; i < flags.length; i++) {
//            if (!flags[i]) {
//                perm[j++] = base10 + i;
//                if (j > sz) {
//                    break;
//                }
//            }
//        }
//        return perm;
//    }

    public static int[][] tuples(int N, int n) {
        // src=[0,1,..9]
        // in_use: 0,1,2; i=0, n=4
        // not_in_use: 3,4,5,6,7,8,9; j=0
        // out: k=0;
        // tuple: 0,1,2 + not_in_use[j++] -> out[k++]

        // i++

        int[] src = new int[N];
        for (int i = 0; i < N; i++) {
            src[i] = i;
        }

        int[] in_use = new int[n - 1];

        int s = 0;
        for (int i = s; i < n + s - 1; i++) {
            in_use[i] = src[i]; // 0,1,2
        }
        System.out.println(Arrays.toString(in_use));

        int[] not_in_use = new int[N - n + 1];
        for (int j = 0, i = s + n - 1; i < N; j++, i++) {
            not_in_use[j] = src[i]; // 3,4,5,6,7,8,9
        }
        System.out.println(Arrays.toString(not_in_use));

        int[][] out = new int[84][n]; //3*7+3*6+3*5+3*4+3*3+3*2+3*1=84
        for (int i = 0; i < 84; i++) {
            for (int j = 0; j < N - n; j++) {
                int[] tuple = new int[n];
                for (int k = 0; k < n - 1; k++) {
                    tuple[k] = in_use[k];
                }
                tuple[n - 1] = not_in_use[j];
                out[i] = tuple;
                System.out.println(Arrays.toString(tuple));
            }
            s++;
        }
        return out;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(perm(987, 3)));
//        System.out.println(Arrays.toString(perm(456, 3)));
//        System.out.println(Arrays.toString(perm(123, 3)));
//        System.out.println(Arrays.toString(perm("012")));

        int N = 10;
        int n = 4;
        tuples(N, n);
    }
}
