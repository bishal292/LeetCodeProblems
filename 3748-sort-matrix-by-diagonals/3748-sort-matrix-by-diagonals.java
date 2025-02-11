class Solution {
    // public int[][] sortMatrix(int[][] grid) {
    //     //Store diagonals of matrix in hashmap
    //     HashMap<Integer, List<Integer>> diagonals = new HashMap<>();
    //     int n = grid.length;
    //     for(int i=0; i < n; i++){
    //        for(int j=0; j < n; j++){
    //          int key = i-j;
    //          diagonals.putIfAbsent(key, new ArrayList<>());
    //          diagonals.get(key).add(grid[i][j]);
    //        }
    //     }
    //     //Sort each stored list in hashmap O(n * nlogn) or O(n^2 logn)
    //     for(int it: diagonals.keySet()){ //O(n)
    //           Collections.sort(diagonals.get(it), (list1, list2) -> { //O(n logn)
    //             if(it < 0) //sort in non decreasing order
    //               return list1 - list2;
    //             else  
    //               return list2 - list1; //sort in non increasing order
    //           });
    //     }
    //     //Place sorted values back in the matrix
    //     for(int i=0; i < n; i++){
    //        for(int j=0; j < n; j++){
    //          int key = i-j;
    //          grid[i][j] = key < 0 ? diagonals.get(key).get(i) : diagonals.get(key).get(j);
    //        }
    //     }
    //     return grid;
    // }

    public int[][] sortMatrix(int[][] a) {
        int n = a[0].length;
        for (int i=0; i<n; i++)
            for (int j=0; i+j<n; j++)
                for (int k=j+1; i+k<n; k++)
                    if (a[i+j][j] < a[i+k][k]) {
                        int t = a[i+k][k];
                        a[i+k][k] = a[i+j][j];
                        a[i+j][j] = t;
                    }
        for (int i=1; i<n; i++)
            for (int j=0; i+j<n; j++)
                for (int k=j+1; i+k<n; k++)
                    if (a[j][i+j] > a[k][i+k]) {
                        int t = a[k][i+k];
                        a[k][i+k] = a[j][i+j];
                        a[j][i+j] = t;
                    }
        return a;
    }
}