class Solution {
    String [] alpha = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        helper("",digits,ans);
        return ans;
    }

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