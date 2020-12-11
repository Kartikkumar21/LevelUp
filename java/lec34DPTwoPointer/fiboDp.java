import java.util.*;
class fiboDp{
    public static int fibo(int n,int[] dp){
        if(n<=1) return dp[n]=n;
        if(dp[n]!=0){
            return dp[n];
        }
        int a=fibo(n-1,dp);
        int b=fibo(n-2,dp);

        return dp[n]=a+b;
        
        // if (n <= 1)
        //     return dp[n] = n;
        // if (dp[n] != 0)
        //     return dp[n];
        // int a = fib01(n - 1, dp);
        // int b = fib01(n - 2, dp);
        // return dp[n] = a + b;
    }
    public static void main(String[] args){
        int n=9;
        int[]dp=new int[n+1];
        // for(int i=0;i<dp.length;i++){
        System.out.print(fibo(n,0));
        // }

    }

}