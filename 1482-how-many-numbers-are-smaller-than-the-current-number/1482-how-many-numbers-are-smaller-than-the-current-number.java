class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {

        // Brute-Force

        // int len = nums.length;
        // int[] result = new int[len];
        // for(int i=0;i<len;i++){
        //     for(int j=0;j<len;j++){
        //         if(i==j)continue;
        //         if(nums[j]<nums[i]){
        //             result[i]++;
        //         }
        //     }
        // }
        // return result;



        // Optimized Way
        // As the elements in the nums Array can ranges between 0 to 100 inclusive so total size for the temp arr will be 101. 
        int[] countArray = new int[101];
        // Storing the count of each element from nums to new declared array.
        for(int num:nums) {
            countArray[num] +=1;
        }
        // manupulating the count in such way so that the array will store the total count of the element smaller then the element of current index.
        for(int j=1; j<= 100; j++) {
            countArray[j] += countArray[j-1];
        }
        
        for(int k=0; k< nums.length; k++) {
            int pos = nums[k];
            nums[k] = pos==0 ? 0 : countArray[pos-1];
        }
        
        return nums;

    }
}