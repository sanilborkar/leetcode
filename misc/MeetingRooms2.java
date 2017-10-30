/**
 * Problem   : https://leetcode.com/problems/meeting-rooms-ii/
 * Submission: https://leetcode.com/submissions/detail/125727144/
 */

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        
        ArrayList<Integer> starts = new ArrayList<Integer>();
        ArrayList<Integer> ends = new ArrayList<Integer>();
        for (Interval I : intervals) {
            starts.add(I.start);
            ends.add(I.end);
        }
        
        Collections.sort(starts);
        Collections.sort(ends);
        
        int s_ind = 0, e_ind = 0, count = 0, max = 0;
        while (s_ind < starts.size() && e_ind < ends.size()) {
            if (starts.get(s_ind) < ends.get(e_ind)) {
                count++;
                s_ind++;
            } else {
                count--;
                e_ind++;
            }
            
            max = Math.max(max, count);
        }
        
        return max;
    }
}
