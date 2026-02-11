class Solution {
    static int[] seen = new int[100001];
    static int leet = 0;

    public int longestBalanced(int[] nums) {
        leet++;
        int n = nums.length;
        int ans = 0;

        // for (int i = 0; i < n; i++) {
        //     HashSet<Integer> even = new HashSet<>();
        //     HashSet<Integer> odd = new HashSet<>();
        //     for (int j = i; j < n; j++) {
        //         if(nums[j] % 2 == 0){
        //             even.add(nums[j]);
        //         }else odd.add(nums[j]);

        //         if(even.size() == odd.size())ans = Math.max(ans,j-i+1);
        //     }
        // }
        for (int i = 0; i < n; i++) {
            int[] A = new int[2];
            for (int j = i; j < n; j++) {
                int num = nums[j];
                if (seen[num] != leet)
                    if (num % 2 == 0) {
                        A[0]++;
                    } else {
                        A[1]++;
                    }
                if (A[0] == A[1])
                    ans = Math.max(ans, j - i + 1);

                seen[num] = leet;
            }
            leet++;
        }
        return ans;
    }
}