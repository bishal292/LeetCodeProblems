class Solution {
    public void rotate(int[] nums, int k) {
        // 1 2 3 4 5 6 7        k=3
        // 0 1 2 3 4 5 6
        // 3 4 5 6 0 1 2
        int n= nums.length;
        k = k % n;
        if( n == 1 || k == 0 )return;
        int[] temp = new int[n];
        
        for(int i=0;i<k;i++){
            temp[i]=nums[n-k+i];
        }
        for(int i = k,j=0;i<n;i++){
            temp[i] = nums[j++];
        }
        for(int i=0;i<n;i++){
            nums[i] = temp[i];
        }
    }
}