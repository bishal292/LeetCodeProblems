class Solution {
    public void rotate(int[][] matrix) {

        // BruteForce Using extra Space.

        // int n = matrix.length;
        // int[][] ans = new int[n][n];

        // for(int i = 0;i<n;i++){
        //     for(int j =0 ;j<n;j++){
        //         ans[i][j] = matrix[n-1-j][i];
        //     }
        // }
        // for(int i = 0;i<n;i++){
        //     for(int j =0 ;j<n;j++){
        //         matrix[i][j] = ans[i][j];
        //     }
        // }

        // For Optimal approach (In place Rotation.)
        /**
        Understanding the pattern in the question.
        1st row in the result matrix is the reverse of the first column of the original matrix.
        2ndt row in the result matrix is the reverse of the Second(2nd) column of the original matrix.
        Similarly, 3rd row in the result matrix is the reverse of the Third(3rd) column of the original matrix.
        and Go on....

    So now somehow if we can swap the rows and columns, then reversing the individual rows, answer can be found.

    now for transposing a matrix there is a pattern lets see through this small example:

        1 2 3
        4 5 6
        7 8 9

        will result to this below matrix after being transposed:

        1 4 7
        2 5 8
        3 6 9

        here we can clearly observe that:
        1. main diagonal elements remain same as the original matrix.
        2. Other remaining elements are just mirror swapped.Means arr[i][j] -> arr[j][i]


        From these above observation we can see that if we swap the upperTriangle elements of the matrix with the lower then transpose would be found.
         */
        //  Let's find the transpose of the matrix:
        int n = matrix.length;
        for(int i = 0;i<n-1;i++){//Not needed to traverse the last row as all the upperTriangle element lies before this.
            for(int j = i+1;j<n;j++){
                swap(matrix,i ,j);
            }
        }

        // Now reverse individual row elements
        for(int[] arr: matrix){
            int i = 0;
            int j = n-1;
            while(i<j){
                swapRow(arr,i,j);
                i++;
                j--;
            }
        }
    }

    private void swapRow(int[] arr, int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private void swap(int[][] matrix, int i,int j){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }
}