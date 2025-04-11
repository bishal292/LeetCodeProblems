class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int ans = 0;
        for(int i = low;i<= high;i++){
            String str = Integer.toString(i);
            int digitCount = str.length();
            if(digitCount % 2 == 1)continue;
            int first = 0;
            int last = 0;
            for(int j = 0;j < digitCount / 2;j++){
                first += str.charAt(j) - '0';
                last += str.charAt(digitCount - 1 - j)- '0';
            }
            if(first == last)ans++;
        }
        return ans;
    }
}