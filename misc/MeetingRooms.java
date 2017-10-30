/**
 * Problem   : https://leetcode.com/problems/meeting-rooms/
 * Submission: https://leetcode.com/submissions/detail/125673529/
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
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return true;
        
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        
        // Stack<Interval> st = new Stack<Interval>();
        // st.push(intervals.get(0));
        
        for (int i = 1; i < intervals.length; i++) {
            Interval first = intervals[i-1];
            Interval second = intervals[i];
            
            if (second.start >= first.start && second.start < first.end)
                return false;
        }
        
        return true;
    }
}
