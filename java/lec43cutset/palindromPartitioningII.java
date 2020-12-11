// leetcode 132
 public int minCut(String str,int si,int[] dp,boolean[][] isPalindrome){
    if(si == str.length() || isPalindrome[si][str.length() - 1]){
        return dp[si] = 0;
    }
    
    if(dp[si] != -1) return dp[si];
    
    int ans  = (int)1e8;
    for(int cut = si;cut < str.length();cut++){
        if(isPalindrome[si][cut]){
            int MinCutCount =  minCut(str,cut+1,dp,isPalindrome);
            ans = Math.min(ans,MinCutCount + 1);
        }
    }
    
    return dp[si] = ans;
}


public int minCut(String str) {
    if(str.length() <= 1) return 0;
    int n = str.length();
    
    boolean[][] isPalindrome = new boolean[n][n];
    for(int gap = 0;gap<n;gap++){
        for(int i = 0,j = gap;j < n;i++,j++){
            if(gap == 0) isPalindrome[i][j] = true;
            else if(gap == 1) isPalindrome[i][j] = str.charAt(i) == str.charAt(j);
            else isPalindrome[i][j] = isPalindrome[i +1 ][j - 1] && (str.charAt(i) == str.charAt(j));
        }
    }
    
    int[] dp = new int[n + 1];
    Arrays.fill(dp,-1);
    return minCut(str,0,dp,isPalindrome);
}