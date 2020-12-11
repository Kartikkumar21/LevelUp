public static void allSolution(Node node, int data){
    Node curr = node;
    Node pred = null;
    Node succ = null;
    while (curr != null){
        if (curr.data == data){
            if (curr.left != null){
                pred = curr.left;
                while (pred.right != null)
                    pred = pred.right;
            }

            if (curr.right != null){
                succ = curr.right;
                while (succ.left != null)
                succ = succ.left;
            }
            break;
        }
        else if (curr.data < data){
            pred = curr;
            curr = curr.right;
        }
        else{
            succ = curr;
            curr = curr.left;
        }
    }
}
