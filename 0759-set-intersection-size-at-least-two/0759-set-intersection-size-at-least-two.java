class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);        // sort by last index asc
            }
            return Integer.compare(b[0], a[0]);            // if equal, sort by first desc
        });
        int first  = -1;
        int second  = -1;
        int ans = 0;
        for(int[] arr : intervals){
            if(arr[0] <= first)continue;
            if(arr[0] > second){
                first = arr[1] - 1;
                second = arr[1];
                ans += 2;
            }else{
                first = second;
                second = arr[1];
                ans += 1;
            }
        }
        return ans;
    }
}