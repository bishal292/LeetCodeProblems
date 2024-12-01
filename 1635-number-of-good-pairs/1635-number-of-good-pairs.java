class Solution {
    public int numIdenticalPairs(int[] nums) {
        int count=0;
        for(int j=0;j<nums.length;j++){
            for(int i=0;i<j;i++){
                if(nums[i]==nums[j])count++;
            }
        }
        return count;
    }
}