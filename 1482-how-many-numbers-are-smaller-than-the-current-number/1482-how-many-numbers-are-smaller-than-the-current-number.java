class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(i==j)continue;
                if(nums[j]<nums[i]){
                    result[i]++;
                }
            }
        }
        return result;
    }
}