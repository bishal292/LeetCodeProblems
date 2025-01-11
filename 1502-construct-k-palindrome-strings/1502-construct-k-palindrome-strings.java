class Solution {
    public boolean canConstruct(String s, int k) {
        if(k > s.length()) return false;

        int[] charCount = new int[26];

        for(int i = 0;i<s.length();i++){
            charCount[s.charAt(i) - 'a']++;
        }
        int evenCount= 0;
        int oddCount = 0;
        for(int i =0;i<26;i++){
            if(charCount[i] == 0){
                continue;
            }
            else if(charCount[i] % 2 == 0){
                evenCount++;
            }else{
                oddCount++;
            }
        }
        if(oddCount > k)return false;
        return true;
    }
}