class Solution {
    public int maximumWealth(int[][] accounts) {
        int richest = 0;
        for(int[] per : accounts){
            int sum =0;
            for(int bal : per){
                sum+=bal;
            }
            if(sum>richest)richest=sum;
        }
        return richest;
    }
}