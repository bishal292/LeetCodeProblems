class Solution {
    public long coloredCells(int n) {
        // long ans = 1l;
        // long diff = 4l;
        // while(n > 1){
        //     ans += diff;
        //     diff += 4;
        //     n--;
        // }

        // return ans;

        // Mathematical formula solution: O(1)

        return 1 + (long) 2 * n *(n-1);
    }
}