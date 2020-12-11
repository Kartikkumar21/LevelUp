 // Leetcode 1143
    public int longestCommonSubsequence(String s1, String s2,int n,int m,int[][] dp) {
        if(n==0 || m == 0) return 0;
        if(dp[n][m]!=-1) return dp[n][m];
        
        if(s1.charAt(n-1) == s2.charAt(m-1)) dp[n][m] = longestCommonSubsequence(s1,s2,n-1,m-1,dp) + 1;
        else dp[n][m] = Math.max(longestCommonSubsequence(s1,s2,n,m-1,dp),longestCommonSubsequence(s1,s2,n-1,m,dp));
        
        return dp[n][m];
    }

    public int longestCommonSubsequenceDP(String s1, String s2,int N,int M,int[][] dp) {
        for(int n=0;n<=N;n++){
            for(int m =0;m<=M;m++){
                if(n==0 || m == 0){
                    dp[n][m] = 0;
                    continue;
                }

                if(s1.charAt(n-1) == s2.charAt(m-1)) dp[n][m] = dp[n-1][m-1] + 1;
                else dp[n][m] = Math.max(dp[n][m-1],dp[n-1][m]);
            }
        }

        return dp[N][M];
    }
    
    public int longestCommonSubsequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        
        int[][] dp = new int[n+1][m+1];
        // for(int[] d : dp) Arrays.fill(d,-1);
        
        return longestCommonSubsequenceDP(s1,s2,n,m,dp);
    }