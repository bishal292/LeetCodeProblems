class Solution {
    public long coloredCells(int n) {
        long ans = 1l;
        long diff = 4l;
        while(n > 1){
            ans += diff;
            diff += 4;
            n--;
        }

        return ans;
    }
}