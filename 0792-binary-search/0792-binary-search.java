class Solution {
    public int search(int[] nums, int target) {
//      Iterative Approach for binary search.

        // int start = 0;
        // int end = nums.length -1;
        // while(start <= end){
        //     int mid = start + (end - start) / 2;
        //     if(nums[mid] > target){
        //         end = mid - 1;
        //     }else if(nums[mid] < target){
        //         start = mid + 1;
        //     }else{
        //         return mid;
        //     }
        // }   
        // return -1;


        // Recursive Approach
        return helper(nums,target, 0, nums.length - 1); 
    }
    public static int helper(int[] arr,int target,int start, int end){
        if(start > end)return -1;
        int mid = start + (end - start)/2;
        if(arr[mid] == target) return mid;

        if(arr[mid] > target)return helper(arr,target,start,mid - 1);
        else return helper(arr,target,mid+1,end);
    }
}