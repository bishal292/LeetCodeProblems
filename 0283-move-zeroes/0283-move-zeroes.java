class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int i = 0, j = 0; // Two pointer where i is point to the next index and j is to point to the next
                          // non-zero element;
        while (i < n) {
            if (j < n) {
                if (nums[j] == 0) {
                    j++;
                } else {
                    nums[i] = nums[j];
                    i++;
                    j++;
                }
            }else{
                nums[i]=0;
                i++;
            }
        }
    }
}