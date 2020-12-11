import java.util.*;
class queenpermu2D{
    // tnq=total number of queen. 
    // qpsf=queen placed so far.
    public static int queen(boolean[][] box,int tnq,int qpsf,String ans){
        if(qpsf==tnq){
            System.out.println(ans+" ");
            return 1;
        }
        int count=0;
        int n=box.length;
        for(int i=0;i<n*n;i++){
            int r=i/n;
            int c=i%n;
            if(!box[r][c]){
            box[r][c]=true;     
            count+=queen(box,tnq,qpsf+1,ans+" ("+r + ","+ c+")");
            box[r][c]=false;
            }
        }
        return count;
    }
    public static void main(String[] args){
        boolean[][] box=new boolean[4][4];
        System.out.print(queen(box,4,0,""));
    }
}