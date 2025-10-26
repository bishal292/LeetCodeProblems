class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[n*2];

// Simple to keep first n element as they will be on even index.
        // for(int i = 0;i<n;i++){
        //     ans[i+i] = nums[i]; // x1,x2,x3 and even index.
        // }

// Now iterating from last to keep the yn at itscorrect place.
        // for(int i = nums.length -1,diff = 0;i>=n;i--,diff++){
        //     ans[i-diff] = nums[i];
        // }
//   analyzing and finding a pattern where we can iterate from 0 to n keep y at its correct place.
//   i+i+1 is the index whose value is to be changed in ith iteration and the value would be i+n
// So placing the ans in a single loop

        // for(int i = 0;i<n;i++){
        //     ans[i+i] = nums[i];
        //     ans[i+i+1] = nums[i+n];
        // }
        // return ans;

// BY Storing the values upto n at each index from 0,n

        // int factor=0;
        // for(int num : nums){
        //     factor = Math.max(num,factor);
        // }
        // factor++;

        // for(int i = 0;i<n;i++){
        //     nums[i] += nums[i+n] * factor;
        // }
        // for(int i= n-1;i>= 0;i--){
        //     int x = nums[i] % factor;
        //     int y = nums[i] / factor;
        //     nums[2*i] = x;
        //     nums[2*i+1] = y;
        // }

//  Using Bitwise as nums[i]'s max value can be 10^3 = 1000 which in binary can maximum holds upto 10 bits so,

        for(int i= 0;i<n;i++){
            nums[i] = nums[i] << 10; // shifts all the bits to the left 10 times making extra space so that other 10 bit can be added up.
            nums[i] = nums[i] | nums[i+n];// will make 0th-> x1y1,1st->x2,y2
        }

        for(int i = n-1;i>= 0;i--){
            int y = nums[i] & (int)(Math.pow(2,10) - 1);
            int x = nums[i] >> 10;
            nums[2*i] = x;
            nums[2*i+1] = y;
        }
        return nums;
    }
}