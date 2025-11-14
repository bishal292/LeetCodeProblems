class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 == 1)return false;// odd length means 1 bracket is extra means not closed.
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        for(int i = 0;i<n;i++){
            char c = s.charAt(i);
            if(i<n-1 && checkBrac(c,s.charAt(i+1))){
                i++; // if bracket is opened and closed at the same time.
            }else{
                if(!stack.isEmpty() && checkBrac(stack.peek(),c)){
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }
        }

        return stack.isEmpty();
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