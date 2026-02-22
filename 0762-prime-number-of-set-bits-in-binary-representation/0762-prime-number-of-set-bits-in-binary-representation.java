class Solution {
    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        for(int i = left;i<=right;i++){
            if(isPrime(countSetBits(i)))ans++;
        }
        return ans;
    }

    public int countSetBits(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1); // removes lowest set bit
            count++;
        }
        return count;
    }

    public boolean isPrime(int num) {
        if(num <= 1)return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}