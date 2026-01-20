class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] ans = new int[nums.size()];
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            int num = nums.get(i);
            ans[i] = minNum(num);
        }
        return ans;
    }

    public int minNum(int num) {
        for (int i = 0; i < num; i++) {
            if ((i | (i + 1)) == num)
                return i;
        }
        return -1;
    }
}