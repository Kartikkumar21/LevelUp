void addAllLeft(TreeNode *node, stack<TreeNode *> &st)
{
    while (node != nullptr)
    {
        st.push(node);
        node = node->left;
    }
}
int kthSmallest(TreeNode *root, int k)
{
    stack<TreeNode *> st;
    addAllLeft(root, st);

    while (--k > 0)
    {
        TreeNode *rn = st.top();
        st.pop();
        addAllLeft(rn->right, st);
    }
    return st.top()->val;
}