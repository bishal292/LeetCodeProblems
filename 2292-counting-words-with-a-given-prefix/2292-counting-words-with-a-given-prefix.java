class Solution {
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        int n = pref.length();

        for(String word : words){
            // if(word.startsWith(pref)) count++;
            if(word.length() >= n){
                boolean isPrefix = true;
                for(int i = 0;i<n;i++){
                    if(word.charAt(i) != pref.charAt(i)){
                        isPrefix = false;
                        break;
                    }
                }
                if(isPrefix)count++;
            }
        }
        return count;
    }
}