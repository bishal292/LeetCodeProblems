// class Solution {
//     public int findTargetSumWays(int[] nums, int target) {
//         int n = nums.length, mid = n / 2;
//         List<Long> sums1 = new ArrayList<>(), sums2 = new ArrayList<>();
//         computeSums(nums, 0, mid, sums1);
//         computeSums(nums, mid, n, sums2);
//         Map<Long, Long> countMap = new HashMap<>();
//         for (long sum : sums2) countMap.put(sum, countMap.getOrDefault(sum, 0L) + 1);
//         long total = 0;
//         for (long sum : sums1) {
//             long complement = (long) target - sum;
//             total += countMap.getOrDefault(complement, 0L);
//         }
//         return (int) total;
//     }

//     private void computeSums(int[] nums, int start, int end, List<Long> sums) {
//         sums.add(0L);
//         for (int i = start; i < end; ++i) {
//             int num = nums[i], n = sums.size();
//             for (int j = 0; j < n; ++j) {
//                 sums.add(sums.get(j) + num);
//                 sums.set(j, sums.get(j) - num);
//             }
//         }
//     }
// }


class Solution {
    int[] dp;
    public int findTargetSumWays(int[] nums, int target) {
        // use DP
        // assume that we have S1 - S2 = target && S1 + S2 = sum ==> S1 = (target + sum)/2
        // it means that we need to find the number of subsets that have sum = (target + sum)/2
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //System.out.println("target+sum:" + (target+sum));
        if (target > sum || target + sum < 0 || (target+sum)%2 != 0) {
            return 0;
        }
        //System.out.println("---");
        int targetSum = (target + sum)/2;
        // we use DP to represents the number of subset that have sum equals targetSum
        dp = new int[targetSum+1]; 
        dp[0] = 1; // we have at least one way to have sum = 0 as empty subset

        countSubsets(nums, 0, targetSum);
        return dp[targetSum];
    }

    private void countSubsets(int[] nums, int index, int targetSum) {
        if (index == nums.length) {
            return;
        }
        
        for (int j=targetSum; j>=nums[index]; j--) {
            dp[j] += dp[j-nums[index]];
        }
        countSubsets(nums, index+1, targetSum);
    }

    /* backtracking
    public int findTargetSumWays(int[] nums, int target) {
        return backtrack(nums, 0, target, 0);
    }

    private int backtrack(int[] nums, int index, int target, int currentSum) {
        if (index == nums.length) {
            return (currentSum == target) ? 1 : 0;
        }
        int add = backtrack(nums, index+1, target, currentSum+nums[index]);
        int sub = backtrack(nums, index+1, target, currentSum-nums[index]);
        return add+sub;
    }*/
}