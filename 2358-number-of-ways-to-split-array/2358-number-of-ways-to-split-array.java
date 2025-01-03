class Solution {
    public int waysToSplitArray(int[] nums) {
        long totalSum = 0l;
        long prefixSum = 0l;

        for(int num : nums){
            totalSum += num;
        }

        int count = 0;

        for(int i = 0;i<nums.length-1;i++){
            prefixSum += nums[i];
            
            long rightSum = totalSum - prefixSum;
            if(prefixSum >= rightSum){
                count++;
            }
        }

        return count;
    }
}