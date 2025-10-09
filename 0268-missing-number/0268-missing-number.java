class Solution {
    public int missingNumber(int[] nums) {
        // Using Total Sum Approach.

        // int reqSum = 0;
        // int sum = 0;
        // for(int i =0;i<nums.length;i++){
        //     reqSum += i+1;
        //     sum += nums[i];
        // }
        // // System.gc();
        // return reqSum - sum;

        //  Using Cyclic Sort Approach:
        int i = 0;
        // Sort the array in-place using cyclic sort.
        while(i < nums.length){
            int crtIdx = nums[i];
            if(nums[i] == nums.length){
                i++;
                continue;
            }
            if(nums[i] != nums[crtIdx]){
                int temp = nums[i];
                nums[i] = nums[crtIdx];
                nums[crtIdx] = temp;
            }else{
                i++;
            }
        }
        // Check if all the element are at correct index if not then return then index as that element is missing.
        for(i = 0;i<nums.length;i++){
            if(nums[i] != i)return i;
        }
        // and if all the element in the range is at correct index the return the length(n) itself as this is the missing one.
        return nums.length;
    }
}