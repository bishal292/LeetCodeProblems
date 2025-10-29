// class Solution {
//     public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
//         int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};//In spiral direction would be Right, bottom, left, top.

//         int n = rows * cols;
//         int[][] res = new int [n][2];
//         res[0][0] = rStart;
//         res[0][1] = cStart;

//         int count = 1;
//         int step = 1;//inclease after 2 direction movement.
//         int index = 0;//Initially to move to right direction.

//         while(count < n){
//             // We have to move to 2 directon after which the steps would be changed.Step is the count of number of element to be travesed in a particular direction.
//             for(int directionCount = 0 ;directionCount < 2;directionCount++){
//                 int dr = directions[index % 4][0];
//                 int dc = directions[index % 4][1];

//                 for(int i=0;i<step;i++){//moving to same direction for step steps....
//                     rStart += dr;
//                     cStart += dc;
//                     if(rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols){
//                         res[count][0] = rStart;
//                         res[count][1] = cStart;
//                         count++;
//                     }
//                 }
//                 index++; // Change the direction 
//             }
//             step++;
//         }

//         return res;

//     }
// }


class Solution {
    int[][] dirs={{0,1},{1,0},{0,-1},{-1,0}};
    int x = 0,y = 0;
    //              R      D      L     U
    int elem = 0;


    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] ans = new int[rows * cols][2];
        ans[0][0] = rStart;
        ans[0][1] = cStart;
        elem++;

        int index = 0; // to keep track of direction
        int steps = 1;
        x= rStart;
        y= cStart;

        while(elem < ans.length){
            help(rows,cols,ans,steps,0); // Right
            help(rows,cols,ans,steps,1); // Down
            steps++;

            help(rows,cols,ans,steps,2); // left 
            help(rows,cols,ans,steps,3); // up
            steps++;
        }
        return ans;
    }
    public void help(int m,int n,int[][] ans,int steps, int d){
        while(steps > 0){
            x += dirs[d][0];
            y += dirs[d][1];

            if(x < m && x >= 0 && y < n && y >= 0){
                ans[elem][0] = x;
                ans[elem][1] = y;
                elem++;
            }
            steps--;
        }
    }
}