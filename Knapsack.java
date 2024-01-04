public class Knapsack {

    public int solve(int[] v, int[] w, int c) {
        return knapsack(v, w, c, 0);
    }

    private int knapsack(int[] v, int[] w, int c, int i) {
        if (c <= 0 || i >= v.length) {
            return 0;
        }
        int profit1 = 0;
        if (w[i] <= c) {
            profit1 = v[i] + knapsack(v, w,c - w[i], i + 1);
        }
        int profit2 = knapsack(v, w, c, i + 1);
        return Math.max(profit1, profit2);
    }

    public static void main(String[] args) {
        Knapsack ks = new Knapsack();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solve(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solve(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }
}