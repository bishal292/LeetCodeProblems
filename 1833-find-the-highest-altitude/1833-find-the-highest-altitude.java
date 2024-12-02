class Solution {
    public int largestAltitude(int[] gain) {
        int larAlt = 0,curAlt=0;
        for(int alt:gain){
            curAlt+=alt;
            if(larAlt<curAlt)larAlt=curAlt;
        }
        return larAlt;
    }
}