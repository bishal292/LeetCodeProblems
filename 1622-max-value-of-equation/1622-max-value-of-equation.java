class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {

        // ----------------------------------------------------------------------------------------------------------
        //                                  BruteForce : O(N^2) | O(1) will cause TLE
        // ----------------------------------------------------------------------------------------------------------

        // int i = 0;
        // int n = points.length;
        // int ans = Integer.MIN_VALUE;

        // while(i < n-1){
        //     int j = i + 1;

        //     while(j < n && Math.abs(points[i][0] - points[j][0]) <= k){
        //         int sum = points[i][1] + points[j][1] + Math.abs(points[i][0] - points[j][0]);
        //         ans = Math.max(ans , sum);
        //         j++;
        //     }
        //     i++;
        // }
        // return ans;

        // ----------------------------------------------------------------------------------------------------------
        //                                  Priority Queue: O(N logN)
        // ----------------------------------------------------------------------------------------------------------

        // PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> (a.getKey() == b.getKey() ? a.getValue() - b.getValue() : b.getKey() - a.getKey()));
        // int res = Integer.MIN_VALUE;
        // for (int[] point : points) {
        //     while (!pq.isEmpty() && point[0] - pq.peek().getValue() > k) {
        //         pq.poll();
        //     }
        //     if (!pq.isEmpty()) {
        //         res = Math.max(res, pq.peek().getKey() + point[0] + point[1]);
        //     }
        //     pq.offer(new Pair<>(point[1] - point[0], point[0]));
        // }
        // return res;

        // ----------------------------------------------------------------------------------------------------------
        //                                  Using DeQueue: O(N)
        // ----------------------------------------------------------------------------------------------------------

        // Deque<Pair<Integer, Integer>> ms = new ArrayDeque<>();
        // int res = Integer.MIN_VALUE;
        // for (int[] point : points) {
        //     while (!ms.isEmpty() && point[0] - ms.peekFirst().getValue() > k) {
        //         ms.pollFirst();
        //     }
        //     if (!ms.isEmpty()) {
        //         res = Math.max(res, ms.peekFirst().getKey() + point[0] + point[1]);
        //     }
        //     while (!ms.isEmpty() && point[1] - point[0] > ms.peekLast().getKey()) {
        //         ms.pollLast();
        //     }
        //     ms.offerLast(new Pair<>(point[1] - point[0], point[0]));
        // }
        // return res;

        // ----------------------------------------------------------------------------------------------------------
        //                                  A Better Optimized: O(N) | O(1)
        // ----------------------------------------------------------------------------------------------------------


        int ans = Integer.MIN_VALUE;
		int left = 0;
        int right = 1;
        while(left < points.length) {
            if(right < left + 1)
                right = left + 1;
            for (int j = right ; j <= points.length - 1; j++) {
                if(points[j][0] > (points[left][0] + k))
					break;

                int sum = points[left][1] + points[j][1] + points[j][0] - points[left][0] ;
                if(sum > ans){
                    ans = Math.max(ans,sum);
                    right = j - 1;
                }
            }
            left++;
        }
        return ans;
    }
}