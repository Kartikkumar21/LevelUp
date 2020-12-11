public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}
class Solution {
     TreeNode a = null, b = null, prev_ = null;
    public boolean recoverTree_(TreeNode root){
    if (root == null)
        return false;

    if (recoverTree_(root.left))
        return true;

    if (prev_ != null && prev_.val > root.val){
        b = root;
        if (a == null)
            a = prev_;
        else
            return true;
    }
    prev_ = root;
    if (recoverTree_(root.right))
        return true;
    return false;
}
    public void recoverTree(TreeNode root) {
        recoverTree_(root);
    if (a != null)
    {
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }
    }
}