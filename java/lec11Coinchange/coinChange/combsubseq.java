import java.util.*;
class combsubseq{
public static int coinChangeCombinationSubseq_01(int[] coins,int idx,int tar,String ans){
      if(tar==0 || idx >= coins.length){
        if(tar==0){
          System.out.println(ans);
          return 1;
        }
        return 0;
      }
       
      int count = 0;
      if(tar - coins[idx]>=0)
        count += coinChangeCombinationSubseq_01(coins,idx,tar-coins[idx],ans  + coins[idx]);
      
      count += coinChangeCombinationSubseq_01(coins,idx+1,tar,ans);
  
      return count;
    }
     public static void main(String[] args){
        int[] coins={2,3,5,7};
        System.out.println(coinChangeCombinationSubseq_01(coins,0,10,""));
    }
}