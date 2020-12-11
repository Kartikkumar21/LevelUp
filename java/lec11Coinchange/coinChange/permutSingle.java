import java.util.*;
class permutSingle{
    public static int purmutation_Single(int[] coins,int tar,boolean[] vis,String ans){
        if(tar==0){
            System.out.println(ans);
            return 1;
        }
        int count =0;
        for(int i=0;i<coins.length;i++){
            if(!vis[i] && tar-coins[i]>=0){
                vis[i]=true;
                count+=purmutation_Single(coins,tar-coins[i],vis,ans+coins[i]);
                vis[i]=false;
            }
        }
        return count;
    }
    public static void main(String[] args){
        int[] coins={2,3,5,7};
        boolean[] vis=new boolean[4];
        System.out.println(purmutation_Single(coins,10,vis,""));
    }
}