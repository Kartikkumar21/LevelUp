class powerOftwo {
    public static  boolean isPowerOfTwo(int n) {
        return n>0 && (n & (n-1))==0;
    }
    public static void main(String[] args){
        int n=4;
        System.out.print(isPowerOfTwo(n));
    }
}