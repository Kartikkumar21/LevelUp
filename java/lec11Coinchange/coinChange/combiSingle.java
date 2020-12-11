import java.util.*;
class combiSingle{
    public static int combination_Single(int[] coins,int idx,int tar,String ans){
        if(tar==0){
            System.out.println(ans);
            return 1;
        }
        int count =0;
        for(int i=idx;i<coins.length;i++){
            if(tar-coins[i]>=0){
                count+=combination_Single(coins,i+1,tar-coins[i],ans+coins[i]);
            }
        }
        return count;
    }
    public static void main(String[] args){
        int[] coins={2,3,5,7};
        System.out.println(combination_Single(coins,0,10,""));
    }
}