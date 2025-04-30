class Solution {
    public int digitCounts(int number){
        int digit=0;
        while(number>0){
            number = number / 10;
            digit++;
        }
        return digit;
    }
    public boolean doesContainEvenDigits(int number){
        int digit=0;
        while(number>0){
            number = number / 10;
            digit++;
        }
        return digit %2 ==0;
    }
    public int findNumbers(int[] nums) {

        int numCount= 0;

        // Simple Approach to solve the Problem:

        // for(int num:nums){
        //     // int digitCount=digitCounts(num);
        //     // if(digitCount % 2 == 0)numCount++;
        //     if(doesContainEvenDigits(num))numCount++;
        // }


        // Using Logarithms to get the no. of digits in a number.
        for(int i=0; i<nums.length; i++) {
            if(((int)(Math.log10(nums[i])) + 1) % 2 == 0) {
                numCount++;
            }
        }
        return numCount;
    }
}