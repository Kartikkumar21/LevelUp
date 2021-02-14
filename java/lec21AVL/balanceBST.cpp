// leetcode 1382
class Solution
{
    int getHeight(TreeNode *node)
    {
        return node == nullptr ? -1 : max(getHeight(node->left), getHeight(node->right)) + 1;
    }

    int getBalance(TreeNode *node)
    {
        int lh = getHeight(node->left);
        int rh = getHeight(node->right);

        return lh - rh;
    }

    TreeNode *rightRotation(TreeNode *A) // O(1)
    {
        TreeNode *B = A->left;
        TreeNode *BKaRight = B->right;

        B->right = A;
        A->left = BKaRight;

        B->right = getRotation(A);
        return getRotation(B);
    }

    TreeNode *leftRotation(TreeNode *A) //O(1)
    {
        TreeNode *B = A->right;
        TreeNode *BKaLeft = B->left;

        B->left = A;
        A->right = BKaLeft;

        B->left = getRotation(A);
        return getRotation(B);
    }

    TreeNode *getRotation(TreeNode *node) // O(1)
    {

        if (getBalance(node) >= 2) // ll,lr
        {
            if (getBalance(node->left) >= 1) // ll
            {
                return rightRotation(node);
            }
            else // lr
            {
                node->left = leftRotation(node->left);
                return rightRotation(node);
            }
        }
        else if (getBalance(node) <= -2) // rr,rl
        {
            if (getBalance(node->right) >= 1) // rl
            {
                node->right = rightRotation(node->right);
                return leftRotation(node);
            }
            else // rr
            {
                return leftRotation(node);
            }
        }

        return node;
    }

public:
    TreeNode *balanceBST(TreeNode *root)
    {
        if (root == nullptr)
            return nullptr;

        root->left = balanceBST(root->left);
        root->right = balanceBST(root->right);

        return getRotation(root);
    }
};