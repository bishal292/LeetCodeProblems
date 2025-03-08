class Solution {
    public int minimumRecolors(String blocks, int k) {
        if (blocks.length() < k)
            return -1;

        char[] arr = blocks.toCharArray();
        int ans = Integer.MAX_VALUE;
        int bCount = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'B')
                bCount++;
            if (i >= k && arr[i - k] == 'B') {
                bCount--;
                if (bCount == k)
                    return 0;
            }
            ans = Math.min(ans,k - bCount);
        }
        return ans;
    }
}