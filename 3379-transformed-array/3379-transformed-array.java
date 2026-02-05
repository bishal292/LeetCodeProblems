class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num > 0) {
                ans[i] = nums[(i + num) % n];
            } else if (num < 0) {
                int idx = i + num;
                while(idx < 0)idx = n + idx;
                ans[i] = nums[idx];
            } else {
                ans[i] = 0;
            }
        }
        return ans;
    }
}