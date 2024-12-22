class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        int even = 0;
        int odd = 1;

        for (int num : nums) {
            if (num > 0) {
                res[even] = num;
                even += 2;
            } else {
                res[odd] = num;
                odd += 2;
            }
        }

        return res;

    }
}