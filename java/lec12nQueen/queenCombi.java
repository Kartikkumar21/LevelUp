import java.util.*;
class queenCombi{
    // tnq=total number of queen. 
    // qpsf=queen placed so far.
    public static int queen(boolean[] box,int idx,int tnq,int qpsf,String ans){
        if(qpsf==tnq){
            System.out.println(ans+" ");
            return 1;
        }
        int count=0;
        for(int i=idx;i<box.length;i++){
            count+=queen(box,i+1,tnq,qpsf+1,ans+" b"+i + "q"+ qpsf);
        }
        return count;
    }
    public static void main(String[] args){
        boolean[] box=new boolean[6];
        System.out.print(queen(box,0,3,0,""));
    }
}