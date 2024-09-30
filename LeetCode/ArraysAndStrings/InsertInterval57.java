/*
57. Insert Interval

Problema:
Se quiere insertar un arreglo de intervalos a otro, 

Solucion:

chatgpt reveer
*/


class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
         List<int[]> mergedIntervals = new ArrayList<>();
        int i = 0;

        // Step 1: Add all intervals that end before newInterval starts
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            mergedIntervals.add(intervals[i]);
            i++;
        }

        // Step 2: Merge overlapping intervals with newInterval
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        mergedIntervals.add(newInterval); // Add the merged interval

        // Step 3: Add all remaining intervals
        while (i < intervals.length) {
            mergedIntervals.add(intervals[i]);
            i++;
        }

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
