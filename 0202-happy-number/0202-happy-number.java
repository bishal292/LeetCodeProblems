class Solution {
    public boolean isHappy(int n) {
    // HashSet<Integer> set = new HashSet<>();
        int fast = n;
        int slow = n;
        do{
            fast = getDigitsSquareSum(getDigitsSquareSum(fast));
            slow = getDigitsSquareSum(slow);
        }while(fast != slow);

            if(fast == 1)return true;
            
        return false;
    }

    public int getDigitsSquareSum(int n){
        int sum = 0;
        while(n > 0){
            int rem = n % 10;
            sum += (rem * rem);
            n /= 10;
        }
        return sum;
    }
}