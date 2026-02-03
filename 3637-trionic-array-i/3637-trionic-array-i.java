class Solution {
    public boolean isTrionic(int[] nums) {
        // boolean firstInc = false;
        // boolean firstDec = false;
        // boolean secondInc = false;

        // for(int i = 1;i<nums.length;i++){
        //     if(nums[i] > nums[i-1]){
        //         if(!firstDec){
        //             firstInc = true;
        //         }else{
        //             secondInc = true;
        //         }
        //     }else if(nums[i] < nums[i-1]){
        //         if(!firstInc || secondInc){
        //             return false;
        //         }else{
        //             firstDec = true;
        //         }
        //     }else return false;
        // }
        // return firstInc && secondInc && firstDec;

        int p = 0;
        int n = nums.length;

        while(p < n-1 && nums[p] < nums[p+1]){// Strictly Increasing.
        p++;
        }
        if(p==0)return false;// if strictly increasing found.

        int q = p;
        while(q < n-1 && nums[q] > nums[q+1]){
            q++;
        }
        if(p == q) return false;

        p = q;
        while(p < n-1 && nums[p] < nums[p+1]){
            p++;
        }
        if(p==q || p != n-1)return false;
        return true;
    }
}