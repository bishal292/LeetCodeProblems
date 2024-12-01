class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        ArrayList<Boolean> result = new ArrayList<>();
        int maxCandy = Integer.MIN_VALUE;
        for(int candy:candies){
            if(candy>maxCandy)
                maxCandy= candy;
        }
        for(int candy:candies){
            if((candy+extraCandies)>=maxCandy){
                result.add(true);
            }else{
                result.add(false);
            }
        }
        return result;
    }
}