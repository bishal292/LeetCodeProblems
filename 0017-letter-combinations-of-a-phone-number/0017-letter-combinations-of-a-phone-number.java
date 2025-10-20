class Solution {
    // char[][] alpha = { { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
    //         { 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };
    String [] alpha = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        
        // char[] chArr = digits.toCharArray();
        // int[] arr = new int[chArr.length];
        // for(int i = 0;i<chArr.length){
        //     arr[i] = chArr[i] - 2;
        // }
        // for(int i:arr){
        //     for(char ch : alpha[i]){

        //     }
        // }
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