class Solution {
    public long pickGifts(int[] gifts, int k) {
        long giftPicked=0l;
        for(int i=0;i<k;i++){
            int idx =0;
            for(int j=0;j<gifts.length;j++){
                if(gifts[j]>gifts[idx]){
                    idx = j;
                }
            }
            gifts[idx] = (int) Math.sqrt(gifts[idx]);
        }
        for(int gift:gifts){
            giftPicked += gift;
        }
        return giftPicked;
    }
}