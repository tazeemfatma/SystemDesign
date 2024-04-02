package Questions;

import java.util.LinkedList;
import java.util.Queue;

public class PrintLeafNodesOfBinaryTree {
    static Node root;
    static int sum=0;
    static class Node{
        int data;
        Node right, left;
        Node(int item){
            data=item;
            right=left=null;
        }
    }
    public static void main(String[] args){
        //        1
        //    2      3
        //  4  _  5    8
        //       6 7 9 10
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.right.left=new Node(5);
        root.right.right=new Node(8);
        root.right.left.left=new Node(6);
        root.right.left.right=new Node(7);
        root.right.right.left=new Node(9);
        root.right.right.right=new Node(10);
        //sum=0;
        printLeafNodes(root);
       System.out.println(sum);
       printPreOrder(root);
       printLevelOrder(root);

    }

    private static void printLevelOrder(Node root) {
        System.out.println("Level Order");
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node x=queue.poll();
            System.out.println(x.data);
            if(x.left!=null)
                queue.add(x.left);
            if(x.right!=null)
                queue.add(x.right);
            System.out.println();
        }
    }

    private static void printPreOrder(Node root) {
        if(root==null)
            return;
        System.out.print(root.data);
        System.out.println();
        printPreOrder(root.left);
        printPreOrder(root.right);

    }

    private static void printLeafNodes(Node root) {
        if(root == null)
            return ;
        if(root.left==null && root.right==null) {
            System.out.println(root.data + " ");
            sum+=root.data;
        }
        if(root.left!=null)
             printLeafNodes(root.left);

        if(root.right !=null)
             printLeafNodes(root.right);
    }

}
