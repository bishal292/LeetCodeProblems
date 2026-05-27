class Solution {
    public int numberOfSpecialChars(String word) {
        int ans = 0;

        int[] lc = new int[26];
        int[] uc = new int[26];

        Arrays.fill(lc,-1);
        Arrays.fill(uc,-1);

        for(int i = 0;i<word.length();i++){
            char c = word.charAt(i);
            if(Character.isLowerCase(c)){
                lc[c-97] = i;
            }else if(uc[c-65] == -1){
                uc[c-65] = i;
            }
        }
        for(int i = 0;i<26;i++){
            if(lc[i] != -1 && lc[i] < uc[i])ans++;
        }
        return ans;
    }
}