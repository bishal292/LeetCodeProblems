class Solution {
    public int maxScore(String s) {
        //  int ones = 0;
        //  for(int i=0;i<s.length();i++){
        //     if(s.charAt(i) == '1')
        //         ones++;
        //  }
        //  int zeros=0;
        //  int maxScore = 0;
        //  for(int i =0;i<s.length()-1;i++){
        //     if(s.charAt(i) == '0'){
        //         zeros++;
        //     }else{
        //         ones--;
        //     }
        //     maxScore = Math.max(maxScore , zeros + ones);
        //  }
        //  return maxScore;


        // Optimal Approach:


        int n = s.length();
        int zeros = s.charAt(0) == '0' ? 1 : 0; // if start is zero then current score is 1;
        int ones = 0;
        int score = zeros;

        for(int i = 1;i < n - 1;i++){
            if(s.charAt(i) == '0'){
                zeros++;
            }else{
                zeros--;
                ones++;
            }
            score = Math.max(score , zeros);
        }
        ones += s.charAt(n-1) == '1' ? 1 : 0;

        return ones + score;
    }
}