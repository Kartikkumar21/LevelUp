// leetcode 1008
class Solution {
    int idx=0;
    public TreeNode bstFromPreorder(int[] preorder,int lrange,int rrange) {
        if(idx>=preorder.length || preorder[idx]<lrange || preorder[idx]>rrange)
            return null;
        
        int data=preorder[idx++];
        TreeNode node=new TreeNode(data);
        node.left=bstFromPreorder(preorder,lrange,data);
        node.right=bstFromPreorder(preorder,data,rrange);
        
        return node;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder,-(int)1e8,(int)1e8);
    }
}