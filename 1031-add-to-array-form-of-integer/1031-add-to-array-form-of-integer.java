class Solution {
    public List<Integer> addToArrayForm(int[] num, int k){
        List<Integer> result = new ArrayList<>();
        int i = num.length - 1;  // Start from the last digit
        
        // Process each digit, adding k and handling carry
        while (i >= 0 || k > 0) {
            if (i >= 0) {
                k += num[i];  // Add current digit to k
                i--;          // Move to the previous digit
            }
            result.add(k % 10);  // Append the last digit of k
            k /= 10;             // Update k for the next carry
        }
        
        // Reverse the result as digits are added in reverse order
        Collections.reverse(result);
        return result;
    }

}