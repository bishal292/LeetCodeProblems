class Solution {
    public long gridGame(int[][] grid) {
        // Long topSum = 0l;
        // Long ans = Long.MAX_VALUE;
        // int n = grid[0].length;

        // for (int num : grid[0]) {
        //     topSum += num;
        // }

        // Long botSum = 0l;
        // for (int i = 0; i < n; i++) {
        //     topSum -= grid[0][i];

        //     ans = Math.min(ans, Math.max(topSum, botSum));

        //     botSum += grid[1][i];
        // }

        // return ans;

        long ans = Long.MAX_VALUE;
        long s1 = 0; // suffix sum of the points in the first row
        long s2 = 0; // prefix sum of the points in the second row
        for (int v : grid[0]) {
            s1 += v;
        }
        int n = grid[0].length;
        for (int j = 0; j < n; ++j) { // j = find optimal position to go down
            s1 -= grid[0][j];
            ans = Math.min(ans, Math.max(s1, s2));
            s2 += grid[1][j];
        }
        return ans;
    }
}