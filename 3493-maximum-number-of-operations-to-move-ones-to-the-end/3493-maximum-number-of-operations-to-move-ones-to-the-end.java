class Solution {
    public int maxOperations(String s) {
        int ans = 0;
        int i = 0;
        int count = 0;
        int n = s.length();
        while (i < n) {
            while (i < n && s.charAt(i) == '1') {
                count++;
                i++;
            }
            if (i < n && s.charAt(i) == '0') {// next zero encountered.
                ans += count;
            }
            while (i < n && s.charAt(i) == '0') {
                i++;
            }
        }

        return ans;

        // int ans = 0, ones = 0;
        // int n = s.length();

        // for (int i = 0; i < n - 1; i++) {
        //     if(s.charAt(i) == '1')ones++;
        //     if (s.charAt(i) == '1' && s.charAt(i + 1) == '0') {
        //         ans += ones;
        //     }
        // }

        // return ans;
    }
}