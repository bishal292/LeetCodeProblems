class Solution {
    public boolean isPowerOfThree(int n) {
        // Recursive Approach


        // if(n <= 0)return false;
        // if(n == 1)return true;
        // if(n % 3 != 0)return false;
        // return isPowerOfThree(n / 3); 

        // Mathematics
        if(n <= 0)return false;
        double x = Math.log10(n) / Math.log10(3);
        return x == Math.floor(x);
    }
}