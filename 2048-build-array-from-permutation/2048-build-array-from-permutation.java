class Solution {
    public int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];

        // for(int i = 0;i<nums.length;i++){
        //     ans[i] = nums[nums[i]];
        // }
        // return ans;

        return getAns(nums,ans,0);
    }
    int[] getAns(int[] nums,int[] ans,int index){
        if(index == nums.length){
            return ans;
        }
        ans[index] = nums[nums[index]];
        return getAns(nums,ans,index + 1);
    }
}