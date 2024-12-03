class Solution {
    public int digitCounts(int number){
        int digit=0;
        while(number>0){
            number = number / 10;
            digit++;
        }
        return digit;
    }
    public int findNumbers(int[] nums) {
        int numCount= 0;
        for(int num:nums){
            int digitCount=digitCounts(num);
            if(digitCount % 2 == 0)numCount++;
        }
        return numCount;
    }
}