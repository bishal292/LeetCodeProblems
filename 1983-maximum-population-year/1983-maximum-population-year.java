class Solution {
    public int maximumPopulation(int[][] logs) {
        // Arrays.sort(logs,(a,b) -> Integer.compare(a[0],b[0]));
        int[] sum = new int[101];
        int year = 1950;
        
        for(int[] arr:logs){
            int bir = arr[0]-1950;
            int dea = arr[1]-1950;
            sum[bir]++;
            sum[dea]--;
        }

        int maxSum = sum[0];
        for(int i = 1;i<101;i++){
            sum[i] += sum[i-1];
            if(sum[i] > maxSum){
                maxSum = sum[i];
                year = i+1950;
            }
        }
        return year;
    }
}