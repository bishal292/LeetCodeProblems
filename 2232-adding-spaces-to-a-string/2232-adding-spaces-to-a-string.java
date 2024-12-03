class Solution {
    public String addSpaces(String s, int[] spaces) {

        int m = spaces.length;
        int n = s.length();

        // Crossed Time limit as insert operation takes more time and always heavy to
        // work with the frequent changing string due to it's immutable nature.

        // StringBuilder sb = new StringBuilder(s);
        // for(int i=m-1;i>=0;i--){
        // sb.insert(spaces[i]," ");
        // }
        // return sb.toString();

        // Optimized way to solve the problem.

        // char[] ch = new char[n+m];

        // for(int i=0,j=0;i<n;i++){
        // if(j<m && i+j==spaces[j]+j){
        // ch[i+j]=' ';
        // j++;
        // }
        // ch[i+j] = s.charAt(i);
        // }
        // return new String(ch);

        // More Optimized Way to solve the same problem.

        char[] newChrs = new char[n + m];
        char[] sChr = s.toCharArray();

        int i = 0;
        int idx = 0;
        for (int spc : spaces) {
            while (i < spc) {
                newChrs[idx++] = sChr[i++];//Adding all the characters in the array before the space insertion.
            }
            newChrs[idx++] = ' ';
        }

        while (i < n) {
            newChrs[idx++] = sChr[i++];
        }

        return new String(newChrs);
    }
}