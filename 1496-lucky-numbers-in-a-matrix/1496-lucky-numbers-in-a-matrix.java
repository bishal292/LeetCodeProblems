class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> luckyNumbers = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            
            // Step 1: Find the minimum in the current row
            int minRow = matrix[i][0];
            int minIndex = 0;

            for (int j = 1; j < n; j++) {
                if (matrix[i][j] < minRow) {
                    minRow = matrix[i][j];
                    minIndex = j;
                }
            }

            // Step 2: Check if this minimum is the maximum in its column
            boolean isLucky = true;
            for (int k = 0; k < m; k++) {
                if (matrix[k][minIndex] > minRow) {
                    isLucky = false;
                    break;
                }
            }

            // Step 3: If the number is lucky, add it to the list
            if (isLucky) {
                luckyNumbers.add(minRow);
            }
        }

        return luckyNumbers;
    }
}