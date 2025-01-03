class Solution {
    public int[] productExceptSelf(int[] nums) {
        // Bruteforce:


        // int[] ans = new int[nums.length];
        // Arrays.fill(ans,1);
        // for(int i = 0 ;i<nums.length;i++){
        //     for(int j = 0;j<nums.length;j++){
        //         if(i != j){
        //             ans[i] *= nums[j];
        //         }
        //     }
        // }
        // return ans;


        // Optimized Approach:

        // int n = nums.length;
        // int[] prefix = new int[n];
        // prefix[0] = 1;
        // int[] suffix = new int[n];
        // suffix[n-1] = 1;
        // int[] ans = new int[n];
        // for(int i = 1;i<n;i++){
        //     prefix[i] = prefix[i-1] * nums[i-1];
        // }
        // for(int i = n-2;i>=0;i--){
        //     suffix[i] = suffix[i+1] * nums[i+1];
        // }

        // for(int i =0;i<n;i++){
        //     ans[i] = prefix[i] * suffix[i];
        // }
        // return ans;


        int n = nums.length;
        int[] ans = new int[n];

        ans[0] = 1;
        for(int i =1;i<n;i++){
            ans[i] = ans[i-1] * nums[i-1];
        }

        int prevSuffix = 1;

        for(int i = n - 2;i >= 0;i--){
            prevSuffix *= nums[i+1]; 
            ans[i] *= prevSuffix;
        }
        return ans;
    }
}