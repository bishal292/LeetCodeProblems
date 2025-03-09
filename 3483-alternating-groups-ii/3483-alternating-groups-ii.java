class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int len = colors.length;
        int ans = 0;
        int prev = colors[0];
        int left = 0;
        for(int right = 0;right<len + k -1;right++){
            int current = colors[right % len];
            if(prev == current){
                left = right;
            }else{
                prev = current;
                if(right - left + 1 == k){
                    ans++;
                    left++;
                }
            }
        }
        return ans;
    }
}