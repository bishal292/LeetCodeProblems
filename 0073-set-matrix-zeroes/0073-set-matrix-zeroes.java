// class Solution {
//     public void setZeroes(int[][] matrix) {
//         int m = matrix.length; // 3
//         int n = matrix[0].length; // 3

//         int[] zeros = new int[m + n];// 6 --> first 3(m) to denotes row and other after 3 to denote column.

//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (matrix[i][j] == 0) {
//                     zeros[i] = 1;
//                     zeros[m + j] = 1; // Stores 1 in zeros Array.
//                 }
//             }
//         }
//         for (int i = 0; i < m; i++) {

//             for (int j = 0; j < n; j++) {
//                 if ((zeros[i] == 1) || (zeros[m + j] == 1)) {
//                     matrix[i][j] = 0;
//                 }
//             }
//         }
//     }
// }

public class Solution {
    public void setZeroes(int[][] matrix) {
        boolean fr = false, fc = false;
        int m = matrix.length, n = matrix[0].length;

        // Mark rows and columns to be zeroed
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) fr = true;
                    if (j == 0) fc = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // Set matrix elements to zero based on markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Handle first row and column separately
        if (fr) {
            for (int j = 0; j < n; j++) matrix[0][j] = 0;
        }
        if (fc) {
            for (int i = 0; i < m; i++) matrix[i][0] = 0;
        }
    }
}