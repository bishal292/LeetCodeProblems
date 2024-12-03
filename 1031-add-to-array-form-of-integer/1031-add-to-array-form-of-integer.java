class Solution {
    public List<Integer> addToArrayForm(int[] num, int k){
        List<Integer> result = new ArrayList<>();
        int i = num.length - 1;  // Start from the last digit
        
        // here in this Approach instead of adding k to the num; num is being added to k in reverse order and then last digit of k is being added in the list("result");
        // then update k with the new value as its last digit is already added.
        // Example: num= [1,2,4,5,7,1,9] , k = 1; 
        // Iterating nums in reverse order and adding with k:
        // k: 1+9 = 10
        // adding last digit in list (i.e 0) and updating k with its new value as last digit is already inserted (i.e 1)


        // Process each digit, adding k and handling carry
        while (i >= 0 || k > 0) {
            if (i >= 0) {
                k += num[i];  // Add current digit to k
                i--;          // Move to the previous digit in num array
            }
            result.add(k % 10);  // Append the last digit of k
            k /= 10;             // Update k for the next carry
        }
        
        // Reverse the result as digits are added in reverse order
        Collections.reverse(result);
        return result;
    }

}