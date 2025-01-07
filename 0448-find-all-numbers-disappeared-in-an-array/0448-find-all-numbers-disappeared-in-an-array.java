class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();

        boolean lastElem = false;

        int i = 0;
        while (i < nums.length) {
            int elem = nums[i];
            int correctIdx = elem - 1;

            if (elem == nums.length)
                lastElem = true;

            if (elem <= nums.length && elem != nums[correctIdx]) {
                swap(nums, i, correctIdx);
            } else
                i++;

        }

        for (i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i) {
                ans.add(i + 1);
            }
        }

        return ans;

    }

    void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}