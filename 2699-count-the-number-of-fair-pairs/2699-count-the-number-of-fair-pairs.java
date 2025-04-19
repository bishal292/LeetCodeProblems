class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);

        // long ans = 0l;
        // int n = nums.length;
        // for(int i = 0;i<n;i++){
        //     for(int j = i+1;j<n;j++){
        //         int sum = nums[i]+nums[j];
        //         if(sum > upper) break;
        //         if(sum >= lower){
        //             ans++;
        //         }
        //     }
        // }
        // return ans;

        return countAtLeast(nums, lower) - countAtLeast(nums, upper+1);
    }

    long countAtLeast(int[] nums, long comp) {
        long ans = 0; int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] >= comp) {
                ans += j - i;
                j--;
            }
            else i++;
        }
        return ans;
    }
}