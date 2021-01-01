// leetcode 300
public int binarySearch(ArrayList<Integer> arr,int data){
    int si = 0, ei = arr.size();
    while(si < ei){
        int mid = (si + ei) / 2; 
        if(data > arr.get(mid)) si = mid + 1;
        else ei = mid;
    }

    return si;
}

public int lengthOfLIS(int[] arr)
{
    if (arr.length <= 1)
        return arr.length;
    int n = arr.length;

    ArrayList<Integer> list = new ArrayList<>();

    for (int ele : arr)
    {
        // int idx = Collections.binarySearch(list,ele);
        // if(idx < 0) idx = -idx - 1;
        
        int idx = binarySearch(list,ele);
        if (idx == list.size())
            list.add(ele);

        list.set(idx, ele);
    }

    return list.size();
}