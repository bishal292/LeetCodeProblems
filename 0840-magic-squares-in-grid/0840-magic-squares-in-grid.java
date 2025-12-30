class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        if(row < 3 || col < 3)return 0;
        int ans = 0;
        for(int i = 2;i<row;i++){
            for(int j = 2;j<col;j++){
                if(magicSquare(grid,i,j)){
                    ans++;
                }
            }
        }
        return ans;
    }
    public boolean magicSquare(int[][] grid,int m,int n){
        // m -> row,n -> col
        int i = m - 2;
        int j = n - 2;
        int mdia = grid[i][j] + grid[i+1][j+1] + grid[i+2][j+2];
        int sdia = grid[m][j] + grid[m-1][n-1] + grid[i][n];
        if(mdia != sdia)return false;

        HashSet<Integer> set = new HashSet<>();
        for(i = m-2 ;i <= m; i++){
            int sum = 0;
            for(j = n-2 ;j <= n; j++){
                int num = grid[i][j];
                if(num > 9 || num <1)return false;
                if(set.contains(num))return false;
                set.add(num);
                sum += num;
            }
            if(sum != mdia)return false;
        }
        set.clear();
        for (j = n - 2; j <= n; j++) {
            int sum = 0;
            for (i = m - 2; i <= m; i++) {
                int num = grid[i][j];
                if(num > 9 || num <1)return false;
                if (set.contains(num)) return false;
                set.add(num);
                sum += num;
            }
            if (sum != mdia) return false;
        }

        return true;
    }
}