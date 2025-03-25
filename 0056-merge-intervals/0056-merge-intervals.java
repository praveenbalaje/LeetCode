class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]); // Sort by end time
            }
            return Integer.compare(a[0], b[0]); // If end times are equal, sort by start time
        });

        int[][] res = new int[intervals.length][2];
        int count = 0;
        res[count][0] = intervals[0][0];
        res[count][1] = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= res[count][1]) {
                if(intervals[i][1] > res[count][1]) {
                res[count][1] = intervals[i][1];
                }
            } else {
                count += 1;
                res[count][0] = intervals[i][0];
                res[count][1] = intervals[i][1];
            }
        }

        int ans[][] = new int[count + 1][2];
        for (int i = 0; i <= count; i++) {
            ans[i][0] = res[i][0];
            ans[i][1] = res[i][1];
        }

        return ans;
    }
}