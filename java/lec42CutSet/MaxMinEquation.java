// https://www.geeksforgeeks.org/minimum-maximum-values-expression/
public static class pair{
        int minVal = 0;
        int maxVal = 0;

        pair(int minVal,int maxVal){
            this.minVal = minVal;
            this.maxVal = maxVal;
        }
    }

    public static int Evaluate(char ch, int a,int b){
        if(ch == '*') return a*b;
        else return a+b;
    }


    public static pair minMaxEvaluation(int[] num,char[] operator,int si,int ei,pair[][] dp){
        if(si == ei){
            return new pair(num[si],num[si]);
        }
        if(dp[si][ei] != null) return dp[si][ei];

        pair myAns = new pair((int)1e9,-(int)1e9);
        for(int cut = si; cut < ei; cut++){
            pair left = minMaxEvaluation(num,operator,si,cut,dp);
            pair right = minMaxEvaluation(num,operator,cut+1,ei,dp);

            char ch = operator[cut];

            myAns.minVal = Math.min(myAns.minVal, Evaluate(ch,left.minVal,right.minVal)); // m,m / M,M / m,M / M,m  -> m : for min, M : for Max 
            myAns.maxVal = Math.max(myAns.maxVal, Evaluate(ch,left.maxVal,right.maxVal));
        }

        return dp[si][ei] = myAns;
    }

    public  static void minMaxEvaluation(){
        int[] num = {1,2,3,4,5};
        char[] operator ={'+','*','+','*'};
        int n = num.length;
        pair[][] dp = new pair[n][n];


        pair ans = minMaxEvaluation(num,operator,0,n-1,dp);
        System.out.println("minVal : "  + ans.minVal + ", maxVal: " + ans.maxVal);
    }

    public int maxCoins(int[] nums,int si,int ei ,int[][] dp) {
        if(dp[si][ei] != -1) return dp[si][ei];

        int lVal = (si == 0) ? 1 : nums[si-1];
        int rVal = (ei == nums.length - 1) ? 1 : nums[ei + 1];


        
        int myAns = 0;
        for(int cut = si; cut <= ei; cut++){
            int leftAns = (cut == si) ? 0 : maxCoins(nums,si,cut-1,dp);
            int rightAns = (cut == ei) ? 0 : maxCoins(nums,cut+1,ei,dp);

            myAns = Math.max(myAns, leftAns + lVal * nums[cut] * rVal + rightAns);
        }

        return dp[si][ei] = myAns;
    }


    public int maxCoins(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        
        int[][] dp = new int[n][n];
        for(int[] d: dp)Arrays.fill(d,-1);
        
        return maxCoins(nums,0,n-1,dp);   
    }