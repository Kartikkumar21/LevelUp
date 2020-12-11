import java.util.*;
class nQueenBit{
    static int  colN =0 ,diagN =0 ,adiagN=0 ;
    static int call=0;
    public static int queen_bits(int n,int r,int tnq,String ans){
        if(tnq==0){
            System.out.println(ans);
            return 1;
        }
        int count=0;
        for(int c=0;c<n;c++){
            if((colN &(1<<c))==0 && (diagN & (1<<(r+c)))==0 && (adiagN & (1<<(r-c+n-1)))==0){
                colN ^= (1<<c);
                diagN ^= (1<<r+c);
                adiagN ^= (1<< r-c+n-1);

                count+=queen_bits(n,r+1,tnq-1,ans+"("+r+","+c+")");

                colN ^= (1<<c);
                diagN ^= (1<<r+c);
                adiagN ^= (1<< r-c+n-1);
            }
        }
        return count;
    }
    public static void main(String[] args){
        boolean[][] box = new boolean[4][4];
      int tnq = 4;
      int n = box.length;
      int m = box[0].length;
      System.out.println(queen_bits(n,0,tnq,""));
    }
}