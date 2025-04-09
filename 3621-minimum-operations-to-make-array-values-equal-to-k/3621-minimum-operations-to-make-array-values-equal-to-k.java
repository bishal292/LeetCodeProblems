class Solution {
    public int minOperations(int[] nums, int k) {
        int ans = 0;
        boolean[] seen = new boolean[101];
        for (int num : nums) {
            if (num < k)
                return -1;
            if (num > k && !seen[num]) {
                seen[num] = true;
                ans++;
            }
        }
        return ans;
    }

    // public int minOperations(int[] nums, int k) {
    //     HashSet<Integer> set = new HashSet<>();
    //     for (int num : nums) {
    //         if (num < k)
    //             return -1;
    //         if (num > k)
    //             set.add(num);
    //     }
    //     return set.size();
    // }
}