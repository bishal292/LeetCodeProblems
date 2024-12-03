class Solution {
    public int diagonalSum(int[][] mat) {
        int sum=0;
        int len=mat.length;
        for(int r=0,c=0;r<len;r++,c++){
            sum+=mat[r][c];
        }
        for(int r=0,c=len-1;r<len;r++,c--){
            if(r!=c)
            sum+=mat[r][c];
        }
        return sum;
    }
}