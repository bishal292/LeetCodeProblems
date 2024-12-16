/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray arr) {
        int start =0;
        int end = arr.length() - 1;
        // finding peak element.
        while(start < end){
            int mid = start + (end -start)/2;
            if(arr.get(mid) > arr.get(mid+1)){
                end = mid;
            }else{
                start = mid + 1;
            }
        }

        if(target > arr.get(start)) return -1; // if the target is greater than the peak element itself.
        // Traversing Left in the array to the peak element
        int peak = start;
        start = 0;
        while(start <= end ){
            int mid = start + (end -start)/2;
            if(arr.get(mid) > target){
                end = mid - 1;
            }else if(arr.get(mid) < target){
                start = mid + 1;
            }else{
                return mid;
            }
        }
        // if element Not found in left then traverse Right.
        start = peak + 1;
        end = arr.length() -1;
        while(start <= end ){
            int mid = start + (end -start)/2;
            if(arr.get(mid) < target){
                end = mid - 1;
            }else if(arr.get(mid) > target){
                start = mid + 1;
            }else{
                return mid;
            }
        }
        return -1; // Element not found
    }
}