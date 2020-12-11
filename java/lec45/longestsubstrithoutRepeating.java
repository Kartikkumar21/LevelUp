// leetcode 3
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()<=1){
            return s.length();
        }
        int n=s.length(), si=0,ei=0,count=0,len=0;
        int Maxsi=0,Maxei=0;
        int[] map=new int[128];
        
        while(ei<n){
            if(map[s.charAt(ei++)]++>0) count++;
            
            while(count>0){
                if(map[s.charAt(si++)]-- > 1) count--;
            }
            //len=max(len,ei-si);
            if(ei-si>len){
                len=ei-si;
                Maxei=ei;
                Maxsi=si;
            }
        }
        return len;
    }
}