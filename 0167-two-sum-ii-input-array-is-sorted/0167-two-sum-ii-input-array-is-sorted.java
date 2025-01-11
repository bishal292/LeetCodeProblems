class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int start = 0;
        int end = numbers.length - 1;
        // two Pointer Approach.
        
        // while(start <= end){
        //     int sum = numbers[start] + numbers[end];
        //     if(sum > target){
        //         end--;
        //     }else if(sum < target){
        //         start++;
        //     }else{
        //         return new int[]{start+1, end+1};
        //     }
        // }
        
        // Binary Search:

        for (int i = 0;numbers[i] <= target/2 && i <= end; i++) {
            int complement = target - numbers[i];
            int index = binarySearch(numbers, i + 1, end, complement);
            if (index != -1) {
                return new int[]{i + 1, index + 1};
            }
        }

        return new int[]{-1,-1};
    }

    private int binarySearch(int[] numbers, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (numbers[mid] == target) {
                return mid;
            } else if (numbers[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}