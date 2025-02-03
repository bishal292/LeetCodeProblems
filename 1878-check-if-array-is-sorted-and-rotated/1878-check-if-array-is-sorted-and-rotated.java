class Solution {
    public boolean check(int[] nums) {
        int peakCount = 0;
        int n = nums.length;
        for(int i=0;i<n-1;i++){
            if(nums[i] > nums[i+1])peakCount++;
        }
        if(peakCount > 1)return false;
        if(peakCount == 0 || nums[n-1]<= nums[0])return true;

        return false;
    }
}