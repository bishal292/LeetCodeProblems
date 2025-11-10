class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;


        // BruteForce
        // int maxArea = 0;
        // for(int i = 0;i<n;i++){
        //     int num = heights[i];
        //     int count = 1;
        //     int j = i-1;
        //     while(j>= 0 && heights[j] >= num){
        //         j--;
        //         count++;
        //     }
        //     j = i+1;
        //     while(j<n && heights[j] >= num){
        //         j++;
        //         count++;
        //     }
        //     int sum = num * (count);
        //     maxArea = Math.max(sum,maxArea);
        // }
        // return maxArea;
        

        // Better 
        int[] ls = new int[n];
        Arrays.fill(ls, -1);/// fills left smallest with -1
        int[] rs = new int[n];
        Arrays.fill(rs,n);/// fill right smallest with the n
        Stack<Integer> stack = new Stack<>();

//  Finding next smallest element.
        for(int i = 0;i<n;i++){
            int elem = heights[i];
            while(!stack.isEmpty() && heights[stack.peek()] > elem){
                rs[stack.pop()] = i;
            }
            stack.push(i);
        }
//  Finding Previous smallest element.
        for(int i = n-1;i>= 0;i--){
            int elem = heights[i];
            while(!stack.isEmpty() && heights[stack.peek()] > elem){
                ls[stack.pop()] = i;
            }
            stack.push(i);
        }
        int ans = 0;
        for(int i = 0;i<n;i++){
            ans = Math.max(ans, heights[i] * (rs[i] - ls[i] -1));
        }
        return ans;
    }
}