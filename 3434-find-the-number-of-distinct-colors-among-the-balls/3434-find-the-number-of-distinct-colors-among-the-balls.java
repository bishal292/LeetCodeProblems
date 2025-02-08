// class Solution {
//     public int[] queryResults(int limit, int[][] queries) {
//         int n =  queries.length;
//         int[] ans = new int[n];
//         HashMap<Integer,Integer> ballCol = new HashMap<>();
//         HashMap<Integer,Integer> colCount = new HashMap<>();

//         for(int i = 0;i<n;i++){
//             int ball = queries[i][0];
//             int col = queries[i][1];

//             if(!ballCol.containsKey(ball)){
//                 ballCol.put(ball,col);
//             }else{
//                 int prevCol = ballCol.get(ball);
//                 if(colCount.get(prevCol) == 1){
//                     colCount.remove(prevCol);
//                 }else{
//                     colCount.put(prevCol,colCount.getOrDefault(prevCol,0) - 1);
//                 }
//                 ballCol.put(ball,col);
//             }
//             colCount.put(col,colCount.getOrDefault(col,0)+1);
//             ans[i] = colCount.size();
//         }
//         return ans;
//     }
// }



class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer,Integer> node = new HashMap<>();
        Map<Integer,Integer> color = new HashMap<>();
        int ans[]=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int it[]=queries[i];
            if(node.containsKey(it[0])){
                if(node.get(it[0])==it[1]) {
                    ans[i]=color.size();continue;
                }
                else if (color.get(node.get(it[0]))<=1) color.remove(node.get(it[0]));
                else
                color.put(node.get(it[0]),color.get(node.get(it[0]))-1);
                node.put(it[0],it[1]);
                color.put(it[1],color.getOrDefault(it[1],0)+1);
            }
            else{
                node.put(it[0],it[1]);
                color.put(it[1],color.getOrDefault(it[1],0)+1);
            }
            ans[i]=color.size();
        }
        return ans;
    }
}