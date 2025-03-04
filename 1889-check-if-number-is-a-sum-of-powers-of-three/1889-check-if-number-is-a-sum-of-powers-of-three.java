class Solution {
    public boolean checkPowersOfThree(int n) {
        //  Explanation in binary representation a number is represented in 0 - 1 combination
        // while reverting it back to decimal the number is multiplied with 2's powers increasing order
        // like (10110) => 1 * 2^4 + 0 * 2^3 + 1 * 2^2 + 1 * 2^1 + 0 * 2^0 => here it like 2^4 + 2^2 + 2^1 
        // similar operation using 3 means ternary conversion instead of binary and whenever it leaves remainder 2 it will requires 2 time multiplication with a power to get the particular value.
        
        while(n>0){
            if(n % 3 == 2){
                return false;
            }
            n /= 3;
        }
        return true;
    }
}