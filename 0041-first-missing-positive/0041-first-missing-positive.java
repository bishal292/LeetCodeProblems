class Solution {
    public int firstMissingPositive(int[] nums) {
        // BruteForce using extra Space with Space Complexity: O(N);
        int[] sorted = new int[nums.length];
        for(int num : nums){
            if(num > 0 && num <= nums.length){
                sorted[num-1] = num;
            }
        }
        int missingNum = -1;
        for(int i = 0;i< nums.length;i++){
            if(sorted[i] != i+1){
                missingNum = i+1;
                break;
            }else if(sorted[i] == nums.length){
                missingNum = i+2;
            }
        }
        return missingNum == -1 ? nums.length : missingNum ;
    }
}