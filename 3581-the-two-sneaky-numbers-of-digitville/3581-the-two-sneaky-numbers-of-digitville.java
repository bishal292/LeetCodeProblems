class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] ans = { -1, -1 };
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i) { // already at correct index.continue to next index.
                i++;
                continue;
            }
            int crtIdx = nums[i];
            if (nums[i] == nums[crtIdx]) { // if there is already a same number at the correct index then it is a duplicate
                if (ans[0] == -1) // if this is 1st duplicate.
                    ans[0] = nums[i];
                else if (ans[0] != nums[i]) { // if this 2nd then just break the loop.
                    ans[1] = nums[i];
                    break;
                }
                i++;
                continue;
            }
            int temp = nums[i];
            nums[i] = nums[crtIdx];
            nums[crtIdx] = temp;
        }
        return ans;
    }
}