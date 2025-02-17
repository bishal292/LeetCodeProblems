// class Solution {

//     public int numTilePossibilities(String tiles) {
//         int len = tiles.length();

//         if (len == 1)
//             return 1;
//         int uniq = 0;
//         int[] freq = new int[26];
//         for (char c : tiles.toCharArray()) {
//             int i = c - 'A';
//             if (freq[i] == 0)
//                 uniq++;
//             freq[i] += 1;
//         }
//         if (uniq == 1)
//             return len;
//         int ans = backtrack(freq);
//         return ans;
//     }

//     public int backtrack(int[] freq) {
//         int count = 0;
//         for (int i = 0; i < 26; i++) {
//             if (freq[i] == 0)
//                 continue;
//             count++;
//             freq[i]--;
//             count += backtrack(freq);
//             freq[i]++;
//         }
//         return count;
//     }
// }
class Solution {
    public int numTilePossibilities(String tiles) {
        char[] arr = tiles.toCharArray();
        return permute(0, arr);
    }
    public int permute(int start, char[] arr) {
        if(start == arr.length) return 0;
        int ans = 0;
        for(int i=start; i<arr.length; i++) {
            if(!isPermutedBefore(start, i-1, arr[i], arr)) {
                swap(start, i, arr);
                ans += 1+permute(start+1, arr);
                swap(start, i, arr);
            }
        }
        return ans;
    }
    public boolean isPermutedBefore(int i, int j, char ch, char[] arr) {
        while(i<=j)
            if(arr[i++] == ch) return true;
        return false;
    }
    public void swap(int i, int j, char[] arr) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}