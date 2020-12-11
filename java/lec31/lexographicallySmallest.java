// leetcode 1061
// 1061
    int[] par;
    int findPar(int u ){
        if(par[u] == u) return u;
        return par[u] = findPar(par[u]);
    }
    
    public String smallestEquivalentString(String A, String B, String S) {
        
        par = new int[26];
        for(int i=0;i<26;i++) par[i] = i;
        
        for(int i=0;i<A.length();i++){
            int p1 = findPar(A.charAt(i) - 'a');
             int p2 = findPar(B.charAt(i) - 'a');
            
            par[p1] = Math.min(p1,p2);
            par[p2] = Math.min(p1,p2);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<S.length();i++)
        {
            int p = findPar(S.charAt(i) - 'a');
            sb.append((char)(p + 'a'));
        }
        
        return sb.toString();
        
    }