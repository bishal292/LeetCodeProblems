class Solution {
    public int minAddToMakeValid(String s) {
        // int count = 0;
        // Stack<Character> stack = new Stack<>();
        // for(char c:s.toCharArray()){
        //     if(c == '('){
        //         stack.push(c);
        //     }else{
        //         if(!stack.isEmpty() && stack.peek() == '('){
        //             stack.pop();
        //         }else{
        //             count++;
        //         }
        //     }
        // }
        // return stack.isEmpty() ? count : count+stack.size();


        int mustClose = 0; // brackets which are opened to be closed.
        int mustOpen = 0; // Brackets which are closed was required to be opened first.

        for(char c : s.toCharArray()){
            if(c == '('){
                mustClose++;
            }else if(mustClose == 0){
                mustOpen++;
            }else{
                mustClose--;
            }
        }
        return mustOpen + mustClose;
    }
}