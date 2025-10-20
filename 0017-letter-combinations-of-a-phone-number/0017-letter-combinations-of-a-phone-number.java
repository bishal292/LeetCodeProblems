class Solution {
    final String [] alpha = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits == null || digits.isEmpty())return ans;
        // helper("",digits,ans);
        helper(new StringBuilder(),digits,ans);
        return ans;
    }

    void helper(StringBuilder p,String up,List<String> list){
        if(up.isEmpty()){
            list.add(p.toString());
            p = new StringBuilder();
            return;
        }
        int idx = (int)up.charAt(0) - '2';
        for(char ch : alpha[idx].toCharArray()){
            helper(p.append(ch),up.substring(1),list);
            p.deleteCharAt(p.length() - 1);
        }
    }
// Method using String as 1 Args which is inefficients as require frequent writing operation.
    void helper(String p,String up,List<String> list){
        if(up.isEmpty()){
            list.add(p);
            return;
        }
        int idx = (int)up.charAt(0) - '2';
        for(char ch : alpha[idx].toCharArray()){
            helper(p+ch,up.substring(1),list);
        }
    }
}