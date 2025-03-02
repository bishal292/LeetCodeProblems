class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int m = nums1.length, n = nums2.length , ptr1 = 0, ptr2 = 0;
        List<int[]> res = new ArrayList<>();

        while (ptr1 < m && ptr2 < n) {

            if (nums1[ptr1][0] == nums2[ptr2][0]) {
                res.add(new int[] { nums1[ptr1][0], nums1[ptr1][1] + nums2[ptr2][1] });
                ptr1++;
                ptr2++;
            } else if (nums1[ptr1][0] < nums2[ptr2][0]) {
                res.add(nums1[ptr1++]);
            } else {
                res.add(nums2[ptr2++]);
            }

        }
        while (ptr1 < m) {
            res.add(nums1[ptr1++]);
        }
        while (ptr2 < n) {
            res.add(nums2[ptr2++]);
        }
        return res.toArray(new int[res.size()][2]);
    }
}