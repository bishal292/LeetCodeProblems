class Solution {
    public int punishmentNumber(int n) {
        // int[] arr =
        // {1,9,10,36,45,55,82,91,99,100,235,297,369,370,379,414,657,675,703,756,792,909,918,945,964,990,991,999,1000};
        // int sum = 0;
        // for(int i=0;i<arr.length;i++){
        // if(arr[i]<=n) sum += arr[i]*arr[i];
        // else if(arr[i]>n) break;
        // }
        // return sum;
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int sqr = i * i;
            if (canPartition(sqr, i)) {
                ans += sqr;
            }
        }
        return ans;
    }

    boolean canPartition(int square, int target) {
        if (square == target)
            return true;
        if (square < target || target < 0)
            return false;

        return (canPartition(square / 10, target - (square % 10)) || canPartition(square / 100, target - (square % 100))
                || canPartition(square / 1000, target - (square % 1000)));
    }
}