class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // int[] zeros = new int[m+n];
        // for(int i = 0;i<m;i++){
        //     for(int j = 0;j<n;j++){
        //         if(matrix[i][j] == 0){
        //             zeros[i] = 1;
        //             zeros[j+m] = 1;
        //         }
        //     }
        // }
        // for(int i = 0;i<m;i++){
        //     for(int j = 0;j<n;j++){
        //         if(zeros[i] == 1 || zeros[j+m] == 1){
        //             matrix[i][j] = 0;
        //         }
        //     }
        // }

        // taking the original array as the marker instead of taking the extra array of size m+n;
        // taking the elements in the first row and first col as the marker for the inner elem keeping track of either first row or col contains zero.

        boolean fr = false, fc = false;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0)
                        fr = true;
                    if (j == 0)
                        fc = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }


        if (fc)
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        if (fr)
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
    }
}