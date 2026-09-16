class Solution {
    public int numberOfSets(int n, int k) {
        final int MOD = 1_000_000_007;
        int[][] notEnd = new int[n + 1][k + 1];
        int[][] end = new int[n + 1][k + 1];
        notEnd[1][0] = 1;
        for (int i = 2; i <= n; i++) {
            for (int segments = 0; segments <= k; segments++) {
                notEnd[i][segments] =
                    (notEnd[i - 1][segments] + end[i - 1][segments]) % MOD;
                end[i][segments] = end[i - 1][segments];
                if (segments > 0) {
                    end[i][segments] =
                        (end[i][segments] + notEnd[i - 1][segments - 1]) % MOD;
                    end[i][segments] =
                        (end[i][segments] + end[i - 1][segments - 1]) % MOD;
                }
            }
        }
        return (notEnd[n][k] + end[n][k]) % MOD;
    }
}