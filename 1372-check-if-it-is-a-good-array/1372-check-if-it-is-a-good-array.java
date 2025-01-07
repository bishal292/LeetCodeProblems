// class Solution {
//     public boolean isGoodArray(int[] nums) {
//         int result = nums[0];
//         if(nums.length == 1 && nums[0] == 1)return true;
//         for (int i = 1; i < nums.length; i++) {
//             result = gcd(result, nums[i]);
//             if(result == 1)return true;
//         }
//         return false;
//     }

//     private int gcd(int a, int b) {
//         if (b == 0) return a;
//         return gcd(b, a % b);
//     }
// }


class Solution {
    public boolean isGoodArray(int[] A) {
        int x = A[0], y;
        for (int a: A) {
            while (a > 0) {
                y = x % a;
                x = a;
                a = y;
            }
        }
        return x == 1;
    }
}