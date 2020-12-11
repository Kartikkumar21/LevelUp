//https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
    public static int knapsack01(int[] weight,int[] value,int n,int tar,int[][] dp){
        if(n == 0 || tar == 0){
            return dp[n][tar] = 0;
        }

        if(dp[n][tar] != -1) return dp[n][tar];

        int maxValue = 0;
        if(tar - weight[n - 1] >= 0)
           maxValue = knapsack01(weight,val,n - 1,tar - weight[n - 1],dp) + value[n - 1];
        maxValue = Math.max(maxValue, knapsack01(weight,val,n - 1,tar,dp))
        
        return dp[n][tar] = maxValue;
    }