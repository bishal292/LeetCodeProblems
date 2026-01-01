class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        if(digits[n-1] != 9){ // if last digit is not 9 then simply increase it by 1 and return;
            digits[n-1]++;
            return digits;
        }
        int carry = 0;
        int i = n-1;
        do{
            int num = digits[i]+1;
            int rem = num % 10;
            carry = num / 10;
            digits[i] = rem;
            i--;
        }while(i >= 0 && carry != 0);
        if(carry != 0){ // means 1 more extra space array is required.
            int[] ans = new int[n+1];
            ans[0] = carry;
            for(int j = 0;j<n;j++){
                ans[j+1] = digits[j];
            }
            return ans;
        }
        return digits;
    }
}