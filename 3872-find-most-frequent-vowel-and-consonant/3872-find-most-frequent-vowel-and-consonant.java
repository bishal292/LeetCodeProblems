class Solution {
    public int maxFreqSum(String s) {
        String vs = "aeiou";
        int[] vowels = new int[26];
        int[] cons = new int[26];
        for(char ch : s.toCharArray()){
            if(vs.indexOf(ch) != -1){
                vowels[ch - 'a']++;
            }else{
                cons[ch -'a']++;
            }
        }
        int mvf = 0;
        int mcf = 0;
        for(char ch:vs.toCharArray()){
            mvf = Math.max(mvf,vowels[ch - 'a']);
        }
        for(int i = 0;i<26;i++){
            mcf = Math.max(mcf,cons[i]);
        }
        return mvf+mcf;
    }
}