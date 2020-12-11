import java.util.*;
class permsingleSubseq{
public static int coinChangePermutationSingleSubSeq_01(int[] coins,int idx,int tar,boolean[] vis,String ans){
      if(tar==0 || idx >= coins.length){
        if(tar==0){
          System.out.println(ans);
          return 1;
        }
        return 0;
      }
       
      int count = 0;
      if(!vis[idx] && tar - coins[idx]>=0){
        vis[idx] = true;
        count += coinChangePermutationSingleSubSeq_01(coins,0,tar-coins[idx],vis,ans  + coins[idx]);
        vis[idx] = false;
      }
      count += coinChangePermutationSingleSubSeq_01(coins,idx+1,tar,vis,ans);
  
      return count;
    }
     public static void main(String[] args){
        int[] coins={2,3,5,7};
        boolean[] vis=new boolean[4];
        System.out.println(coinChangePermutationSingleSubSeq_01(coins,0,10,vis,""));
    }
}