import java.util.;
class bstConst{
    public static class Node{
    int data = 0;
    Node left = null;
    Node right = null;

        Node(int data)
        {
            this.data = data;
        }
    }
   
    public static Node constructTree(int[] arr, int si, int ei){
    if (si > ei)
        return null;-

    int mid = (si + ei) / 2;
    Node node = new Node(arr[mid]);
    node.left = constructTree(arr, si, mid - 1);
    node.right = constructTree(arr, mid + 1, ei);

    return node;
}

public static int maximum(Node node){
    Node curr = node;
    while (curr.right != null)
    {
        curr = curr.right;
    }

    return curr.data;
}

public static int minimum(Node node)
{
    Node curr = node;
    while (curr.left != null)
    {
        curr = curr.left;
    }
    return curr.data;
}
public static bool find(Node node, int data)
{
    Node curr = node;
    while (curr != null)
    {
        if (curr.data == data)
            return true;
        else if (curr.data < data)
            curr = curr.right;
        else
            curr = curr.left;
    }
    return false;
}
}