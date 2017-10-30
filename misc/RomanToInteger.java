/**
 * Problem   : https://leetcode.com/problems/roman-to-integer/
 * Submission: https://leetcode.com/submissions/detail/125208791/
 */

class Solution {
    int value(char c) {
        switch(c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return -1;
        }
    }
    
    public int romanToInt(String s) {
        char[] arr = s.toCharArray();
        int num = 0;
        
        for (int i = 0; i < arr.length; i++) {
            
            int v = value(arr[i]);
            if (i + 1 < arr.length) {
                int next = value(arr[i + 1]);
                
                if (v >= next)
                    num += v;
                else {
                    num += next - v;
                    i++;
                }
            } else
                num += v;
        }
        
        return num;
    }
}
