class Solution {
    public int splitArray(int[] nums, int k) {
        int start = 0; // will store the smallest possible answer
        int end = 0; // will store the largest possible answer

        for(int num : nums){
            start = Math.max(start,num);
            end += num;
        }

        // Binary search in the range
        while(start < end){
            int mid = start + (end - start)/2;
            int pieces = 1; // the minimum pieces in which the array can be divided will be 1.
            int sum = 0; // keeps track of the elems sum.

            for(int num : nums){
                if(sum + num > mid){ // checks if adding current elem will exceeds the maximum value if yes then the array will now be divided into another piesce and the sum for the new piece will resets to the current elem.
                    pieces++;
                    sum = num;
                }else{
                    sum += num;
                }

                if(pieces > k){ // if at any points the number of pieces is increased than the required no. of piece(K) means the potetial answer is larger than the current potential ans(mid)
                    start = mid + 1;
                    break;
                }
            }

            if(pieces <= k){ // If the no. of Pieces(parts) formed for the current potential ans(mid) is less than eq. to the req. parts(k) then this might be the answer but there is a possibility that further more smaller number could be the answer so, check for it.
                end = mid;
            }
        }
        return end;
    }
}