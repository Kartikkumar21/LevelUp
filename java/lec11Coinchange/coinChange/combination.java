import java.util.*;
class combination{
    public static int combination(int[] coins,int idx,int targ,String ans){
        if(targ==0){
            System.out.println(ans);
            return 1;
        }
        int count=0;
        for(int i=idx;i<coins.length;i++){
            if(targ-coins[i]>=0){
            count+=combination(coins,i,targ-coins[i],ans+coins[i]);
            }
        }
        return count;
    }
    public static void main(String[] args){
        int[] coins={2,3,5,7};
        System.out.print(combination(coins,0,10,""));
    }
}