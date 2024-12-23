class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if(n==1)return;
        int idx1 = -1; // will be pointing to the index from right which is sorted in ascending order means that number can be reArranged with the smallest number from its right which must be greater than the current element. -> BreakPoint
        // [4,2,0,2,3,2,0]
        //  0 1 2 3 4 5 6
        //        i -> here i (3) element is the breaking point which can be replace with th number which is just greater than the current element (i);

        int idx2 = -1; // pointing to the index which is just greater than the idx th element and on its right side.

        for(int i = n-2;i>=0;i--){
            if(nums[i] < nums[i+1]){
                idx1 = i;
                break;
            }
        }
        // if no such index(idx1) is found then the array is purely sorted in descending order.
        if(idx1 == -1){
            reverse(nums, 0);
            return;
        }

        // if such index is found then find the element on right which is greater than the idx elements.
        for(int i = n-1;i >= 0;i--){
            if(nums[i] > nums[idx1]){
                idx2 = i;
                break;
            }
        }

        //  swap the elements on the both the index
        nums[idx1] += nums[idx2];
        nums[idx2] = nums[idx1] - nums[idx2];
        nums[idx1] -= nums[idx2];

        // then reverse the reight remaining elements just after idx1  
        reverse(nums,idx1 + 1);
    }
    public void reverse(int[] nums , int start){
        int end = nums.length - 1;
        while(start < end){//swap opposite elements from both the end i.e last to first and firs to last.....
            nums[start] += nums[end];
            nums[end] = nums[start] - nums[end];
            nums[start] -= nums[end];
            start++;
            end--;
        }
    }
}