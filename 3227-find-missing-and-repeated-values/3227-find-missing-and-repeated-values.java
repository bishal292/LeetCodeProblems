class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] ans = new int[2];
        int n = grid.length;
        boolean[] flag = new boolean[n*n];
        for(int[] arr:grid){
            for(int num : arr){
                if(flag[num-1]){
                    ans[0] = num;
                }
                flag[num-1] = true;
            }
        }
        for(int i =0;i<flag.length;i++){
            if(!flag[i]){
                ans[1] = i+1;
                break;
            }
        }
        return ans;
    }
}