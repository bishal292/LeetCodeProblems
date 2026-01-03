class Solution {
    public int splitArray(int[] nums, int k) {
        int start = 0;
        int end = 0;
        for (int n : nums) {
            start = Math.max(start, n);
            end += n;
        }
        while (start < end) {
            int mid = start + (end - start) / 2;
            int pieces = 1;
            int sum = 0;
            for (int n : nums) {
                if (sum + n > mid) {
                    pieces++;
                    sum = n;
                } else {
                    sum += n;
                }

                if (pieces > k) {
                    start = mid + 1;
                    break;
                }
            }
            if(pieces <= k){
                end = mid;
            }
        }
        return end;
    }
}