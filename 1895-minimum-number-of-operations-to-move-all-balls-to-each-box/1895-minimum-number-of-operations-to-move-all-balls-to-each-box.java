class Solution {
    public int[] minOperations(String boxes) {

        // BruteForce Solution:->
        int n = boxes.length();
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j =0;j<n;j++){
                if(boxes.charAt(j)=='1')
                    sum += Math.abs(j-i);
            }
            ans[i] = sum;
        }



//  Optimal Solution:
        // int sum = 0;
        // int n = boxes.length();
        // int[] ans = new int[n];
        // int rightBall = 0;
        // int leftBall = 0;

        // for(int i=0;i<n;i++){
        //     if(boxes.charAt(i)=='1'){
        //         sum += i;
        //         rightBall++;
        //     }
        // }

        // // here prefixSum is the move required by all the balls at left of the current index ball.
        // // And sum is the move required by the balls at right to reach the current index.
        // int prefixSum = 0;
        // for(int i = 0;i<n;i++){
        //     ans[i] = sum + prefixSum;
        //     if(boxes.charAt(i) == '1'){
        //         leftBall ++;
        //         rightBall --;
        //     }
        //     sum -= rightBall;
        //     prefixSum += leftBall;
        // }
        return ans;
    }
}