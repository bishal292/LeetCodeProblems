class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder sb = new StringBuilder();

        int carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            int bitA = (i >= 0) ? a.charAt(i) - '0' : 0; // Get the bit from a or 0 if out of bounds(exceeds the size)
            int bitB = (j >= 0) ? b.charAt(j) - '0' : 0; // Get the bit from b or 0 if out of bounds(exceeds the size)

            // Sum the bits and the carry
            int sum = bitA + bitB + carry;
            sb.append(sum % 2); // Append the result of sum mod 2 (binary digit)
            carry = sum / 2;       // Update the carry

            i--; // Move to the previous bit in a
            j--; // Move to the previous bit in b
        }

        return sb.reverse().toString();
    }
}