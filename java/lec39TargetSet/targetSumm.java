//https://www.geeksforgeeks.org/subset-sum-problem-dp-25/

    public static int targetSum(int[] arr,int idx,int tar,int[][] dp){
        if(tar == 0 || idx == arr.length){
            return dp[idx][tar] = tar == 0 ? 1 : 0;
        }

        if(dp[idx][tar] != -1) return dp[idx][tar];

        int count = 0;
        if(tar - arr[idx] >= 0)
          count += targetSum(arr,idx+1,tar - arr[idx], dp);
        count += targetSum(arr,idx+1,tar, dp);

        return dp[idx][tar] = count;
    }

    public static int targetSumDP(int[] arr,int Idx,int Tar,int[][] dp){
        for(int idx = arr.length;idx >= 0;idx--){
            for(int tar = 0;tar<=Tar;tar++){
                if(tar == 0 || idx == arr.length){
                    dp[idx][tar] = (tar == 0) ? 1 : 0;
                    continue;
                }
                
                int count = 0;
                if(tar - arr[idx] >= 0)
                   count += dp[idx + 1][tar-arr[idx]];
                count += dp[idx + 1][tar];
               
                dp[idx][tar] = count;
            }
        }

        return dp[Idx][Tar];
    }


    public static int targetSum2(int[] arr,int n,int tar,int[][] dp){
        if(tar == 0 || n == 0){
            return dp[n][tar] = (tar == 0) ? 1 : 0;
        }

        if(dp[n][tar] != -1) return dp[n][tar];

        int count = 0;
        if(tar - arr[n - 1] >= 0)
          count += targetSum2(arr,n - 1,tar - arr[n - 1], dp);
        count += targetSum2(arr,n - 1,tar, dp);

        return dp[n][tar] = count;
    }

    public static int targetSumDP2(int[] arr,int N,int Tar,int[][] dp){
        for(int n = 0;n<=N;n++){
            for(int tar = 0;tar<=Tar;tar++){
                if(tar == 0 || n == 0){
                    dp[n][tar] = (tar == 0) ? 1 : 0;
                    continue;
                }
                
                int count = 0;
                if(tar - arr[n - 1] >= 0)
                   count += dp[n-1][tar-arr[n-1]];
                count += dp[n-1][tar];
               
                dp[n][tar] = count;
            }
        }

        return dp[N][Tar];
    }
    public static boolean targetSumPath(int[] arr,int n,int tar,int[][] dp,String psf){
        if(tar == 0 || n == 0){
           if(tar == 0){
            System.out.println(psf);
            return true;
           }
           return false;
        }

        boolean res = false;
        if(tar - arr[n - 1] >= 0 && dp[n-1][tar - arr[n-1]] > 0)
          res = res || targetSumPath(arr,n - 1,tar - arr[n - 1], dp, psf + arr[n-1] + ",");
        if(dp[n-1][tar] > 0) res = res || targetSumPath(arr,n - 1,tar, dp,psf);

        return res;
    }

    public static void targetSum(){
        int[] arr = {2,3,5,7};
        int tar = 10;

        int[][] dp = new int[arr.length+1][tar+1];
        // for(int[] d: dp) Arrays.fill(d,-1);
        // int ans = targetSumDP(arr,0,tar,dp);

        int ans = targetSumDP2(arr,arr.length,tar,dp);
        System.out.println(targetSumPath(arr,arr.length,tar,dp,""));

        print2D(dp);
    }