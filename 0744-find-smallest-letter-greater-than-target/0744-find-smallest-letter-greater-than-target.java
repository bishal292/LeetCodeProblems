class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        if(target == 'z'|| letters[letters.length - 1] <= target)return letters[0];
        char ch = 'z';
        for(char c : letters){
            if(c > target){
                ch = c;
                break;
            }
        }
        return ch;
    }
}