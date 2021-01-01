class lastIndex{
    public static int last(int[] arr,int data){
        int si=0;
        int ei=arr.length-1;
        while(si<=ei){
            int mid=(ei+si)/2;
            if(arr[mid]== data){
                if(mid+1<arr.length && arr[mid+1]== data){
                    si=mid+1;
                }else{
                    return mid;
                }
            }else if (arr[mid]>data){
                ei=mid -1;
            }else{
                si=mid+1;
            }
        }
        return -1;
    }
}