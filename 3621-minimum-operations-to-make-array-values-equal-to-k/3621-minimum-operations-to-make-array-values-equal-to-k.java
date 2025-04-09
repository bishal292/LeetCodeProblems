class Solution {
    public int minOperations(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums){
            if(num < k)return -1;
            if(num > k)set.add(num);
        }
        // int lar = -1;
        // int secLar= -1;
        // for(int i = 100;i>0;i++){
        //     if(arr[num]==0)continue;
        //     if(lar != -1 && secLar != -1)break;
        //     secLar = lar;

        // }
        return set.size();
    }
}