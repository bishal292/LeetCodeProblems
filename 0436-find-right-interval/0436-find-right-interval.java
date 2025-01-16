class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] ans = new int[n];

        // Step 1: Store original indices before sorting
        HashMap<int[], Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(intervals[i], i);
        }

        // Step 2: Sort intervals based on the start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 3: Use binary search to find the right interval
        for (int i = 0; i < n; i++) {
            int rightIndex = binarySearch(intervals, intervals[i][1]); // Find the right interval
            ans[indexMap.get(intervals[i])] = (rightIndex == -1) ? -1 : indexMap.get(intervals[rightIndex]);
        }

        return ans;
    }

    // Binary search to find the smallest interval whose start >= endI
    private int binarySearch(int[][] intervals, int endI) {
        int low = 0, high = intervals.length - 1;
        int idx = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (intervals[mid][0] >= endI) {
                idx = mid; // Possible answer, but we need the smallest start
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return idx;
    }
}