class Solution {

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
            if(!grid[0][i]){
                q.offer(new int[]{0,i});
                vis[0][i] =true;
            }
        }

        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            if(x == row - 1)return true;

            for (int[] d : dir) {
                int nx = x + d[0];
                int ny = y + d[1];

                if (nx >= 0 && ny >= 0 && nx < row && ny < col && !grid[nx][ny] && !vis[nx][ny]) {
                    vis[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }

        }
        return false;
    }
}