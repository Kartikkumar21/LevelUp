Node prevDLL = null;
Node headDLL = null;

void bToDLL_(Node node){
    if(node==null) return;

    bToDLL_(node.left);
    
    if(prevDLL==null) headDLL = node;
    else{
        prevDLL.right = node;
        node.left = prevDLL;
    }

    prevDLL = node;

    bToDLL_(node.right);
}

Node bToDLL(Node root)
{
    bToDLL_(root);
    return headDLL;
}
