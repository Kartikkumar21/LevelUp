import java.util.*;
class treeDia{
    public static class Node{
        int data=0;
        Node left=null;
        Node right=null;
        Node(int data){
            this.data=data;
        }
    }
    public static int hieght(Node node){
        return node==null? -1 : Math.max(hieght(node.left),hieght(node.right))+1;
    }
    public static int dia01(Node node){
        if(node== null){
            return 0;
        }

        int ld=dia01(node.left);
        int rd=dia01(node.right);

        int lh=hieght(root.left);
        int rh=hieght(root.right);
        
        return Math.max(Math.max(ld,rd),lh+rh+2);
    }
    public static int[] dia02(Node node){
        if(node ==null) return new int[]{0,-1};

        int[] lres=dia02(node.left);
        int[] rres=dia02(node.right);

        int dia=Math.max(Math.max(lres[0],rres[0]),lres[1]+rres[1]+2);
        int hie=Math.max(lres[1]+rres[1]) + 1;

        return new int[]{dia,hie};
    }

    static int diaAns=0;
    public static int dia03(Node node){
        if(node==null){
            return -1;
        }

        int lh=dia03(node.left);
        int rh=dia03(node.right);

        diaAns=Math.max(diaAns,lh+rh+2);
        return Math.max(lh,rh) +2;
    }
}