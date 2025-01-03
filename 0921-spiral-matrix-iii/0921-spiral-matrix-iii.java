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

    int x=0,y=0,pos=0;
    int dirs[][]={{1,0},{0,-1},{-1,0},{0,1}};

    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {

        int[][] ans=new int[rows*cols][2];

        ans[pos][0]=rStart;
        ans[pos][1]=cStart;

        pos++;

        x=rStart;
        y=cStart;
        
        int jumps=0;

        while(pos<rows*cols)
        {
            jumps++;
            help(rows,cols,jumps,ans,3);
            help(rows,cols,jumps,ans,0);

            jumps++;

            help(rows,cols,jumps,ans,1);
            help(rows,cols,jumps,ans,2);
        }
        return ans;
    }

    public void help(int n,int m,int jump,int[][] ans,int ind)
    {
        while(jump--!=0)
        {
            x+=dirs[ind][0];
            y+=dirs[ind][1];

            if(x<n && y<m && x>-1 && y>-1)
            {
                ans[pos][0]=x;
                ans[pos][1]=y;
                pos++;
            }
        }
    }
}