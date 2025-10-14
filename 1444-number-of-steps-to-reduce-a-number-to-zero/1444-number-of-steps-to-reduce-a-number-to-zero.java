class Solution {
    public int numberOfSteps(int num) {
        // int steps = 0;

        // while(num != 0){
        //     if((num & 1) == 0){
        //         num /= 2;
        //     }else{
        //         num --;
        //     }
        //     steps++;
        // }
        // return steps;


        // RECURSIVE APPROACH
        return helper(num,0);
    }
    public int helper(int n,int steps){
        if(n == 0)return steps;
        if(n % 2 == 0){
            return helper(n/2,steps + 1);
        }
        return helper(n-1,steps+1);
    }
}