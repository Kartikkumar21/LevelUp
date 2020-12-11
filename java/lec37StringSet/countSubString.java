//Leetcode 647
    public int countSubstrings(String s) {
        int n = str.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0; 
        for(int gap = 0;gap < n;gap++){
            for(int i=0,j=gap; j < n;i++,j++){
                if(gap == 0) dp[i][j] = true;
                else if(gap == 1) dp[i][j] = str.charAt(i) == str.charAt(j);
                else dp[i][j] = str.charAt(i) == str.charAt(j)  && dp[i+1][j-1];
            
                if(dp[i][j]) count++; 
            }
        }
        return count;
    }   