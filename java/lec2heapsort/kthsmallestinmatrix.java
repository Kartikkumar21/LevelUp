// leet 378
public int kthSmallest(int[][] matrix, int k) {

    int n = matrix.length;
    int m = matrix[0].length;

    // val, i, j
    PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
        return a[0] - b[0]; // default pq (min).
    }); 

    for(int i=0;i<n;i++) pq.add(new int[]{matrix[i][0],i,0});

    while(k-- > 1){
        int[] rEle = pq.remove();
        int r = rEle[1];
        int c = rEle[2];

        if(c + 1 < m) pq.add(new int[]{matrix[r][c + 1],r,c + 1});
    }

    return pq.remove()[0];
}
