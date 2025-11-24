class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        int num = 0;
        List<Boolean> ans = new ArrayList<>();
        for(int n : nums){
            num *= 2;
            // num = num << 1;
            if(n == 1){
                num += 1;
            }
            if(num % 5 == 0){
                ans.add(true);
            }else{
                ans.add(false);
            }
            num %= 5;
        }
        return ans;
    }
}