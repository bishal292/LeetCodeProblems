class Solution {
    public int maxSumDivThree(int[] nums) {
        ArrayList<Integer> r1 = new ArrayList<>();
        ArrayList<Integer> r2 = new ArrayList<>();
        int ans = 0;
        Arrays.sort(nums);
        for (int num : nums) {
            ans += num;
            if (num % 3 == 1) {
                r1.add(num);
            } else if (num % 3 == 2) {
                r2.add(num);
            }
        }

        if (ans % 3 == 0)
            return ans; // if whole sum is 3 divisable then just return the total sum.

        int psbl = 0, psbl2 = 0;
        if (ans % 3 == 1) {
            if (r1.size() > 0) {
                psbl = ans - r1.get(0);
            }
            if(r2.size() > 1)
                psbl2 = ans - r2.get(0) - r2.get(1);
            return Math.max(psbl, psbl2);
        }
        // if extra remainder is 2
        if (r2.size() > 0) {
            psbl = ans - r2.get(0); // found potential ans
        }
        if(r1.size() > 1){
            psbl2 = ans - r1.get(0) - r1.get(1);
        }
        return Math.max(psbl,psbl2);
    }
}