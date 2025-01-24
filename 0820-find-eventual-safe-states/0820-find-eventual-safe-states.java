class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        int n = graph.length;

        // HashMap<Integer,Boolean> map = new HashMap<>();
        String[] map = new String[n];
        // Arrays.fill(map,"-1");

        for (int i = 0; i < n; i++) {
            if (dfs(i, graph, map)) {
                ans.add(i);
            }
        }
        return ans;
    }

    // private boolean dfs(int node,int[][] graph, HashMap<Integer,Boolean> map){
    // if(map.containsKey(node)){
    // return map.get(node);
    // }

    // map.put(node,false);
    // for(int neighbour : graph[node]){
    // if(!dfs(neighbour,graph,map))return false;
    // }
    // map.put(node,true);
    // return true;
    // }
    private boolean dfs(int node, int[][] graph, String[] map) {
        // if (map[node] != "-1") {
        if (map[node] != null) {
            if (map[node] == "true")
                return true;
            return false;
        }
        map[node] = "false";

        for (int neighbour : graph[node]) {
            if (!dfs(neighbour, graph, map))
                return false;
        }
        map[node] = "true";
        return true;
    }
}