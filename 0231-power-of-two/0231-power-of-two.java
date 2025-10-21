class Solution {
    public boolean isPowerOfTwo(int n) {
        // Iterative Approach
        // if(n<= 0)return false;
        // while(n>1){
        //     if(n%2 == 1)return false;
        //     n /= 2;
        // }
        // return true;
        
        
        // Recursive Approach
        
        // if(n<= 0)return false;
        // if(n==1)return true;
        // if(n % 2 == 1)return false;
        // return isPowerOfTwo(n/2);


        // Most Optimized and bit Manupulation

        return (n > 0 && (n & (n-1)) == 0);
    }
}