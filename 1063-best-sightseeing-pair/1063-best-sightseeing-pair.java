class Solution {
    public int maxScoreSightseeingPair(int[] values) {

        // Brute-Force Approach -N^2

        // int n = values.length;
        // int maxSum = 0;
        // for(int i =0;i<n-1;i++){
        //     for(int j= i+1;j<n;j++){
        //         maxSum = Math.max(maxSum, values[i] + values[j] + i - j );
        //     }
        // }
        // return maxSum;


        // Optimal Solution : O(N);

        int maxSum = 0;
        int maxI = values[0];

        for(int i =1;i<values.length;i++){
            maxSum = Math.max(maxSum , values[i] - i + maxI);

            maxI = Math.max(maxI, values[i] + i);
        }

        return maxSum;
    }
}