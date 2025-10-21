class Solution {
    public boolean isPowerOfFour(int n) {
        // if(n == 1)return true;
        // if(n < 1 || n % 4 != 0 )return false;
        // return isPowerOfFour(n / 4);

        if(n < 1)return false;
        double x = Math.log10(n) / Math.log10(4);
        return x == Math.floor(x);
    }
}