class Solution {
    public int minimumCost(int[] nums) {
        int cost = nums[0];
        int sh = Integer.MAX_VALUE;
        int th = Integer.MAX_VALUE;
        for(int i = 1;i<nums.length;i++){
            int num = nums[i];
            if(num <= sh){
                th = sh;
                sh = num;
            }else if(num < th){
                th = num;
            }
        }
        return cost + sh + th;
    }
}