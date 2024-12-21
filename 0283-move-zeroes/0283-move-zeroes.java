class Solution {
    public void moveZeroes(int[] nums) {
        // int n = nums.length;
        // int i = 0, j = 0; // Two pointer where i is point to the next index and j is to point to the next
        //                   // non-zero element;
        // while (i < n) {
        //     if (j < n) {
        //         if (nums[j] == 0) {
        //             j++;
        //         } else {
        //             nums[i] = nums[j];
        //             i++;
        //             j++;
        //         }
        //     }else{
        //         nums[i]=0;
        //         i++;
        //     }
        // }


        // A better and optimized version of code.

        int n = nums.length;
        int lastNonZeroIndex = 0;
        for(int i=0;i<n;i++){
            if(nums[i] != 0){
                nums[lastNonZeroIndex++] = nums[i];
            }
        }
        // after the above loop 'lastNonZeroIndex' will be pointing to the next index of the last nonZero index 
        for(int i= lastNonZeroIndex;i<n;i++){
            nums[i] = 0;
        }

    }
}