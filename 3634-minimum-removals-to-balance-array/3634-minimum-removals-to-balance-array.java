class Solution {
    public int minRemoval(int[] nums, int k) {
        // int min = Integer.MAX_VALUE;
        // int max = Integer.MIN_VALUE;

        // for(int i = 0;i<nums.length;i++){
        //     min = Math.min(min,nums[i]);
        //     max = Math.max(max,nums[i]);
        // }
        // if(min * k >= max)return 0;
        // max = min * k;
        // min = 0;
        // for(int num : nums){
        //     if(num > max)min++;
        // }
        // return min;
        int ans = Integer.MAX_VALUE;
        int n = nums.length;
        Arrays.sort(nums);
        int i = 0;
        while(i<n){
            long max = (long)nums[i] * k;
            int j = i+1;
            while(j < n && nums[j] <= max){
                j++;
            }
            if(j == n){
                ans = Math.min(ans,i);
                break;
            }
            ans = Math.min(ans,n-j+i);
            i++;
        }
        return ans;
    }
}