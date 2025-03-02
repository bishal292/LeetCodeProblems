class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int m = nums1.length, n = nums2.length;
        int maxId = nums1[m - 1][0] > nums2[n - 1][0] ? nums1[m - 1][0] : nums2[n - 1][0];
        List<int[]> res = new ArrayList<>();
        int ptr1 = 0, ptr2 = 0;

        // If continuous element is guranted to be present by including both array

        // for(int i = 0; i < maxId ; i++){
        // int sum = 0;
        // if(ptr1 < m && nums1[ptr1][0] == i+1){
        // sum += nums1[ptr1][1];
        // ptr1++;
        // }
        // if(ptr2 < n && nums2[ptr2][0] == i+1){
        // sum += nums2[ptr2][1];
        // ptr2++;
        // }
        // ans[i][0] = i+1;
        // ans[i][1] = sum;
        // }

        while (ptr1 < m && ptr2 < n) {
            int[] temp = new int[2];
            int id1 = nums1[ptr1][0];
            int id2 = nums2[ptr2][0];
            int val1 = nums1[ptr1][1];
            int val2 = nums2[ptr2][1];
            if (id1 == id2) {
                temp[0] = id1;
                temp[1] = val1 + val2;
                ptr1++;
                ptr2++;
                res.add(temp);
                continue;
            }
            if (id1 < id2) {
                temp[0] = id1;
                temp[1] = val1;
                ptr1++;
                res.add(temp);
                continue;
            }
            temp[0] = id2;
            temp[1] = val2;
            ptr2++;
            res.add(temp);
        }
        while(ptr1 < m){
            res.add(nums1[ptr1++]);
        }
        while(ptr2 < n){
            res.add(nums2[ptr2++]);
        }
        return res.toArray(new int[res.size()][2]);
    }
}