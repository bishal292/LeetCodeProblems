class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        long aliceTotal = 0l;
        long bobTotal = 0l;
        HashSet<Integer> set = new HashSet<>();

        for(int candy : aliceSizes){
            aliceTotal += candy;
            set.add(candy);
        }
        for(int candy : bobSizes){
            bobTotal += candy;
        }
        int diff = (int) (aliceTotal - bobTotal) / 2;
        for(int candy : bobSizes){
            if(set.contains(candy + diff))
                return new int[]{candy+diff,candy};
        }
        return new int[]{-1,-1};
    }
}