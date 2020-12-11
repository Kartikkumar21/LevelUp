 // Leetcode 516
    
    public int longestPalindromeSubseq(String s,int i,int j,int[][] dp) {
        if( i > j || i == j) return dp[i][j] = (i == j) ? 1: 0;

        if(dp[i][j]!=0) return dp[i][j];

        if(s.charAt(i) == s.charAt(j)) dp[i][j] = longestPalindromeSubseq(s,i+1,j-1,dp) + 2;
        else dp[i][j] = Math.max(longestPalindromeSubseq(s,i+1,j,dp),longestPalindromeSubseq(s,i,j-1,dp));

        return dp[i][j];
    }

    
    public int longestPalindromeSubseqDP(String s,int I,int J,int[][] dp) {
        int n = s.length();
        String[][] sdp = new String[n][n];
        for(String[] d: sdp) Arrays.fill(d,"");

        for(int gap = 0;gap<n;gap++){
            for(int i=0,j=gap;j<n;i++,j++){
                
                if(i == j) {
                    dp[i][j] = (i == j) ? 1: 0;
                    sdp[i][j] = s.charAt(i) + "";
                    continue;
                }

                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2;
                    sdp[i][j] = s.charAt(i) + sdp[i+1][j-1] +s.charAt(i);
                }
                else{
                    if(dp[i+1][j] > dp[i][j-1]){
                        dp[i][j] = dp[i+1][j];
                        sdp[i][j] = sdp[i+1][j];
                    }else{
                        dp[i][j] = dp[i][j-1];
                        sdp[i][j] = sdp[i][j-1];
                    }
                }               
            }
        }

        return dp[I][J];
    }