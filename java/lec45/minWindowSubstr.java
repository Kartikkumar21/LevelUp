// leetcode 76
class Solution {
    public String minWindow(String s, String t) {
    int ns = s.length();
    int nt = t.length();
    
    int[] freq = new int[128];
    for(int i=0;i<nt;i++) freq[t.charAt(i)]++;
    
    int requirement = nt, si = 0,ei = 0, len = (int)1e8;
    int head = 0;
    
    while(ei < ns){
        if(freq[s.charAt(ei++)]-- > 0) requirement--;
        
        while(requirement == 0){
            if(ei - si < len) len = ei - (head = si);
            
            if(freq[s.charAt(si++)]++ == 0) requirement++;
        }
    }
    
    return len == (int)1e8 ? "" : s.substring(head, head + len); 
}
}