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

        for(int i = 0;i<n;i++){
            ans[i+i] = nums[i];
            ans[i+i+1] = nums[i+n];
        }

        
        return ans;
    }
}