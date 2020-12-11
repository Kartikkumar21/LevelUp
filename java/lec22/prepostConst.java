  //Leetcode 889
    public TreeNode buildTree(int[] postorder,int posi,int poei, int[] preorder,int psi,int pei) {
        if(psi > pei) return null;
        if(psi == pei) return new TreeNode(preorder[psi]); // leaf node

        TreeNode node = new TreeNode(preorder[psi]);
        int idx = posi;

        while(postorder[idx] != preorder[psi + 1]){
            idx++;
        }

        int count = idx - posi + 1;

        node.left = buildTree(postorder,posi,posi + count - 1, preorder, psi+1,psi + count);
        node.right = buildTree(postorder,posi + count,poei-1, preorder,psi + count + 1, pei);

        return node;
    }

 
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if(post.length==0) return null;
        int n = post.length;

        return buildTree(post,0,n-1,pre,0,n-1);        
    }
