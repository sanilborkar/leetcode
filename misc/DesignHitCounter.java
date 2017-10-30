/**
 * Problem   : https://leetcode.com/problems/design-hit-counter/
 * Submission: https://leetcode.com/submissions/detail/125331449/
 */

class HitCounter {
    HashMap<Integer, Integer> index;
    
    /** Initialize your data structure here. */
    public HitCounter() {
        index = new HashMap<Integer, Integer>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        if (index.containsKey(timestamp))
            index.put(timestamp, index.get(timestamp) + 1);
        else
            index.put(timestamp, 1);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int start = timestamp - 300 + 1;
        int count = 0;
        
        for (int i = start; i <= timestamp; i++) {
            if (index.containsKey(i))
                count += index.get(i);
        }
        
        return count;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
