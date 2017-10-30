/**
 * Problem   : https://leetcode.com/problems/implement-magic-dictionary/
 * Submission: https://leetcode.com/submissions/detail/123826027/
 */

class MagicDictionary {
    HashMap<Integer, ArrayList<String>> dict;
    
    /** Initialize your data structure here. */
    public MagicDictionary() {
        dict = new HashMap<Integer, ArrayList<String>>();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        int len;
        for (String s : dict) {
            len = s.length();
            ArrayList<String> arr;
            
            if (this.dict.containsKey(len)) {
                arr = this.dict.get(len);
            } else {
                arr = new ArrayList<String>();
            }
            
            arr.add(s);
            this.dict.put(len, arr);
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        char[] w = word.toCharArray();
        
        ArrayList<String> arr = dict.getOrDefault(word.length(), new ArrayList<String>());
        if (arr.size() == 0)
            return false;
        
        for (String s : arr) {
            // if (!s.startsWith(word) && !s.endsWith(word)) {
            //     continue;
            // }
            
            char[] c_arr = s.toCharArray();
            int i = 0;
            boolean diff = false;
            
            for (char c : c_arr) {                
                if (c != w[i]) {
                    if (!diff)
                        diff = true;
                    else
                        break;
                }

                i++;
            }
            
            if (i == s.length() && diff)
                return true;
        }
        
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */
