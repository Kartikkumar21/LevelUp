class powerOF4 {
    public static boolean isPowerOfFour(int num) {
        if(num>0 && (num & (num-1))==0){
            return (num-1)%3==0;   
        }
           return false;
    }
    public static void main(String[] args){
        int num=16;
        System.out.print(isPowerOfFour(num));
    }
}