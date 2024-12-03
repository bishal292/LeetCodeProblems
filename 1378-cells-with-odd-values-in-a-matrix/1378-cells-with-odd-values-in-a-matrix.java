class Solution {

    public int oddCells(int m, int n, int[][] indices) {

        int count = 0;
        int[][] resMatrix = new int[m][n];
        for(int[] indexes:indices){
            int row = indexes[0];
            int col = indexes[1];
            // for(int i=0;i<m;i++){
            //     for(int j=0;i<j;j++){
            //         if(i==row || j==col){
            //             resMatrix[i][j]+=1;
            //         }
            //     }
            // }
            for(int i=0;i<n;i++){
                resMatrix[row][i]+=1;
            }
            for(int i=0;i<m;i++){
                resMatrix[i][col]+=1;
            }
        }
        for(int[] row:resMatrix){
            for(int elem: row){
                if(elem != 0 && elem %2 != 0)count++;
            }
        }
        return count;

    }
}