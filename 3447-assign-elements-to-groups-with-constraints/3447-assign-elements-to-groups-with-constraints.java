class Solution {
    public int[] assignElements(int[] groups, int[] elements) {
        int n = groups.length;
        int m = elements.length;
        int[] assigned = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < m; i++) {
            int num = elements[i];
            if (!map.containsKey(num))
                map.put(num, i);
        }

        // Arrays.fill(assigned,-1);
        for (int i = 0; i < n; i++) {
            int num = groups[i];
            ArrayList<Integer> factors = getFactors(num);
            assigned[i] = -1;
            for (int fac : factors) {
                if (map.containsKey(fac)) {
                    int idx = map.get(fac);
                    if (assigned[i] == -1) {
                        assigned[i] = idx;
                    } else {
                        assigned[i] = assigned[i] < idx ? assigned[i] : idx;
                    }
                }
            }
        }
        return assigned;
    }

    public ArrayList<Integer> getFactors(int num) {
        ArrayList<Integer> factors = new ArrayList<>();
        factors.add(1);
        factors.add(num);
        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) {
                factors.add(i);
                if (i * i != num)
                    factors.add(num / i);
            }
        }
        return factors;
    }
}