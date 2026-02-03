class Solution {
    public boolean isTrionic(int[] nums) {
        boolean firstInc = false;
        boolean firstDec = false;
        boolean secondInc = false;

        for(int i = 1;i<nums.length;i++){
            if(nums[i] > nums[i-1]){
                if(!firstDec){
                    firstInc = true;
                }else{
                    secondInc = true;
                }
            }else if(nums[i] < nums[i-1]){
                if(!firstInc || secondInc){
                    return false;
                }else{
                    firstDec = true;
                }
            }else return false;
        }
        return firstInc && secondInc && firstDec;
    }
}