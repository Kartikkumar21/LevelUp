
    //https://www.geeksforgeeks.org/unbounded-knapsack-repetition-items-allowed/
    public static int nboundedCost(int[] weight,int[] val,int Tar){
        int[] dp = new int[tar+1];
        for(int i = 0;i<weight.length;i++){   
           for(int tar = weight[i];tar <= Tar;tar++){
               dp[tar] = Math.max(dp[tar],dp[tar - weight[i]] + val[i]);
           }
        }

        return dp[Tar];
    }