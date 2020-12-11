// www.geeksforgeeks.org/optimal-binary-search-tree-dp-24/
  // only for memoization
    public static int OBST(int[] keys,int[] freq,int si,int ei,int level,int[][][] dp){
        if(dp[si][ei][level] != -1) return dp[si][ei][level];

        int minCost = (int) 1e9;
        for(int cut = si; cut<=ei;cut++){
            int leftTree = (cut == si) ? 0 : OBST(keys,freq, si, cut-1 ,level + 1,dp);
            int rightTree = (cut == ei) ? 0 : OBST(keys,freq, cut + 1, ei ,level + 1,dp);

            minCost = Math.min(minCost, leftTree + freq[cut] * level  + rightTree);
        }

        return dp[si][ei][level] = minCost;
    }

    public static int OBST_01(int[] keys,int[] freq,int si,int ei,int[] psum,int[][] dp){
        if(dp[si][ei] != -1) return dp[si][ei];

        int minCost = (int) 1e9;
        for(int cut = si; cut<=ei;cut++){
            int leftTree = (cut == si) ? 0 : OBST(keys,freq, si, cut-1 ,psum,dp);
            int rightTree = (cut == ei) ? 0 : OBST(keys,freq, cut + 1, ei ,psum,dp);

            minCost = Math.min(minCost, leftTree + (psum[ei] - (si == 0 ? 0 :psum[si-1]))  + rightTree);
        }
        
        return dp[si][ei] = minCost;
    }

    public static int OBST_02(int[] keys,int[] freq,int si,int ei,int[][] dp){
        if(dp[si][ei] != -1) return dp[si][ei];

        int minCost = (int) 1e9;
        int sum = 0;
        for(int cut = si; cut<=ei;cut++){
            int leftTree = (cut == si) ? 0 : OBST(keys,freq, si, cut-1 ,dp);
            int rightTree = (cut == ei) ? 0 : OBST(keys,freq, cut + 1, ei ,dp);
            sum += arr[cut];
            minCost = Math.min(minCost, leftTree + rightTree);
        }
        
        return dp[si][ei] = minCost + sum;
    }

    public static int OBST_02_DP(int[] keys,int[] freq,int SI,int EI,int[][] dp){
        int n = keys.length;
        for(int gap = 0; gap < n ;gap++){
            for(int si=0,ei = gap;ei < n;si++,ei++){
                int minCost = (int) 1e9;
                int sum = 0;
                for(int cut = si; cut<=ei;cut++){
                    int leftTree = (cut == si) ? 0 : dp[si][cut-1];
                    int rightTree = (cut == ei) ? 0 : dp[cut+1][ei];
                    sum += arr[cut];
                    minCost = Math.min(minCost, leftTree + rightTree);
                }
                
                dp[si][ei] = minCost + sum;
            }
        }
        return dp[SI][EI];
    }

    public static void OBST(){
        int[] keys={10, 12, 20};
        int[] freq ={34, 8, 50};
        int n = keys.length;
        int[] psum = new int[n];
        int prev = 0;
        for(int i=0;i<n;i++){
            psum[i] = prev + freq[i];
            prev = psum[i];
        }

        int[][][] dp = new int[n][n][n+1];
        for(int[][] D:dp) for(int[] d:D) Arrays.fill(d,-1);
        System.out.println(OBST(keys,freq,0,n-1,1,dp));
    }