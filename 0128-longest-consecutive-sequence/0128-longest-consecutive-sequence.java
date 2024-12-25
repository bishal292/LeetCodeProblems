class Solution {
    public int longestConsecutive(int[] nums) {
        // Brute force Using sort method:-> Not fit for the question as asked for O(N)

        // if (nums.length == 0)
        // return 0;
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

        // Approach 2 : Using HashSet O(N);
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

        // approach 3: using an extra space boolean array for the range (max <--> min)
        // if (nums == null || nums.length == 0) {
        //     return 0; // Handle empty array
        // }

        // int max = Integer.MIN_VALUE;
        // int min = Integer.MAX_VALUE;

        // // Find the minimum and maximum values in the array
        // for (int number : nums) {
        //     if (number < min) {
        //         min = number;
        //     }
        //     if (number > max) {
        //         max = number;
        //     }
        // }

        // // Create and populate the boolean array
        // boolean[] isObserved = new boolean[max - min + 1];
        // for (int num : nums) {
        //     isObserved[num - min] = true;
        // }

        // // Find the longest consecutive sequence
        // int longest = 0;
        // int count = 0;

        // for (boolean flag : isObserved) {
        //     if (flag) {
        //         count++;
        //     } else {
        //         longest = Math.max(longest, count);
        //         count = 0;
        //     }
        // }

        // // Check the final sequence
        // longest = Math.max(longest, count);

        // return longest;
    }
}