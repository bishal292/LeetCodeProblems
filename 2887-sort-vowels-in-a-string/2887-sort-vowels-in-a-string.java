class Solution {
    public String sortVowels(String s) {
        int[] upper = new int[26];
        int[] lower = new int[26];

        for(char ch : s.toCharArray()){
            if(ch =='a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                lower[ch -'a']++;
            }
            if(ch =='A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'){
                upper[ch - 'A']++;
            }
        }
        StringBuilder sb = new StringBuilder();

        for(int i = 0;i<26;i++){
            while(upper[i] > 0){
                sb.append((char)(i + 'A'));
                upper[i]--;
            }
        }
        for(int i = 0;i<26;i++){
            while(lower[i] > 0){
                sb.append((char)(i + 'a'));
                lower[i]--;
            }
        }

        StringBuilder ans = new StringBuilder();
        int i = 0;
        for(char ch : s.toCharArray()){
            if(ch =='a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch =='A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'){
                ans.append(sb.charAt(i++));
            }else{
                ans.append(ch);
            }
        }
        
        return ans.toString();
    }
}