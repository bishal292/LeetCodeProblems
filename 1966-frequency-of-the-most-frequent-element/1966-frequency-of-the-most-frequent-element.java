class Solution {
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int maxFrequency = 1;

        // Brute Force Approach N^2 complexity

        // for (int i = 0; i < n; i++) {
        //     int remainingK = k;
        //     int frequency = 1;

        //     for (int j = i - 1; j >= 0; j--) {
        //         int cost = nums[i] - nums[j];
        //         if (remainingK >= cost) {
        //             remainingK -= cost;
        //             frequency++;
        //         } else {
        //             break;
        //         }
        //     }
        //     maxFrequency = Math.max(maxFrequency, frequency);
        // }


        // Optimal Solution: Sliding window:

        int left = 0; // left Pointer
        long sum =0L; // It stores the total sum of the elements within the window(left - right).

        for(int right = 0; right < n; right++){// i is the another pointer which will points to each elements individually;

            sum += nums[right];

            // if the required number to make all the number witihn window as same as the number at right pointer is larger than the given k(extran number) itself then remove the leftmost element and move the left pointer to next element until the sum(required Extra Number) comes within the range of k.
            while( (long)(right - left + 1)*nums[right] - sum > k){
                sum -= nums[left];
                left++;
            }

            maxFrequency = Math.max(maxFrequency, right - left + 1);
        }


        return maxFrequency;
    }
}