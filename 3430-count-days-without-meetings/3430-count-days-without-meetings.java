class Solution {
    // public int countDays(int days, int[][] meetings) {
    //     boolean[] busy = new boolean[days+1];
    //     for(int[]arr : meetings){
    //         markBusy(arr,busy);
    //     }
    //     int ans = 0;
    //     for(int i = 1;i<busy.length;i++){
    //         if(!busy[i])ans++;
    //     }
    //     return ans;
    // }
    // public void markBusy(int[] arr,boolean[] busy){
    //     for(int i = arr[0];i<=arr[1];i++){
    //         busy[i] = true;
    //     }
    // }

    public int countDays(int days, int[][] meetings) {
        List<int[]> events = new ArrayList<>();

        // Convert meetings into start (+1) and end (-1) events
        for (int[] meeting : meetings) {
            events.add(new int[]{meeting[0], 1});
            events.add(new int[]{meeting[1] + 1, -1});
        }

        // Sort events by day
        events.sort(Comparator.comparingInt(a -> a[0]));

        int availableDays = 0, activeMeetings = 0, prevDay = 1;

        for (int[] event : events) {
            int currDay = event[0], change = event[1];

            if (activeMeetings == 0) {
                availableDays += (currDay - prevDay);
            }

            activeMeetings += change;
            prevDay = currDay;
        }

        // Count free days after the last meeting
        if (activeMeetings == 0) {
            availableDays += (days - prevDay + 1);
        }

        return availableDays;
    }
}