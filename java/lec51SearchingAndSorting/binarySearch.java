class binarySearch{
    public static int binarySearch(int[] arr,int data){
        int si=0;
        int ei=arr.length;
        while(si<=ei){
            int mid=(si+ei)/2;
            if(arr[mid]==data)return mid;

            else if(arr[mid]<data){
                si=mid+1;
            }
            else{
                ei=mid-1;
            }
        }
        return -1;
    }
}