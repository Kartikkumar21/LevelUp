public static void widthDiagonal(Node node,int level,int[] res){
        if(node == null) return;

        res[0] = Math.min(level,res[0]);
        widthDiagonal(node.left,level-1,res);
        widthDiagonal(node.right,level,res);
    }

    public static void DiagonalView(Node node,int level,ArrayList<Integer>[] ans){
        if(node == null) return;

        ans[level].add(node.data);

        DiagonalView(node.left,level-1,ans);
        DiagonalView(node.right,level,ans);
    }

    public static void DiagonalView(Node node){
        int[] res = new int[1];
        widthDiagonal(node,0,res);

        ArrayList<Integer>[] ans = new ArrayList[0 - res[0] + 1];  // vector<vector<int>> ans(0 - res[0] + 1,vector<int>());
        for(int i=0;i<ans.length;i++) ans[i] = new ArrayList<>();

        DiagonalView(node,-res[0],ans);
    }