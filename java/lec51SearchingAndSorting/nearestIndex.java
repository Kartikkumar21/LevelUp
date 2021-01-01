class nearestIndex{
    public static int nearestIndex(int[] arr,int data){
        if(arr.length==0) return -1;

        int n=arr.length;
        if(data <=arr[0] || data >= arr[n-1]) return data<=arr[0] ? 0 : n-1;

        int si=0, ei=n-1;
        while(si<=ei){
            int mid=( si+ei )/2;
            if(arr[mid]== data) return mid;
            else if(arr[mid] < data) si=mid+1;
            else ei=mid-1;
        }
        return ((data - arr[ei] < arr[si] - data) ? ei : si);
    }
}