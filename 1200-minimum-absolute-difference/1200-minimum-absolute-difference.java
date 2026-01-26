class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        HashMap<Integer,List<List<Integer>>> map = new HashMap<>();
        Arrays.sort(arr);
        int minD = Integer.MAX_VALUE;
        for(int i = 0;i<arr.length - 1;i++){
            // int dif = Math.abs(arr[i+1]) - Math.abs(arr[i]);
            int dif = arr[i+1] - arr[i];
            minD = Math.min(minD,dif);
            List<List<Integer>> out = map.getOrDefault(dif,new ArrayList<>());
            List<Integer> pair = new ArrayList<>();
            pair.add(arr[i]);
            pair.add(arr[i+1]);
            out.add(pair);
            map.put(dif,out);
        }
        return map.get(minD);
    }
}