class Solution {
    public int maxAbsoluteSum(int[] nums) {
        // int negSum = 0;
        // int posSum = 0;
        // int ans = 0;
        // for(int num : nums){
        //     if(negSum >= 0)negSum = num;
        //     else negSum += num;
        //     if(posSum <= 0)posSum = num;
        //     else posSum += num;

        //     ans = Math.max(ans,Math.max(posSum,Math.abs(negSum)));
        // }
        // return ans;

        int sum = 0, minSum = 0, maxSum = 0;
        for (int num : nums) {
            sum += num;
            if (sum > maxSum) maxSum = sum;
            if (sum < minSum) minSum = sum;
        }
        return Math.abs(maxSum - minSum);
    }
}