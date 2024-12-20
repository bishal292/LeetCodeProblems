class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 1)return 1;
        int j = 1;// second pointer to point to the next Unique Element.
        for(int i = 1;i<nums.length;i++){
            if(nums[i] != nums[i-1])
                nums[j++] = nums[i];
        }
        return j;
    }
}