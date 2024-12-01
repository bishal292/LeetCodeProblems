class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int len = nums.length;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            // Move elements to the right starting from the last index to avoid overwriting
            for (int j = len - 1; j > index[i]; j--) {
                result[j] = result[j - 1];
            }
            // Insert the current number at the given index
            result[index[i]] = nums[i];
        }

        return result;
    }
}