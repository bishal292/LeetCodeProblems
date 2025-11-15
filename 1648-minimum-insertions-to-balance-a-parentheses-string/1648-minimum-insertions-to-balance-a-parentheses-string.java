class Solution {
    public int minInsertions(String s) {
//         int ans = 0;
//         Stack<Character> stack = new Stack<>();
//         for (int i = 0; i < s.length(); i++) {
//             char c = s.charAt(i);
//             if (c == '(') { // simply add the opening brackets.
//                 stack.push(c);
//             } else {
//                 if(i + 1 < s.length() && s.charAt(i+1) == ')'){ // if 2 consicutive '))' simply skips the next char without increment.
//                     i++;
//                 }else{ // if there is only 1 ')' the ans must be increased by 1 for the remaining ')'
//                     ans++;
//                 }

//  // if current char is ')' then it must be closed either for a single or double '))'  
// //  As for single ')' the ans is already handled above the in this only the ans should be handled for '(' in the stack.
//                 if(stack.isEmpty()){
//                     ans++;
//                 }else{
//                     stack.pop();
//                 }
//             }
//         }
//         return ans + (stack.size() * 2);




// OPTIMAL SOLUTION:

        int ans = 0;
        int open = 0;
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '('){
                open++;
            }else{
                if(i+1 <s.length() && s.charAt(i+1) == ')'){
                    i++;
                }else{
                    ans++;
                }
                if(open > 0){
                    open--;
                }else{
                    ans++;
                }
            }
        }
        return open == 0 ? ans : ans + (open * 2);
    }
}