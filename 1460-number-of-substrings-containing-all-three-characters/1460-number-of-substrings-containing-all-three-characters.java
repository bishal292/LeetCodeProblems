class Solution {
    public int numberOfSubstrings(String s) {
        int[] freq = new int[3];
        int n = s.length();
        int left = 0;
        int ans = 0;
        
        for (int right = 0; right < n; right++) {
            freq[s.charAt(right) - 'a']++;
            
            while (isPresent(freq)) {
                ans += (n - right);
                freq[s.charAt(left) - 'a']--;
                left++;
            }
        }
        return ans;
    }
    
    public boolean isPresent(int[] freq) {
        return freq[0] > 0 && freq[1] > 0 && freq[2] > 0;
    }
}
