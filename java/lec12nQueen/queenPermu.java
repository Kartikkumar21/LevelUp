import java.util.*;
class queenPermu{
    // tnq=total number of queen. 
    // qpsf=queen placed so far.
    public static int queen(boolean[] box,int tnq,int qpsf,String ans){
        if(qpsf==tnq){
            System.out.println(ans);
            return 1;
        }
        int count=0;
        for(int i=0;i<box.length;i++){
            if(!box[i]){
                box[i]=true;
                count+=queen(box,tnq,qpsf+1,"b"+i+"q"+qpsf+" ");
                box[i]=false;
            }
        }
        return count;
    }
    public static void main(String[] args){
         boolean[] box=new boolean[6];
        System.out.print(queen(box,3,0,""));
    }
}