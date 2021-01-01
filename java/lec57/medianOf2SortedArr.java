// leetcode 4
public double findMedianSortedArrays(int[] arr1, int[] arr2) {
    int n = arr1.length;
    int m = arr2.length;
    if(n > m) return findMedianSortedArrays(arr2,arr1);

    int gMid = (n + m + 1) >> 1; // mid is right oriented, so more no of elements belong to left region.

    int si = 0, ei = n;
    while(si <= ei){
        int sMid = (si + ei) >> 1;
        int lMid = gMid - sMid;

        int sLeftRegionEle = sMid - 1 >=0 ? arr1[sMid - 1] : -(int)1e8;
        int sRightRegionEle = sMid < n ? arr1[sMid] : (int) 1e8;

        int lLeftRegionEle = lMid - 1 >= 0? arr2[lMid - 1] : -(int)1e8;
        int lRightRegionEle = lMid < m ? arr2[lMid] : (int) 1e8;

        if(sLeftRegionEle > lRightRegionEle) ei = sMid - 1;
        else if(lLeftRegionEle > sRightRegionEle) si = sMid + 1;
        else{

            int leftBoundaryEle = Math.max(sLeftRegionEle, lLeftRegionEle);
            int rightBoundaryEle = Math.min(sRightRegionEle,lRightRegionEle);

            if(((n + m) & 1) != 0) return leftBoundaryEle * 1.0;
            else return (leftBoundaryEle + rightBoundaryEle) / 2.0;
        }
    }
    return 0.0;
}