// leetcode 322
public int minCoinsRequired(int[] arr, int tar,int[] dp) {
        if(tar == 0){
            return 0;
        }

        if(dp[tar] != -1) return dp[tar];

        int minCoin = (int)1e9;
        for(int ele : arr){
            if(tar - ele >= 0 ){
                int val = minCoinsRequired(arr,tar - ele,dp);
                if(val != (int)1e9 && val + 1 < minCoin)
                   minCoin = val + 1;
            }
        }

        return dp[tar] = minCoin;
    }

    public int minCoinsRequiredDP(int[] arr, int Tar,int[] dp){
        dp[0] = 0;
        for(int tar = 1; tar<=Tar;tar++){
            int minCoin = (int)1e9;
            for(int ele : arr){
                if(tar - ele >= 0 ){
                    int val = dp[tar - ele];
                    if(val != (int)1e9 && val + 1 < minCoin)
                       minCoin = val + 1;
                }
            }
            dp[tar] = minCoin;
        }
        return dp[Tar];
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        Arrays.fill(dp,-1);

        int ans = minCoinsRequiredDP(coins,amount,dp);
        return ans != (int)1e9? ans: -1;
    }