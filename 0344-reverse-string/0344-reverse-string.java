class Solution {
    public void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        while (i < j) {
            if (s[i] == s[j]){
                i++;
                j--;
                continue;
            }
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }

        // Recursive Approach.

        // helper(s,0,s.length - 1);
    }

    public void helper(char[] s, int start, int end) {
        if (start >= end) {
            return;
        }
        if (s[start] == s[end]) {
            helper(s, ++start, --end);
            return;
        }
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
        helper(s, ++start, --end);
    }
}