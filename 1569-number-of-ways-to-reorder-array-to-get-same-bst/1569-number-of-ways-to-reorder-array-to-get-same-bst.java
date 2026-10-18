
import java.util.*;

class Solution {
    private static final int MOD = 1_000_000_007;
    private int[][] comb;

    public int numOfWays(int[] nums) {
        int n = nums.length;
        comb = new int[n + 1][n + 1];

        // Precompute combinations: nCr
        for (int i = 0; i <= n; i++) {
            comb[i][0] = comb[i][i] = 1;

            for (int j = 1; j < i; j++) {
                comb[i][j] =
                    (comb[i - 1][j - 1] + comb[i - 1][j]) % MOD;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int x : nums) {
            list.add(x);
        }

        return (int) ((dfs(list) - 1 + MOD) % MOD);
    }

    private long dfs(List<Integer> nums) {
        int n = nums.size();

        if (n < 3) {
            return 1;
        }

        int root = nums.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            int x = nums.get(i);

            if (x < root) {
                left.add(x);
            } else {
                right.add(x);
            }
        }

        long leftWays = dfs(left);
        long rightWays = dfs(right);

        long ways = comb[n - 1][left.size()];
        ways = ways * leftWays % MOD;
        ways = ways * rightWays % MOD;

        return ways;
    }
}
