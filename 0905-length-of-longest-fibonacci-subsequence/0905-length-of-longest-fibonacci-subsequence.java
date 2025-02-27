class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int maxSeq = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr)
            set.add(num);

        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int cur = arr[i];
            int nxt = arr[i + 1];
            int sum = cur + nxt;
            int len = 2;
            while (set.contains(sum)) {
                len++;
                cur = nxt;
                nxt = sum;
                sum = cur + nxt;
                maxSeq = Math.max(maxSeq, len);
            }

        }
        return maxSeq;
    }
}