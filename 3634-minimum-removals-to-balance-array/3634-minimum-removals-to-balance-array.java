class Solution {
    public int minRemoval(int[] nums, int k) {
        int ans = Integer.MAX_VALUE;
        int n = nums.length;
        Arrays.sort(nums);
        int i = 0;

        // while(i<n){
        //     long max = (long)nums[i] * k;
        //     int j = i+1;
        //     while(j < n && nums[j] <= max){
        //         j++;
        //     }
        //     if(j == n){
        //         ans = Math.min(ans,i);
        //         break;
        //     }
        //     ans = Math.min(ans,n-j+i);
        //     i++;
        // }



        i = 0;
        ans = 0;
        for (int j = 0; j < nums.length; j++) {
            while ((long) nums[j] > (long) nums[i] * k) {
                i++;
            }
            ans = Math.max(ans, j - i + 1);
        }
        ans = n - ans;

        return ans;
    }
}