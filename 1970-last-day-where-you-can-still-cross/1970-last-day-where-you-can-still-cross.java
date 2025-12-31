class Solution {
    /* 
    public int latestDayToCross(int row, int col, int[][] cells) {
        int ans = 0;
        int lastCol = 0; // Track the colum from where there was a valid path last time.
        boolean[][] grid = new boolean[row][col];
        for (int i = 0; i < cells.length; i++) {
            // As cells are 1-indexed.
            int x = cells[i][0] - 1;
            int y = cells[i][1] - 1;
            grid[x][y] = true;// water filled.
            boolean pos = false;
            for (int j = lastCol; j < col; j++) {
                if (isPossible(grid, 0, j,new boolean[row][col])){
                    pos = true;
                    lastCol = j;
                    ans++;
                    break;
                }
            }
            if(!pos)break; // if not possible to go to the end further.
        }
        return ans;
    } 
    */

    public boolean isPossible(boolean[][] grid,int x,int y,boolean[][] isVisited){
        if(x == grid.length)return true;
        if(x < 0 || y < 0 || y == grid[0].length)return false;// if anyhow it exceeds the columns.
        if(grid[x][y] || isVisited[x][y]){ // if there is water on the field.
            return false;
        }
        isVisited[x][y] = true;
        //go down
        if(isPossible(grid,x+1,y,isVisited))return true;
        // go right
        if(isPossible(grid,x,y+1,isVisited)) return true;
        // go left
        if(isPossible(grid,x,y-1,isVisited)) return true;
        // go up
        if(isPossible(grid,x-1,y,isVisited)) return true;
        return false;
    }

    public int latestDayToCross(int row, int col, int[][] cells){
        int left  = 1,right = cells.length;
        int ans = 0;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(canCross(cells,row,col,mid)){
                left = mid + 1;
                ans = mid;
            }else{
                right = mid - 1;
            }
        }
        return ans;
    }

    public boolean canCross(int[][] cells,int row,int col,int day){
        boolean[][] grid = new boolean[row][col];
        for(int j = 0;j<day;j++){
            int x = cells[j][0] - 1;
            int y = cells[j][1] - 1;
            grid[x][y] = true;
        }

        boolean[][] vis = new boolean[row][col];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0;i<col;i++){
            if(!grid[0][i] && isPossible(grid,0,i,new boolean[row][col])){
                // q.offer(new int[]{0,i});
                // vis[0][i] =true;
                return true;
            }
        }

        // int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};

        // while(!q.isEmpty()){
        //     int[] cur = q.poll();
        //     int x = cur[0];
        //     int y = cur[1];

        //     if(x == row - 1)return true;

        //     for (int[] d : dir) {
        //         int nx = x + d[0];
        //         int ny = y + d[1];

        //         if (nx >= 0 && ny >= 0 && nx < row && ny < col && !grid[nx][ny] && !vis[nx][ny]) {
        //             vis[nx][ny] = true;
        //             q.offer(new int[]{nx, ny});
        //         }
        //     }

        // }

        return false;
    }
}