class Solution {
    public int maxChunksToSorted(int[] arr) {
        int chunkCount =0;
        int sum=0;// to count the sum of the elements in the array till ith index
        for(int i=0;i<arr.length;i++){
            int reqSum = i* (i + 1) / 2; //required sum till the ith elements in th array;
            sum += arr[i];
            if(sum == reqSum){// means these parts can be sorted separetely.
                chunkCount++;
            }
        }
        return chunkCount;
    }
}