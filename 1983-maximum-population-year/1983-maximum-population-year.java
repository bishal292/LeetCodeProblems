class Solution {
    public int maximumPopulation(int[][] logs) {

        int[] pop = new int[101];

        for(int[] log:logs){
            int birth = log[0];
            int death = log[1];
            
            // while(birth<death){
            //     pop[birth-1950] += 1;
            //     birth++;
            // }

            // Optimized Version compared to above while -> loop;

            pop[birth-1950] += 1;
            pop[death-1950] -=1;
        }

        int curYear = 0, maxPop=0;
        int curPop =0;
        for(int i=0;i<101;i++){
            // if(maxPop < pop[i] && curYear < i+1950 ){
            //     curYear = i+1950;
            //     maxPop = pop[i];
            // }

            //  Conditions Check according to the above change 
            curPop += pop[i];
            if(maxPop < curPop && curYear < i + 1950){
                maxPop = curPop;
                curYear = i + 1950;
            }
        }

        return curYear;
    }
}