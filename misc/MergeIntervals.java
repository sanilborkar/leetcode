/**
 * Problem   : https://leetcode.com/problems/merge-intervals/
 * Submission: https://leetcode.com/submissions/detail/125661529/
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
    private void merge(Interval first, Interval second) {
        if (first == null || second == null) return;
        
        if (second.end > first.end)
            first.end = second.end;
    }
    
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) return intervals;
        
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        
        Stack<Interval> st = new Stack<Interval>();
        st.push(intervals.get(0));
        
        for (Interval I : intervals) {
            Interval top = st.peek();
            
            if (I. start >= top.start && I.start <= top.end) {
                top = st.pop();
                merge(top, I);
                st.push(top);
            } else
                st.push(I);
        }
        
        List<Interval> ans = new ArrayList<Interval>();
        while (!st.empty()) {
            ans.add(st.pop());
        }
        
        return ans;
    }
}
