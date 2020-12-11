// 494
    public int findTargetSumWays(int[] nums, int tar,int n,int sum,int[][] dp) {
        if(n == 0){
            return dp[n][sum] = (tar == sum)? 1: 0;
        }

        if(dp[n][sum] != -1) return dp[n][sum];

        int count = 0;
        count += findTargetSumWays(nums,tar,n-1,sum + nums[n-1],dp); // positive number
        count += findTargetSumWays(nums,tar,n-1,sum + (-nums[n-1]),dp); // negative number

        return dp[n][sum] = count;
    }
    
    
    public int findTargetSumWays(int[] nums, int S) {
        int n = nums.length;
      
        if(n == 0) return 0; 
        
        int sum = 0;
        for(int ele : nums) sum+=ele;
        if(S > sum || S < -sum) return 0;
        int[][] dp = new int[n+1][2 * sum + 1];
        for(int[] d: dp) Arrays.fill(d,-1);
        int ans = findTargetSumWays(nums,(S + sum),n,(0 + sum),dp);

        return ans;
    }


