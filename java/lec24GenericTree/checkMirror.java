import java.util.*;
class checkMirror{
    public static class Node{
        int data=0;
        ArrayList<Node> childs;
        Node(int data){
            this.data=data;
            childs=new ArrayList<Node>();
        }
    }
    public static boolean isMirror(Node node1, Node node2){
        if(node1.childs.size()!=node2.childs.size() || node1.data!=node2.data){
            return false;
        }

        for(int i=0,j=node1.childs.size()-1;i<=j;i++,j--){
            Node ch1=node1.childs.get(i);
            Node ch2=node2.childs.get(j);

            if(!isMirror(ch1,ch2))
                return false;
        }

        return true;
    }
}