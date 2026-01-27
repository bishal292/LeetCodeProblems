class Solution {
    public int reverse(int x) {
        long rev = 0;
        boolean neg = x < 0;
        long y = Math.abs(x);
        while(y > 0){
            long rem = y % 10;
            y /= 10;
            if( rev * 10 + rem > Integer.MAX_VALUE)return 0;
            rev = rev * 10 + rem;
        }
        int ans = (int)rev;
        return neg ? -ans : ans;
    }
}