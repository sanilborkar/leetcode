/**
 * Problem   : https://leetcode.com/problems/task-scheduler/
 * Submission: https://leetcode.com/submissions/detail/125716169/
 */

class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) return 0;
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (char t : tasks) {
            if (map.containsKey(t))
                map.put(t, map.get(t) + 1);
            else
                map.put(t, 1);
        }
        
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(26, Collections.reverseOrder());
        for (int freq : map.values())
            q.add(freq);
        
        int time = 0;
        while (!q.isEmpty()) {
            int i = 0;
            ArrayList<Integer> temp = new ArrayList<Integer>();
            
            while (i <= n) {
                if (!q.isEmpty()) {
                    int first = q.poll();
                    if (first > 1)
                        temp.add(first - 1);   
                }

                time++;
                
                if (q.isEmpty() && temp.size() == 0)
                    break;
                i++;
            }
            
            for (int t : temp)
                q.add(t);
        }
        
        return time;
    }
}
