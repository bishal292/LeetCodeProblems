class Solution {
    public long countBadPairs(int[] nums) {
        // HashMap<Integer,Integer> bag = new HashMap<>();
        // int n = nums.length;
        // long totCount = 1l * n*(n-1) / 2;
        // long goodPair = 0L;

        // for(int i = 0;i<n;i++){
        //     int key = nums[i] - i;
        //     int prevCount = bag.getOrDefault(key,0);
        //     goodPair += prevCount;
        //     bag.put(key,prevCount + 1);
        // }

        // return totCount - goodPair;

        Map<Integer, Integer> bag = new HashMap<>();
        long count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += -1 + bag.merge(nums[i] - i, 1, Integer::sum);
        }
        int len = nums.length;
        return 1L * len * (len - 1) / 2 - count;
    }
}