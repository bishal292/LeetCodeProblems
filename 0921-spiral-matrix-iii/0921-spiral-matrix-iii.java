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
    //              R      D      L     U

    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] ans = new int[rows * cols][2];
        ans[0][0] = rStart;
        ans[0][1] = cStart;

        int index = 0; // to keep track of direction
        int steps = 1;
        int elem = 1;

        while(elem < ans.length){// while all the elem is not filled.
            for(int dirCount = 0;dirCount < 2;dirCount++){ // after each 2 movement steps should be increased.
                int dr = dirs[index % 4][0];
                int dc = dirs[index % 4][1];
                for(int i = 0;i<steps;i++){ // for each direction move the pointer steps time
                    rStart += dr;
                    cStart += dc;
                    if(rStart < rows && rStart >= 0 && cStart < cols && cStart >= 0){
                        ans[elem][0] = rStart;
                        ans[elem][1] = cStart;
                        elem++;
                    }
                }
                index++;// change the direction after each movement in a direction is completed steps time
            }
            steps++;
        }

        return ans;
    }
}