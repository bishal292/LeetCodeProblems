class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        // Edge Case: If the matrix is empty
        if (m == 0 || n == 0) {
            return false;
        }

        // If target is outside the range of the entire matrix
        if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) {
            return false;
        }

        // Binary Search to find the correct row
        int start = 0;
        int end = m - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid][0] <= target && target <= matrix[mid][n - 1]) {
                start = mid; // Found the row
                break;
            } else if (matrix[mid][0] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        // The row to search in is `start`
        int row = start;

        // Binary Search within the row
        start = 0;
        end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }
}
