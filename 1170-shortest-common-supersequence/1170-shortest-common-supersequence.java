// class Solution {
//     public String shortestCommonSupersequence(String str1, String str2) {
//         int m = str1.length();
//         int n = str2.length();

//         // Create DP table
//         int[][] dp = new int[m + 1][n + 1];

//         // Fill the DP table
//         for (int i = 1; i <= m; i++) {
//             for (int j = 1; j <= n; j++) {
//                 if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
//                     dp[i][j] = dp[i - 1][j - 1] + 1; // If characters match
//                 } else {
//                     dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // Take max from either previous row or column
//                 }
//             }
//         }

//         // Build the shortest common supersequence
//         StringBuilder result = new StringBuilder();
//         int i = m, j = n;
//         while (i > 0 && j > 0) {
//             // If characters are the same, add to the result
//             if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
//                 result.append(str1.charAt(i - 1));
//                 i--;
//                 j--;
//             } else if (dp[i - 1][j] > dp[i][j - 1]) { // Move in the direction of the larger dp value
//                 result.append(str1.charAt(i - 1));
//                 i--;
//             } else {
//                 result.append(str2.charAt(j - 1));
//                 j--;
//             }
//         }

//         // If there are any remaining characters in str1
//         while (i > 0) {
//             result.append(str1.charAt(i - 1));
//             i--;
//         }

//         // If there are any remaining characters in str2
//         while (j > 0) {
//             result.append(str2.charAt(j - 1));
//             j--;
//         }

//         // Reverse the result before returning
//         return result.reverse().toString();
//     }
// }

class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        String res="";
        try{
        Callable<String> task = () -> generateLCS(str1,str2);
        FutureTask<String> future = new FutureTask<>(task);
        new Thread(future).start();
        res = future.get();
        }catch(Exception e){

        } // Wait for the thread to finish
        return res;

    }

    public String generateLCS(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();

        int[][] lcsMatrix = new int[l1 + 1][l2 + 1];

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    lcsMatrix[i][j] = lcsMatrix[i - 1][j - 1] + 1;
                } else {
                    lcsMatrix[i][j] = Math.max(lcsMatrix[i - 1][j], lcsMatrix[i][j - 1]);
                }
            }
        }

        int row = l1;
        int col = l2;


        String lcs = "";
        StringBuilder ans = new StringBuilder();
        while (row != 0 && col != 0) {
            if (str1.charAt(row - 1) == str2.charAt(col - 1)) {
                ans.append(str1.charAt(row - 1));
                row--;
                col--;
            } else if (lcsMatrix[row - 1][col] > lcsMatrix[row][col - 1]) {
                ans.append(str1.charAt(row - 1));
                row--;
            } else {
                ans.append(str2.charAt(col - 1));
                col--;
            }
        }

        for(int i = l1 - row; i < l1; i++){
            ans.append(str1.charAt(row - 1));
            row--;
        }


        for(int i = l2 - col; i < l2; i++){
            ans.append(str2.charAt(col - 1));
            col--;
        }

        return ans.reverse().toString();
    }
}

