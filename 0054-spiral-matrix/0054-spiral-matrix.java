class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int left = 0, top = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;

        while (left <= right && top <= bottom) {

            // left -> right
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            top++;
            // top -> bottom
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--;
            // Right -> left
            if (top <= bottom)
                for (int i = right; i >= left; i--) {
                    ans.add(matrix[bottom][i]);
                }
            bottom--;
            // Bottom -> top
            if (left <= right)
                for (int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
            left++;
        }
        return ans;
    }
}