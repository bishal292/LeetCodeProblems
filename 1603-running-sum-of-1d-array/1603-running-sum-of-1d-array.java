class Solution {
    public int[] runningSum(int[] nums) {
        int len = nums.length;
        int[] runningSum = new int[len];
        int currentSum=0;
        for(int i=0;i<len;i++){
            currentSum += nums[i];
            runningSum[i]=currentSum;
        }
        return runningSum;
    }
}