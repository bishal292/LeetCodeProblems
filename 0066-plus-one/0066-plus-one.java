class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            if(digits[i]<9){
                digits[i]++;
                return digits;
            }
            digits[i]=0; // if the digit is 9 then set it to 0 and 1 carry will be added in the next element
        }
        // If the loop is fully executed the it means all the digit were 9 so new array must be returned.

        digits = new int[digits.length +1 ];
        digits[0] = 1;
        return digits;
    }
}