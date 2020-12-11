import java.util.*;
class bfs{

    public static class Node{
        int data=0;
        Node left=null;
        Node right=null;
        Node(int data){
            this.data=data;
        }
    } 
    static int idx=0;
    public static Node constTree(int[] arr){
        if(idx>=arr.length || arr[idx]==-1){
            idx++;
            return null;
        }
        Node node=new Node(arr[idx++]);
        node.left=constTree(arr);
        node.right=constTree(arr);
        return node;
    }
    // normal
    public static void BFS_01(Node node){
        LinkedList<Node> que = new LinkedList<>();
        que.addLast(node);

        while(que.size()!=0){
            Node vtx = que.removeFirst();
            System.out.print(vtx.data + " ");
            if(vtx.left != null) que.addLast(vtx.left);
            if(vtx.right != null) que.addLast(vtx.right);
        }
    }
    // delimeter
    public static void BFS_02(Node node){
        LinkedList<Node> que = new LinkedList<>();
        que.addLast(node);
        que.addLast(null);

        while(que.size()!=1){
            Node vtx = que.removeFirst();
            
            System.out.print(vtx.data + " ");
        
            if(vtx.left != null) que.addLast(vtx.left);
            if(vtx.right != null) que.addLast(vtx.right);
            
            if(que.getFirst()==null){
                System.out.println();
                que.removeFirst();
                que.addLast(null);
            }
        }
    }
                // line wise
    public static void BFS_03(Node node){
        LinkedList<Node> que = new LinkedList<>();
        que.addLast(node);

        int level = 0;
        while(que.size()!=0){
            int size = que.size();
            System.out.print("Level : " + level + " -> ")
            while(size-- > 0){
                Node vtx = que.removeFirst();
                System.out.print(vtx.data + " ");
                if(vtx.left != null) que.addLast(vtx.left);
                if(vtx.right != null) que.addLast(vtx.right);
            }

            System.out.println();
            level++;
        }
    }
    public static void main(String[] args){
        int[] arr={10,20,30,null,40,50,null};
        Node root=constTree(arr);
        bfs_02(root);
    }
}