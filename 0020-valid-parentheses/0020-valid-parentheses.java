class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if(n % 2 == 1)return false;// odd length means 1 bracket is extra means not closed.
        // Stack<Character> stack = new Stack<>();
        char[] stack = new char[n];
        int top = 0;
        
        // for(int i = 0;i<n;i++){
        //     char c = s.charAt(i);
        //     if(i<n-1 && checkBrac(c,s.charAt(i+1))){
        //         i++; // if bracket is opened and closed at the same time.
        //     }else{
        //         if(!stack.isEmpty() && checkBrac(stack.peek(),c)){
        //             stack.pop();
        //         }else{
        //             stack.push(c);
        //         }
        //     }
        // }

        for(int i = 0; i< n;i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                stack[top++] = c;
            }else{
                if(top <= 0)return false;
                char p = stack[top -1];
                if(!checkBrac(p,c)){
                    return false;
                }
                top--;
            }
        }

        // return stack.isEmpty();
        return top == 0;
    }

    public boolean checkBrac(char c,char n){
            if(c == '(' && n == ')'){
                return true;
            }
            if(c == '{' && n == '}'){
                return true;
            }
            if(c == '[' && n == ']'){
                return true;
            }
            return false;
    }
}