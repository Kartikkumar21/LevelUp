int idx = 0;
public boolean checkTree(int[] preorder,int psi,int pei, int[] inorder,int isi,int iei,int[] post){
    if(psi > pei) return true;

    int idx = isi;
    boolean flag = false;
    while(idx < iei){
        if(inorder[idx] == preorder[psi]){
            flag = true;
            break;
        }
        idx++;
    }

    if(!flag) return false; 

    int count = idx - isi; // countOfNodesInLeftSubTree.

    if(!checkTree(preorder,psi+1,psi+count,inorder,isi,idx-1,post)) return  false;
    if(!checkTree(preorder,psi+count+1,pei,inorder,idx+1,iei,post)) return  false;
    
    if(preorder[psi] != post[idx++]) return false;
    
    return true;
}


public TreeNode checkTree(int[] preorder, int[] inorder,int[] post) {
    if(preorder.length==0) return null;
    int n = preorder.length;

    return checkTree(preorder,0,n-1,inorder,0,n-1,post);
}