// https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1#
 static long totalInversionCount(long[] arr, long[] sortedArray,  int si,  int mid,  int ei)
{
     long count = 0;
     int i = si, j = mid, k = si;

    while (i < mid && j <= ei)
    {
        if (arr[i] <= arr[j]){
            sortedArray[k++] = arr[i++];
            // arr[i] > arr[j] and i > j; count += ei - j + 1;
        }else{
            sortedArray[k++] = arr[j++];
            count += mid - i;  
        }
    }

    while (i < mid)
        sortedArray[k++] = arr[i++];
    while (j <= ei)
        sortedArray[k++] = arr[j++];

    while (si <= ei)
        arr[si] = sortedArray[si++];
    return count;
}

static long inversionCount(long[] arr, long[] sortedArray, int si,int ei)
{
    if (si >= ei)
        return 0;

    int mid = (si + ei) / 2;
    long count = 0;

    count += inversionCount(arr, sortedArray, si, mid);
    count += inversionCount(arr, sortedArray, mid + 1, ei);

    count += totalInversionCount(arr, sortedArray, si, mid+1, ei);
    return count;
}

static long inversionCount(long[] arr, long N)
{
    if (N == 0)
        return 0;
    int n = (int)N;
    long[] sortedArray = new long[n];
    return inversionCount(arr, sortedArray, 0, n - 1);
}