class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;

        // Brute force Using sort method:-> Not fit for the question as asked for O(N)
        // but sort method uses O(NlogN)

        // Arrays.sort(nums);
        // int maxCount = 0;
        // int count = 1;
        // for (int i = 0; i < nums.length - 1; i++) {

        // if (nums[i] == nums[i + 1]) {
        // } else if (nums[i] + 1 == nums[i + 1]) {
        // count += 1; // if Next NUmber is just 1 grater than the current number
        // } else
        // count = 1;
        // maxCount = Math.max(count, maxCount);
        // }

        // return Math.max(count, maxCount);

        int n = nums.length;
        // converrted array to set
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int max = 0;
        for (int ele : set) {
            int x = ele - 1;
            int count = 0;
            if (!set.contains(x)) {
                while (set.contains(x + 1)) {
                    x = x + 1;
                    count++;
                }
            }
            max = Math.max(max, count);
        }
        return max;
    }
}