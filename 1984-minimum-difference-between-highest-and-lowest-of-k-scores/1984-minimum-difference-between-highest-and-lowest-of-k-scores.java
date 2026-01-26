class Solution {
    public int minimumDifference(int[] nums, int k) {
        // BruteForce Solution
        // return helper(nums,k,0,Integer.MIN_VALUE,Integer.MAX_VALUE);
        // Optimized Solution.
        Arrays.sort(nums);
        int i = 0;
        int ans = Integer.MAX_VALUE;
        while(i + k - 1 < nums.length){
            int dif = nums[i + k - 1] - nums[i];
            ans = Math.min(dif,ans);
            i++;
        }
        return ans;
    }
    // Brute Force Solution.
    public int helper(int[] nums,int k,int idx,int max,int min){
        if(k == 0){
            return max - min;
        }
        if(idx >= nums.length)return Integer.MAX_VALUE;
        int mx = Math.max(max,nums[idx]);
        int mi = Math.min(min,nums[idx]);
        int taking = helper(nums,k-1,idx + 1,mx,mi);
        int notTak = helper(nums,k,idx + 1,max,min);
        return Math.min(taking,notTak);
    }
}