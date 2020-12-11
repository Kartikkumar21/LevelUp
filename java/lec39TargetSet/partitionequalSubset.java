//416
    public boolean canPartition(int[] arr) {
        int N = arr.length;
        if(N==0) return false;

        int sum = 0;
        for(int ele : arr) sum+=ele;
        if(sum % 2 != 0) return false;

        int Tar = sum / 2;
        boolean[][] dp = new boolean[N + 1][Tar + 1];

        for(int n = 0;n<=N;n++){
            for(int tar = 0;tar<=Tar;tar++){
                if(tar == 0 || n == 0){
                    dp[n][tar] = (tar == 0) ? true : false;
                    continue;
                }
                
                int count = 0;
                if(tar - arr[n - 1] >= 0)
                   dp[n][tar] = dp[n][tar] || dp[n-1][tar-arr[n-1]];
                dp[n][tar] = dp[n][tar] ||  dp[n-1][tar];               
            }
        }

        return dp[N][Tar];
    }