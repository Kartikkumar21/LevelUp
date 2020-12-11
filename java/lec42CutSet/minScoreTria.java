 //1039
    public int minScoreTriangulation(int[] A,int si,int ei,int[][] dp) {
        if(si + 1 == ei){
            return dp[si][ei] = 0;
        }
        if(dp[si][ei] != 0) return dp[si][ei];
        
        int minAns = (int)1e9;
        for(int cut = si + 1; cut < ei;cut++){
            int leftPoly = minScoreTriangulation(A,si,cut,dp);
            int rightPoly = minScoreTriangulation(A,cut,ei,dp);
            
            minAns = Math.min(minAns, leftPoly + A[si] * A[cut] * A[ei] + rightPoly);
        }

        return dp[si][ei] = minAns;
    }
    
    public int minScoreTriangulation(int[] A) {
        int n = A.length;
        int[][] dp = new int[n][n];
        return minScoreTriangulation(A,0,n-1,dp); 
    }