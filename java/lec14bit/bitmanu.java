import java.util.*;
class bitmanu{
    public static int On(int n,int k){
      int mask= (1<<k);
      return (n|mask);
    }
    public static int Off(int n,int k){
        int mask=(~(1<<k));
        return (n&mask);
    }
    public static void main(String[] args){
        int n=10;
        int k=2;
        System.out.println(Off(n,k));
    }
}