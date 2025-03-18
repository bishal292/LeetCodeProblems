class Solution {
    public boolean divideArray(int[] nums) {
        // HashMap<Integer,Integer> map = new HashMap<>();
        // for(int num:nums){
        //     map.put(num,map.getOrDefault(num,0)+1);
        // }
        // for(int count : map.values()){
        //     if(count % 2 != 0){
        //         return false;
        //     }
        // }
        // return true;

        // A faster Approach:


        int[] freq = new int[501];

        for(int i = 0; i<nums.length; i++){
            freq[nums[i]]++;
        }

        for(int i = 0; i<501; i++){
            if(freq[i]%2 != 0){
                return false;
            }
        }

        return true;
    }
}