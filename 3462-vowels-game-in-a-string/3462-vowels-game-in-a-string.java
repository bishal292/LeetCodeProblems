class Solution {
    public boolean doesAliceWin(String s) {
        // int count = 0;
        // for(char ch:s.toCharArray()){
        //     if("aeiou".indexOf(ch) != -1){
        //         count++;
        //     }
        // }
        // if(count == 0){
        //     return false;
        // }
        // return true;

        for(char ch: s.toCharArray()){
            if("aeiou".indexOf(ch) != -1)return true;
        }
        return false;
    }
}