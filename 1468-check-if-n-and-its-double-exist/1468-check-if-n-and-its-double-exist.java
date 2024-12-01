class Solution {
    public boolean checkIfExist(int[] arr) {
        // for(int i=0;i<arr.length;i++){
        //     for(int j=0;j<arr.length;j++){
        //         if(i==j)continue;
        //         if(arr[i]==(2*arr[j])){
        //             return true;
        //         }
        //     }
        // }
        // return false;


        // Optimized way 


        Set<Integer> seen = new HashSet<>();
        for (int num : arr) {
            if (seen.contains(2 * num) || (num % 2 == 0 && seen.contains(num / 2))) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }
}