class Solution {
    public boolean checkIfPangram(String sentence) {

        // // Simple Solution by using Set to store the characters from the sentence and
        // returning true if length of set is 26 else false.
        // Set hs = new HashSet<>();
        // for(char ch: sentence.toCharArray()){
        // hs.add(ch);
        // }
        // return hs.size()==26?true:false;

        // Optimized Solution using BitMasking:

        // int n = sentence.length();
        // int seen = 0;

        // for (int i = 0; i < n; i++) {
        //     int index = sentence.charAt(i) - 'a';
        //     int currentBit = 1 << index;
        //     seen = seen | currentBit;
        // }
        // // if all the letters are present then seen = 1....(26times)
        // // seen+1 = 1000(0 should be present 26 times) ---> 1<<26
        // if ((1 << 26) - 1 == seen)
        //     return true;
        // return false;


        // Another Optimized Solution:

        char[] alphabets = {'a', 'b', 'c', 'd', 'e',
        'f', 'g', 'h', 'i', 'j', 'k',
        'l', 'm', 'n', 'o', 'p',
        'q', 'r', 's', 't', 'u',
        'v', 'w', 'x', 'y', 'z'};

        for(char c: alphabets){
            if(!sentence.contains(String.valueOf(c)))
                return false;
        }

        return true;
    }
}