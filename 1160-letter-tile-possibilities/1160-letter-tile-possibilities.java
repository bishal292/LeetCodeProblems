class Solution {

    public int numTilePossibilities(String tiles) {
        int len = tiles.length();

        if (len == 1)
            return 1;
        int uniq = 0;
        int[] freq = new int[26];
        for (char c : tiles.toCharArray()) {
            int i = c - 'A';
            if (freq[i] == 0)
                uniq++;
            freq[i] += 1;
        }
        if (uniq == 1)
            return len;
        int ans = backtrack(freq);
        return ans;
    }

    public int backtrack(int[] freq) {
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0)
                continue;
            count++;
            freq[i]--;
            count += backtrack(freq);
            freq[i]++;
        }
        return count;
    }
}