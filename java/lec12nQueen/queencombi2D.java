import java.util.*;
class queencombi2D{
    // tnq=total number of queen. 
    // qpsf=queen placed so far.
    public static int queen(boolean[][] box,int idx,int tnq,int qpsf,String ans){
        if(qpsf==tnq){
            System.out.println(ans+" ");
            return 1;
        }
        int count=0;
        int n=box.length;
        for(int i=idx;i<n*n;i++){
            int r=i/n;
            int c=i%n;
            count+=queen(box,i+1,tnq,qpsf+1,ans+" ("+r + ","+ c+")");
        }
        return count;
    }
    public static void main(String[] args){
        boolean[][] box=new boolean[4][4];
        System.out.print(queen(box,0,4,0,""));
    }
}