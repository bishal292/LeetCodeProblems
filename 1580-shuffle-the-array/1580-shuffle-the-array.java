class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[2*n];
        for(int i=0;i<n;i++){
            result[i+i]=nums[i];
            result[i+i+1] = nums[i+n];
        }
        return result;
    }
}