class Solution {
    public int missingNumber(int[] nums) {
        int reqSum = 0;
        int sum = 0;
        for(int i =0;i<nums.length;i++){
            reqSum += i+1;
            sum += nums[i];
        }
        return reqSum - sum;
    }
}