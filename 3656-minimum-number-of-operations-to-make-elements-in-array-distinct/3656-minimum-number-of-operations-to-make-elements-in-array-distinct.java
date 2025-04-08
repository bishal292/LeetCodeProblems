class Solution {
    // Optimized Solution:
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        boolean[] seen = new boolean[101];
        for(int i = n - 1 ; i >= 0 ; i--){
            if(seen[nums[i]])
                return i / 3 + 1;
            else seen[nums[i]] = true;
        }
        return 0;
    }

    // public int minimumOperations(int[] nums) {
    //     HashMap<Integer, Integer> map = new HashMap<>();
    //     for (int num : nums) {
    //         map.put(num, map.getOrDefault(num, 0) + 1);
    //     }
    //     int ans = 0, i = 0;
    //     while (i < nums.length) {
    //         if (!checkIfDuplicatesPresent(map))
    //             return ans;
    //         for (int j = i; j < i + 3 && j < nums.length; j++) {
    //             int num = nums[j];
    //             map.put(num, map.getOrDefault(num, 0) - 1);
    //         }
    //         ans++;
    //         i += 3;
    //     }
    //     return ans;
    // }

    boolean checkIfDuplicatesPresent(HashMap<Integer, Integer> map) {
        for (int val : map.values()) {
            if (val > 1)
                return true;
        }
        return false;
    }
}