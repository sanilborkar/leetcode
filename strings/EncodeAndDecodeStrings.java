/**
 * Problem   : https://leetcode.com/problems/encode-and-decode-strings/
 * Submission: https://leetcode.com/submissions/detail/125222121/
 */

public class Codec {

    private static final char END_OF_TEXT = 0x03;
    
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        
        for (String s : strs) {
            sb.append(s);
            sb.append(END_OF_TEXT);
        }
        
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        char[] arr = s.toCharArray();
        List<String> list = new ArrayList<String>();
        
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            if (arr[i] == END_OF_TEXT) {
                list.add(sb.toString());
                sb = new StringBuilder();
            } else {
                sb.append(arr[i]);
            }
            
            i++;
        }
        
        return list;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
