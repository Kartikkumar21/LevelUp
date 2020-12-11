import java.util.Arrays;
public class l003_TargetSet{
    public static void print(int[] arr){
        for(int ele: arr)
          System.out.print(ele + " "); 
        
        System.out.println();
    }

    public static void print2D(int[][] arr){
        for(int[] a: arr)
          print(a);

        System.out.println();
    }

    public static int coinChangePermutation(int[] arr,int tar,int[] dp){
        if(tar == 0){
            return dp[tar] = 1;
        }
        
        if(dp[tar]!=0) return dp[tar];

        for(int ele : arr){
            if(tar - ele >= 0){
                dp[tar] += coinChangePermutation(arr,tar-ele,dp);
            }
        }
        return dp[tar];
    }
 
    public static int coinChangePermutationDP(int[] arr,int Tar,int[] dp){
        dp[0] = 1;
        for(int tar = 1; tar <= Tar; tar++){
            for(int ele : arr){
                if(tar - ele >= 0){
                    dp[tar] += dp[tar-ele];
                }
            }            
        }

        return dp[Tar];
    }
}