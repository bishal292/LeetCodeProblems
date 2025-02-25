class Solution {
    // public int numOfSubarrays(int[] arr) {
    //     long ans = 0l;
    //     int mod = 1000000007;
    //     int oddCount = 0;
    //     int evenCount = 1;
    //     long preSum = 0l;
    //     for (int num : arr) {
    //         preSum += num;
    //         if (preSum % 2 == 0) {
    //             evenCount++;
    //             ans += oddCount;
    //         } else {
    //             oddCount++;
    //             ans += evenCount;
    //         }
    //         ans %= mod;
    //     }
    //     return (int) ans;
    // }

    public int numOfSubarrays(int[] arr) {
        long oddCount = 0, prefixSum = 0;
        for (int a : arr) {
            prefixSum += a;
            oddCount += prefixSum % 2;
        }
        oddCount += (arr.length - oddCount) * oddCount;
        return (int) (oddCount % 1_000_000_007);
    }
}