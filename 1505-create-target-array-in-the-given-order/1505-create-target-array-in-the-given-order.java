class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int len = nums.length;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            // Move elements to the right starting from the last index to avoid overwriting
            shiftToRight(index[i],result);
            // Insert the current number at the given index
            result[index[i]] = nums[i];
        }

        return result;
    }
    void shiftToRight(int index,int[] arr){
        for(int i=arr.length-1;i>index;i--){
            arr[i]=arr[i-1];
        }
    }
}