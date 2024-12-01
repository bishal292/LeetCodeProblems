class Solution {
    public int numIdenticalPairs(int[] nums) {
        // int count=0;
        // for(int j=0;j<nums.length;j++){
        //     for(int i=0;i<j;i++){
        //         if(nums[i]==nums[j])count++;
        //     }
        // }
        // return count;


        // Optimized Way


        int[] countArray = new int[101];
        for(int num: nums){
            countArray[num]++;
        }
        int totalCount =0 ;
        for(int i: countArray){
            totalCount+=((i * (i-1)) /2);
        }
        return totalCount;
    }
}