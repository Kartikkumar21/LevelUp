//1035
    public int maxUncrossedLines(int[] A, int[] B) {
        int N=A.length;
        int M=B.length;
        
        int[][] dp=new int[N+1][M+1];
    
        for(int n=0;n<=N;n++){
            for(int m=0;m<=M;m++){
                
                if(n==0|| m==0) {
                    dp[n][m]=0;
                    continue;
                }
                if(A[n-1]==B[m-1]) dp[n][m]=dp[n-1][m-1]+1;
                else dp[n][m]=Math.max(dp[n-1][m],dp[n][m-1]);
            }
            
        }
        
        return dp[N][M];
    }