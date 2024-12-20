class Solution {
    public void rotate(int[] nums, int k) {

        int n= nums.length;
        k %= n;
        if( n == 1 || k == 0 )return;

        // using temp Array to store the result;

        // int[] temp = new int[n];
        
        // for(int i=0;i<k;i++){
        //     temp[i]=nums[n-k+i];
        // }
        // for(int i = k;i<n;i++){
        //     temp[i] = nums[i-k];
        // }
        // for(int i=0;i<n;i++){
        //     nums[i] = temp[i];
        // }

        // Optimal Solution (inspace rotation);
        // 1 2 3 4 5 6 7
        // 7 6 5 4 3 2 1
        // 5 6 7 4 3 2 1
        // 5 6 7 1 2 3 4

        // Reverse the entire array;
        reverseInRanges(nums, 0,n-1);

        // Now reverse the first k elements;
        reverseInRanges(nums, 0 , k-1);
        
        // Reverse the remaining elements after first k elements
        reverseInRanges(nums, k, n-1);
        
    }
    private void reverseInRanges(int[] nums , int start, int end){
        while(start < end){
            nums[start] += nums[end];
            nums[end] = nums[start] - nums[end];
            nums[start++] -= nums[end--];
        }
    }
}