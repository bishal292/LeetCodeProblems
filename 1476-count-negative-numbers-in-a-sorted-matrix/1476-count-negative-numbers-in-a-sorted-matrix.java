class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        // For Edge Cases to make it run faster
        // if(grid[0][0] < 0 )return m*n;

        // BruteForce Solution:

        // for(int i = 0;i<m;i++){
        // for(int j = 0;j<n;j++){
        // if(grid[i][j] < 0){
        // count++;
        // }
        // }
        // }

        // Best Optimal Solution:
        int row = m - 1, col = 0;

        // while(row >= 0 && col < n){
        // if(grid[row][col] < 0){
        // count += (n - col);
        // row--;
        // }else{
        // col++;
        // }
        // }

        for (int[] arr : grid) {
            int negIdx = binSearchFirstNeg(arr);
            if (negIdx != -1)
                count += n - negIdx;
        }

        return count;
    }

    private int binSearchFirstNeg(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int idx = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < 0) {
                idx = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return idx;
    }
}