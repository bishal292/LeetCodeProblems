class Solution {
    public int smallestNumber(int n) {
        // while((n & (n+1)) != 0){
        //     n++;
        // }
        // return n;

        // int mask = 1;
        // while(mask <= n){
        //     mask <<= 1;
        // }
        // return mask -1;


        if ((n & (n + 1)) == 0) return n; // if n is already all 1's
        int highest = Integer.highestOneBit(n); // like 1000
        int mask = (highest << 1) - 1;          // make it 1111
        return mask;
    }
}