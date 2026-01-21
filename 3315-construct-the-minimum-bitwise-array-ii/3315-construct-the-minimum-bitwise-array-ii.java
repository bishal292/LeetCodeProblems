class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] ans = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);
            if(num == 2){
                ans[i] = -1;
                continue;
            }
            boolean found = false;
            for(int j = 1;j<32;j++){
                if((num & (1 << j)) > 0){
                    continue;
                }
                int prev = j-1;
                ans[i] = (num ^ (1 << prev ));
                found = true;
                break;
            }
            if(!found)ans[i] = -1;
        }
        return ans;
    }
}