// https://www.geeksforgeeks.org/smallest-window-contains-characters-string/hars
public int minWindow(String s) {
    int n = s.length();
    
    int[] freq = new int[128];
    for(int i=0;i<nt;i++) freq[s.charAt(i)] = 1;

    int requirement = 0, si = 0, ei = 0,head = 0, len = (int)1e8;
    for(int ele : freq) requirement += ele;

    while(ei < n){
        if(freq[s.charAt(ei++)]-- > 0) requirement--;

        while(requirement == 0){
            len = (ei - si <= len) ? ei - (head = si) : len;

            if(freq[s.charAt(si++)]++ == 0) requirement++;
        }
    }

    return len;
}
