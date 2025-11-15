class Solution {
    public int minInsertions(String s) {
        int ans = 0;
        Stack<Character> stack = new Stack<>();
        boolean mustOpen = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else {
                if(i + 1 < s.length() && s.charAt(i+1) == ')'){
                    i++;
                }else{
                    ans++;
                }

                if(stack.isEmpty()){
                    ans++;
                }else{
                    stack.pop();
                }
            }
        }
        return ans + (stack.size() * 2);
    }
}