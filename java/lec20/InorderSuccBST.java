//510
public Node inorderSuccessor(Node node){
    Node curr = node;
    Node succ = null;
    if (node.right != null){
        succ = curr.right;
        while (succ.left != null)
        {
            succ = succ.left;
        }

        return succ;
    }
    while (curr.parent != null && curr.parent.val < node.val)
    {
        curr = curr.parent;
    }
    return curr.parent != null ? curr.parent : null;
}

public Node inorderSuccessor(Node node){
    Node curr = node;
    Node succ = null;
    if (node.right != null){
        succ = curr.right;
        while (succ.left != null)
        {
            succ = succ.left;
        }

        return succ;
    }

    while (curr.parent != null){
        if (curr.parent.left == curr)
            return curr.parent;
        curr = curr.parent;
    }
    return null;
}