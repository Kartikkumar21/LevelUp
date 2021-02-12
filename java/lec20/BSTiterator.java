//Leetcode 173
class BSTIterator {
        Stack<TreeNode> st=new Stack<>();
    public BSTIterator(TreeNode root) {

    allLeft(root);
    }
    public void allLeft(TreeNode node){
        while (node != null)
        {
            st.push(node);
            node = node.left;
        }
    }
    public int next(){
        TreeNode node = st.pop();
        allLeft(node.right);

        return node.val;
    }
    public boolean hasNext(){
        return st.size() != 0;
    }
}