class Solution {
    public long gridGame(int[][] grid) {
        Long topSum = 0l;
        Long ans = Long.MAX_VALUE;
        int n = grid[0].length;

        for(int num : grid[0]){
            topSum += num;
        }

        Long botSum = 0l;
        for(int i = 0;i<n;i++){
            topSum -= grid[0][i];

            ans = Math.min(ans,Math.max(topSum,botSum));

            botSum += grid[1][i];
        }

        return ans;
    }
}