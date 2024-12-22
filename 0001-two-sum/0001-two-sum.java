class Solution {
    public int[] twoSum(int[] nums, int target) {
        // for(int i=1;i<nums.length;i++){
        //     for(int j=i;j<nums.length;j++){
        //         if(nums[j]+nums[j-i]==target) return new int[]{j-i,j};
        //     }
        // }
        // return new int[] {};

        // Optimized way to solve the same using hashMap.

        // A hashMap to store the currentNumber as key with it's index as value. 
        Map<Integer,Integer> numToIdxMap = new HashMap<>(); 

        int n = nums.length;
        for(int i =0;i<n;i++){
            int diff = target - nums[i];

            // If the hashmap already contains the required number which can make the current number sums to the target then return the array index
            if(numToIdxMap.containsKey(diff)){
                return new int[] {i,numToIdxMap.get(diff)};
            }
            // if the key is not present in the hash map then add the currentElement as key with it's index as value.
            numToIdxMap.put(nums[i],i);
        }
        return new int[]{};
    }
}