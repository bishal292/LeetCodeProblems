class Solution {
    public int smallestNumber(int n) {
        // while((n & (n+1)) != 0){
        //     n++;
        // }
        // return n;

        int mask = 1;
        while(mask <= n){
            mask <<= 1;
        }
        return mask -1;
    }
}