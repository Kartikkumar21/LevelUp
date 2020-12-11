class BSTinOrderPre{
    // 105
public TreeNode buildTree(int[] preorder,int psi,int pei, int[] inorder,int isi,int iei){
        if(psi > pei) return null;

        TreeNode node = new TreeNode(preorder[psi]);
        int idx = isi;
        while(inorder[idx]!=preorder[psi]){
            idx++;
        }

        int count = idx - isi; // countOfNodesInLeftSubTree.

        node.left = buildTree(preorder,psi+1,psi+count,inorder,isi,idx-1);
        node.right = buildTree(preorder,psi+count+1,pei,inorder,idx+1,iei);

        return node;
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0) return null;
        int n = preorder.length;

        return buildTree(preorder,0,n-1,inorder,0,n-1);
    }

}