class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        char ch = '0';
        int cnt = 0;
        for(int i = 0;i<s.length();i++){
            char cur = s.charAt(i);
            if(cur != ch){
                ch = cur;
                sb.append(cur);
                cnt = 1;
            }else if(cnt < 2){ // why 2? in the second iteration while inserting the character for second time the counter value would be still 1 as not incremented and so on.
                sb.append(cur);
                cnt++;
            }
        }
        return sb.toString();
    }
}