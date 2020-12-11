// https://practice.geeksforgeeks.org/problems/count-palindromic-subsequences/1
    public int countPS(String str,int i,int j,int[][] dp)
    {
        if(i >= j ){
            return dp[i][j] = (i == j)?1:0;
        }
        if(dp[i][j]!=0) return dp[i][j];
        
        int x = countPS(str,i+1,j-1,dp);
        int y = countPS(str,i,j-1,dp);
        int z = countPS(str,i+1,j,dp);
        
        if(str.charAt(i) == str.charAt(j)) dp[i][j] = (x + 1) + (y + z - x); //(y + z + 1);
        else dp[i][j] = (y + z - x);
        
        return dp[i][j];
    }
    
    public int countPS_DP(String str,int I,int J,int[][] dp)
    {
        for(int gap = 0;gap < str.length();gap++){
            for(int i =0,j = gap; j < str.length();i++,j++){
        if(i >= j ){
            dp[i][j] = (i == j)?1:0;
            continue;
        }
        
        int x = dp[i+1][j-1];//countPS(str,i+1,j-1,dp);
        int y = dp[i][j-1];//countPS(str,i,j-1,dp);
        int z = dp[i+1][j];//countPS(str,i+1,j,dp);
        
        if(str.charAt(i) == str.charAt(j)) dp[i][j] = (x + 1) + (y + z - x); //(y + z + 1);
        else dp[i][j] = (y + z - x);
        
            }
        }
    
        return dp[I][J];
    }
    public  int countPS(String str)
    {
        int n = str.length();
        int[][] dp = new int[n][n];

        return (countPS_DP(str, 0, n - 1 , dp));
    }