class Solution {
    public boolean checkIfPangram(String sentence) {
        Set hs = new HashSet<>();
        for(char ch: sentence.toCharArray()){
            hs.add(ch);
        }
        return hs.size()==26?true:false;
    }
}