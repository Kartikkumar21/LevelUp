class BSTiterator{
//Leetcode 173
public static class BSTIterator{
    Stack<TreeNode> st=new Stack<>();
    BSTIterator(TreeNode root){
        allLeft(root);
    }
    public void allLeft(TreeNode node){
        while (node != nullptr)
        {
            st.push(node);
            node = node->left;
        }
    }
    public int next(){
        TreeNode node = st.top();
        st.pop();
        allLeft(node->right);

        return node->val;
    }
    public bool hasNext(){
        return st.size() != 0;
    }
}