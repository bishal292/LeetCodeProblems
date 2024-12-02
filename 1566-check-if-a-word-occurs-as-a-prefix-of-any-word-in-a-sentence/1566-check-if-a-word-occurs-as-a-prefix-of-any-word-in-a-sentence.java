class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int index=-1;
        String[] strArr = sentence.split(" ");

        int left=0,right=strArr.length-1;
        while(left<=right){
            if(strArr[left].startsWith(searchWord)){
                return left+1;
            }else if(strArr[right].startsWith(searchWord)){
                index = (index==-1 || index>right)?right+1:index;
            }
            left++;
            right--;
        }
        return index;
    }
}