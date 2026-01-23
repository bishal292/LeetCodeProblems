class Solution {
    // public int minPair(List<Integer> v) {
    //     int minSum = (int)1e9;
    //     int pos = -1;

    //     for(int i = 0; i < v.size() - 1; i ++){
    //         int sum = v.get(i) + v.get(i + 1);
    //         if (sum < minSum) {
    //             minSum = sum;
    //             pos = i;
    //         }
    //     }
    //     return pos;
    // }

    // public void mergePair(List<Integer> v, int pos) {
    //     v.set(pos, v.get(pos) + v.get(pos + 1));
    //     v.remove(pos + 1);
    // }

    // public int minimumPairRemoval(int[] nums) {
    //     List<Integer> v = new ArrayList<>();
    //     for(int x : nums) v.add(x);

    //     int ops = 0;
    //     while(!isSorted(v)){
    //         int pos = minPair(v);
    //         mergePair(v, pos);
    //         ops++;
    //     }
    //     return ops;
    // }

    // private boolean isSorted(List <Integer> v) {
    //     for(int i = 0; i < v.size() - 1; i ++){
    //         if(v.get(i) > v.get(i + 1)) return false;
    //     }
    //     return true;
    // }

    public int minimumPairRemoval(int[] nums) {
        int n = nums.length,count = 0;
        while(n > 0){
            int minSum = Integer.MAX_VALUE , minIdx = -1;
            boolean dec = false; // By default assumed that all the elemnts are in ascending/Increasing Order.
            for(int i = 0;i<n-1;i++){
                if(nums[i] + nums[i+1] < minSum){
                    minSum = nums[i] + nums[i+1];
                    minIdx = i;
                }
                if(nums[i] > nums[i+1]){ // Decreasing seq. is found.
                    dec = true;
                }
            }
            if(!dec)return count; // if all the element become sorted then simply return the count.
            count++;
            nums[minIdx] = minSum;
            for(int i = minIdx+1;i<n-1;i++){
                nums[i] = nums[i+1];
            }
            n--;
        }
        return count;
    }
}