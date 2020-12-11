import java.util.*;
class permutation{
    public static int permut(int[] coins,int tar,String ans){
        if(tar==0){
            System.out.println(ans);
            return 1;
        }
        int count=0;
        for(int i=0;i<coins.length;i++){
            if(tar-coins[i]>=0){
                count+=permut(coins,tar-coins[i],ans + coins[i]);
            }
        }
        return count;
    }
    public static void main(String[] args){
        int[] coins={2,3,5,7};
        System.out.print(permut(coins,10,""));
    }
}